package trivia;

/**
 *  Represents a single trivia question: a prompt shown to the player, the
 *  list of answer choices displayed alongside it, and the letter of the
 *  correct choice ("A", "B", "C", or "D").
 *
 *  @author Emerson Molina
 *  @version Sep 22, 2026
 */
public class Question
{
    //~ Fields ................................................................
    private String prompt;
    private String[] answers;
    private String solution;

    //~ Constructors ..........................................................
    /**
     * Constructs a Question from a prompt, its answer choices, and the
     * letter of the correct choice.
     *
     * @param prompt the question text shown to the user
     * @param answers the answer choices shown to the user (e.g. "A) ...")
     * @param solution the letter ("A"-"D") of the correct answer
     */
    public Question(String prompt, String[] answers, String solution)
    {
        this.prompt = prompt;
        this.answers = answers;
        this.solution = solution;
    }

    //~Public  Methods ........................................................
    /**
     * Returns the question prompt.
     *
     * @return the prompt shown to the user
     */
    public String getPrompt()
    {
        return prompt;
    }

    /**
     * Returns the answer choices for this question.
     *
     * @return the answer choices shown to the user
     */
    public String[] getAnswers()
    {
        return answers;
    }

    /**
     * Returns the letter of the correct answer choice.
     *
     * @return the solution letter (e.g. "A")
     */
    public String getSolution()
    {
        return solution;
    }

    /**
     * Checks a user-supplied answer against the solution, ignoring case.
     * A null or blank answer is treated as incorrect rather than throwing.
     *
     * @param userAnswer the answer letter input by the user; may be null
     * @return true if userAnswer matches the solution (case-insensitive),
     *         false otherwise, including when userAnswer is null
     */
    public boolean checkSolution(String userAnswer)
    {
        // Calling equalsIgnoreCase on `solution` (never null in normal use)
        // rather than on `userAnswer` means a null userAnswer safely
        // evaluates to false instead of throwing a NullPointerException.
        return solution.equalsIgnoreCase(userAnswer);
    }

}