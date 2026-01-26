document.addEventListener("DOMContentLoaded", () => {
    const sessions = [
        {
            module: "Math",
            dayOfWeek: "MONDAY",
            startTime: "09:00",
            endTime: "12:00",
            type: "Lecture",
            location: "2B-5"
        },
        {
            module: "Physics",
            dayOfWeek: "WEDNESDAY",
            startTime: "10:00",
            endTime: "14:00",
            type: "Lab",
            location: "1B-9"
        },
        {
            module: "English",
            dayOfWeek: "WEDNESDAY",
            startTime: "14:00",
            endTime: "16:00",
            type: "Lecture",
            location: "1B-11"
        }
    ];

    renderTimetable(sessions);
});

function timeToMinutes(time) {
    const [h, m] = time.split(":").map(Number);
    return h * 60 + m;
}


function renderTimetable(sessions) {
    const tbody = document.querySelector("#timetable tbody");
    const hours = ["08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30",
        "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30",
        "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"];

    hours.forEach(hour => {
        const row = document.createElement("tr");
        const timeCell = document.createElement("td");
        timeCell.innerText = hour;
        row.appendChild(timeCell);

        ["MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY", "SATURDAY", "SUNDAY"].forEach(day => {
            const cell = document.createElement("td");

            const session = sessions.find(s =>
                s.dayOfWeek === day && s.startTime === hour
            );

            if (session) {
                const start = timeToMinutes(session.startTime);
                const end = timeToMinutes(session.endTime);
                const duration = end - start;
                const rowSpan = duration / 30;//Divide by the interval on the timetable

                cell.rowSpan = rowSpan;
                cell.classList.add("session");
                cell.innerHTML = `
                  <strong>${session.module}</strong><br>
                  <small>${session.type || ""}</small><br>
                  <small>${session.startTime} – ${session.endTime}</small><br>
                  <small>${session.location || ""}</small>
                  
                `;
            } else {
                // Skip cells that are covered by a rowspan
                const isCovered = sessions.some(s =>
                    s.dayOfWeek === day &&
                    timeToMinutes(s.startTime) < timeToMinutes(hour) &&
                    timeToMinutes(s.endTime) > timeToMinutes(hour)
                );

                if (isCovered) return;
            }

            row.appendChild(cell);
        });


        tbody.appendChild(row);
    });
}
