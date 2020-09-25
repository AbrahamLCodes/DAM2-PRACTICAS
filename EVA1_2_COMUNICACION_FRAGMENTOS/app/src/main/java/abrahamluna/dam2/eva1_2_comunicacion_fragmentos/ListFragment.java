package abrahamluna.dam2.eva1_2_comunicacion_fragmentos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.eva1_2_comunicacion_fragmentos.R;


public class ListFragment extends Fragment {

    //DATOS DE LA LISTA
    private String[] datos = {
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre",
            "Perro",
            "gato",
            "Quiero",
            "Comer",
            "Ahhhhh"
    };

    private MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_list, container, false);

        //AQUI LLENAMOS LA LISTA
        ListView lst = frameLayout.findViewById(R.id.lstVwDatos);
        lst.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                datos
        ));

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                main.onMessageFromFragment("LISTA", datos[position]);
            }
        });
        //-----------------------
        return frameLayout;
    }
}