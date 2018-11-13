import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DialogFragment loadingScreen = LoadingScreen.getInstance();

        findViewById(R.id.main_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                loadingScreen.show(getSupportFragmentManager(), "loading screen");

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        loadingScreen.dismiss();
                    }

                }, 3000);

            }

        });
    }
}
