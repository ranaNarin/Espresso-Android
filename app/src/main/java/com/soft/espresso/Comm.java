package com.soft.espresso;

/**
 * Created by narinder.rana on 11/30/2017.
 */

public class Comm {

    static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public static boolean isEmailInvalid(String email)
    {
        if (email.matches(emailPattern) && email.length() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
