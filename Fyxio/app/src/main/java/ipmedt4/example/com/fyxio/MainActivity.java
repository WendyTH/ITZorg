package ipmedt4.example.com.fyxio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button lastButton;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.btn_start_ex);

        // Capture button clicks
        button.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(MainActivity.this,
                        FirstActivity.class);
                startActivity(myIntent);
            }
        });

        lastButton = (Button) findViewById(R.id.btn_last_ex);
        lastButton.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View arg0) {
                SharedPreferences prefs = getSharedPreferences("NUMBER", Context.MODE_PRIVATE);
                number = prefs.getInt("exNumber", 0);

                if(number == 1){
                    Intent lastIntent = new Intent(MainActivity.this,
                            FirstActivity.class);
                    startActivity(lastIntent);
                    Log.d("TESTING 1st", "Value , " + number);
                }
                if(number == 2){
                    Intent lastIntent = new Intent(MainActivity.this,
                            SecondActivity.class);
                    startActivity(lastIntent);
                    Log.d("TESTING 2nd", "Value , " + number);
                }
                if(number == 3){
                    Intent lastIntent = new Intent(MainActivity.this,
                            ThirdActivity.class);
                    startActivity(lastIntent);
                    Log.d("TESTING 3rd", "Value , " + number);
                }
                if(number == 4){
                    Intent lastIntent = new Intent(MainActivity.this,
                            FourthActivity.class);
                    startActivity(lastIntent);
                    Log.d("TESTING 4th", "Value , " + number);
                }
                if(number == 5){
                    Intent lastIntent = new Intent(MainActivity.this,
                            FifthActivity.class);
                    startActivity(lastIntent);
                    Log.d("TESTING 5th", "Value , " + number);
                } else {
                    Log.d("TESTING NUMBER", "Value , " + number);
                }


            }
        });
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
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
