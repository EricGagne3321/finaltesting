<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login and Registration</title>
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <script src="js/login.js"></script>
</head>
<body>
  <!-- Your JSP content here -->
  
  <!-- Forms container -->
  <div class="form-container" id="form-container">
    <!-- Login form -->
    <form id="login-form" action="Login" method="post">
      <h2>Login</h2>
      <!-- Your login form fields here -->
      <div class="form-field">
        <label for="login-email">Email:</label>
        <input type="email" id="login-email" name="login-email" value="user@example.com">
      </div>
      
      <div class="form-field">
        <label for="login-password">Password:</label>
        <input type="password" id="login-password" name="login-password" value="password">
      </div>
      
      <button type="submit">Login</button>
    </form>
    
    <!-- Registration form -->
    <form id="registration-form" class="registration-form" style="display: none;" action="register" method="post">
      <h2>Registration</h2>
      <!-- Your registration form fields here -->
      <div class="form-field">
        <label for="reg-first-name">First Name:</label>
        <input type="text" id="reg-first-name" name="reg-first-name">
      </div>
      
      <div class="form-field">
        <label for="reg-last-name">Last Name:</label>
        <input type="text" id="reg-last-name" name="reg-last-name">
      </div>
      
      <!-- Include the login fields again for convenience -->
      <div class="form-field">
        <label for="reg-email">Email:</label>
        <input type="email" id="reg-email" name="reg-email">
      </div>
      
      <div class="form-field">
        <label for="reg-password">Password:</label>
        <input type="password" id="reg-password" name="reg-password">
      </div>
      
      <button type="submit">Register</button>
    </form>
  </div>

  <!-- Toggle button -->
  <button class="toggle-button" onclick="toggleForms()">Switch Form</button>

</body>
</html>
