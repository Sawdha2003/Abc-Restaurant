package com.Assignement.Abc_backend;

import java.util.function.BooleanSupplier;

public class Query {

    public static boolean isvalidname(String name){

        return name.matches("^[a-zA-Z0-9_]*$");
    }

    

    public static boolean isvalidemail(String email){

       return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }

    public static boolean isvalidmessage(String message){


        return message != null && message.trim().length() >= 10 && message.trim().length() <= 500;

    }
    
}
