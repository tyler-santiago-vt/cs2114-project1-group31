package trivia;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class for GameController, covering category/answer validation,
 * category and answer selection (including re-prompting on invalid or
 * already-completed input), question flow, and game-state bookkeeping such as
 * resetGame and allCategoriesCompleted. Input to GameController is simulated by
 * redirecting System.in before constructing each GameController, since its
 * Scanner field reads from System.in at construction time.
 *
 * @author Tyler Santiago
 * @version Sep 22, 2026
 */
public class GameControllerTest
{
    // ~ Fields ................................................................
    private ScoreTracker score;
    private QuestionBank bank;
    private InputStream originalSystemIn;
    private PrintStream originalSystemOut;

    // ~ Constructors ..........................................................
    /**
     * Sets up a fresh ScoreTracker and QuestionBank before each test, and
     * remembers the real System.in/System.out so they can be restored.
     */
    @Before
    public void setUp()
    {
        score = new ScoreTracker();
        bank = new QuestionBank();
        originalSystemIn = System.in;
        originalSystemOut = System.out;
    }


    /**
     * Restores the real System.in/System.out after each test, so redirecting
     * input/output in one test can't affect another.
     */
    @After
    public void tearDown()
    {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }


    /**
     * Builds a GameController whose Scanner reads the given simulated console
     * input (each line separated by \n).
     */
    private GameController controllerWithInput(String simulatedInput)
    {
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        return new GameController(score, bank);
    }


    /**
     * Runs action while System.out is redirected, and returns everything it
     * printed as a String.
     */
    private String captureOutput(Runnable action)
    {
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));
        action.run();
        return capturedOutput.toString();
    }

    // ~Public Methods ........................................................

    // -- validAnswer ---------------------------------------------------


    /**
     * Normal case: a valid answer letter is accepted, case-insensitively.
     */
    @Test
    public void testValidAnswerAcceptsValidLetters()
    {
        GameController game = controllerWithInput("");
        assertTrue(game.validAnswer("a"));
        assertTrue(game.validAnswer("D"));
    }


    /**
     * Bad-input case: letters outside A-D, and null, are rejected.
     */
    @Test
    public void testValidAnswerRejectsInvalidInput()
    {
        GameController game = controllerWithInput("");
        assertFalse(game.validAnswer("z"));
        assertFalse(game.validAnswer(""));
        assertFalse(game.validAnswer(null));
    }

    // -- validCategory ---------------------------------------------------


    /**
     * Normal case: a valid category letter is accepted, case-insensitively.
     */
    @Test
    public void testValidCategoryAcceptsValidLetters()
    {
        GameController game = controllerWithInput("");
        assertTrue(game.validCategory("a"));
        assertTrue(game.validCategory("E"));
    }


    /**
     * Bad-input case: letters outside A-E, and null, are rejected.
     */
    @Test
    public void testValidCategoryRejectsInvalidInput()
    {
        GameController game = controllerWithInput("");
        assertFalse(game.validCategory("z"));
        assertFalse(game.validCategory(""));
        assertFalse(game.validCategory(null));
    }

    // -- selectAnswer ---------------------------------------------------


    /**
     * Normal case: a valid answer on the first try is returned, upper-cased.
     */
    @Test
    public void testSelectAnswerValidInput()
    {
        GameController game = controllerWithInput("b\n");
        assertEquals("B", game.selectAnswer());
    }


    /**
     * Bad-input case: invalid entries are skipped, re-prompting until a valid
     * answer is given.
     */
    @Test
    public void testSelectAnswerReprompsOnInvalidInput()
    {
        GameController game = controllerWithInput("z\n\nC\n");
        assertEquals("C", game.selectAnswer());
    }

    // -- selectCategory ---------------------------------------------------


    /**
     * Normal case: a valid category letter selects that category and resets
     * questionNumber to 0.
     */
    @Test
    public void testSelectCategoryValidInput()
    {
        GameController game = controllerWithInput("A\n");
        game.selectCategory();
        assertEquals("animals", game.getCategory());
        assertEquals(0, game.questionNumber);
        assertTrue(game.hasMoreQuestions());
    }


    /**
     * Bad-input case: invalid category letters are skipped, re-prompting until
     * a valid one is given.
     */
    @Test
    public void testSelectCategoryReprompsOnInvalidInput()
    {
        GameController game = controllerWithInput("z\nA\n");
        game.selectCategory();
        assertEquals("animals", game.getCategory());
    }


    /**
     * Bad-input case: a category that has already been completed can't be
     * selected again; the method re-prompts until a fresh category is chosen.
     * This also confirms endCategory() actually marked the category as
     * completed in the first place.
     */
    @Test
    public void testSelectCategoryRejectsAlreadyCompletedCategory()
    {
        GameController game = controllerWithInput("A\nA\nB\n");
        game.selectCategory();   // picks animals
        game.endCategory();     // marks animals completed
        game.selectCategory();  // "A" is rejected (already completed), falls
                                // through to "B"
        assertEquals("music", game.getCategory());
    }

    // -- nextQuestion ---------------------------------------------------


    /**
     * Normal case: answering the first animal question correctly ("B")
     * increases the score and advances questionNumber, without ending the game.
     */
    @Test
    public void testNextQuestionCorrectAnswer()
    {
        GameController game = controllerWithInput("A\nB\n");
        game.selectCategory();
        game.nextQuestion();

        assertEquals(1, score.getScore());
        assertEquals(1, game.questionNumber);
        assertFalse(game.isGameOver());
    }


    /**
     * Bad-input case: answering incorrectly ends the game without advancing the
     * score or questionNumber.
     */
    @Test
    public void testNextQuestionWrongAnswerEndsGame()
    {
        // The first animal question's solution is "B"; "A" is wrong.
        GameController game = controllerWithInput("A\nA\n");
        game.selectCategory();
        game.nextQuestion();

        assertTrue(game.isGameOver());
        assertEquals(0, score.getScore());
        assertEquals(0, game.questionNumber);
    }

    // -- hasMoreQuestions ---------------------------------------------------


    /**
     * Normal case: false before any category is selected, true right after
     * selecting one.
     */
    @Test
    public void testHasMoreQuestions()
    {
        GameController game = controllerWithInput("A\n");
        assertFalse(game.hasMoreQuestions());
        game.selectCategory();
        assertTrue(game.hasMoreQuestions());
    }


    /**
     * Edge case: once the game is over, hasMoreQuestions is false even though
     * the category still has unanswered questions left in it.
     */
    @Test
    public void testHasMoreQuestionsFalseAfterGameOver()
    {
        GameController game = controllerWithInput("A\nA\n"); // wrong answer
        game.selectCategory();
        game.nextQuestion();
        assertFalse(game.hasMoreQuestions());
    }

    // -- allCategoriesCompleted
    // ---------------------------------------------------


    /**
     * Normal case: false for a freshly started game.
     */
    @Test
    public void testAllCategoriesCompletedFalseInitially()
    {
        GameController game = controllerWithInput("");
        assertFalse(game.allCategoriesCompleted());
    }


    /**
     * Normal case: true once all 5 categories have been selected and completed.
     */
    @Test
    public void testAllCategoriesCompletedTrueAfterAllFive()
    {
        GameController game = controllerWithInput("A\nB\nC\nD\nE\n");

        for (int i = 0; i < 5; i++)
        {
            game.selectCategory();
            game.endCategory();
        }

        assertTrue(game.allCategoriesCompleted());
    }

    // -- resetGame ---------------------------------------------------


    /**
     * Normal case: resetGame restores every piece of state to its starting
     * defaults, even after the game has been played partway through and lost.
     */
    @Test
    public void testResetGameRestoresDefaults()
    {
        GameController game = controllerWithInput("A\nA\n"); // wrong answer ->
                                                             // game over
        game.selectCategory();
        game.nextQuestion();
        assertTrue(game.isGameOver());

        game.resetGame();

        assertFalse(game.isGameOver());
        assertEquals(0, game.questionNumber);
        assertEquals("", game.getCategory());
        assertFalse(game.hasMoreQuestions());
        assertFalse(game.allCategoriesCompleted());
        assertEquals(0, score.getScore());
    }

    // -- getCategory ---------------------------------------------------


    /**
     * Normal case: before any selection, getCategory is empty.
     */
    @Test
    public void testGetCategoryInitiallyEmpty()
    {
        GameController game = controllerWithInput("");
        assertEquals("", game.getCategory());
    }

    // -- endGame / endCategory (console output)
    // ---------------------------------------------------


    /**
     * Normal case: endGame(true) reports the current score in its printed win
     * message.
     */
    @Test
    public void testEndGameWinMessageIncludesScore()
    {
        GameController game = controllerWithInput("");
        score.increaseScore();

        String output = captureOutput(() -> game.endGame(true));

        assertTrue(output.contains("Correct!"));
        assertTrue(output.contains("1"));
    }


    /**
     * Bad-input/edge case: endGame(false) reports a loss message rather than
     * the win message.
     */
    @Test
    public void testEndGameLossMessage()
    {
        GameController game = controllerWithInput("");

        String output = captureOutput(() -> game.endGame(false));

        assertTrue(output.contains("Game Over"));
    }


    /**
     * Edge case: endCategory prints its score message even if no category was
     * ever selected, and should not throw.
     */
    @Test
    public void testEndCategoryWithoutSelectionDoesNotThrow()
    {
        GameController game = controllerWithInput("");

        String output = captureOutput(() -> game.endCategory());

        assertTrue(output.contains("score"));
        assertFalse(game.allCategoriesCompleted());
    }
}
