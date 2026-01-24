(async function () {
    try {
        const res = await fetch("http://localhost:8080/students/me", {
            credentials: "include"
        });

        if (res.status === 401) {
            window.location.replace("/auth.html");
            return;
        }

        const student = await res.json();

        // Populate UI
        document.getElementById("studentName").textContent =
            student.firstName + " " + student.lastName;

        loadAssignments();

    } catch (err) {
        console.error(err);
        window.location.replace("/login.html");
    }
})();


async function loadAssignments() {
    const res = await fetch("http://localhost:8080/assignments", {
        credentials: "include"
    });

    if (res.status === 401) {
        window.location.replace("/login.html");
        return;
    }

    const assignments = await res.json();
    /*renderAssignments(assignments);*/
}
