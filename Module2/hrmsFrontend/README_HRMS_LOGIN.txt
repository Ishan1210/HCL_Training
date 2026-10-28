HRMS FRONTEND - LOGIN AND ATTENDANCE DASHBOARD

Project folder name is unchanged: hrmsFrontend

Requirements:
- Node.js and npm
- Backend running at http://localhost:8080

Run:
1. Extract the zip.
2. Open a terminal in the hrmsFrontend folder.
3. Run: npm install
4. Run: npm run dev
5. Open the local URL printed by Vite (normally http://localhost:5173).

Pages:
- / : Employee Portal with Login and Register options
- /registration : Register employee
- /login : Login using registered email and password
- /dashboard : Shows employee details and their attendance date, in-time and out-time

The dashboard displays attendance for the logged-in employee ID only. If there are no records for that employee yet, it displays an empty-state message.
