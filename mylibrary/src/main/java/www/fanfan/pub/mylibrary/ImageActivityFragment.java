package www.fanfan.pub.mylibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class ImageActivityFragment extends Fragment {
    TextView displayJoke;
    View root;
    public ImageActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root =  inflater.inflate(R.layout.fragment_image, container, false);
        displayJoke = (TextView)root.findViewById(R.id.textView);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras == null)
        {
            Log.d("Intent", "get null in android Library");
        }
        else {
            String showText = extras.getString("JOKE");
            displayJoke.setText(showText);
        }
        return  root;
    }
}
