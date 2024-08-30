package com.Assignement.Abc_backend;

public class Dinein {

    public static  boolean isvaliddate(String date){

        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean isvalidname(String name){

        return name.matches("[A-Za-z\\s-']+");
    }


    public static boolean isvalidemail(String email){

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
}

public static boolean isvalidguest(int guest){
    return guest >= 1 && guest <= 100;
}                                                                       

public static boolean isvalidnumber(String number){

    return number.matches("^\\+?\\d{9,15}$");

}

public static boolean isvalidtime(String time){

    return time.matches("^(0[1-9]|1[0-2]):[0-5][0-9] (AM|PM)$");

}

public void setStatus(String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
}

}
