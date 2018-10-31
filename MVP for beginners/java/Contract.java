public interface Contract {

    interface LoginView {

        void showProgressbar();

        void hideProgressbar();

        void onSuccess();

        void onFailed(String messsage);

    }

    interface LoginListener {

        void onSuccess();

        void onFailed(String messsage);

    }

}
