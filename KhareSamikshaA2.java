import java.util.Scanner;

/**
 * Samiksha Khare Assignment 2
 */
public class KhareSamikshaA2 {
	/**
	 * Returns the given array in the form [int1 int2 int3 ...] 
	 *
	 */
	private static String printArray(int[] array) {
		String printArray = "[";
		for (int i = 0; i < array.length; i++) {
			printArray += " " + array[i] + " ";
		 }
		return printArray + "]";
	}
	
	/**
	 * Returns copy of the given array 
	 *
	 */
	private static int[] copyArray(int[] originalArray) {
		int[] copiedArray = new int[originalArray.length];
		for (int i = 0; i < originalArray.length; i++) {
			 copiedArray[i] = originalArray[i];
		 }
		return copiedArray;
	}
	
	/**
	 * Returns the sorted array in ascending order using Bubble sort algorithm
	 *
	 */
	private static int[] sortArray(int[] array) {
		for(int a = 1; a < array.length; a++){
            for(int b = array.length-1; b >= a; b--){
            	// If elements out of order, swap them
                if(array[b-1] > array[b]){
                	// Swap elements
                    int temp = array[b-1];
                    array[b-1] = array[b];
                    array[b] = temp;
                }
            }
        }
        return array;
	}
	
	/**
	 * Calculates the sum of odd and even elements in the given array
	 *
	 */
	private static void sumOfOddEvenIntegers(int[] array) {
		int oddSum = 0;
		int evenSum = 0;
		for (int number : array) {
			if (number % 2 == 0) {
				evenSum += number;
			} else {
				oddSum += number;
			}
		}
		
		System.out.println("The sum of all odd elements: " + oddSum);
		System.out.println("The sum of all even elements: " + evenSum);
	}
	
	/**
	 * Prints the largest integer with its index for the given array
	 *
	 */
	private static void largestInteger(int[] originalArray) {
		int largestInteger = originalArray[0];
		int largestIndex = 0;
		for (int i = 1; i < originalArray.length; i++) {
			 if (originalArray[i] > largestInteger) {
				 largestInteger = originalArray[i];
				 largestIndex = i;
			 }
		 }
		
		System.out.println("Largest integer found is " + largestInteger +  " at index " + largestIndex);
	}
	
	/**
	 * Calculates the average of all integers in the given array 
	 *
	 */
	private static void calculateAverage(int[] originalArray) {
		float totalSum = 0;
		for (int i = 0; i < originalArray.length; i++) {
			totalSum += originalArray[i];
		 }
		
		float average = totalSum / originalArray.length;
		
		// Print the average value rounded off to 2 decimal digits
		System.out.printf("Average of array elements: %.2f\n", average);
	}
	
	/**
	 * Check if any particular element is present in the given array and user input 
	 *
	 */
	private static void searchInteger(int[] originalArray, int integer) {
		// Initialize index to -1
		int index = -1;
		
		// Iterate through the originalArray to find the index of the specified integer
		for (int i = 0; i < originalArray.length; i++) {
	        // If integer value is present, assign the index value and exit the loop
			if (integer ==  originalArray[i]) {
				index = i;
				break;
			}
		 }
		
	    // Check if the integer was found, if present print index, else print integer not found
		if (index != -1) {
			System.out.println("Integer found at: " + index);
		}
		else {
			System.out.println("No such integer was found");
		}
	}
	
	/**
	 * Prints the occurrences of specified integer in the given array
	 * 
	 */
	private static void countInteger(int[] array, int integer) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (integer ==  array[i]) {
				count++;
			}
		 }
		System.out.println("Occurrences of " + integer + ": " + count);
	}
	
	/**
	 * Replace an integer of the given array with the integer and the index specified by the user 
	 * and returns the new array
	 * 
	 */
	private static int[] replaceInteger(int[] array, int integer, int index) {
		array[index] = integer;
		return array;
	}
	
	/**
	 * Main function
	 * 
	 */
	public static void main(String[] args) {
		
		// Define variables for original array and its length
        int[] originalArray;
        int originalArrayLength;
        
        // Create a Scanner object to read input from the standard input stream
        Scanner scan = new Scanner(System.in);

        do {
            // Get the array length from the user
            System.out.print("Please enter the length of an array: ");

            try {
            	originalArrayLength = Integer.parseInt(scan.nextLine());
            	// Check if the array length specified by the user is between 2-10
                if (originalArrayLength >= 2 && originalArrayLength <= 10) {
                	// IF valid input, get the array elements from the user
                    break; 
                } else {
                    System.out.println("\nUsage: Enter a length between 2-10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Usage: Input should only be integer numbers.");
            }
        } while (true);
        
        do {
			System.out.print("Please enter " + originalArrayLength + " the elements of the array: ");
            
			// Get the array input as string from the user
			String input = scan.nextLine();

            try {
            	// Split the array string by spaces and initialize originalArray
                String[] elements = input.split("\\s+");
                originalArray = new int[originalArrayLength];

                // Parse all elements to integer
                for (int i = 0; i < originalArrayLength; i++) {
                    originalArray[i] = Integer.parseInt(elements[i]);
                }

                // Check for any non-integer values                
                boolean allIntegers = true;
                for (int num : originalArray) {
                    if (num == Integer.MIN_VALUE) {
                    	// Exit the loop early if any non-integer is found
                        allIntegers = false;
                        break; 
                    }
                }
                if (allIntegers) {
                	// Break the loop if all elements are integers
                    break; 
                } 
            } catch (NumberFormatException e) {
                System.out.println("Usage: Input should only be integer numbers.");
            }
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Usage: Input should have " + originalArrayLength + " values");
			}
        } while (true);
        
        
        // a. Print the original array
		System.out.println("\nThe input array is: " + printArray(originalArray));
		
		// b. Make copy of the original array and print copied array
		int[] copiedArray = copyArray(originalArray);
		System.out.println("The copied array is: " + printArray(copiedArray));
		
		// c. Sort the copied array in ascending order and print sorted array 
		int[] sortedArray = sortArray(copiedArray);
		System.out.println("The sorted array is: " + printArray(sortedArray));
		
		// d. Calculate the sum of odd and even elements 
		sumOfOddEvenIntegers(originalArray);
		
		// e. Get the largest integer value with its index
		largestInteger(originalArray);
		
		// f. Calculate the average of elements
		calculateAverage(originalArray);
		
		// g. Search the integer value in the array
		System.out.print("\nEnter an integer to search: ");
		if (scan.hasNextInt()) {
			int integer = scan.nextInt();
			searchInteger(originalArray, integer);
        } 
		
		// h. Count occurrences of the integer in the array
		System.out.print("\nEnter the integer to count occurrences: ");
		if (scan.hasNextInt()) {
			int integer = scan.nextInt();
			countInteger(originalArray, integer);
        } 
		
		// i. Replace integer of the array with integer and index specified by user
		System.out.print("\nEnter the integer to insert: ");
		if (scan.hasNextInt()) {
			int integer = scan.nextInt();
			System.out.print("Enter the index to be inserted at: ");
			if (scan.hasNextInt()) {
				int index = scan.nextInt();
				int[] newArray = replaceInteger(copyArray(originalArray), integer, index);
				System.out.println("\nThe new array is: " + printArray(newArray));
			}
			
        } 
		
		// Program complete
		System.out.println("\nProgram Completed.");
		
		return;
	}
}
