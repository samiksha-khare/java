/**
 * This program calculates the Greatest Common Divisor (GCD) of two integer values
 */
public class KhareSamikshaA1 {
    /**
     * Function to compute the Greatest Common Divisor of two integers.
     * @param number1 Integer value 1
     * @param number2 Integer value 2
     * @return Greatest Common Divisor
     */
    public static int greatestCommonDivisor(int number1, int number2) {
        int divisor;

        // Convert numbers to absolute value
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);

        // Assign the greater of two numbers to the divisor
        if (number1 > number2) {
            divisor = number1;
        }
        else {
            divisor = number2;
        }
        // Loop through the positive values of divisor until it finds GCD
        while (divisor>=1) {
            // If both numbers are divisible by the current divisor, the divisor is the GCD, so break the loop
            if (number1 % divisor == 0 && number2 % divisor == 0) {
                break;
            }
            // Else, decrement the divisor and continue the loop
            else {
                divisor -= 1;
            }
        }

        return divisor;
    }

    public static void main(String[] args) {
        // Check if the user passes exactly 2 command-line arguments
        if (args.length != 2) {
            System.out.println("Usage : java KhareSamikshaA1.java number1 number2");
        }
        else {
            // Parse the command-line arguments as integers
            int number1 = Integer.parseInt(args[0]);
            int number2 = Integer.parseInt(args[1]);

            // Print the Greatest Common Divisor of two integers
            System.out.println("The GCD of " + number1 + " and " + number2 + " is: " + greatestCommonDivisor(number1, number2));
        }

        System.out.println("\nProgram Completed.");
    }
}

/*
 * Sources used:
 * - Google search on parsing string command-line values to integers
 * - Google search for the Math.abs(number) function to get absolute values of the input integers
 */