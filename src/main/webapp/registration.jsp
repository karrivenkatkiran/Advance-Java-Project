<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Responsive Registration Form</title>
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
      .card {
        width: 100%;
        max-width: 500px;
      }
      .form-control {
        margin-bottom: 15px;
      }
      .error {
        color: red;
        font-size: 0.9rem;
      }
    </style>
  </head>
  <body>
    <div class="container text-center">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="card p-4">
            <form
              name="registration"
              action="registerr"
              method="post"
              onsubmit="return validateForm() && validate()"
            >
              <input
                type="text"
                name="firstName"
                id="firstName"
                class="form-control"
                placeholder="Enter First Name"
                onfocus="validateAlphabets(this)"
              />
              <p id="fnerr" class="error"></p>

              <input
                type="text"
                name="lastName"
                id="lastName"
                class="form-control"
                placeholder="Enter Last Name"
                onfocus="validateAlphabets2(this)"
              />
              <p id="lnerr" class="error"></p>

              <input
                type="tel"
                name="tel"
                id="tel"
                class="form-control"
                maxlength="10"
                placeholder="Enter Mobile Number"
                onfocus="return validateNumeric(this)"
              />
              <p id="telerr" class="error"></p>
              <p id="ajax1" class="error"></p>

              <input
                type="email"
                name="username"
                id="username"
                class="form-control"
                placeholder="Enter Email Id"
              />
              <p id="ajax2" class="error"></p>

              <input
                type="password"
                name="password"
                id="password"
                class="form-control"
                placeholder="Enter Password"
              />
              <p id="pwerr" class="error"></p>

              <input
                type="password"
                name="cPassword"
                id="cPassword"
                class="form-control"
                placeholder="Confirm Password"
                onblur="return checkPassword()"
              />
              <p id="error" class="error"></p>

              <button type="submit" class="btn btn-primary w-100">
                Submit
              </button>
              <p></p>
              <button class="btn btn-primary w-100">
                <a href="./Loginmain.jsp" style="color: white; text-decoration: none;">Log In</a>
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
      var telIsValid = true;
      var unIsValid = true;

      $(document).ready(function () {
        telIsValid = true;
        $("#tel").blur(function (event) {
          var tel = $("#tel").val();
          if (tel.length > 9) {
            $.get("GetServlet", { tel: tel }, function (responseText) {
              $("#ajax1").text(responseText);
              $("#ajax1")[0].style.color = "red";
              telIsValid = false;
            });
          } else {
            $("#ajax1").text("Enter Valid Mobile Number !!");
            $("#ajax1")[0].style.color = "red";
            telIsValid = false;
          }
        });

        unIsValid = true;
        $("#username").blur(function (event) {
          var username = $("#username").val();
          const regex = /^([a-z0-9._%+-])+@gmail\.com$/;
          if (regex.test(username)) {
            $("#ajax2").text("");
            $.get("AjaxEmail", { username: username }, function (responseText) {
              $("#ajax2").text(responseText);
              $("#ajax2")[0].style.color = "red";
              unIsValid = false;
            });
          } else {
            $("#ajax2").text("Enter valid Email Id");
            $("#ajax2")[0].style.color = "red";
            unIsValid = false;
          }
        });
      });

      function checkPassword() {
        const pass = document.getElementById("password").value;
        const vpass = document.getElementById("cPassword").value;
        const errorElement = document.getElementById("error");

        if (pass === "" || vpass === "") {
          errorElement.innerText = "Password fields cannot be empty.";
          errorElement.style.color = "RED";
          return false;
        }

        if (pass !== vpass) {
          errorElement.innerText = "Passwords do not match.";
          errorElement.style.color = "RED";
          return false;
        }

        errorElement.innerText = "";
        return true;
      }

      function validateAlphabets(input) {
        const regex = /^[A-Za-z]+$/;
        input.addEventListener("keypress", function (event) {
          const c = event.key;
          if (!regex.test(c)) {
            event.preventDefault();
            document.getElementById("fnerr").innerText = "Enter Alphabets Only";
            document.getElementById("fnerr").style.color = "RED";
          } else {
            document.getElementById("fnerr").innerText = "";
          }
        });
      }

      function validateAlphabets2(input) {
        const regex = /^[A-Za-z]+$/;
        input.addEventListener("keypress", function (event) {
          const c = event.key;
          if (!regex.test(c)) {
            event.preventDefault();
            document.getElementById("lnerr").innerText = "Enter Alphabets Only";
            document.getElementById("lnerr").style.color = "RED";
          } else {
            document.getElementById("lnerr").innerText = "";
          }
        });
      }

      function validateNumeric(input) {
        input.addEventListener("keypress", function (event) {
          const regex = /^[0-9]+$/;
          const c = event.key;
          if (!regex.test(c)) {
            event.preventDefault();
          }
        });
      }

      function validateForm() {
        let fn = document.getElementById("firstName").value;
        let ln = document.getElementById("lastName").value;
        let tel = document.getElementById("tel").value;
        let email = document.getElementById("username").value;
        let pw = document.getElementById("password").value;

        if (fn == "" || ln == "" || tel == "" || email == "" || pw == "") {
          document.getElementById("error").innerText =
            "All Fields are Mandatory";
          document.getElementById("error").style.color = "RED";
          return false;
        } else {
          return true;
        }
      }
    </script>
  </body>
</html>
