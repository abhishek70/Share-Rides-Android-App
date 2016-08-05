package com.example.abhishek.sharerides.helpers;

/**
 * Created by abhishek on 5/24/16.
 */
public class Utils {

    //Email Validation pattern
    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    //Fragments Tags
    public static final String LOGIN_FRAGMENT           = "Login_Fragment";
    public static final String SIGNUP_FRAGMENT          = "SignUp_Fragment";
    public static final String FORGOTPASSWORD_FRAGMENT  = "ForgotPassword_Fragment";
    public static final String DRIVER                   = "Driver";
    public static final String RIDER                    = "Rider";
    public static final Integer SUCCESS_CODE            = 1;
    public static final Integer ERROR_CODE              = 0;
    public static final String LOGOUT                   = "Logging Out...";

    //Rider Map Constants
    public static final String SET_PICKUP_LOCATION      = "SET PICKUP LOCATION";
    public static final String CANCEL_RIDE              = "CANCEL RIDE";
    public static final String SEARCHING_DRIVER         = "Searching Driver...";
    public static final String CANCELLING_REQUEST       = "Cancelling Request...";

}
