package test;

import main.Recursiv;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class RecursivTest {
    private Recursiv algo = new Recursiv();

    @Before
    public void setUp() {
        algo = new Recursiv();

    }

    @Test
    public void testFibonacciPositiveNumber() {
        long result = algo.calculateFibonacci(8);
        Assertions.assertEquals(result, 21);
    }

    @Test
    public void testFibonacciWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            algo.calculateFibonacci(-10);
        });


    }

    @Test
    public void testCalcDigitsWithNPostiveNumber() {
        int result = algo.calcDigits(12345);
        Assertions.assertEquals(result, 5);
    }

    @Test
    public void testCalcSumOfDigitsWithNumber() {
        int result = algo.calculateDigitalRoot(1234);
        Assertions.assertEquals(result, 10);
    }

    @Test
    public void testReverseStringOneDigit() {
        String digit = algo.reverseString("A");
        Assertions.assertEquals(digit, "A");

    }

    @Test
    public void testReverseWithName() {
        String name = algo.reverseString("Mahmoud");
        Assertions.assertEquals(name, "duomhaM");
    }

    @Test
    public void testReverseEmpty() {
        assertThrows(NullPointerException.class, () -> {
            algo.reverseString(null);

        });
    }

    @Test
    public void testSumOrdinary() {
        int[] number = {1, 2, 3, -7};
        int result = algo.sum(number);
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void testSumEmpty() {
        int[] emptyArray = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            algo.sum(emptyArray);
        });
    }

    @Test
    public void testMinPositiv() {
        int[] testArray = {7, 2, 1, 9, 7, 1};
        int result = algo.min(testArray);
        Assertions.assertEquals(result, 1);
    }

    @Test
    public void testWithEmptyArray() {
        int[] emptyArray = {};
        int result = algo.min(emptyArray);
        Assertions.assertEquals(result, Integer.MAX_VALUE);
    }

    @Test
    public void testWithNegativeArr() {
        int[] negativNumber = {1, 2, 3, -7};
        int result = algo.min(negativNumber);
        Assertions.assertEquals(result, -7);

    }
}