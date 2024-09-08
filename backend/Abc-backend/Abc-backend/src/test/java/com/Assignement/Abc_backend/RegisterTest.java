package com.Assignement.Abc_backend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
