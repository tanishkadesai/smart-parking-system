# 🚗 Smart Parking System

A Smart Parking Management System built using **Java (JSP & Servlets)** and **MySQL** that allows users to manage parking slots efficiently with a modern dark-themed UI.

---

## ✨ Features

- 🚘 Park Vehicle (auto slot allocation)
- 🚪 Exit Vehicle (bill generation based on time)
- 🔍 Search Vehicle
- 📊 Dashboard (Total / Available / Occupied slots)
- 🅿️ View Parking Slots visually
- 🧾 Parking Receipt with bill calculation
- 🌙 Modern Dark UI with glassmorphism design

---

## 🛠️ Tech Stack

- **Frontend:** HTML, CSS, JSP
- **Backend:** Java Servlets
- **Database:** MySQL
- **Server:** Apache Tomcat

---

## 📸 Screenshots

### Dashboard
(Add your screenshot here)

### Parking Slots UI
(Add your screenshot here)

### Receipt
(Add your screenshot here)

---

## ⚙️ How to Run

1. Clone the repository
```bash
git clone https://github.com/your-username/smart-parking-system.git

2. Open in IntelliJ / Eclipse
3. Configure Tomcat Server
4. Setup MySQL database:
CREATE TABLE parking_slots (
    slot_id INT PRIMARY KEY,
    status VARCHAR(20),
    vehicle_no VARCHAR(20),
    entry_time TIMESTAMP
);

5. Run the project

📂 Project Structure
src/
 └── main/
     ├── java/servlets/
     ├── webapp/
     │    ├── index.jsp
     │    ├── viewSlots.jsp
     │    ├── receipt.jsp
     │    ├── style.css
     │    └── images/

🚀 Future Improvements
🔔 Notifications system
📱 Mobile responsive UI
💳 Online payment integration
📈 Analytics dashboard

👩‍💻 Author
Tanishka Desai

