package abrahamluna.dam2.rep_3_runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rep_3_runonuithread.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private Runnable runnable = new Runnable(){

        @Override
        public void run() {
            //AQUI MODIFICAMOS LA INTERFAZ GRAFICA
            textView.append("Hola mundo cruel\n");

        }
    };

    private Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();

            int i = 0;
            while (i < 10){
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        thread.start();
    }
}