package trivia;
import java.util.Arrays;
import java.util.Scanner;

public class GameController
{
    //~ Fields ................................................................

    private ScoreTracker score;
    private Question question;
    public int questionNumber;
    
    private Question[] currentCategoryQuestions;
    private boolean lastAnswerCorrect;
    private boolean gameOver;
    private int userScore = score.getScore();
    Scanner input = new Scanner(System.in);
    
    //~ Constructors ..........................................................

    public GameController(ScoreTracker score, QuestionBank questionBank) {
        this.score = score;
        this.questionBank = questionBank;
        this.questionNumber = 0;
    }
    
    //~Public  Methods ........................................................

    /**
     * Displays the user's score and prints either a win or lose message
     * based on if the user won or lost.
     */
    public void endGame(boolean win)
    {
        String message;
        if (win == true) {
            message = "Correct! You've answered all questions correctly! Score: ";
        } else {
            message = "Incorrect, Game Over! Score: ";
        }
        
        System.out.println(message + userScore);
    }
    
    /**
     * Displays the user's score after finishing a category.
     */
    public void endCategory()
    {
        System.out.println("You have answered all the quesstions in this category! Your score so far is: " + userScore);
    }
    
    /**
     * Sets the current question to the next one up in the question array
     * from the selected category, prints the question prompt + possible
     * answers, and prompts the user for an answer.
     */
    public void nextQuestion() {
        question = currentCategoryQuestions[questionNumber];

        System.out.println(question.getPrompt());
        for (String answer : question.getAnswers()) {
            System.out.println(answer);
        }

        String userAnswer = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Your answer: ");
            userAnswer = input.nextLine().trim();
            valid = validAnswer(userAnswer);
            if (!valid) {
                System.out.println("Please enter A, B, C, or D.");
            }
        }

        lastAnswerCorrect = question.checkSolution(userAnswer);
        if (lastAnswerCorrect) {
            score.increaseScore();
            System.out.println("Correct!");
            questionNumber++;
        } else {
            System.out.println("Incorrect. The correct answer was: " + question.getCorrectAnswerText());
            gameOver = true;
            endGame();
        }
    }
    
    /**
     * Returns if the given answer is valid
     */
    public boolean validAnswer(String answer)
    {
        String formattedAnswer = answer.trim().toLowerCase();
        
        // 4 answer choices (a -> d)
        return (Arrays.asList("a", "b", "c", "d").contains(formattedAnswer));
    }
    
    /**
     * Returns if the given category is valid
     */
    public boolean validCategory(String category)
    {
        String formattedCategory = category.trim().toLowerCase();
        
        // 5 category choices (a -> e)
        return (Arrays.asList("a", "b", "c", "d", "e").contains(formattedCategory));
    }
    
    /**
     * Prompts the user to select and answer. If the user has a valid input,
     * it returns the selected answer. Otherwise, it re-prompts the user
     * to input a valid answer.
     */
    public String selectAnswer(String answer)
    {
        boolean validAnswer = false;
        String userInput = "";
        
        while (validAnswer == false)
        {
            System.out.println("Select an answer from the choices above");
            userInput = input.nextLine();
            if (validAnswer(userInput))
            {
                return userInput.toUpperCase();
            } else {
                System.out.println("Invalid input. Please input 'a', 'b', 'c', or 'd' to select the desired answer choice");
            }
        }
    }
    
    /**
     * Prompts the user to select a category. If the user input is valid,
     * returns the category. Otherwise, prompts the user for a valid input
     */
    public String selectCategory(String category)
    {
        boolean validCategory = false;
        String userInput = "";
        
        while (validCategory == false)
        {
            System.out.println("Select a category: A) Animals, B) Music, C) Geography, D) People, E) History");
            userInput = input.nextLine();
            if (validCategory(userInput))
            {
                switch (userInput.toUpperCase()) {
                    case "A":
                        return "animals";
                        break;
                    case "B":
                        return "music";
                        break;
                    case "C":
                        return "geography";
                        break;
                    case "D":
                        return "people";
                        break;
                    case "E":
                        return "history";
                        break;
                }
            } else {
                System.out.println("Invalid selection. Please input 'A', 'B', 'C', 'D', or 'E' to select the desired category.");
            }
            
        }
    }
    
    /**
     * Returns if gameOver has been set to true or not
     */
    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * Resets the game by changing all values to their defaults
     */
    public void resetGame() {
        gameOver = false;
        questionNumber = 0;
        currentCategoryQuestions = null;
        score.resetScore();
    }
    
    /**
     * Returns whether or not there are more questions left in the current category
     */
    public boolean hasMoreQuestions() {
        return !gameOver && currentCategoryQuestions != null && questionNumber < currentCategoryQuestions.length;
    }
    
    /**
     * Displays the user's score when ending the game
     */
    public void endGame() {
        System.out.println("Game over! Your final score is: " + score.getScore());
    }
    
}
