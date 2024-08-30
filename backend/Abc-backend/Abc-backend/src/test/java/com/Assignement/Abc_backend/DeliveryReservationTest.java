package com.Assignement.Abc_backend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DeliveryReservationTest {


    @Test

    public void TestValidaddress(){

        assertTrue(Delivery.isvalidadress("120/1 Liliy Avenue"));
        assertFalse(Delivery.isvalidadress(".road,120/"));
        
    }

    @Test
    public void TestValidproductname(){

        assertTrue(Delivery.isvalidproducts("Pizza"));
        assertFalse(Delivery.isvalidproducts("-pizza/"));
    }

    @Test
    public void TestSpecialnote(){

        assertTrue(Delivery.isvalidnote("Add 2 table spoon of sugar"));
        assertFalse(Delivery.isvalidnote(""));
    }
}
