/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter44;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author aalsc
 */
public class LoanTest {
    
    public LoanTest() {
  
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAnnualInterestRate method, of class Loan.
     */
    @Test
    public void testGetAnnualInterestRate() {
        System.out.println("getAnnualInterestRate");
        Loan instance = new Loan();
        double expResult = 0.0;
        double result = instance.getAnnualInterestRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnnualInterestRate method, of class Loan.
     */
    @Test
    public void testSetAnnualInterestRate() {
        System.out.println("setAnnualInterestRate");
        double annualInterestRate = 0.0;
        Loan instance = new Loan();
        instance.setAnnualInterestRate(annualInterestRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfYears method, of class Loan.
     */
    @Test
    public void testGetNumberOfYears() {
        System.out.println("getNumberOfYears");
        Loan instance = new Loan();
        int expResult = 0;
        int result = instance.getNumberOfYears();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumberOfYears method, of class Loan.
     */
    @Test
    public void testSetNumberOfYears() {
        System.out.println("setNumberOfYears");
        int numberOfYears = 0;
        Loan instance = new Loan();
        instance.setNumberOfYears(numberOfYears);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoanAmount method, of class Loan.
     */
    @Test
    public void testGetLoanAmount() {
        System.out.println("getLoanAmount");
        Loan instance = new Loan();
        double expResult = 0.0;
        double result = instance.getLoanAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoanAmount method, of class Loan.
     */
    @Test
    public void testSetLoanAmount() {
        System.out.println("setLoanAmount");
        double loanAmount = 0.0;
        Loan instance = new Loan();
        instance.setLoanAmount(loanAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthlyPayment method, of class Loan.
     */
    @Test
    public void testGetMonthlyPayment() {
        System.out.println("getMonthlyPayment");
        Loan instance = new Loan();
        double expResult = 0.0;
        double result = instance.getMonthlyPayment();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPayment method, of class Loan.
     */
    @Test
    public void testGetTotalPayment() {
        System.out.println("getTotalPayment");
        Loan instance = new Loan();
        double expResult = 0.0;
        double result = instance.getTotalPayment();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoanDate method, of class Loan.
     */
    @Test
    public void testGetLoanDate() {
        System.out.println("getLoanDate");
        Loan instance = new Loan();
        Date expResult = null;
        Date result = instance.getLoanDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
