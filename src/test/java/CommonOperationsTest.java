import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CommonOperationsTest {

    public CommonOperationsTest() {
    }

    @Test
    public void isDivisible_false_isNotDivisible() {
        int divident = 4;
        int divisor = 3;
        CommonOperations instance = new CommonOperations();
        boolean expResult = false;
        boolean result = instance.isDivisible(divident, divisor);
        assertEquals(expResult, result);
    }

    @Test
    @Parameters({"5, 5","9, 3","12, 3","3, 3","1, 1","6, 2"})
    public void isDivisible_True_isDivisible(int divident, int divisor) {
        CommonOperations instance = new CommonOperations();
        boolean expResult = true;
        boolean result = instance.isDivisible(divident, divisor);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isDivisible_throwsIllegalArgumentException_whenDividedByZero() {
        int divident = 4;
        int divisor = 0;
        CommonOperations instance = new CommonOperations();
        boolean result = instance.isDivisible(divident, divisor);
    }


    @Test
    @Parameters({"5, 2","9, 3"})
    public void floorRootValue_returnsCorrectResult_correctParameterGiven(int number, int expRes) {
        System. out.println("floorRootvalue");
        CommonOperations instance = new CommonOperations();
        int result = instance. floorRootValue (number);
        assertEquals(expRes, result);
    }

    @Test
    public void testMarkNonPrimeFromTable_MarksNoNPrime_WhenNonDivisible() {
        System. out.println("markHonPrimeF romTable");
        //given
        int[][] numbersTable = {{2, 1}, {3, 1}, {4, 1}, {5, 1}};
        int range = 2;
        int[][] expResult = {{2, 1}, {3, 0}, {4, 0}, {5, 0}};
        PrimeNumbers instance = new PrimeNumbers(new CommonOperations() {
            public boolean isDivisible(int divident, int divisor) {
                return true;
            }
        });
        //when
        int[][] result = instance.markNonPrimeFromTable(numbersTable, range);
        //then
        assertArrayEquals(expResult, result);
    }


}

