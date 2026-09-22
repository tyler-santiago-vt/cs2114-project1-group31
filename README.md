# Super Trivia

A simple console-based trivia game written in Java. Pick a category, answer
10 questions, and try to clear all 5 categories without getting one wrong.

## Categories

- Animals
- Music
- Geography
- People
- History

## How to Play

1. Run the game and select a category by entering its letter (A-E).
2. Answer each question by entering a letter (A-D).
3. Answer all 10 questions correctly to complete the category and move on
   to a new one.
4. Get a question wrong, and the game ends immediately.
5. Complete all 5 categories to win.

## Project Structure

```
src/trivia/
├── Main.java              # Entry point; runs the game loop
├── GameController.java    # Game flow, input handling, scoring logic
├── Question.java          # A single question (prompt, answers, solution)
├── QuestionBank.java      # Holds all questions, grouped by category
├── ScoreTracker.java      # Tracks the player's score
└── *Test.java             # JUnit tests for each class above
```

## Requirements

- Java 8 or later
- JUnit 4 (for running the tests)

## Running the Game

Compile and run from the `src` directory:

```
javac trivia/*.java
java trivia.Main
```

## Running the Tests

With JUnit 4 and Hamcrest on the classpath:

```
javac -cp junit-4.13.2.jar:hamcrest-core-1.3.jar -d out trivia/*.java
java -cp out:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore trivia.QuestionTest trivia.ScoreTrackerTest trivia.QuestionBankTest trivia.GameControllerTest
```