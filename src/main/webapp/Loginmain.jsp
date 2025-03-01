<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Page</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <style>
      body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        background-color: #f4f4f9;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-4">
          <div class="card p-4">
            <h4 class="text-center mb-4">Login</h4>
            <form
              name="login_page"
              action="login"
              method="post"
              onsubmit="return validateLogin()"
            >
              <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input
                  type="text"
                  class="form-control"
                  name="username"
                  id="username"
                  placeholder="Enter Username"
                />
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input
                  type="password"
                  class="form-control"
                  name="password"
                  id="password"
                  placeholder="Enter Password"
                />
              </div>
              <% if(session.getAttribute("i") != null &&
              (int)session.getAttribute("i") == 1) { %>
              <div class="mb-3">
                <p id="error" class="text-danger">
                  <%= session.getAttribute("error") %>
                </p>
              </div>
              <% } %>
              <button type="submit" class="btn btn-primary w-100">Login</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
