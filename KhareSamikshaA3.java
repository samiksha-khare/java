import java.util.Scanner;

public class KhareSamikshaA3 {

    /**
     * Function to check if two strings are anagrams
     *
     * @param string1
     * @param string2
     * @return Boolean
     */
    public static Boolean isAnagram(String string1, String string2) {
        // Remove white spaces, punctuations from the string and convert it to lowercase
        string1 = string1.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();
        string2 = string2.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();

        // Check if the lengths of string1 and string2 are not equal
        if (string1.length() != string2.length()) {
            return false;
        }
        // Iterate through each character in string1
        for (int i = 0; i < string1.length(); i++) {
            char ch = string1.charAt(i);
            int index = string2.indexOf(ch);

            // If character is not found in string2, return false
            if (index == -1) {
                return false;
            } else {
                // Else, remove the matched character from string2
                string2 = extractSubstring(string2,0, index-1).concat(extractSubstring(string2,index+1,string2.length()-1));
            }
        }
        // Return true, if all characters in string1 have been matched in string2, which means strings are anagram
        return true;
    }

    /**
     * Function to extract a substring from a given string
     *
     * @param string3
     * @param startIndex
     * @param endIndex
     * @return String
     */
    public static String extractSubstring(String string3, int startIndex, int endIndex) {
        // Create a StringBuilder instance
        StringBuilder extractedSubstring = new StringBuilder();

        // Iterate from start to end index
        for (int i = startIndex; i <= endIndex; i++) {
            // Append iterated character to extractedSubstring
            extractedSubstring.append(string3.charAt(i));
        }
        return extractedSubstring.toString();
    }

    /**
     * Main method
     * @param args
     */

    public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    // User input for the first anagram string
    System.out.print("Anagram String 1 = ");
    String str1 = scan.nextLine();

    // User input for the second anagram string
    System.out.print("Anagram String 2 = ");
    String str2 = scan.nextLine();

    // User input for the string, to extract a substring
    System.out.print("Substring Extraction String 3 = ");
    String str3 = scan.nextLine();

    // User input for the starting index of the substring
    System.out.print("Starting index of substring = ");
    int startIndex = scan.nextInt();

    // User input for the ending index of the substring
    System.out.print("Ending index of substring = ");
    int endIndex = scan.nextInt();

    // Check if str1 and str2 are anagrams
    if (isAnagram(str1,str2)) {
        System.out.println("\n" + str1 + " and " + str2 + " are anagrams of each other.");
    }
    else {
        System.out.println("\n" + str1 + " and " + str2 + " are not anagrams of each other.");
    }

    // Extract substring from str3 for the given start and end index
    try {
        System.out.println("\nThe extracted substring is: " + extractSubstring(str3, startIndex, endIndex));
    }
    catch (IndexOutOfBoundsException e) {
        // Handle the exception if the substring indices are out of bounds
        System.out.println("\nUsage: java Enter a valid index within the given string length.");
    }

    System.out.println("\nProgram Completed.");
}
}

/**
 * Sources Used:
 * - Google searched to remove white spaces, and punctuations from the strings
 */