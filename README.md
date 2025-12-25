# Studious

**Studious** is a student assistance web application designed to help students organize their academic workload and collaborate with peers. Its core functionality includes assignment and assessment tracking, timetable management, and group collaboration features.

![Studious Screenshot](demo/Studious%20-%20SignUp.jpeg)  
*Screenshot of the Studious web interface.*

---

## Features

### Academic Organization
- Register with name, email, and school/university.
- Select modules/subjects from a predefined list.
- Recreate your semester timetable with module sessions and locations.
- Add and manage assignments and upcoming assessments.
- View assignments and exams in a calendar format.
- Receive automated email reminders for deadlines.

### Collaboration
- Create or join study groups or group-assignment teams.
- In-app chat for group communication.
- Share documents within groups.
- Create group calendar events with external meeting links.
- Group events sync to all members’ calendars.

### Administration (Optional / Future)
- Manage the predefined list of modules/subjects.
- Manage student accounts (activate/deactivate users).

---

## Functional Requirements

- Secure user registration and login.
- Profile updates.
- Module and timetable management.
- Assignment and assessment management (add/edit/delete).
- Calendar view for assignments and exams.
- Email notifications for upcoming and overdue tasks.
- Group creation, joining, and management.
- In-app chat and document sharing for groups.
- Syncing group events to all members’ calendars.
- Admin features for module and user management.
- Extensible architecture for future features like video calls and enhanced analytics.

---

## Non-Functional Requirements

- **Performance:** Responses within 2–3 seconds for user actions.
- **Scalability:** Support multiple users and groups concurrently; scalable backend.
- **Usability:** Intuitive, responsive, and mobile-friendly design.
- **Reliability & Availability:** Accurate data with minimal downtime; core services available 99% of the time.
- **Security:** Secure authentication (JWT) and data protection.
- **Maintainability:** Modular, well-documented code.
- **Portability:** Works across browsers and devices; mobile transition feasible.
- **Data Integrity:** Consistent and synchronized data.
- **Extensibility:** Architecture supports future features.
- **Email Notifications:** Reliable and timely notifications.
- **Compliance:** Follow data protection guidelines (e.g., GDPR if applicable).

---

## User Roles

### Student
- Manage profile, modules, timetable, assignments, and assessments.
- Receive notifications for deadlines.
- Participate in groups with chat, document sharing, and event management.

### Admin (Optional / Future)
- Manage module list and student accounts.
- Oversee system usage and ensure data integrity.

---

## Architecture Notes

- **Languages:** HTML, CSS, JavaScript, Java, SQL
- **Framework:** Spring Boot
- **Database:** PostgreSQL
- **Architecture Style:** Layered / MVC / Microservices
- **Third-party Services:** Email notifications, calendar integration
- **Security:** JWT authentication

---

## Screenshot

![Studious Screenshot](path/to/your/image.png)  
*Example view of the Studious calendar and group interface.*

---

## Future Roadmap

Planned enhancements and improvements for Studious:

- **Mobile Application:** Transition the web platform to a mobile-friendly app.
- **Project Management as Academic Tasks:**
    - Add a “Project” feature with a list of subtasks.
    - Assign specific students to individual subtasks.
    - Allow multiple students in a group to check/uncheck, edit, add, or delete subtasks.
    - Enable shared visibility and collaboration for group projects.
- **Additional Features (Optional/Future):**
    - Video calls with screen sharing.
    - Enhanced student progress analytics.
    - Improved notifications and reminders.
    - Advanced reporting for assignments and group activities.

