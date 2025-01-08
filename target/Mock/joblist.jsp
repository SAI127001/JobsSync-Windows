<%@page import="com.ty.dao.Admindao"%>
<%@page import="com.ty.entity.job_entity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	    <link rel="stylesheet" href="style.css">
	    <style type="text/css">
	      form {
	    padding: 100px;
}
	    </style>
</head>
<body>
<nav class="head">
        <div class="logo">
    
           <div class="img"><img src="images/4375017_js_logo_node_icon.png" height="55px" width="55px"></div>
           <div class="logo-name">JobsSync</div>
 
        </div>
        <div class="head-list">
          
         <ul class="ul-list">
             <li> <a href="job.html"> Add Job</a></li> 
           <li> <a href="read.jsp">User list</a></li>
           <li> <a href="company.html">Company</a></li>
          <li> <a href="joblist.jsp"> Job List</a></li>
            <li><a href="login.html">LogOut</a></li>
         </ul>
 
        </div>
 
 
     </nav>
<%/*
String se=(String) session.getAttribute("username");*/
%>
<%
 /*if(se!=null){*/
%>
<!-- <h1 style="align-items: center; justify-content: center; display: flex;  padding-bottom: -200px; position: absolute; top: 200px;">User List</h1> -->

<form action="read">
<% List<job_entity> emp=Admindao.read(); %>



<div class="container mt-5" >
		<table class="table table-dark table-striped" >

			<thead >
				<tr>
					<th scope="col">ID</th>
					<th scope="col">COMPANY_NAME</th>
					<th scope="col">JOB_ROLE</th>
					<th scope="col">JOB_DESC</th>
				   <th scope="col">A_EXP</th>
				   <th scope="col">PACKAGE</th>
				   <th scope="col">BOND</th>
					<th scope="col">VACANCY</th>
					<th scope="col">LAST_DATE</th>
				<!--  	<th scope="col">SKILL</th>
					<th scope="col">EXPERIENCE</th>-->
				</tr>
			</thead>
			<tbody>
			<% for(job_entity s:emp){ %>
			<tr>
					<td scope="col"><%= s.getId() %></td>
					<td scope="col"><%= s.getCom_name() %></td>
					<td scope="col"><%= s.getJob_role() %></td>
					<td scope="col"><%= s.getJob_desc() %></td>
				    <td scope="col"><%= s.getA_exp() %></td>
					<td scope="col"><%= s.getJob_package() %></td>
					<td scope="col"><%= s.getBond() %></td>
					<td scope="col"><%= s.getVacancy() %></td>
					<td scope="col"><%= s.getLast_date()%></td>
					
				</tr>
			<%} %>
			
			
			</tbody>
		</table>
		<!-- <a><button type="button" class="btn btn-success">Success</button></a> -->
		<a class="btn btn-success" href="register.jsp" role="button"> Registration</a>
		<a class="btn btn-success" href="logout" role="button">Logout</a>

	</div>

</form>
<%/*}
 else{
	PrintWriter ps=response.getWriter();
	response.setContentType("text/html");
	ps.print("plese login!!");
	request.getRequestDispatcher("index.jsp").include(request, response);
	
}
	*/%>
</body>
</html>