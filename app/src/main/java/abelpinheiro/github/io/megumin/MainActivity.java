package abelpinheiro.github.io.megumin;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int numberImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberImage = 0;
        final LinearLayout layout = findViewById(R.id.layout);
        final ImageView meguminImage = findViewById(R.id.megumin_image);
        mediaPlayer = MediaPlayer.create(this, R.raw.explosion_3);
        meguminImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (numberImage){
                    case 0:
                        layout.setPadding(0,0,0,0);
                        meguminImage.setImageResource(R.drawable.megumin01);
                        mediaPlayer.start();
                        numberImage = 1;
                        break;
                    case 1:
                        meguminImage.setImageResource(R.drawable.megumin03);
                        numberImage = 2;
                        mediaPlayer.start();
                        break;
                    case 2:
                        layout.setPadding(50,50,50,50);
                        meguminImage.setImageResource(R.drawable.megumin02);
                        numberImage = 0;
                        mediaPlayer.start();
                        break;
                }
            }
        });
    }
}
