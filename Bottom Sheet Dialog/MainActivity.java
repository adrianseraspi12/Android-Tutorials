import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetDialogView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        bottomSheetDialog.setContentView(bottomSheetDialogView);

        View shareView = bottomSheetDialogView.findViewById(R.id.share);
        View getLinkView = bottomSheetDialogView.findViewById(R.id.get_link);
        View editNameView = bottomSheetDialogView.findViewById(R.id.edit_name);
        View deleteView = bottomSheetDialogView.findViewById(R.id.delete);

        shareView.setOnClickListener(this);
        getLinkView.setOnClickListener(this);
        editNameView.setOnClickListener(this);
        deleteView.setOnClickListener(this);

        Button button = findViewById(R.id.main_show_bottom_sheet_dialog);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.main_show_bottom_sheet_dialog:
                bottomSheetDialog.show();
                break;

            case R.id.share:
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.get_link:
                Toast.makeText(MainActivity.this, "Get link", Toast.LENGTH_SHORT).show();
                break;

            case R.id.edit_name:
                Toast.makeText(MainActivity.this, "Edit name", Toast.LENGTH_SHORT).show();
                break;

            case R.id.delete:
                Toast.makeText(MainActivity.this, "Delete collection", Toast.LENGTH_SHORT).show();
                break;

        }

    }

}
