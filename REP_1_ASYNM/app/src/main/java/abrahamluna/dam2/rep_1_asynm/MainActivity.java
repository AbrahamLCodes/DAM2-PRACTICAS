package abrahamluna.dam2.rep_1_asynm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rep_1_asynm.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private MiClaseAsincrona prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        prueba = new MiClaseAsincrona();

        prueba.execute(1,10,1000);

    }

    class MiClaseAsincrona extends AsyncTask<Integer, String, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.append("INICIO DEL HILO");
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int i = integers[0];
            while( i <= integers[1]){ // Final
                try {
                    Thread.sleep(integers[2]);
                    publishProgress("Hola Mundo!!\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView.append(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.append("FINAL DEL HILO");
        }
    }
}