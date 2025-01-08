pipeline {
    agent any

    environment {
        DOCKER_HUB_USER = 'sai127001'
        DOCKER_HUB_REPO = 'win-jobssync'
        APP_NAME = 'jobsync'
        S3_BUCKET = 'win-jobsync-artifacts'
        POSTGRES_USER = 'admin'
        POSTGRES_PASSWORD = 'admin'
        POSTGRES_DB = 'jobsync_db'
        EC2_INSTANCE_IP = '54.173.75.224'
        EC2_SSH_USER = 'ubuntu'
    }

    stages {
        stage('Checkout Git') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    versionTag = "${env.BUILD_ID}-${new Date().format('yyyyMMddHHmmss')}"
                    echo "Generated Version Tag: ${versionTag}"
                    bat 'copy target\\Mock.war docker\\'
                    bat "docker build -t ${env.DOCKER_HUB_USER}/${env.DOCKER_HUB_REPO}:${versionTag} ./docker"
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKER_HUB_USER', passwordVariable: 'DOCKER_HUB_PASSWORD')]) {
                    bat """
                        echo %DOCKER_HUB_PASSWORD% | docker login -u %DOCKER_HUB_USER% --password-stdin
                    """
                }
                bat "docker push ${env.DOCKER_HUB_USER}/${env.DOCKER_HUB_REPO}:${versionTag}"
            }
        }

        stage('Upload WAR File to S3 with Versioning') {
            steps {
                script {
                    def warFileName = "${env.APP_NAME}-${versionTag}.war"
                    bat "move target\\Mock.war target\\${warFileName}"
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-creds', accessKeyVariable: 'AWS_ACCESS_KEY_ID', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                        bat "aws s3 cp target\\${warFileName} s3://${env.S3_BUCKET}/artifacts/"
                    }
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: 'ec2-ssh-key', keyFileVariable: 'SSH_KEY_FILE')]) {
                    script {
                        bat """
                            # Set permissions for the SSH key file
                            icacls %SSH_KEY_FILE% /inheritance:r
                            icacls %SSH_KEY_FILE% /grant:r "%USERNAME%":F

                            # SSH into the EC2 instance and deploy the Docker container
                            plink -batch -ssh -i %SSH_KEY_FILE% ${env.EC2_SSH_USER}@${env.EC2_INSTANCE_IP} "
                                # Pull the Docker image from Docker Hub
                                docker pull ${env.DOCKER_HUB_USER}/${env.DOCKER_HUB_REPO}:${versionTag}

                                # Stop and remove the existing container (if any)
                                docker stop ${env.APP_NAME} || true
                                docker rm ${env.APP_NAME} || true

                                # Run the new container
                                docker run -d --name ${env.APP_NAME} -p 8081:8081 ${env.DOCKER_HUB_USER}/${env.DOCKER_HUB_REPO}:${versionTag}
                                # Verify the container is running
                                sleep 10
                                docker ps --filter \"name=${env.APP_NAME}\" --format \"{{.Status}}\"
                            "
                        """
                    }
                }
            }
        }
    }

    post {
        success {
            emailext body: 'The build and deployment succeeded!', subject: 'Build Success', to: 'codesai127.0.0.1@gmail.com'
        }
        failure {
            emailext body: "The build or deployment failed. Please check the Jenkins logs for details.", subject: 'Build Failure', to: 'codesai127.0.0.1@gmail.com'
        }
    }
}