package com.Elibrary.demo.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validateName(String userName){
        Pattern pattern = Pattern.compile("^[A-Za-z]{3,50}$");
        Matcher matcher = pattern.matcher(userName);

        return matcher.matches();
    }


    public static boolean validatePassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d,!@#$%^&*()-+=?<>]{8,20}$");
        Matcher matcher = pattern.matcher(password);
       return matcher.matches();

    }

    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("^[a-zA-z0-9.%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);
       return matcher.matches();
    }


}
