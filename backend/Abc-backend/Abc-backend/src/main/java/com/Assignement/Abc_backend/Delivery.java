package com.Assignement.Abc_backend;

public class Delivery {

    public static boolean isvalidadress(String address){

        return address.matches("[A-Za-z0-9]+([ ,/\\.][A-Za-z0-9]+)*");
    }

    public static boolean isvalidproducts (String products){
        return products.matches("[A-Za-z ]+");
    }

    public static boolean isvalidnote(String note){

        return note != null && !note.trim().isEmpty();

    }
}
