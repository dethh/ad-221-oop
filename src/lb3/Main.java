package lb3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Task 1");
        System.out.print("Enter your string: ");
        String inString= s.next();
        boolean isEndsWithEd = isEndsWithEd(inString);
        System.out.println("String ends with 'ed': " + isEndsWithEd);

        System.out.println("Task 2");
        System.out.print("Enter your string: ");
        inString= s.next();
        int digitsSum = sumDigits(inString);
        System.out.println("The sum of the numbers in the line: " + digitsSum);

        System.out.println("Task 3");
        System.out.print("Enter your string: ");
        inString= s.next();
        int maxBlockLength = findMaxBlockLength(inString);
        System.out.println("Length of the longest block of characters: " + maxBlockLength);

        System.out.println("Task 4");
        inString = " Владимир Александрович Зеленский  ";
        System.out.print("Source string: "+inString+"\n" );
        printWords(inString);

        System.out.println("Task 5");
        String firstLine = "Никита";
        String secondLine = "qwezxcasd";
        System.out.println("First line: "+firstLine);
        System.out.println("Second line: "+secondLine);
        String combinedString = mergeStrings(firstLine, secondLine);
        System.out.println("Integration result: " + combinedString);
    }
    private static boolean isEndsWithEd(String input) {
        return input.trim().endsWith("ed");
    }
    private static int sumDigits(String input) {
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                sum += Character.getNumericValue(currentChar);
            }
        }

        return sum;
    }
    private static int findMaxBlockLength(String input) {
        int maxLength = 0;
        int currentLength = 1;

        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) == input.charAt(i - 1)) {
                currentLength++;
            } else {

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        return maxLength;
    }
    private static void printWords(String input) {
        String[] words = input.trim().split("\\s+");
        System.out.print("Words:\n");
        for (String word : words) {
            System.out.println(word);
        }
    }
    public static String mergeStrings(String firstLine, String secondLine) {
        int firstLength = firstLine.length();
        int secondLength = secondLine.length();
        StringBuilder result = new StringBuilder();

        int maxLength = firstLength + secondLength;

        for (int i = 0; i < maxLength; i++) {
            if (i < firstLength) {
                result.append(firstLine.charAt(i));
            }
            if (i < secondLength) {
                result.append(secondLine.charAt(i));
            }
        }
        return result.toString();
    }

}
