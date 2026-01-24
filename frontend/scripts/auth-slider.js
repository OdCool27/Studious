// ===============================
// Auth Toggle + Form Swap Logic
// ===============================

const buttons = document.querySelectorAll(".auth-toggle__btn");
const slider = document.querySelector(".auth-toggle__slider");

const loginForm = document.querySelector(".login-form");
const signupForm = document.querySelector(".signup-form");
const formContainer = document.querySelector("#form-container");

// -------------------------------
// Update container height
// -------------------------------
function updateContainerHeight() {
    const visibleForm = document.querySelector(".is-visible");
    if (!visibleForm) return;

    const styles = getComputedStyle(formContainer);
    const paddingTop = parseFloat(styles.paddingTop);
    const paddingBottom = parseFloat(styles.paddingBottom);
    const EXTRA_SPACE = 40;

    formContainer.style.height =
        visibleForm.scrollHeight + paddingTop + paddingBottom + EXTRA_SPACE +"px";
}


// -------------------------------
// Initial setup
// -------------------------------
window.addEventListener("load", () => {
    updateContainerHeight();
});

// -------------------------------
// Handle toggle clicks
// -------------------------------
buttons.forEach((btn) => {
    btn.addEventListener("click", () => {

        // Do nothing if already active
        if (btn.classList.contains("is-active")) return;

        // Toggle active button styles
        buttons.forEach(b => b.classList.remove("is-active"));
        btn.classList.add("is-active");

        // Move slider
        slider.style.transform =
            btn.dataset.mode === "signup"
                ? "translateX(100%)"
                : "translateX(0)";

        // Swap forms
        if (btn.dataset.mode === "signup") {
            loginForm.classList.remove("is-visible");
            signupForm.classList.add("is-visible");
        } else {
            signupForm.classList.remove("is-visible");
            loginForm.classList.add("is-visible");
        }
    });
});

// -------------------------------
// Sync height after animations
// -------------------------------
loginForm.addEventListener("transitionend", updateContainerHeight);
signupForm.addEventListener("transitionend", updateContainerHeight);
