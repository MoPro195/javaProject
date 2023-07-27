package test;

import org.junit.Before;

import static org.junit.jupiter.api.Assertions.*;

import main.BasicCalculationTypes;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicCalculationTypesTest {
    private BasicCalculationTypes calculator;

    @Before
    public void setUp() {
        calculator = new BasicCalculationTypes();

    }

    @Test
    public void testCalculationWithZero() {
        int result = calculator.calculation(10, 0);
        Assertions.assertEquals(result, 0);

    }

    @Test
    public void testCalculationWithPositiveNumbers() {
        int result = calculator.calculation(3, 4);
        Assertions.assertEquals(result, 6);
    }

    @Test
    public void testCalculationWithNegativeNumbers() {
        int result = calculator.calculation(-5, 5);
        Assertions.assertEquals(result, -5);
    }

    @Test
    public void testCalcSumAndCountAllNumbersDivBy_2_Or_7WithPostiveNumber() {
        String expectedOutput = "Count : 1,Sum:2";
        Assertions.assertEquals(calculator.calcSumAndCountAllNumbersDivBy_2_Or_7(3), expectedOutput);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcSumAndCountAllNumbersDivBy_2_Or_7WithNegativeNumber() {
        calculator.calcSumAndCountAllNumbersDivBy_2_Or_7(-10);
    }

    @Test
    public void testIsEvenNormallyFunction() {
        Assertions.assertTrue(calculator.isEven(8));
    }

    @Test
    public void testIsEvenWithOddNumber() {
        Assertions.assertFalse(calculator.isEven(5));
    }

    @Test
    public void testIsOddNormallyFunction() {
        Assertions.assertTrue(calculator.isOdd(15));
    }

    @Test
    public void testIsOddWithEvenNumber() {
        Assertions.assertFalse(calculator.isOdd(10));
    }

    @Test
    public void testNumberAsTextNormallyFunction() {
        Assertions.assertEquals(calculator.numberAsText(42), "FOURTWO");
    }

    @Test
    public void testNumberAsTexWithHugeNumber() {
        Assertions.assertEquals(calculator.numberAsText(24680), "TWOFOURSIXEIGHTZERO");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberAsTextWithNegativNumber() {
        calculator.numberAsText(-100);

    }

    @Test
    public void testCalcPerfectNumbers() {
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(6);
        expectedOutput.add(28);
        expectedOutput.add(496);
        Assertions.assertEquals(calculator.calcPerfectNumbers(1000), expectedOutput);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcPerfectNumbersWithNegativNumber() {
        calculator.calcPerfectNumbers(-100);
    }

    @Test
    public void testPrimesUpTo10() {
        List<Integer> result = calculator.calcPrimesUpTo(10);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);
        assertEquals(expected, result);
    }

    @Test
    public void testPrimesUpTo20() {
        List<Integer> result = calculator.calcPrimesUpTo(20);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        assertEquals(expected, result);
    }

    @Test
    public void testPrimesUpTo30() {
        List<Integer> result = calculator.calcPrimesUpTo(30);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionCalcPrimes() {
        calculator.calcPerfectNumbers(0);
    }

    @Test
    public void testCheckSumWithNormalFunction() {
        Assertions.assertEquals(calculator.calcCheckSum("11111"), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckSumWithEmptyInput() {
        calculator.calcCheckSum("");
    }

    @Test
    public void testCheckSumWithCrazyNumbers() {
        Assertions.assertEquals(calculator.calcCheckSum("87654321"), 0);

    }


}