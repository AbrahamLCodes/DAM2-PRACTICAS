package abrahamluna.dam2.eva1_5_cambio_orientacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, DetailActivity.class);
    }

    public void onMessageFromFragmentToMain(){
        frameLayout = findViewById(R.id.frmLyDetail);
        if(frameLayout != null){//LANDSCAPE
            //CREAR DINAMICAMENTE EL FRAGMENTO DETAIL
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            DetailFragment detailFragment = new DetailFragment();
            ft.replace(R.id.frmLyDetail, detailFragment);
            ft.commit();
        }else{//PORTRAIT
            startActivity(intent);
        }
    }
}