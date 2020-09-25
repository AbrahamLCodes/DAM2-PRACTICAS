package abrahamluna.dam2.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rep_5_servicios.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private Button iniciar, terminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);

        iniciar = findViewById(R.id.iniciar);
        terminar = findViewById(R.id.terminar);

        BroadcastReceiver broadcastReceiver = new MyBroadcastReciever();
        IntentFilter intentFilter = new IntentFilter("MI_SERVICIO");
        registerReceiver(broadcastReceiver, intentFilter);


        iniciar.setOnClickListener(this);
        terminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iniciar:
                
                startService(intent);
                break;
            case R.id.terminar:
                stopService(intent);
                break;
        }
    }

     class MyBroadcastReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.wtf("MENSAJE", "THREAD");
        }
    }
}