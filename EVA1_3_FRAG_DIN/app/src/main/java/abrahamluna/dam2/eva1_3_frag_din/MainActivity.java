package abrahamluna.dam2.eva1_3_frag_din;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import abrahamluna.dam2.eva1_3_frag_din.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarRojo(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        RedFragment redFragment = new RedFragment();
        ft.replace(R.id.fmf, redFragment);
        ft.commit();
    }

    public void mostrarAzul(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        BlueFragment blueFragment = new BlueFragment();
        ft.replace(R.id.fmf, blueFragment);
        ft.commit();
    }
}