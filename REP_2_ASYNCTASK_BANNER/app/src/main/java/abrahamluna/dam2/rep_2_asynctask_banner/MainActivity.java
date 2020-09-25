package abrahamluna.dam2.rep_2_asynctask_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.rep_2_asynctask_banner.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private MiClaseAsincrona miClaseAsincrona;
    private int [] images = {R.drawable.cms, R.drawable.software};
    private int position;

    public MainActivity(){
        position = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        miClaseAsincrona = new MiClaseAsincrona();
        miClaseAsincrona.execute(0,10,1000);

    }

    class MiClaseAsincrona extends AsyncTask<Integer, String, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(position > 1){
                position = 0;
            }
            imageView.setImageResource(images[position]);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int i = integers[0];
            while( i <= integers[1]){ // Final
                try {
                    Thread.sleep(integers[2]);
                    publishProgress("Hola Mundo!!\n");
                    if(position > 1){
                        position = 0;
                    }
                    position++;
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
            if(position > 1){
                position = 0;
            }
            imageView.setImageResource(images[position]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(position > 1){
                position = 0;
            }
            imageView.setImageResource(images[position]); //FINAL DEL HILO
        }
    }
}