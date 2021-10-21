import java.util.Scanner;

public class HealthyHearts {
    private static final double MAXIMUM_HEART_RATE = 220;
    private static final double MINIMUM_HR_ZONE_PERCENTAGE = 0.5;
    private static final double MAXIMUM_HR_ZONE_PERCENTAGE = 0.85;
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your age: ");
        int age = myScanner.nextInt();
        calculateAndPrintHeartRateStats(age);
    }

    private static void calculateAndPrintHeartRateStats(int age){
        if(age > 0 || age < 120) {                                                       //checking for a valid age
            double maxHeartRate = MAXIMUM_HEART_RATE - age;
            System.out.println("Your maximum heart rate should be: " + (int) maxHeartRate);
            double minHRZone = maxHeartRate * MINIMUM_HR_ZONE_PERCENTAGE;   //calculating the minimum heart rate zone
            double maxHRZone = maxHeartRate * MAXIMUM_HR_ZONE_PERCENTAGE;   //calculating the maximum heart rate zone
            System.out.println("Your target HR Zone is " + Math.round(minHRZone) + " - " + Math.round(maxHRZone )+ " beats per minute");
        } else {
            System.out.println("Invalid age entered.");
        }
    }
}
