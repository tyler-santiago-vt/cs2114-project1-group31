



package trivia;


import java.util.Scanner;


public class Main
{

    public static void main(String[] args)
    {

        // TODO Auto-generated method stub

    
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................


        ScoreTracker score = new ScoreTracker();
        Question questions;
        Question[] currectCategory;
        QuestionBank questionBank;
        GameController game = new GameController(score, questionBank);
     
        boolean validity = false;
        boolean gameOver = false;
        int questionNumber = 0;
        String category = null;
        String answer = null;

        System.out.print("Welcome to Super Trivia!! " + "\n" + "\n");

        Scanner input = new Scanner(System.in);
        System.out.print(
            "Please pick a catergory: Music, History, People, or Geography: ");

        String userInput = input.nextLine();

        /**while (!validity)
        {

            if (userInput.equalsIgnoreCase("Music"))
            {
                validity = true;
                category = "Music";
                break;
            }
            else if (userInput.equalsIgnoreCase("History"))
            {
                validity = true;
                category = "History";
                break;
            }
            else if (userInput.equalsIgnoreCase("People"))
            {
                validity = true;
                category = "People";
                break;
            }
            else if (userInput.equalsIgnoreCase("Geography"))
            {
                validity = true;
                category = "Geography";
                break;
            }
            else
            {
                validity = false;
                System.out.print(
                    "Not a valid catergory... Try again!" + "\n " + "\n");
                System.out.print(
                    "Please pick a catergory: Music, History, People, or Geography: ");
                userInput = input.nextLine();

            }

        }
**/
        
        for(int i = 0; i < currentCategory[i]; i++ ) {
         questions = questions.getQuestion(category, questionNumber);
         questions.getPrompt(); 
         answer = input.nextLine();
         game.selectAnswer(answer);
        questions.checkSolution(answer);
        
        
        }
         

    }

}
