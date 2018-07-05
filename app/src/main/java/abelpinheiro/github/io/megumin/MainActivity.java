package abelpinheiro.github.io.megumin;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    int numberImage = 0;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberImage = 0;
        final LinearLayout layout = findViewById(R.id.layout);
        final ImageView meguminImage = findViewById(R.id.megumin_image);
        meguminImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (numberImage){
                    case 0:
                        layout.setPadding(0,0,0,0);
                        meguminImage.setImageResource(R.drawable.megumin01);
                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.explosion_3);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        numberImage = 1;
                        break;
                    case 1:
                        meguminImage.setImageResource(R.drawable.megumin03);
                        numberImage = 2;
                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.explosion_3);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        break;
                    case 2:
                        layout.setPadding(50,50,50,50);
                        meguminImage.setImageResource(R.drawable.megumin02);
                        numberImage = 0;
                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.explosion_3);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        break;
                }
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
