package abrahamluna.dam2.eva1_5_cambio_orientacion;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MasterFragment extends Fragment {

    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_master, container, false);
        Button button = linearLayout.findViewById(R.id.btnDetail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DEPENDEMOS DE LA ORIENTACION
                //PORTRAIT - LANZAR UNA ACTIVIDAD
                //LANDSCAPE - CREAR DINAMICAMENTE UN FRAGMENTO
                main.onMessageFromFragmentToMain();
            }
        });
        return linearLayout;
    }
}