package main;

import java.util.*;

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


    /**
     * Converts a Roman numeral to a decimal number.
     *
     * @param romanNumber The Roman numeral to be converted.
     * @return The decimal representation of the Roman numeral.
     * @throws IllegalArgumentException If the input is invalid.
     */
    public int fromRomanNumber(String romanNumber) throws IllegalArgumentException {
        // Create a HashMap to map Roman characters to their decimal values.

        HashMap<String, Integer> romanList = new HashMap<>();
        String[] romanString = romanNumber.split("");
        int romanToDecimal = 0;
        // Populate the HashMap with Roman characters and their values.

        romanList.put("I", 1);
        romanList.put("V", 5);
        romanList.put("X", 10);
        romanList.put("L", 50);
        romanList.put("C", 100);
        romanList.put("D", 500);
        romanList.put("M", 1000);
        // Check if the input is empty and throw an exception if it is.

        if (romanNumber.isEmpty()) {
            throw new IllegalArgumentException("The string must have a value");
        }
        // Iterate through the Roman characters and calculate the decimal representation.

        for (int index = 0; index < romanString.length - 1; index++) {
            if (!romanList.containsKey(romanString[index])) {
                // Throw an exception if an invalid character is encountered.

                throw new IllegalArgumentException("The entry is not found in the Roman alphabet");
            }

            int currentValue = romanList.get(romanString[index]);
            int nextValue = romanList.get(romanString[index + 1]);

            if (currentValue < nextValue) {
                romanToDecimal -= currentValue;
            } else {
                romanToDecimal += currentValue;
            }
        }

        // Add the value of the last character.

        romanToDecimal += romanList.get(romanString[romanString.length - 1]);

        return romanToDecimal;
    }

    /**
     * This method calculates all combinations of values a, b, and c where the formula
     * a^2 + b^2 = c^2 holds true, with each value starting from 1 and going up to 99.
     *
     * @return A Set containing the unique products of a, b, and c that satisfy the equation.
     */
    public Set<Integer> combinatorics() {
        Set<Integer> numberSet = new HashSet<>();

        for (int a = 1; a < 100; a++) {
            int aSquared = a * a;
            for (int b = a; b < 100; b++) {
                int bSquared = b * b;
                int cSquared = aSquared + bSquared;
                if (isPerfectSquare(cSquared)) {
                    int c = (int) Math.sqrt(cSquared);
                    if (c < 100) {
                        numberSet.add(a * b * c);
                    }
                }
            }
        }

        return numberSet;
    }

    /**
     * This method checks if a given number is a perfect square.
     *
     * @param num The number to be checked.
     * @return true if 'num' is a perfect square, false otherwise.
     */
    private boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public Set<Integer> combinatoric() {
        Set<Integer> numberSet = new HashSet<>();

        for (int a = 1; a < 99; a++) {
            int aSquared = a * a;

            for (int b = a; b < 99; b++) {
                int bSquared = b * b;

                for (int c = b; c < 99; c++) {
                    int cSquared = c * c;
                    int productAB = aSquared * bSquared;
                    int productCD = cSquared * (aSquared + bSquared);

                    if (productAB == productCD) {
                        numberSet.add(productAB);
                    }
                }
            }
        }
        return numberSet;
    }


    public Set<Integer> findArmstrongNumbers() {
        Set<Integer> armstrongNumbers = new HashSet<>();
        final int MAX_DIGIT = 9;

        for (int digitX = 1; digitX <= MAX_DIGIT; digitX++) {
            int xCubed = digitX * digitX * digitX;

            for (int digitY = digitX; digitY <= MAX_DIGIT; digitY++) {
                int yCubed = digitY * digitY * digitY;

                for (int digitZ = digitY; digitZ <= MAX_DIGIT; digitZ++) {
                    int zCubed = digitZ * digitZ * digitZ;

                    if (digitX * digitY * digitZ == xCubed + yCubed + zCubed) {
                        armstrongNumbers.add(digitX * 100 + digitY * 10 + digitZ);
                    }
                }
            }
        }

        return armstrongNumbers;
    }

}








