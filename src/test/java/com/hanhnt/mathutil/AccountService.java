package com.hanhnt.mathutil; 

public class AccountService {
    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.contains("@") && email.contains(".");
    }

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.trim().isEmpty()) return false;
        if (password == null || password.length() <= 6) return false;
        return isValidEmail(email);
    }
}