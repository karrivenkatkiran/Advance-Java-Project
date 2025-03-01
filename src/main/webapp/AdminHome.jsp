<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.studentmodel.RegisterModel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    />
		<title>Admin Home</title>
	</head>
	<body>
		<% List<RegisterModel> list=(List<RegisterModel>) session.getAttribute("list"); %>
		<div class="container mt-5">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
	                    <th>First Name</th>
	                    <th>Last Name</th>
	                    <th>User Name</th>
	                    <th>Phone Number</th>
	                    <th></th>
	                    <th></th>
	                 </tr>
	             </thead>
	             <tbody>
	             <% if (list != null && !list.isEmpty()) {
	             		for(RegisterModel r:list) {%>
	             	<tr>
	             		<td><%= r.getFirstName() %></td>
	             		<td><%= r.getLastName() %></td>
	             		<td><%= r.getUserName() %></td>
	             		<td><%= r.getMobileno() %></td>
	             		<td>
	             			<div class="text-center">
        						<a href="updatePage?username=<%= r.getUserName() %>" class="btn btn-primary">Edit</a>
      						</div>
	             		</td>
	             		<td>
	             			<div class="text-center">
        						<a href="DeleteStudent?username=<%= r.getUserName() %>" class="btn btn-primary">Delete</a>
      						</div>
	             		</td>
	             	</tr>
	             		<%}
	             		}else{%>
	             		<tr colspan="4">No students available</tr>
	             		<%} %>
	             		
	             </tbody>
			</table>
		</div>
	</body>
</html>