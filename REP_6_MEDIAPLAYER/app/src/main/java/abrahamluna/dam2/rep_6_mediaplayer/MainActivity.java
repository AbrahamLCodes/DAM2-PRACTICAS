package abrahamluna.dam2.rep_6_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rep_6_mediaplayer.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button iniciar, detener;
    private MediaPlayer mediaPlayer;

    public MainActivity(){
        mediaPlayer = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.iniciar);
        detener = findViewById(R.id.detener);

        iniciar.setOnClickListener(this);
        detener.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.canals);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iniciar:
                iniciar();
                break;
            case R.id.detener:
                detener();
                break;
        }
    }

    private void iniciar(){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    private void detener(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
}