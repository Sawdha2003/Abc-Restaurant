package com.Assignment.Abc_Restaurant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DineinReservationTest {


    @Test

    public void TestValiddineindate(){
        assertTrue(Dinein.isvaliddate("24/08/2024"));
        assertFalse(Dinein.isvaliddate("aa/05/2l24"));
    }

    

    @Test
    public void Testvaliddineinname(){

       
        assertTrue(Dinein.isvalidname ("Abc-Restuarant"));
        assertFalse(Dinein.isvalidname("123ggkl/"));

    }

    


    @Test
    public void Testvalidemail(){


        assertTrue(Dinein.isvalidemail ("Sam123@email.com"));
        assertFalse(Dinein.isvalidemail("123@.kpp"));
    }



    @Test
    public void Testvalidguest(){
        assertTrue(Dinein.isvalidguest(5)); 
        assertFalse(Dinein.isvalidguest(0)); 
        assertFalse(Dinein.isvalidguest(101)); 
        assertFalse(Dinein.isvalidguest(-1)); 
    }



    @Test
    public void Testvalidnumber(){

        assertTrue(Dinein.isvalidnumber("0771546985"));
        assertFalse(Dinein.isvalidnumber("11aj@45d"));

    }

    @Test
    public void Testvalidtime(){
        assertTrue(Dinein.isvalidtime("11:30 AM")); 
        assertFalse(Dinein.isvalidtime("1-20 PM")); 
        assertFalse(Dinein.isvalidtime("13:00 PM"));
    }
}
