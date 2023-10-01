package main;

import java.util.Arrays;

public class Recursiv {


    /**
     * Calculates the Fibonacci number at position 'n' using a recursive approach.
     *
     * @param n The position in the Fibonacci sequence.
     * @return The Fibonacci number at position 'n'.
     * @throws IllegalArgumentException If 'n' is less than 1.
     */

    public long calculateFibonacci(int n) throws IllegalArgumentException {

        if (n < 1) {
            throw new IllegalArgumentException("The fibonacci algoritm is only for positiv number");
        }
        if (n == 1 || n == 2) {
            return 1;

        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }


    public int calcDigits(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("The method is intended for positive integers only.");
        }
        if (number < 10) {
            return 1;
        }
        int firstDigit = number / 10;
        return calcDigits(firstDigit) + 1;

    }

    public int calculateDigitalRoot(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("The method is intended for positive integers only.");
        }
        if (number < 10) {
            return number;
        }
        int lastDigit = number % 10;

        return calculateDigitalRoot(number / 10) + lastDigit;

    }

    /**
     * Reverses a given string using recursion.
     *
     * @param input The string to be reversed.
     * @return The reversed string.
     * @throws IllegalArgumentException If the input string is empty.
     * @throws NullPointerException     If the input string is null.
     */
    public String reverseString(String input) throws NullPointerException {
        if (input == null) {
            throw new NullPointerException();
        }

        if (input.length() == 1) {
            return input;
        }
        char firstDigit = input.charAt(0);
        String restOfString = input.substring(1);

        return reverseString(restOfString) + firstDigit;


    }

    public int sum(int[] numberArray) throws IllegalArgumentException {
        if (numberArray.length == 0) {
            throw new IllegalArgumentException("Array need a value");
        }
        if (numberArray.length == 1) {
            return numberArray[0];
        }

        return sum(Arrays.copyOfRange(numberArray, 1, numberArray.length)) + numberArray[0];

    }


    public int min(int[] numberArray) {
        if (numberArray.length == 0) {
            return Integer.MAX_VALUE;
        }

        if (numberArray.length == 1) {
            return numberArray[0];
        }
        int firstDigit = numberArray[0];
        int[] restDigit = Arrays.copyOfRange(numberArray, 1, numberArray.length);
        int minOfRest = min(restDigit);
        if (firstDigit < minOfRest) {
            return firstDigit;
        } else {
            return min(restDigit);
        }

    }


}
