package ipmedt4.example.com.fyxio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

/**
 * Created by thier on 7-6-2017.
 */

public class ThirdActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener{

    private YouTubePlayerFragment playerFragment;
    private YouTubePlayer mPlayer;

    Button button;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        playerFragment =
                (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_player_fragment);

        playerFragment.initialize(Config.DEVELOPER_KEY, this);

        //button listener aanroepen
        addListenerOnButton();
    }

    //imagebutton onclick listener
    public void addListenerOnButton(){
        imageButton = (ImageButton) findViewById(R.id.next_btn3);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(ThirdActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }

        });
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        mPlayer = player;

        //Enables automatic control of orientation
        mPlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);

        //Show full screen in landscape mode always
        mPlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);

        //System controls will appear automatically
        mPlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);

        if (!wasRestored) {
            //player.cueVideo("9rLZYyMbJic");
            mPlayer.cueVideo(Config.YOUTUBE_VIDEO3_CODE);
        }
        else
        {
            mPlayer.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        mPlayer = null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(ThirdActivity.this, Settings.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
