import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    private static final int MINIMUM_ROUNDS = 1;
    private static final int MAXIMUM_ROUNDS = 10;
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private static final int RANDOM_MAX_VALUE = 3;
    private static final String USER_NAME = "User";
    private static final String CPU_NAME = "CPU";
    private static final String TIE = "Tie";


    public static void main(String[] args){
        playRockPaperScissors();
    }


    private static void playRockPaperScissors(){
        boolean playing = true;
        Scanner myScanner = new Scanner(System.in);
        while(playing) {
            int cpuWins = 0;
            int userWins = 0;
            int ties = 0;
            System.out.println("Please enter the number of rounds you would like to play (between 1 and 10): ");
            int rounds = myScanner.nextInt();
            if (rounds >= MINIMUM_ROUNDS && rounds <= MAXIMUM_ROUNDS) {
                for (int roundsCompleted = 0; roundsCompleted < rounds; roundsCompleted++) {
                    int userSelection = -1;
                    System.out.println("Please enter '1' for Rock, '2' for Paper or '3' for Scissors: ");
                    while(userSelection != ROCK && userSelection != PAPER && userSelection != SCISSORS) {
                        userSelection = myScanner.nextInt();
                        if (userSelection > 3 || userSelection < 1){
                            System.out.println("Invalid input - Try again");
                        }
                    }
                    printOutput(USER_NAME, userSelection);

                    Random randNum = new Random();
                    int cpuSelection = randNum.nextInt(RANDOM_MAX_VALUE) + 1;
                    printOutput(CPU_NAME, cpuSelection);

                    String outcome = returnResult(userSelection, cpuSelection);
                    switch(outcome){
                        case TIE:
                            ties++;
                            break;
                        case USER_NAME:
                            userWins++;
                            break;
                        case CPU_NAME:
                            cpuWins++;
                            break;
                        default:
                            break;
                    }
                }
                printNumberOfWins(cpuWins, userWins, ties);
                printWinner(userWins, cpuWins);
                System.out.println("\nWould you like to play again? (Y/N): ");
                myScanner.nextLine(); //throw away the \n not consumed by nextInt()
                String response = "";
                while (!response.equals("N") && !response.equals("n")) {
                    response = myScanner.nextLine();
                    if (response.equals("N") || response.equals("n")) {
                        System.out.println("Thanks for playing!");
                        playing = false;
                    } else if (!response.equals("Y") && !response.equals("y")) {
                        System.out.println("\nIncorrect input - Would you like to play again? (Y/N): ");
                    }
                    else {
                        break;
                    }
                }

            } else {
                System.out.println("Incorrect input - game has quit automatically");
                playing = false;
            }
        }
    }
    private static void printOutput(String user, int input){
        switch (input) {
            case ROCK:
                System.out.println(user + " chose Rock");
                break;
            case PAPER:
                System.out.println(user +" chose Paper");
                break;
            case SCISSORS:
                System.out.println(user +" chose Scissors");
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

    private static void printNumberOfWins(int cpuWins, int userWins, int ties){
        System.out.println("\nNumber of CPU wins: " + cpuWins);
        System.out.println("Number of User wins: " + userWins);
        System.out.println("Number of ties: "+ ties);
    }

    private static void printWinner(int userWins, int cpuWins){
        if (userWins > cpuWins) {
            System.out.println("You beat the CPU overall: You are the victor!");
        } else if (userWins < cpuWins) {
            System.out.println("The CPU beat you overall: The CPU is the victor!");
        } else {
            System.out.println("Its a majority tie: No one wins!");
        }

    }

    private static String returnResult(int userSelection, int cpuSelection){
        String result = TIE;
        if (userSelection == cpuSelection) {
            System.out.println("It's a tie!");
        }
        if ((userSelection == ROCK && cpuSelection == SCISSORS) || (userSelection == PAPER && cpuSelection == ROCK) || (userSelection == SCISSORS && cpuSelection == PAPER)) {
            System.out.println("You beat the CPU!");
            result = USER_NAME;
        }
        if ((userSelection == SCISSORS && cpuSelection == ROCK) || (userSelection == ROCK && cpuSelection == PAPER) || (userSelection == PAPER && cpuSelection == SCISSORS)) {
            System.out.println("The CPU beat you!");
            result = CPU_NAME;
        }
        return result;
    }
}
