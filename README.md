# VitalSense - Mobile Health Monitoring App

## 🩺 Project Overview

VitalSense is a mobile health monitoring Android application that allows users to measure and track their vital signs — Heart Rate (HR), Blood Oxygen Saturation (SpO2), and Blood Pressure (BP) — using the mobile device's built-in camera and flashlight via PPG (Photoplethysmography) technique. All health data is stored locally in an SQLite database and can be reviewed anytime via a user-friendly interface.


## 📱 Features

- ✅ Splash Screen with logo and branding.
- ✅ Simple and clean main dashboard.
- ✅ Health monitoring using the mobile camera (PPG technique).
- ✅ Measurement of:
  - Heart Rate (BPM)
  - SpO2 (%)
  - Blood Pressure (mmHg)
- ✅ Result display screen with reset functionality.
- ✅ Local data storage using SQLite database.
- ✅ Historical data review via side navigation drawer.
- ✅ Professional UI/UX design.



## ⚙ Technologies Used

| Layer | Technology |
|-------|------------|
| Frontend | Android XML Layouts, Android Views, RecyclerView |
| Backend | Java (Android SDK) |
| Database | SQLite |
| Design | Vector Drawables, Custom Logo |
| IDE | Android Studio |
| Sensor Technique | Photoplethysmography (PPG) |



## 📂 Project Structure

VitalSense/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/vitalsense/
│   │   │   │   ├── SplashActivity.java
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── MeasurementActivity.java
│   │   │   │   ├── ResultActivity.java
│   │   │   │   ├── HistoryActivity.java
│   │   │   │   ├── HistoryAdapter.java
│   │   │   │   ├── database/DatabaseHelper.java
│   │   │   │   └── models/MeasurementModel.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── drawable/
│   │   │   │   └── values/
│   │   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
└── settings.gradle
💡 Working Principle
VitalSense uses the mobile camera's flash and lens to capture real-time changes in fingertip color when placed on the camera lens. The PPG algorithm calculates heart rate, oxygen saturation, and blood pressure based on light absorption variations caused by blood flow.

🚀 How To Run
Clone or download this repository.

Open in Android Studio.

Build the project to resolve dependencies.

Deploy to an Android device (camera and flash required).

Start monitoring vitals!

📈 Future Enhancements
Cloud sync & backup.

Export reports in CSV or PDF format.

Doctor consultation reports.

AI-powered advanced prediction.

Multi-user profiles.

📞 Contact
For any queries or suggestions, feel free to contact:

Developer:
VitalSense Team
Email: [g98717209anil@gmail.com]
GitHub: ['github.com:BADAM2001/vitalsense.git']

📖 License
This project is licensed under the MIT License - see the LICENSE file for details.


✅ ✅ ✅

👉 **Shall we continue?**

If you say:

- **"Generate Project Report"** — I’ll prepare a professional document style project report for submission.
- **"Generate Abstract"** — I can generate a small poster-style abstract too.

---

> This will make your VitalSense project 100% ready for academic or professional presentation. 🚀🚀🚀
