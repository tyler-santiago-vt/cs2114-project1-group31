package trivia;

/**
 * Entry point for the Super Trivia console game. Repeatedly presents a
 * category of 10 questions at a time; the round ends the moment the
 * player answers a question incorrectly, or once every category has been
 * completed (a win).
 *
 * @author Poorna Bhat
 * @version Sep 22, 2026
 */
public class Main
{
    /**
     * Runs the Super Trivia game: greets the player, lets them pick a
     * category, then loops through questions and categories until the
     * player either answers incorrectly or completes every category.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args)
    {
        ScoreTracker score = new ScoreTracker();
        QuestionBank questionBank = new QuestionBank();
        GameController game = new GameController(score, questionBank);

        System.out.println("Welcome to Super Trivia!!");

        game.selectCategory();
        System.out.println("You have selected the category: " + game.getCategory());

        while (true)
        {
            while (game.hasMoreQuestions())
            {
                game.nextQuestion();
            }

            if (game.isGameOver())
            {
                // nextQuestion() already printed the loss message.
                break;
            }

            game.endCategory();

            if (game.allCategoriesCompleted())
            {
                game.endGame(true);
                break;
            }

            game.selectCategory();
        }
    }
}