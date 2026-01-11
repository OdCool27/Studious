const buttons = document.querySelectorAll(".auth-toggle__btn");
const slider = document.querySelector(".auth-toggle__slider");

const loginForm = document.querySelector(".auth-form--login");
const signupForm = document.querySelector(".auth-form--signup");

buttons.forEach((btn, index) => {
  btn.addEventListener("click", () => {

    // If already active, do nothing
    if (btn.classList.contains("is-active")) return;

    // Toggle active button
    buttons.forEach(b => b.classList.remove("is-active"));
    btn.classList.add("is-active");

    // Move slider
    slider.style.transform =
      btn.dataset.mode === "signup"
        ? "translateX(100%)"
        : "translateX(0)";

    // Swap forms
    if (btn.dataset.mode === "signup") {
      loginForm.classList.remove("is-active");
      signupForm.classList.add("is-active");
    } else {
      signupForm.classList.remove("is-active");
      loginForm.classList.add("is-active");
    }
  });
});
