package main;

import java.util.ArrayList;
import java.util.List;

public class BasicCalculationTypes {


    /**
     * This method takes two integer parameters n and m.
     *
     * @param n is an integer number
     * @param m is the second integer number
     * @return the result of the calculation
     */
    public int calculation(int n, int m) {
        int product = n * m;
        int halfProduct = product / 7;
        return halfProduct % 2;
    }

    /**
     * Calculates the count and sum of all numbers from 1 to the given number (inclusive)
     * that are divisible by 2 or 7.
     *
     * @param number The upper limit for the calculation.
     * @return A formatted string containing the count and sum.
     * @throws IllegalArgumentException Thrown if the given number is less than 1.
     */
    public String calcSumAndCountAllNumbersDivBy_2_Or_7(int number) throws IllegalArgumentException {
        if (number < 1) {
            throw new IllegalArgumentException("Number must be a positive number");

        }
        int count = countNumbersDivBy_2_Or_7(number);
        int total_sum = sumNumbersDivBy_2_Or_7(number);


        return String.format("Count : %d,Sum:%d", count, total_sum);
    }

    /**
     * Counts the number of integers from 1 to the given number (inclusive)
     * that are divisible by 2 or 7.
     *
     * @param number The upper limit for the calculation.
     * @return The count of numbers that are divisible by 2 or 7.
     */
    private int countNumbersDivBy_2_Or_7(int number) {
        int count = 0;
        for (int index = 1; index <= number; index++) {
            if ((index % 2 == 0) || (index % 7 == 0)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the sum of all numbers from 1 to the given number (inclusive)
     * that are divisible by 2 or 7.
     *
     * @param number The upper limit for the calculation.
     * @return The sum of numbers that are divisible by 2 or 7.
     */
    private int sumNumbersDivBy_2_Or_7(int number) {
        int totalSum = 0;
        for (int index = 1; index <= number; index++) {
            if ((index % 2 == 0) || (index % 7 == 0)) {
                totalSum += index;
            }
        }
        return totalSum;
    }


    /**
     * Checks if the given number is even.
     *
     * @param number The number to be checked.
     * @return True if the number is even, false otherwise.
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Checks if the given number is odd.
     *
     * @param number The number to be checked.
     * @return True if the number is odd, false otherwise.
     */
    public boolean isOdd(int number) {
        return !isEven(number);
    }


    /**
     * Converts a given positive number into its corresponding textual representation for each digit.
     *
     * @param number The positive number to be converted.
     * @return The textual representation of the digits in the given number.
     * @throws IllegalArgumentException If the number is negative.
     */
    public String numberAsText(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be a positive number");
        }

        StringBuilder valueAsText = new StringBuilder();
        while (number > 0) {
            int remainder = number % 10;
            String digitText = getDigitText(remainder);
            valueAsText.insert(0, digitText);
            number = number / 10;
        }

        return valueAsText.toString();
    }

    /**
     * Returns the textual representation of a single digit using a switch expression.
     *
     * @param digit The digit to be converted into textual representation.
     * @return The textual representation of the digit.
     * @throws IllegalArgumentException If the digit is not within the range 0-9.
     */
    private String getDigitText(int digit) {
        return switch (digit) {
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> throw new IllegalArgumentException("Invalid digit: " + digit);
        };
    }

    /**
     * Calculates a list of perfect numbers up to the given number.
     * A perfect number is a positive integer that is equal to the sum of its proper divisors.
     *
     * @param number The maximum number up to which to calculate the perfect numbers.
     * @return A list of perfect numbers found up to the given number.
     * @throws IllegalArgumentException If the input number is less than 1.
     */
    public List<Integer> calcPerfectNumbers(int number) throws IllegalArgumentException {
        List<Integer> perfectNumberList = new ArrayList<>();
        if (number < 1) {
            throw new IllegalArgumentException("Input must be a positive Number");
        }

        for (int candidate = 1; candidate <= number; candidate++) {
            int sumOfDivisors = calculateSumOfDivisors(candidate);

            if (sumOfDivisors == candidate) {
                perfectNumberList.add(candidate);
            }
        }

        return perfectNumberList;
    }

    /**
     * Calculates the sum of proper divisors for a given number.
     *
     * @param number The number for which to calculate the sum of proper divisors.
     * @return The sum of proper divisors for the given number.
     */
    private int calculateSumOfDivisors(int number) {
        int totalSum = 0;
        for (int divisor = 1; divisor < number; divisor++) {
            if (number % divisor == 0) {
                totalSum += divisor;
            }
        }
        return totalSum;
    }

    /**
     * Calculates all prime numbers up to the given number using the Sieve of Eratosthenes algorithm.
     *
     * @param number The given number up to which prime numbers are to be calculated.
     * @return A list of all prime numbers up to the given number.
     * @throws IllegalArgumentException If the given number is less than 2.
     */
    public List<Integer> calcPrimesUpTo(int number) throws IllegalArgumentException {
        if (number < 2) {
            throw new IllegalArgumentException("Prime numbers start at 2");
        }

        List<Boolean> isComposite = initializeIsCompositeList(number);
        markMultiplesAsComposite(isComposite, number);

        return collectPrimes(isComposite);
    }

    /**
     * Initializes the isComposite list and marks all indices as "true".
     *
     * @param number The given number up to which the isComposite list is initialized.
     * @return The initialized isComposite list.
     */
    private List<Boolean> initializeIsCompositeList(int number) {
        List<Boolean> isComposite = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            isComposite.add(true);
        }
        isComposite.set(0, false);
        isComposite.set(1, false);
        return isComposite;
    }

    /**
     * Marks the multiples of prime numbers as "false" in the isComposite list.
     *
     * @param isComposite The list containing boolean values representing whether a number is composite or prime.
     * @param number      The given number up to which multiples are marked as composite.
     */
    private void markMultiplesAsComposite(List<Boolean> isComposite, int number) {
        for (int prime = 2; prime * prime <= number; prime++) {
            if (isComposite.get(prime)) {
                for (int multiple = prime * prime; multiple <= number; multiple += prime) {
                    isComposite.set(multiple, false);
                }
            }
        }
    }

    /**
     * Collects the prime numbers from the isComposite list and returns them as a list.
     *
     * @param isComposite The list containing boolean values representing whether a number is composite or prime.
     * @return A list of prime numbers collected from the isComposite list.
     */
    private List<Integer> collectPrimes(List<Boolean> isComposite) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < isComposite.size(); i++) {
            if (isComposite.get(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }


    /**
     * Calculates the position-based checksum for a given number represented as a string.
     *
     * @param text The number as a string for which the checksum should be calculated.
     * @return The position-based checksum of the number (totalSum % 10).
     * @throws IllegalArgumentException If the input string is empty.
     */
    public int calcCheckSum(String text) throws IllegalArgumentException {

        if (text.isEmpty()) {
            throw new IllegalArgumentException("String must have at least one char");
        }
        int totalSum = 0;
        int textLength = text.length();

        for (int index = 0; index < textLength; index++) {
            totalSum += (index + 1) * Character.getNumericValue(text.charAt(index));
        }

        return totalSum % 10;
    }


}


