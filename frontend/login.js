// -------------------------------
// Element selection
// -------------------------------
const buttons = document.querySelectorAll(".auth-toggle__btn");
const slider = document.querySelector(".auth-toggle__slider");

const loginForm = document.querySelector(".auth-form--login");
const signupForm = document.querySelector(".auth-form--signup");
const formContainer = document.querySelector("#form-container"); // make sure HTML has this

// -------------------------------
// Update container height
// -------------------------------
function updateContainerHeight() {
  const visibleForm = document.querySelector(".auth-form.is-active");
  if (!visibleForm || !formContainer) return;

  const styles = getComputedStyle(formContainer);
  const paddingTop = parseFloat(styles.paddingTop);
  const paddingBottom = parseFloat(styles.paddingBottom);
  const EXTRA_SPACE = 40;

  formContainer.style.height =
      visibleForm.scrollHeight + paddingTop + paddingBottom + EXTRA_SPACE + "px";
}

// -------------------------------
// Initial setup
// -------------------------------
window.addEventListener("load", updateContainerHeight);

// -------------------------------
// Toggle login/signup forms
// -------------------------------
buttons.forEach((btn) => {
  btn.addEventListener("click", () => {
    if (btn.classList.contains("is-active")) return;

    buttons.forEach(b => b.classList.remove("is-active"));
    btn.classList.add("is-active");

    slider.style.transform =
      btn.dataset.mode === "signup" ? "translateX(100%)" : "translateX(0)";

    if (btn.dataset.mode === "signup") {
      loginForm.classList.remove("is-active");
      signupForm.classList.add("is-active");
    } else {
      signupForm.classList.remove("is-active");
      loginForm.classList.add("is-active");
    }

    updateContainerHeight();
  });
});

// -------------------------------
// Form validation for signup
// -------------------------------
function validateForm(email, password, confirmPassword) {
  const errors = [];
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) errors.push({ field: "email", message: "Invalid email format." });

  if (password !== confirmPassword) errors.push({ field: "password", message: "Passwords must match." });

  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]).{8,}$/;
  if (!passwordRegex.test(password)) errors.push({
    field: "password",
    message: "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character."
  });

  return errors;
}

document.addEventListener("DOMContentLoaded", function() {
  const form = document.getElementById("signUpForm"); // fixed
  if (!form) return;

  form.addEventListener("submit", function(event) {
    event.preventDefault();

    const email = form.querySelector("input[type='email']").value.trim();
    const password = form.querySelector("input[type='password']").value;
    const confirmPassword = form.querySelector("#confirmPasswordInput").value;

    const errors = validateForm(email, password, confirmPassword);

    form.querySelectorAll(".error-msg").forEach(el => el.textContent = "");

    if (errors.length > 0) {
      errors.forEach(err => {
        const el = form.querySelector(`#${err.field}Error`);
        if (el) el.textContent = err.message;
      });
    } else {
      const successMsg = form.querySelector(".success-msg");
      if (successMsg) {
        successMsg.textContent = "Form submitted successfully!";
      }

      //form.submit(); // uncomment to actually submit
    }
  });
});

