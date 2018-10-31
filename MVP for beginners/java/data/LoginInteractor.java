import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;

import com.codace.loginform.Contract;

public class LoginInteractor {

    private Contract.LoginListener loginListener;

    public LoginInteractor(Contract.LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void login(final LoginCredentials loginCredentials) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                if (hasError(loginCredentials)) {
                    return;
                }

                loginListener.onSuccess();
            }

        }, 3000);

    }

    private boolean hasError(LoginCredentials loginCredentials) {
        String username = loginCredentials.getUsername();
        String password = loginCredentials.getPassword();

        if (TextUtils.isEmpty(username)) {
            loginListener.onFailed("The email is empty");
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            loginListener.onFailed("The email is invalid");
            return true;
        }

        if (TextUtils.isEmpty(password)) {
            loginListener.onFailed("The password is empty");
            return true;
        }

        if (password.length() < 5) {
            loginListener.onFailed("Password is weak");
            return true;
        }

        return false;
    }

}
