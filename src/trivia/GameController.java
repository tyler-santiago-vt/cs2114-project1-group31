package trivia;
import java.util.Arrays;

public class GameController
{
    //~ Fields ................................................................

    private ScoreTracker score;
    
    private int userScore = score.getScore();
    
    //~ Constructors ..........................................................

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
    
}
