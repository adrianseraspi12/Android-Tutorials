import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.show_snackbar);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View rootView = findViewById(R.id.root_view);
                Snackbar snackbar = Snackbar.make(rootView, "This is a message", Snackbar.LENGTH_LONG);
                snackbar.setAction("ACTION", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_SHORT).show();
                    }

                });

                //  Change the color of the action button
                snackbar.setActionTextColor(Color.GREEN);

                //  Change the color of the snackbar message
                View snackbarView = snackbar.getView();
                TextView messageView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                messageView.setTextColor(Color.CYAN);

                snackbar.show();

            }

        });

    }
}
