package com.Assignment.Abc_Restaurant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {


  

     @Test
    public void TestvalidUsername(){

        assertTrue(UserRegister.isvalidusername("validuser"));
        assertFalse(UserRegister.isvalidusername("invaid@username"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(UserRegister.isvalidpassword("Strong1P@ss"));
        assertFalse(UserRegister.isvalidpassword("weak"));
    }
    @Test
    public void Testvalidemail(){

        assertTrue(UserRegister.isvaliedemail("niku@gmail.com"));
        assertFalse(UserRegister.isvaliedemail("test@domain"));
    }

}
