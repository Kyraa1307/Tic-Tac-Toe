# Tic-Tac-Toe Game with Login, and Statistics

## Student Information
Name      : Gede Bagus Teguh Saka Phalguna
Student ID: 5026251190
Class     : E

---

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing.
The application requires login using a database, allows the user to play against a computer,
records game statistics (wins, losses, draws, score), and displays the Top 5 scorers.

---

## Features
- Login using username and password stored in a MySQL database
- Play Tic-Tac-Toe on a 3×3 Swing GUI board
- Computer makes random moves as opponent
- Records wins, losses, draws, and score after each game
- Display personal statistics
- Display Top 5 scorers using JTable (data from database)

---

## Score System
| Result | Score Change |
|--------|-------------|
| Win    | +10 points  |
| Draw   | +3 points   |
| Lose   | +0 points   |

---

## Database
Database used: **MySQL**

---

## How to Run

### 1. Create the Database
- Open MySQL (phpMyAdmin, MySQL Workbench, or command line)
- Run the file `database/schema.sql`

### 2. Configure Database Connection
- Open `src/DatabaseManager.java`
- Change `URL`, `USER`, and `PASSWORD` to match your MySQL configuration:
```java
private static final String URL = "jdbc:mysql://localhost:3306/game_project";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 3. Add JDBC Driver
- Download `mysql-connector-j-x.x.x.jar` from https://dev.mysql.com/downloads/connector/j/
- Add it to your project's classpath in your IDE (IntelliJ / Eclipse / NetBeans)

### 4. Run the Program
- Open the project in your IDE
- Run `Main.java`
- Login using one of the sample accounts: username `student1`, password `12345`

---

## Class Explanation

| Class | Responsibility |
|-------|---------------|
| `Main` | Starts the program and opens the Login Window |
| `DatabaseManager` | Handles JDBC database connection |
| `Player` | Stores player data (id, username, wins, losses, draws, score) |
| `PlayerService` | Handles login, statistics update, and Top 5 query |
| `GameLogic` | Handles move validation, winner checking, draw, and computer moves |
| `LoginFrame` | Swing window for login |
| `MainMenuFrame` | Swing window for main menu navigation |
| `GameFrame` | Swing window for playing the game |
| `StatisticsFrame` | Swing window showing personal statistics |
| `TopScorersFrame` | Swing window showing Top 5 scorers using JTable |

---

## TODO Parts Completed by Student
- [x] `DatabaseManager` — database URL, USER, PASSWORD
- [x] `PlayerService.login()` — SQL query and Player object return
- [x] `PlayerService.updateStatistics()` — update wins/losses/draws/score
- [x] `PlayerService.getTopFiveScorers()` — Top 5 query from database
- [x] `LoginFrame` — login button event handling
- [x] `MainMenuFrame` — navigation buttons
- [x] `GameLogic.computerMove()` — random computer move
- [x] `GameFrame` — connect buttons to game logic and database update
- [x] `StatisticsFrame` — display personal stats
- [x] `TopScorersFrame` — display Top 5 using JTable

---

## Screenshots
_(Add screenshots of Login Window, Game Window, Statistics, Top 5 Scorers here)_

---

## GitHub Repository Link
[YOUR GITHUB LINK HERE]

## YouTube Demonstration Video
[YOUR YOUTUBE LINK HERE]
