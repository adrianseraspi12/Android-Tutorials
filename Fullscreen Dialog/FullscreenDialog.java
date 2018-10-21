import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class FullscreenDialog extends DialogFragment implements View.OnClickListener {

    private Callback callback;

    static FullscreenDialog newInstance() {
        return new FullscreenDialog();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullscreenDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fullscreen_dialog, container, false);
        ImageButton close = view.findViewById(R.id.fullscreen_dialog_close);
        TextView action = view.findViewById(R.id.fullscreen_dialog_action);

        close.setOnClickListener(this);
        action.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.fullscreen_dialog_close:
                dismiss();
                break;

            case R.id.fullscreen_dialog_action:
                callback.onActionClick("Whatever");
                dismiss();
                break;

        }

    }

    public interface Callback {

        void onActionClick(String name);

    }

}
