/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Function to toggle between login and registration forms

function toggleForms() {
  var loginForm = document.getElementById('login-form');
  var registrationForm = document.getElementById('registration-form');
  var toggleButton = document.querySelector('.toggle-button');

  if (loginForm.style.display === 'none') {
    loginForm.style.display = 'block';
    registrationForm.style.display = 'none';
    toggleButton.textContent = 'Switch Form';
  } else {
    loginForm.style.display = 'none';
    registrationForm.style.display = 'block';
    toggleButton.textContent = 'Switch Form';
  }
}

// Show the login form as default
document.getElementById('registration-form').style.display = 'block';