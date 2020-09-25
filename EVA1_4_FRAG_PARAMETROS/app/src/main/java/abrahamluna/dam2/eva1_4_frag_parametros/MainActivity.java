package abrahamluna.dam2.eva1_4_frag_parametros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearFragment(View view){
        //TRANSACCION
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //CREAR EL FRAGMENTO
        ParamFragment pf = ParamFragment.newInstance("Hola Mundo", "Valores asignados al fragmento");
        //REEMPLAZAR NUESTRO LAYOUT CON EL FRAGMENTO
        ft.replace(R.id.frmFrag, pf);
        //COMMIT
        ft.commit();
    }
}