package com.Assignement.Abc_backend;

public class UserRegister {


    public static  boolean isvalidusername(String username){

        return username.matches("[A-Za-z0-9_]+");
    }

    public static boolean isvalidpassword(String password){

        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".[a-z].*")
                && password.matches(".*\\d.*");
    }

    public static boolean isvaliedemail(String email){

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }
}
