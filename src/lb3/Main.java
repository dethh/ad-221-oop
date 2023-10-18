package lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //1
        System.out.println("Task 1");
        System.out.print("Enter your string: ");
        String inputString= s.next();
        boolean endsWithEd = endsWithEd(inputString);
        System.out.println("String ends with 'ed': " + endsWithEd);
        System.out.println("-------------------------------------------------");
        //2
        System.out.println("Task 2");
        System.out.print("Enter your string: ");
        inputString= s.next();
        int sumOfDigits = sumDigits(inputString);
        System.out.println("The sum of the numbers in the line: " + sumOfDigits);
        System.out.println("-------------------------------------------------");
        //3
        System.out.println("Task 3");
        System.out.print("Enter your string: ");
        inputString= s.next();
        int longestBlockLength = findLongestBlockLength(inputString);
        System.out.println("Length of the longest block of characters: " + longestBlockLength);
        System.out.println("-------------------------------------------------");
        //4
        System.out.println("Task 4");
        inputString = "  Дмитро Максимович Іванов ";
        System.out.print("Source string: "+inputString+"\n" );
        printWords(inputString);
        System.out.println("-------------------------------------------------");
        //5
        System.out.println("Task 5");
        String strA = "Вася";
        String strB = "12345678";
        System.out.println("First line: "+strA);
        System.out.println("Second line: "+strB);
        String mergedString = mergeStrings(strA, strB);
        System.out.println("Integration result: " + mergedString);
        System.out.println("-------------------------------------------------");
    }

    private static boolean endsWithEd(String input) {
        return input.trim().endsWith("ed");                     // Використовуємо метод endsWith для перевірки закінчення рядка на "ed"
    }

    private static int sumDigits(String input) {
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                sum += Character.getNumericValue(currentChar);  // Якщо символ є цифрою, то додаємо його до суми
            }
        }

        return sum;
    }

    private static int findLongestBlockLength(String input) {
        int longestLength = 0;
        int currentLength = 1;

        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) == input.charAt(i - 1)) {       // Порівнюємо поточний символ з попереднім
                currentLength++;
            } else {

                if (currentLength > longestLength) {            // Якщо символ не співпадає з попереднім, оновлюємо найдовшу довжину і обнуляємо лічильник
                    longestLength = currentLength;
                }
                currentLength = 1;
            }
        }

        if (currentLength > longestLength) {                    // Перевіряємо, чи найдовший блок вкінці рядка
            longestLength = currentLength;
        }

        return longestLength;
    }

    private static void printWords(String input) {
        String[] words = input.trim().split("\\s+");       // Розділяємо рядок на слова, використовуючи пробіл як роздільник
        System.out.print("Words:\n");
        for (String word : words) {
            System.out.println(word);                            // Виводимо знайдені слова у консоль
        }
    }

    public static String mergeStrings(String strA, String strB) {
        int lengthA = strA.length();
        int lengthB = strB.length();
        StringBuilder result = new StringBuilder();

        int maxLength = lengthA + lengthB;

        for (int i = 0; i < maxLength; i++) {
            if (i < lengthA) {
                result.append(strA.charAt(i));
            }
            if (i < lengthB) {
                result.append(strB.charAt(i));
            }
        }

        return result.toString();
    }

}