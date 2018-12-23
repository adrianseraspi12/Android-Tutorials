package com.codace.loginform;

import com.codace.loginform.data.LoginCredentials;

public interface Contract {

    interface LoginView {

        void onSuccess();

        void onFailed(String message);

    }

    interface Presenter {

        void login(LoginCredentials loginCredentials);

    }

}
