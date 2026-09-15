package trivia;

import java.util.Scanner;

/**
 * // -------------------------------------------------------------------------
 * /** Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author poornabhat
 * @version Sep 15, 2026
 */
public class Main
{
    /**
     * 
     */
    public static void main(String[] args)
    {
        ScoreTracker score = new ScoreTracker();
        Question questions;
        GameController game = new GameController();
        QuestionBank questionBank;

        Scanner input = new Scanner(System.in);
        System.out.print(
            "Please pick a catergory: Music, History, People, or Geography");

        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("Music"))
        {

        }
        else if (userInput.equalsIgnoreCase("History"))
        {

        }
        else if (userInput.equalsIgnoreCase("People"))
        {

        }
        else if (userInput.equalsIgnoreCase("Geography"))
        {

        }
        else
        {
            System.out.print("Not a valid catergory. Try Again!");
            userInput = input.nextLine();
        }

    }

}
