package trivia;
import java.util.Arrays;
import java.util.Scanner;

public class GameController
{
    //~ Fields ................................................................

    private ScoreTracker score;
    public int questionNumber;
    
    private int userScore = score.getScore();
    Scanner input = new Scanner(System.in);
    
    //~ Constructors ..........................................................

    public GameController(ScoreTracker score, QuestionBank questionBank) {
        this.score = score;
        this.questionBank = questionBank;
        this.questionNumber = 0;
    }
    
    //~Public  Methods ........................................................

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
    
    public void endCategory()
    {
        System.out.println("You have answered all the quesstions in this category! Your score so far is: " + userScore);
    }
    
    public void nextQuestion()
    {
        
    }
    
    public boolean validAnswer(String answer)
    {
        String formattedAnswer = answer.trim().toLowerCase();
        
        // 4 answer choices (a -> d)
        if (Arrays.asList("a", "b", "c", "d").contains(formattedAnswer))
        {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validCategory(String category)
    {
        String formattedCategory = category.trim().toLowerCase();
        
        // 5 category choices (a -> e)
        if (Arrays.asList("a", "b", "c", "d", "e").contains(formattedCategory))
        {
            return true;
        } else {
            return false;
        }
    }
    
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
    
}
