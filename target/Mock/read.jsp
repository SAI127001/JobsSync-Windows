<%@page import="com.ty.dao.Userdao"%>
<%@page import="com.ty.entity.user_entity"%>
<%@page import="java.io.PrintWriter"%>
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
            <li>  <a href="job.html">Add Job </a></li>
           <li>  <a href="read.jsp">User list</a></li>
             <li><a href="company.html">Company</a></li>
            <li><a href="joblist.jsp"> Job List</a></li>
            <li><a href="login.html"> LogOut</a></li>
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
<% List<user_entity> emp=Userdao.read(); %>



<div class="container mt-5" >
		<table class="table table-dark table-striped" >

			<thead >
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NAME</th>
					<th scope="col">PASSWORD</th>
					<th scope="col">EMAIL</th>
				   <th scope="col">MOBILE NO.</th>
				   <th scope="col">DEPARTMENT</th>
				   <th scope="col">QUALIFICATION</th>
					<th scope="col">YOP</th>
					<th scope="col">LOCATION</th>
					<th scope="col">SKILL</th>
					<th scope="col">EXPERIENCE</th>
				</tr>
			</thead>
			<tbody>
			<% for(user_entity s:emp){ %>
			<tr>
					<td scope="col"><%= s.getId() %></td>
					<td scope="col"><%= s.getName() %></td>
					<td scope="col"><%= s.getPassword() %></td>
					<td scope="col"><%= s.getEmail() %></td>
				    <td scope="col"><%= s.getMobile() %></td>
					<td scope="col"><%= s.getQualification() %></td>
					<td scope="col"><%= s.getYop() %></td>
					<td scope="col"><%= s.getLocation() %></td>
					<td scope="col"><%= s.getSkill()%></td>
					<td scope="col"><%= s.getUser_exp() %></td>
					<td scope="col"><%= s.getSkill()%></td>
				<!--  <td scope="col"><a href="update.jsp?id=<%= s.getId() %>"><button type="button" class="btn btn-warning">Update</button></a></td>*/
					<td scope="col"><a href="delete?id=<%= s.getId() %>"><button type="button" class="btn btn-danger">Delete</button></a></td>/-->
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