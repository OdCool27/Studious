// Validate email and password
function validateForm(email, password, confirmPassword) {
  const errors = [];

  // Email validation
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    errors.push({ field: "email", message: "Invalid email format." });
  }

  // Password validation
  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]).{8,}$/;

  if(password != confirmPassword){
    errors.push({
          field: "password",
          message: "Passwords must match."
        });
  }

  if (!passwordRegex.test(password)) {
    errors.push({
      field: "password",
      message: "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character."
    });
  }

  return errors;
}

// Run after DOM is loaded
document.addEventListener("DOMContentLoaded", function() {
  const form = document.getElementById("myForm");

  form.addEventListener("submit", function(event) {
    event.preventDefault(); // prevent default submission

    // Clear previous messages
    document.getElementById("emailError").textContent = "";
    document.getElementById("passwordError").textContent = "";
    document.getElementById("successMsg").textContent = "";

    const email = document.getElementById("emailInput").value.trim();
    const password = document.getElementById("passwordInput").value;
    const confirmPassword = document.getElementById("confirmPasswordInput").value;

    const errors = validateForm(email, password, confirmPassword);

    if (errors.length > 0) {
      // Display errors
      errors.forEach(err => {
        if (err.field === "email") {
          document.getElementById("emailError").textContent = err.message;
        } else if (err.field === "password") {
          document.getElementById("passwordError").textContent = err.message;
        }
      });
    } else {
      // Success
      document.getElementById("successMsg").textContent = "Form submitted successfully!";
      form.submit(); // uncomment to actually submit
    }
  });
});
