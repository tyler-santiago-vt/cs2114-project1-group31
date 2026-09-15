package trivia;
import java.util.Arrays;
public class GameController
{
    //~ Fields ................................................................

    private ScoreTracker score;
    
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
        
        System.out.println(message + score.getScore());
    }
    
    public void endCategory()
    {
    }
    
    public void nextQuestion()
    {
        
    }
    
    public boolean validAnswer(String answer)
    {
        String formattedAnswer = answer.trim().toLowerCase();
        
        if (Arrays.asList("a", "b", "c", "d").contains(formattedAnswer))
        {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validCategory(String category)
    {
        
    }
    
}
