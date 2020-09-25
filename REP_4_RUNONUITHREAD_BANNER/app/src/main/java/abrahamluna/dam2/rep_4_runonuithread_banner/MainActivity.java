package abrahamluna.dam2.rep_4_runonuithread_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.rep_4_runonuithread_banner.R;

public class MainActivity extends AppCompatActivity {
    private ImageView  imageView;
    private int pos;
    private int [] images = {R.drawable.cms,R.drawable.software};

    public MainActivity(){
        pos = 0;
    }

    private Runnable runnable =  new Runnable() {
        @Override
        public void run() {
            imageView.setImageResource(images[pos]);
        }
    };

    private Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();

            while(true){
                try {
                    if(pos > 1){
                        pos = 0;
                    }
                    Thread.sleep(1000);
                    pos++;
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.img1);
        thread.start();
    }
}