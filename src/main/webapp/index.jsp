<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Responsive Links</title>
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
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
      }
      .btn {
        width: 100%;
        padding: 20px 100px;
      }
    </style>
  </head>
  <body>
    <div class="container text-center">
      <div class="row justify-content-center">
        <div class="col-md-4">
          <div class="card p-4">
            <div class="row flex-column align-items-center">
            <div class="col-10 mb-3">
                <a href="./registration.jsp" class="btn btn-primary"
                  >Registration</a
                >
              </div>
              <div class="col-10 mb-3">
                <a href="./Loginmain.jsp" class="btn btn-primary">Log In</a>
              </div>
              <div class="col-10">
                <a href="./AdminLogin.jsp" class="btn btn-primary">Admin Log in</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
