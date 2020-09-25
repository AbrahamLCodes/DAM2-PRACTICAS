package abrahamluna.dam2.eva1_2_comunicacion_fragmentos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eva1_2_comunicacion_fragmentos.R;


public class DataFragment extends Fragment {

    private TextView textView;
    private MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout ln = (LinearLayout)inflater.inflate(R.layout.fragment_data, container, false);
        Button btn = ln.findViewById(R.id.btn);
        textView = ln.findViewById(R.id.text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                main.onMessageFromFragment("DATA", "Mensaje del fragmento de datos");
            }
        });

        return ln;
    }

    public void onMessageFromMainToFrag(String param){
        textView.setText(param);
    }
}