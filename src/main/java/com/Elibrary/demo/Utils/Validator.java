package com.Elibrary.demo.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validateName(String userName){
        Pattern pattern = Pattern.compile("^[A-Za-z_]{3,50}");
        Matcher matcher = pattern.matcher(userName);

        return matcher.matches();
    }


    public static boolean validatePassword(String password){
        Pattern pattern = Pattern.compile("^[A-Za-z_~`#^*{}%&?@0-9]{5,8}");
        Matcher matcher = pattern.matcher(password);
       return matcher.matches();

    }

    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("^[a-z.@0-9]{3,50}");
        Matcher matcher = pattern.matcher(email);
       return matcher.matches();
    }


}
