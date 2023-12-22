# Restaurant Management Application

Welcome to the README of the University Restaurant Management Application, a Java-based Android application developed to manage restaurant-related activities. This application covers various features, including user authentication, feedback collection, reservation of meals, and a virtual currency system called "Restona coins."

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [YouTube Video](#youtube-video)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The University Restaurant Management Application is designed to streamline restaurant-related tasks for university students. Users can log in, view their account balance (Restona coins), provide feedback on meals, and reserve meals for specific days.

## Features

### 1. Dashboard
- View account balance (Restona coins).
- Navigate to different sections: Money, Stars, Ticket, and Food.
- Log out from the application.

### 2. Money Section
- Scan QR codes to earn Restona coins.
- View and update account balance.

### 3. Stars Section
- Rate meals and provide comments.
- Feedback is stored in the Firebase database.

### 4. Ticket Section
- Reserve meals for specific days.
- Account balance is checked before allowing reservations.

### 5. Food Section
- View the menu for each day of the week.

### 6. User Authentication
- Secure user login and registration.

## Installation

**Open the project in Android Studio:**
   ```bash
   git clone https://github.com/yourusername/restaurant-management-app.git

## Connect to Firebase

1. **Create a new Firebase project.**
2. **Add your Android app to the Firebase project.**
3. **Download the `google-services.json` file and place it in the app directory.**
4. **Build and run the application on an Android emulator or device.**

## Usage

1. Launch the application and log in using your credentials.
2. Explore the dashboard and navigate to different sections.
3. Scan QR codes in the Money section to earn Restona coins.
4. Provide feedback on meals in the Stars section.
5. Reserve meals for specific days in the Ticket section.
6. Log out when finished.

## YouTube Video

Check out the [YouTube video](https://www.youtube.com/watch?v=JoepajIt898) demonstrating the features and usage of the application.

## Dependencies

- Firebase Authentication
- Firebase Realtime Database
- Zxing Android Embedded for QR code scanning
- AndroidX libraries

## Contributing

Contributions to the project are welcome! If you find any issues or have enhancements to suggest, please open an issue or create a pull request.
