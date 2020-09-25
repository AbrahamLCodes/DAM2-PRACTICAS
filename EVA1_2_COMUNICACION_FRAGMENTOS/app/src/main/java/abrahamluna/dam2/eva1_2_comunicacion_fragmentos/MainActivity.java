package abrahamluna.dam2.eva1_2_comunicacion_fragmentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.eva1_2_comunicacion_fragmentos.R;

public class MainActivity extends AppCompatActivity {

    //1. RECUPERAR FRAGMENTOS
    private ListFragment lf;
    private DataFragment df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == ListFragment.class){
            lf = (ListFragment)fragment;
        }else if(fragment.getClass() == DataFragment.class){
            df = (DataFragment)fragment;
        }
    }

    public void onMessageFromFragment(String sender, String param){
        if(sender.equals("LISTA")){
            df.onMessageFromMainToFrag(param);
        }else if(sender.equals("DATA")){
            Toast.makeText(this, param, Toast.LENGTH_SHORT).show();
        }

    }
}