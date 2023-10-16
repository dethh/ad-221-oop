package lb1;

public class Main {
    //1.1
    public static boolean isIncreasing(int[] array) {
        if (array.length < 2) {
            return false;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }

        return true;
    }
    //1.2
    public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
    //1.3
    public static boolean canSplitArray(int[] array) {
        if (array.length < 2) {
            return false;
        }

        int totalSum = 0;
        for (int num : array) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        int currentSum = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum == targetSum) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 1, 1, 2, 1};
        int[] array2 = {2, 1, 2, 1, 1};
        int[] array3 = {10, 10};

        System.out.println("1. Возрастающий массив: " + isIncreasing(array1));
        System.out.println("2. Игра FizzBuzz:");
        fizzBuzz();
        System.out.println("3. Разделение массива: " + canSplitArray(array1));
        System.out.println("3. Разделение массива: " + canSplitArray(array2));
        System.out.println("3. Разделение массива: " + canSplitArray(array3));
    }

}