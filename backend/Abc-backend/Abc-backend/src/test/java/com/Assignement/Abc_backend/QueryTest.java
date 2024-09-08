package com.Assignement.Abc_backend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QueryTest {


    @Test
    public void Testvalidname(){
        assertTrue(Query.isvalidname("Sawdha_Mufeedh"));
        assertFalse(Query.isvalidname("123!Sawdha"));
    }


    @Test
    public void TestvalidEmail(){

        assertTrue(Query.isvalidemail("sawdha123@mail.com"));
        assertFalse(Query.isvalidemail("123saaad111!@"));
        
    }

    @Test
    public void Testvalidmessage(){

        assertTrue(Query.isvalidmessage("This is a valid query message."));
        assertFalse(Query.isvalidmessage("")); 
        assertFalse(Query.isvalidmessage("Too short")); 
        assertFalse(Query.isvalidmessage("A".repeat(501)));
    }
}
