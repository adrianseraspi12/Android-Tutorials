package com.codace.loginform.data;

import android.text.TextUtils;
import android.util.Patterns;

public class LoginCredentials {

    private String username;

    private String password;

    public LoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(username)) {
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            return false;
        }

        if (password.length() < 5) {
            return false;
        }

        return true;
    }
}
