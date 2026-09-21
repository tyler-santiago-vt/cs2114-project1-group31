package trivia;
/**
 *  The question class for Trivia Game, defines how a question is formatted
 *  with an array of answers, and a solution indicating the correct choice
 *  for those answer as well as a prompt which represents the question that
 *  is asked 
 * 
 *  @author emerson
 *  @version Sep 15, 2026
 */
public class Question
{
    //~ Fields ................................................................
private String prompt;
private String[] answers;
private String solution;
    //~ Constructors ..........................................................
/**
 * Constructor for Question takes in a prompt, answers, and solution
 * @param prompt the question prompt given to user
 * @param answers the answers that are given to the user
 * @param solution the solution listed as right for the prompt
 */
public Question(String prompt, String[] answers, String solution)
{
    this.prompt = prompt;
    this.answers = answers;
    this.solution = solution;
}
    //~Public  Methods ........................................................
/**
 * gets the prompt for the question
 * @return prompt the prompt or actual question for a specific
 * section
 */
public String getPrompt()
{
    return prompt;
}
/**
 * gets the answers for the question
 * @return answers the answers for the question
 */
public String[] getAnswers()
{
    return answers;
}

/**
 * takes in an answer and checks it with the solution
 * listed for an answer to see if its correct
 * @return true if the user input matches the answer false
 * otherwise
 * @param userAnswer the answer input by the user 
 */
public boolean checkSolution(String userAnswer)
{
    return userAnswer.equalsIgnoreCase(solution);
}

}
