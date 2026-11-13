import java.util.Scanner;

public class RainwaterCollectionAnalyzer {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] rainwater = new double[10];
        int[] containerIndex = new int[10];

        double total = 0;
        double average;
        double largest = 0;
        int largestIndex = 0;

        System.out.println("RAINWATER COLLECTION ANALYZER");

        // Input and validate rainwater amounts
        for (int i = 0; i < 10; i++) {

            System.out.print("Enter amount for Container " + i + ": ");

            while (true) {
                if (input.hasNextDouble()) {
                    double amount = input.nextDouble();

                    if (Double.isFinite(amount) && amount >= 0) {
                        rainwater[i] = amount;
                        containerIndex[i] = i;
                        break;
                    } else {
                        System.out.println("Invalid! Enter a nonnegative value.");
                    }
                } else {
                    System.out.println("Invalid! Enter a number.");
                    input.next();
                }
            }

            total += rainwater[i];

            if (i == 0 || rainwater[i] > largest) {
                largest = rainwater[i];
                largestIndex = i;
            }
        }

        // Calculate average
        average = total / 10;

        // Display total, average, and largest collection
        System.out.println("\n--- COLLECTION SUMMARY ---");
        System.out.printf("Total Collection: %.2f liters%n", total);
        System.out.printf("Average Collection: %.2f liters%n", average);
        System.out.printf("Largest Collection: %.2f liters%n", largest);
        System.out.println("Container Index: " + largestIndex);

        // Manual sorting in descending order
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++) {

                if (rainwater[j] < rainwater[j + 1]) {

                    double temp = rainwater[j];
                    rainwater[j] = rainwater[j + 1];
                    rainwater[j + 1] = temp;

                    int tempIndex = containerIndex[j];
                    containerIndex[j] = containerIndex[j + 1];
                    containerIndex[j + 1] = tempIndex;
                }
            }
        }

        // Display sorted amounts
        System.out.println("\n--- DESCENDING ORDER ---");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Container Index %d: %.2f liters%n",
                    containerIndex[i], rainwater[i]);
        }

        input.close();
    }
}
