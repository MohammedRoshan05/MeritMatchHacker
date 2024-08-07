package com.example.meritmatch_hacker;

public class ClassUserOperation {
    String User_name;
    String Password;

    public ClassUserOperation(String user_name, String password) {
        User_name = user_name;
        Password = password;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
