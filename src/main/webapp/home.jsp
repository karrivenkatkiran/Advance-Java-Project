<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    />
    <title>Profile Page</title>
  </head>
  <body>
    <% String firstName = (String) session.getAttribute("firstName"); 
    String lastName = (String) session.getAttribute("lastName"); 
    Long number = (Long) session.getAttribute("number"); 
    String userName = (String) session.getAttribute("userName"); %>

    <div class="container mt-5">
      <div class="text-center mb-4">
        <p class="lead">Hello, <strong><%= userName %></strong></p>
      </div>

      <table class="table table-bordered table-striped">
        <thead class="thead-dark">
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone Number</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><%= firstName %></td>
            <td><%= lastName %></td>
            <td><%= userName %></td>
            <td><%= number %></td>
          </tr>
        </tbody>
      </table>

      <div class="text-center mt-3">
        <a href="./updatePage.jsp" class="btn btn-primary">Edit</a>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
  </body>
</html>
