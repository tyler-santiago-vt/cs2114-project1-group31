package trivia;

// -------------------------------------------------------------------------
/**
 * ScoreTracker class keeps track of the user's score throughout the trivia
 * round. It can increase, retrieve, and reset the score through a variable.
 *
 * @author Poorna Bhat
 * @version Sep 22, 2026
 */
public class ScoreTracker
{
    // ~ Fields ................................................................
    /**
     * Stores the user's score throughout the trivia game. Kept private so the
     * score can only change through increaseScore()/resetScore(), rather than
     * being reassigned directly from outside the class.
     */
    private int score;

    // ~ Constructors ..........................................................
    /**
     * ScoreTracker constructor initializes the score variable by giving it a
     * value of 0 before the game starts.
     */
    public ScoreTracker()
    {
        score = 0;
    }


    // ~Public Methods ........................................................
    /**
     * increaseScore raises the score value by 1 if the user gets a question
     * right.
     */
    public void increaseScore()
    {
        score = score + 1;
    }


    /**
     * getScore returns the current value of the score variable.
     *
     * @return the current score
     */
    public int getScore()
    {
        return score;
    }


    /**
     * resetScore resets the score back to the initial value of 0.
     */
    public void resetScore()
    {
        score = 0;
    }

}
