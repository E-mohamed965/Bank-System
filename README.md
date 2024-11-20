
# Bank Management System

## Overview

This is a Java-based graphical user interface (GUI) application for managing banking-related operations. It allows users to sign up, select account types, generate account details, and perform transactions like deposits, withdrawals, and balance inquiries. The backend is powered by MySQL for data storage.

---

## Features

### Sign Up Process
1. **Personal Details**: Users input their personal information such as name, father's name, date of birth, gender, and address on the first page.
2. **Account Details**: Users select their account type and choose required services like ATM cards, internet banking, etc., on the second page.

### Transactions
1. **Deposit**: Enables users to deposit money into their account.
2. **Cash Withdrawal**: Allows users to withdraw money.
3. **Balance Inquiry**: Displays the current account balance.

### Security
- A 16-digit card number and a 4-digit PIN are generated during account creation.
- Users confirm their information before submission.

---

## Technologies Used

1. **Java Swing**: For GUI development.
2. **MySQL**: For data persistence.
3. **JDBC**: To connect the Java application with the MySQL database.
4. **Toedter Calendar Library**: For date selection in the sign-up process.

---

## File Descriptions

1. **SignupOne.java**: Handles the first page of user sign-up for collecting personal details.
2. **SignupTwo.java**: Handles the second page of user sign-up for account details and services.
3. **Transactions.java**: Implements the main menu for banking transactions.
4. **Conn.java**: Manages the MySQL database connection.
5. **icons/**: Stores images used in the GUI.

---

## Setup and Execution

### Prerequisites
1. Install **Java Development Kit (JDK)**.
2. Install **MySQL Database**.
3. Add **Toedter Calendar** library to the Java project's classpath.

### Database Setup
1. Create a MySQL database named `bankmanagmentsystem`.
2. Create the required tables:
   - **signup**: For storing personal details.
   - **signuptwo**: For storing account type and services.
   - **login**: For storing login credentials.
   - **bank**: For storing transaction details.

### Running the Application
1. Compile the Java files:
   ```bash
   javac Bank/Managment/*.java
   ```
2. Run the application starting with `SignupOne`:
   ```bash
   java Bank.Managment.SignupOne
   ```

---

## Future Enhancements
- Add more transaction types like **Fast Cash**, **Mini Statement**, etc.
- Implement password recovery.
- Enhance the UI/UX for better user experience.

---

## License
This project is licensed under the MIT License.
