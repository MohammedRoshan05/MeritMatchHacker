package com.example.meritmatch_hacker;

public class ClassUserInfo {
        String User_name;
        int Karma;
        int Reputation;

    public ClassUserInfo(String user_name, int karma, int reputation) {
        User_name = user_name;
        Karma = karma;
        Reputation = reputation;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public int getKarma() {
        return Karma;
    }

    public void setKarma(int karma) {
        Karma = karma;
    }

    public int getReputation() {
        return Reputation;
    }

    public void setReputation(int reputation) {
        Reputation = reputation;
    }
}
