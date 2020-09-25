package abrahamluna.dam2.rep_5_segunda_parte_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.rep_5_segunda_parte_servicios.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        BroadcastReceiver broadcastReceiver = new MiBroadcastReciever();
        IntentFilter intentFilter = new IntentFilter("MI_SERVICIO");
        registerReceiver(broadcastReceiver,intentFilter);
    }

    class MiBroadcastReciever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.wtf("MENSAJE", "THREAD");
            textView.append("");
        }
    }
}