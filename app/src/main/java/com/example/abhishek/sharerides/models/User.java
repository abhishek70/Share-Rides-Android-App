package com.example.abhishek.sharerides.models;

/**
 * Created by abhishekdesai on 6/8/16.
 */
public class User {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String password;

    // Constructor
    public void user(){

    }

    // Setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public void setEmailId(String emailId){
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getMobileNumber(){
        return mobileNumber;
    }

    public String getEmailId(){
        return emailId;
    }

    public String getPassword(){
        return password;
    }


}
