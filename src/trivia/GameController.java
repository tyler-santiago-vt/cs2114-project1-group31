package trivia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Drives a round of Super Trivia: prompts the player to pick categories, asks
 * the ten questions in each selected category, tracks the score, and decides
 * when the game ends (either because the player answered incorrectly or because
 * every category has been completed).
 *
 * @author Tyler Santiago
 * @version Sep 22, 2026
 */
public class GameController
{
    // ~ Fields ................................................................

    private static final Set<String> VALID_ANSWERS =
        new HashSet<>(Arrays.asList("a", "b", "c", "d"));
    private static final Set<String> VALID_CATEGORIES =
        new HashSet<>(Arrays.asList("a", "b", "c", "d", "e"));

    private ScoreTracker score;
    private QuestionBank questionBank;
    public int questionNumber;

    private Question[] currentCategoryQuestions;
    private boolean gameOver;
    private String category;
    private Set<String> completedCategories = new HashSet<>();
    Scanner input = new Scanner(System.in);

    // ~ Constructors ..........................................................

    /**
     * Constructs a GameController for a new round of trivia.
     *
     * @param score
     *            the score tracker to record correct answers on
     * @param questionBank
     *            the bank of questions to draw categories from
     */
    public GameController(ScoreTracker score, QuestionBank questionBank)
    {
        this.score = score;
        this.questionBank = questionBank;
        this.questionNumber = 0;
        this.category = "";
    }

    // ~Public Methods ........................................................


    /**
     * Displays the user's score and prints either a win or lose message based
     * on if the user won or lost.
     *
     * @param win
     *            true if the player won the game, false if they lost
     */
    public void endGame(boolean win)
    {
        String message = win
            ? "Correct! You've answered all questions correctly! Score: "
            : "Incorrect, Game Over! Score: ";

        System.out.println(message + score.getScore());
    }


    /**
     * Displays the user's score after finishing a category, and marks the
     * current category as completed so it can't be selected again.
     */
    public void endCategory()
    {
        System.out.println(
            "You have answered all the questions in this category! Your score so far is: "
                + score.getScore());

        if (!category.isEmpty())
        {
            completedCategories.add(category);
        }
    }


    /**
     * Presents the next question in the current category (prompt plus answer
     * choices), prompts the user for an answer via selectAnswer(), and updates
     * score/game state based on whether it was correct. Assumes
     * hasMoreQuestions() is true when called (the Main loop only calls this
     * method after checking that).
     */
    public void nextQuestion()
    {
        Question question = currentCategoryQuestions[questionNumber];

        System.out.println(question.getPrompt());
        for (String answer : question.getAnswers())
        {
            System.out.println(answer);
        }

        String userAnswer = selectAnswer();

        if (question.checkSolution(userAnswer))
        {
            score.increaseScore();
            System.out.println("Correct!");
            questionNumber++;
        }
        else
        {
            System.out.println(
                "Incorrect. The correct answer was: " + question.getSolution());
            gameOver = true;
            endGame(false);
        }
    }


    /**
     * Returns whether the given answer letter is one of the four valid answer
     * choices ("A"-"D"), regardless of case or surrounding whitespace.
     *
     * @param answer
     *            the answer letter to validate; may be null
     * @return true if answer is "A", "B", "C", or "D" (case-insensitive), false
     *             otherwise, including when answer is null
     */
    public boolean validAnswer(String answer)
    {
        if (answer == null)
        {
            return false;
        }

        return VALID_ANSWERS.contains(answer.trim().toLowerCase());
    }


    /**
     * Returns whether the given category letter is one of the five valid
     * category choices ("A"-"E"), regardless of case or surrounding whitespace.
     *
     * @param categoryInput
     *            the category letter to validate; may be null
     * @return true if categoryInput is "A" through "E" (case-insensitive),
     *             false otherwise, including when categoryInput is null
     */
    public boolean validCategory(String categoryInput)
    {
        if (categoryInput == null)
        {
            return false;
        }

        return VALID_CATEGORIES.contains(categoryInput.trim().toLowerCase());
    }


    /**
     * Prompts the user to select an answer, re-prompting on invalid input,
     * until a valid choice ("A"-"D") is entered.
     *
     * @return the user's chosen answer letter, upper-cased
     */
    public String selectAnswer()
    {
        String userInput;

        while (true)
        {
            System.out.print("Select an answer from the choices above: ");
            userInput = input.nextLine();

            if (validAnswer(userInput))
            {
                return userInput.trim().toUpperCase();
            }

            System.out.println(
                "Invalid input. Please input 'a', 'b', 'c', or 'd' to select the desired answer choice");
        }
    }


    /**
     * Prompts the user to select a category, re-prompting on invalid or
     * already-completed input, until a valid, not-yet-completed category is
     * chosen. If every category has already been completed, prints a message
     * and returns immediately without prompting (there would be nothing valid
     * left to select).
     */
    public void selectCategory()
    {
        if (allCategoriesCompleted())
        {
            System.out.println("All categories have been completed!");
            return;
        }

        boolean validSelection = false;
        String userInput;

        while (!validSelection)
        {
            System.out.println(
                "Select a category: A) Animals, B) Music, C) Geography, D) People, E) History");
            userInput = input.nextLine();

            if (!validCategory(userInput))
            {
                System.out.println(
                    "Invalid selection. Please input 'A', 'B', 'C', 'D', or 'E' to select the desired category.");
                continue;
            }

            String selectedCategory = questionBank.getCategoryName(userInput);

            if (completedCategories.contains(selectedCategory))
            {
                System.out.println(
                    "You've already completed that category! Please choose a different one.");
                continue;
            }

            currentCategoryQuestions =
                questionBank.getQuestionsForCategory(userInput);
            category = selectedCategory;
            questionNumber = 0;
            validSelection = true;
        }
    }


    /**
     * Returns if gameOver has been set to true or not
     *
     * @return true if the game has ended (the player answered incorrectly)
     */
    public boolean isGameOver()
    {
        return gameOver;
    }


    /**
     * Returns whether all 5 categories have been completed.
     *
     * @return true once every category has been fully answered
     */
    public boolean allCategoriesCompleted()
    {
        return completedCategories.size() >= 5;
    }


    /**
     * Resets the game by changing all values to their defaults, so a new round
     * can begin from scratch.
     */
    public void resetGame()
    {
        gameOver = false;
        questionNumber = 0;
        currentCategoryQuestions = null;
        category = "";
        completedCategories.clear();
        score.resetScore();
    }


    /**
     * Returns whether there are more questions left in the current category.
     * False if the game is over, no category has been selected yet, or the
     * selected category has been fully answered.
     *
     * @return true if another question can be asked in the current category
     */
    public boolean hasMoreQuestions()
    {
        return !gameOver && currentCategoryQuestions != null
            && questionNumber < currentCategoryQuestions.length;
    }


    /**
     * Returns the name of the currently selected category.
     *
     * @return the current category name, or "" if none has been selected
     */
    public String getCategory()
    {
        return category;
    }

}