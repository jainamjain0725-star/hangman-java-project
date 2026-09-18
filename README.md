# Hangman Word Guessing Game

A modular, console-based implementation of the classic Hangman word-guessing game written in Java using Object-Oriented Programming (OOP) principles.

---

## 1. Overview
Developed as part of the **VITyarthi Build Your Own Project (BYOP)** initiative, this project implements an interactive word puzzle game. The system is designed with a clean separation of concerns across 7 modular Java classes, featuring dynamic difficulty scaling, robust input validation, file-based score persistence, and automated logic verification.

---

## 2. Features
- **3 Difficulty Tiers:**
  - **Easy:** 7 attempts (simpler vocabulary like *apple, mango, kiwi*)
  - **Medium:** 5 attempts (moderate vocabulary like *banana, orange, cherry*)
  - **Hard:** 4 attempts (challenging vocabulary like *strawberry, pineapple, watermelon*)
- **Defensive Input Validation:**
  - Blocks numbers, punctuation, and multi-character inputs.
  - Detects duplicate guesses and warns the player without deducting an attempt.
- **Score Persistence:**
  - Automatically records winning player names and points (`attempts left × 10`) to `scores.txt`.
  - Accessible leaderboard view directly from the main menu.
- **Automated Verification:**
  - Dedicated test suite (`TestGame.java`) to ensure game rules, masking, and input handling operate reliably.

---

## 3. Technologies & Tools Used
- **Language:** Java (JDK 17 or higher)
- **Programming Paradigm:** Object-Oriented Programming (OOP)
- **Data Storage:** Java File I/O (`scores.txt`)
- **Version Control:** Git & GitHub

---

## 4. Project Structure

```text
Hangman-Project/
├── hangman/
│   ├── Game.java          # Core game logic, masking, and turn tracking
│   ├── Main.java          # Application entry point and interactive menu
│   ├── Player.java        # Encapsulates player details and score
│   ├── ScoreBoard.java    # Handles reading and writing to scores.txt
│   ├── TestGame.java      # Automated logic verification test suite
│   ├── Validator.java     # Input sanitization and duplicate checking
│   └── WordList.java      # Word repository categorized by difficulty
├── README.md              # Project documentation and guide
├── statement.md           # Problem statement and project scope
└── scores.txt             # Persistent leaderboard file (auto-generated)
```

---

## 5. Installation & How to Run

### Prerequisites
- Java Development Kit (JDK 17 or later) installed on your system.

### Steps to Run:
1. Open terminal or Command Prompt inside the `Hangman-Project` folder.
2. Compile the project:
   ```bash
   javac hangman/*.java
   ```
3. Run the game:
   ```bash
   java hangman.Main
   ```

---

## 6. Instructions for Testing

To run the automated test suite and verify that all core mechanics work properly:

```bash
java hangman.TestGame
```

### Expected Output:
```text
Test 1 Passed: Initial display is correct
Test 2 Passed: Revealed letter is correct
Test 3 Passed: Wrong guess decreases turn
Test 4 Passed: Input validator works
```

---

## 7. Sample Gameplay (Terminal Output)

```text
What's your name? Alex
Hi, Alex Time to play Hangman!

1. Game Time
2. See Scores
3. Exit Game
Make a choice: 1

Set difficulty:
1. Easy Level - 7 Attempts
2. Medium Level - 5 Attempts
3. Hard Level -  4 Attempts
Choice: 2

Make your guess.

Word: _ _ _ _ _ _
Guesses: 
Attempts left: 5

Guess a letter: a
Word: _ a _ a _ a
Guesses: a
Attempts left: 5

Guess a letter: b
Word: b a _ a _ a
Guesses: ab
Attempts left: 5

Guess a letter: n
Word: b a n a n a

You did it
Score achieved: 50
```
