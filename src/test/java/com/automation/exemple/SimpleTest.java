package com.automation.exemple;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimpleTest {

    @Test
    public void calculationPlusTest(){
        int a = 2;
        int b = 2;
        int sum = a + b;
        assertEquals(sum, 4);
    }

    @Test
    public void calculationMinusTest(){
        int a = 5;
        int b = 4;
        int sum = a - b;
        assertEquals(sum, 4, "ACHTUNG!");
    }

    @Test
    public void calculationVerifierTest(){

        int a = 5;
        int b = 4;
        boolean result = verifyPlusCalculationAction(a, b, 9);
        assertTrue(result);
    }

    private boolean verifyPlusCalculationAction(int a, int b, int result) {
        return a + b == result;
    }

}
