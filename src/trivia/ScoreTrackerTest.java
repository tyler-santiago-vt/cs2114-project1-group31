package trivia;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class for ScoreTracker, verifying score starts at zero, increases
 * correctly, and resets correctly, including repeated-use edge cases.
 *
 * @author Tyler Santiago
 * @version Sep 22, 2026
 */
public class ScoreTrackerTest
{
    // ~ Fields ................................................................
    private ScoreTracker tracker;

    // ~ Constructors ..........................................................
    /**
     * Sets up a fresh ScoreTracker before each test runs.
     */
    @Before
    public void setUp()
    {
        tracker = new ScoreTracker();
    }

    // ~Public Methods ........................................................


    /**
     * Normal case: a brand-new tracker starts at a score of 0.
     */
    @Test
    public void testInitialScoreIsZero()
    {
        assertEquals(0, tracker.getScore());
    }


    /**
     * Normal case: increaseScore raises the score by exactly 1.
     */
    @Test
    public void testIncreaseScoreOnce()
    {
        tracker.increaseScore();
        assertEquals(1, tracker.getScore());
    }


    /**
     * Normal case: repeated increases accumulate correctly.
     */
    @Test
    public void testIncreaseScoreMultipleTimes()
    {
        for (int i = 0; i < 5; i++)
        {
            tracker.increaseScore();
        }
        assertEquals(5, tracker.getScore());
    }


    /**
     * Normal case: resetScore brings a non-zero score back to 0.
     */
    @Test
    public void testResetScoreAfterIncreasing()
    {
        tracker.increaseScore();
        tracker.increaseScore();
        tracker.resetScore();
        assertEquals(0, tracker.getScore());
    }


    /**
     * Edge case: resetting a tracker that was never increased should safely
     * remain at 0, not throw or go negative.
     */
    @Test
    public void testResetScoreWhenAlreadyZero()
    {
        tracker.resetScore();
        assertEquals(0, tracker.getScore());
    }


    /**
     * Edge case: score can continue increasing normally after a reset.
     */
    @Test
    public void testIncreaseScoreAfterReset()
    {
        tracker.increaseScore();
        tracker.resetScore();
        tracker.increaseScore();
        assertEquals(1, tracker.getScore());
    }
}
