/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package st10085622_prog5121_poe_p1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Administrator
 */
public class loginTest {
    
    /**
     * AssertEquals Checking to see if username formatting is correct 
     */
    @Test
    public void testUserNameCorrectFormat() {      
        login lg = new login();
        userData ud = new userData();
        String expResult = "kyl_1";
        lg.enterUsername();
        String result = ud.getUsername();
        assertEquals(expResult, result);
    }
    
    /**
     * AssertEquals Checking to see if username formatting is incorrect
     */
    @Test
    public void testUserNameIncorrectFormat() {      
        login lg = new login();
        String expResult = "kyle!!!!!";
        lg.enterUsername();
        String result = lg.username;
        assertEquals(expResult, result);
    }

    /**
     * AssertEquals Checking if password meets requirements defined in question
     * contains capital letter
     * is minimum 8 characters
     * contains special character(s)
     * contains digit(s)
     */
    @Test
    public void testCheckPasswordComplexity() {
        login lg = new login();
        userData ud = new userData();
        String expResult = "Ch&&sec@ke99!";
        lg.enterPassword();
        String result = ud.getPassword();
        assertEquals(expResult, result);
    }
    
       /**
     * AssertEquals Checking if password meets does not requirements
     */
    @Test
    public void testCheckDoesNotMeetPasswordComplexity() {
        login lg = new login();
        String expResult = "password";
        lg.enterPassword();
        String result = lg.password;
        assertEquals(expResult, result);
    }
    
    
    /**
     * AssertTrue Test when login is successful, the status expected is true
     */
    @Test
    public void testLoginUserSuccess() {
        login lg = new login();
        boolean result = lg.loginUser();  
        assertTrue("True: Login is Successful", result);
    }

    /**
     * AssertFalse Test when login fails, the status expected is false
     */
    @Test
    public void testLoginUserFail() {
        login lg = new login();
        boolean result = lg.loginUser();
        assertFalse("False: Login has Failed", result);
    }
    
     /**
     * AssertTrue Test when username is correctly formatted, the status expected is true
     */
    @Test
    public void testUsernameFormatSuccess() {
        login lg = new login(); //this is calling the class login
        lg.enterUsername(); // this calls the method to enter username
        boolean result = lg.checkUserName(lg.username); //this cathces the result and tests it below
        assertTrue("Username is NOT CORRECTLY formatted", result);
    }
    
    /**
     * AssertFalse Test when username is not correctly formatted, the status expected is false
     */
    @Test
    public void testUsernameFormatFail() {
        login lg = new login();
        lg.enterUsername();
        boolean result = lg.checkUserName(lg.username);
        assertFalse("Username is CORRECTLY formatted", result);
    }
    
    
    /**
     * AssertTrue Test when login fails, the status expected is false
     */
    @Test
    public void testPasswordMeetsComplexity() {
        login lg = new login();
        lg.enterPassword();
        boolean result = lg.checkPasswordComplexity(lg.password);
        assertTrue("True: Password does meet the complexities set", result);
    }
    
    /**
     * AssertFalse Test when login fails, the status expected is false
     */
    @Test
    public void testPasswordDoesNotMeetsComplexity() {
        login lg = new login();
        lg.enterPassword();
        boolean result = lg.checkPasswordComplexity(lg.password);
        assertFalse("False: Password does NOT meet the complexities set", result);
    }
    
    
}
