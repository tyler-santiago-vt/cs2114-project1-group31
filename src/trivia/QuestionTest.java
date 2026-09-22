package trivia;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class for Question, makes sure that the question formatting,
 * getters, and answer checking work as they should, for both normal and
 * bad/invalid input.
 *
 * @author Emerson Molina
 * @version Sep 22, 2026
 */
public class QuestionTest
{

    // ~ Fields ................................................................
    private Question question;

    // ~ Constructors ..........................................................
    /**
     * Sets up a fresh question before each test runs.
     */
    @Before
    public void setUp()
    {
        question = new Question(
            "What is 2 + 2?",
            new String[] { "A) 4", "B) 3", "C) 1", "D) 6" },
            "A");
    }

    // ~Public Methods ........................................................


    /**
     * Normal case: the constructor stores a valid prompt/answers/solution.
     */
    @Test
    public void testConstructorNormal()
    {
        assertEquals("What is 2 + 2?", question.getPrompt());
        assertEquals("A", question.getSolution());
    }


    /**
     * Normal case: getPrompt returns exactly what was passed in.
     */
    @Test
    public void testGetPrompt()
    {
        assertEquals("What is 2 + 2?", question.getPrompt());
    }


    /**
     * Normal case: getAnswers returns the answer choices in order.
     */
    @Test
    public void testGetAnswers()
    {
        String[] expected = { "A) 4", "B) 3", "C) 1", "D) 6" };
        assertArrayEquals(expected, question.getAnswers());
    }


    /**
     * Normal case: a correct answer (matching case) is recognized.
     */
    @Test
    public void testCheckSolutionCorrect()
    {
        assertTrue(question.checkSolution("A"));
    }


    /**
     * Normal case: checkSolution ignores case when comparing.
     */
    @Test
    public void testCheckSolutionIgnoresCase()
    {
        assertTrue(question.checkSolution("a"));
    }


    /**
     * Bad-input case: an incorrect answer letter is rejected.
     */
    @Test
    public void testCheckSolutionIncorrect()
    {
        assertFalse(question.checkSolution("C"));
    }


    /**
     * Bad-input case: a null answer is treated as incorrect rather than
     * throwing a NullPointerException.
     */
    @Test
    public void testCheckSolutionNullAnswer()
    {
        assertFalse(question.checkSolution(null));
    }
}
