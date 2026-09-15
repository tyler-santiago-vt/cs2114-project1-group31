package trivia;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *  The test class for question, makes sure that the question formatting 
 *  getters, and setters work as it should 
 * 
 *  @author emerson
 *  @version Sep 15, 2026
 */
public class QuestionTest
{

    //~ Fields ................................................................
private Question question;
    //~ Constructors ..........................................................
/**
 * the set up for the test runs for question 
 */
    public void setUp()
{
    question = new Question("What is 2 + 2?", 
            new String[] {"4", "3", "1", "6"}, "A");
        
}
    //~Public  Methods ........................................................
/**
 * tests that the getter for prompt runs as it should 
 */
    public void testGetPrompt()
{
    assertEquals(question.getPrompt(), "What is 2 + 2?");
}
    /**
     * tests that getter for answers works as it should
     */
   @SuppressWarnings("deprecation")
public void testGetAnswers()
   {
       String[] equalArray = {"4", "3", "1", "6"};
       assertEquals(question.getAnswers(), equalArray);
   }
   /**
    * tests that the check solution checks the answers correctly 
    */
   public void testCheckSolution()
   {
       assertTrue(question.checkSolution("A"));
       assertFalse(question.checkSolution("C"));
       assertFalse(question.checkSolution("F"));
       
   }
}
