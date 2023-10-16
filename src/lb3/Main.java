package lb3;
public class Main {
    public static boolean endsWithEd(String str) {
        return str.endsWith("ed");
    }
    public static int sumNumInString(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }
        return sum;
    }
    public static int longestBlockLength(String str) {
        int maxLength = 0;
        int currentLength = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
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
    public static void printWordsInString(String str) {
        String[] words = str.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }
    public static String mergeStrings(String strA, String strB) {
        StringBuilder result = new StringBuilder();
        int lenA = strA.length();
        int lenB = strB.length();
        int maxLength = Math.max(lenA, lenB);

        for (int i = 0; i < maxLength; i++) {
            if (i < lenA) {
                result.append(strA.charAt(i));
            }
            if (i < lenB) {
                result.append(strB.charAt(i));
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String testString = "This is a test string 1234 ed";

        System.out.println("1. Заканчивается на 'ed': " + endsWithEd(testString));
        System.out.println("2. Сумма цифр: " + sumNumInString(testString));
        System.out.println("3. Длина наибольшего блока: " + longestBlockLength(testString));
        System.out.println("4. Слова в строке:");
        printWordsInString(testString);

        String strA = "abc";
        String strB = "123";
        System.out.println("5. Объединение строк: " + mergeStrings(strA, strB));
    }

}