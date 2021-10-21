import java.util.Scanner;
import java.util.Random;

public class DogGenetics {

    private static final String[] DOG_BREEDS = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
    private static final int TOTAL_PERCENTAGE = 100;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your dog's name? ");
        String dogName = myScanner.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here. \n");
        System.out.println("" + dogName + " is: \n");
        printDogGenetics();

    }

    private static void printDogGenetics(){
        int total = TOTAL_PERCENTAGE;
        for (int i = 0; i < DOG_BREEDS.length-1; i++) {
            if (total > 0) {
                int percentage = RANDOM.nextInt(total);
                total -= percentage;
                System.out.println("" + percentage + "% " + DOG_BREEDS[i]);
            } else {
                System.out.println("0% " + DOG_BREEDS[i]);
            }
        }
        System.out.println("" + total + "% " + DOG_BREEDS[DOG_BREEDS.length-1] + "\n");
        System.out.println("Wow, that's QUITE the dog!");
    }
}
