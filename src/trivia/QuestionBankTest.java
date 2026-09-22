package trivia;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  The test class for QuestionBank, verifying each category has the
 *  expected questions, the letter/name lookup methods behave correctly,
 *  and invalid categories or indices are handled predictably.
 *
 *  @author Tyler Santiago
 *  @version Sep 22, 2026
 */
public class QuestionBankTest
{
    //~ Fields ................................................................
    private QuestionBank bank;

    //~ Constructors ..........................................................
    /**
     * Sets up a fresh QuestionBank before each test runs.
     */
    @Before
    public void setUp()
    {
        bank = new QuestionBank();
    }

    //~Public  Methods ........................................................

    /**
     * Normal case: each category array is populated with 10 questions.
     */
    @Test
    public void testCategoryArraysHaveTenQuestions()
    {
        assertEquals(10, bank.getAnimalQuestions().length);
        assertEquals(10, bank.getMusicQuestions().length);
        assertEquals(10, bank.getGeographyQuestions().length);
        assertEquals(10, bank.getPeopleQuestions().length);
        assertEquals(10, bank.getHistoryQuestions().length);
    }

    /**
     * Normal case: getQuestionsForCategory maps each letter to the right
     * category array.
     */
    @Test
    public void testGetQuestionsForCategoryValidLetters()
    {
        assertSame(bank.getAnimalQuestions(), bank.getQuestionsForCategory("A"));
        assertSame(bank.getMusicQuestions(), bank.getQuestionsForCategory("B"));
        assertSame(bank.getGeographyQuestions(), bank.getQuestionsForCategory("C"));
        assertSame(bank.getPeopleQuestions(), bank.getQuestionsForCategory("D"));
        assertSame(bank.getHistoryQuestions(), bank.getQuestionsForCategory("E"));
    }

    /**
     * Normal case: the mapping is case-insensitive.
     */
    @Test
    public void testGetQuestionsForCategoryLowercase()
    {
        assertSame(bank.getAnimalQuestions(), bank.getQuestionsForCategory("a"));
    }

    /**
     * Bad-input case: an unrecognized letter returns null rather than
     * throwing.
     */
    @Test
    public void testGetQuestionsForCategoryInvalidLetter()
    {
        assertNull(bank.getQuestionsForCategory("Z"));
    }

    /**
     * Bad-input case: a null letter returns null rather than throwing.
     */
    @Test
    public void testGetQuestionsForCategoryNullLetter()
    {
        assertNull(bank.getQuestionsForCategory(null));
    }

    /**
     * Normal case: getCategoryName maps each letter to its category name.
     */
    @Test
    public void testGetCategoryNameValid()
    {
        assertEquals("animals", bank.getCategoryName("A"));
        assertEquals("music", bank.getCategoryName("B"));
        assertEquals("geography", bank.getCategoryName("C"));
        assertEquals("people", bank.getCategoryName("D"));
        assertEquals("history", bank.getCategoryName("E"));
    }

    /**
     * Bad-input case: an unrecognized letter maps to an empty string.
     */
    @Test
    public void testGetCategoryNameInvalid()
    {
        assertEquals("", bank.getCategoryName("Z"));
    }

    /**
     * Normal case: getQuestion returns the correct question by letter
     * and index.
     */
    @Test
    public void testGetQuestionByLetterAndIndex()
    {
        Question q = bank.getQuestion("A", 0);
        assertSame(bank.getAnimalQuestions()[0], q);
    }

    /**
     * Normal case: getQuestion also accepts a category name instead of
     * a letter.
     */
    @Test
    public void testGetQuestionByNameAndIndex()
    {
        Question q = bank.getQuestion("music", 2);
        assertSame(bank.getMusicQuestions()[2], q);
    }

    /**
     * Bad-input case: an unrecognized category returns null.
     */
    @Test
    public void testGetQuestionInvalidCategory()
    {
        assertNull(bank.getQuestion("not-a-category", 0));
    }

    /**
     * Bad-input case: an out-of-range index throws rather than silently
     * returning something wrong.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetQuestionIndexOutOfBounds()
    {
        bank.getQuestion("A", 99);
    }
}
