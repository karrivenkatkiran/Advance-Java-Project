<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update Details</title>
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
      .form-control {
        width: 100%;
      }
      .form-container {
        width: 100%;
        max-width: 500px;
      }
    </style>
  </head>
  <body>
    <% String firstname = (String) session.getAttribute("firstName"); 
    String lastname = (String) session.getAttribute("lastName"); 
    Long mobile = (Long) session.getAttribute("number"); 
    String username = (String) session.getAttribute("userName"); %>
    <div class="container form-container">
      <div class="card p-4">
        <h3 class="text-center mb-4">Update Details</h3>
        <form action="UpdateAdmin" method="post">
          <div class="mb-3">
            <label for="username" class="form-label">
            Username (cannot be changed):</label>
            <input
              type="email"
              class="form-control"
              name="username"
              id="username"
              value="<%= username %>"
              readonly
            />
          </div>
          <div class="mb-3">
            <label for="firstName" class="form-label">First Name:</label>
            <input
              type="text"
              class="form-control"
              name="firstName"
              id="firstName"
              value="<%= firstname %>"
              required
              onfocus="validateAlphabets(this)"
            />
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">Last Name:</label>
            <input
              type="text"
              class="form-control"
              name="lastName"
              id="lastName"
              value="<%= lastname %>"
              required
              onfocus="validateAlphabets2(this)"
            />
          </div>
          <div class="mb-3">
            <label for="tel" class="form-label">Mobile No:</label>
            <input
              type="tel"
              class="form-control"
              name="tel"
              id="tel"
              maxlength="10"
              value="<%= mobile %>"
              required
              onfocus="return validateNumeric(this)"
            />
          </div>
          <div class="text-center">
            <button type="submit" class="btn btn-primary">Update</button>
          </div>
        </form>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
