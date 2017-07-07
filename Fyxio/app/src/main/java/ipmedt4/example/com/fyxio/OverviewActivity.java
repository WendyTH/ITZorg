package ipmedt4.example.com.fyxio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

/**
 * Created by Thierry on 28-6-2017.
 */

public class OverviewActivity extends AppCompatActivity {
    Button button;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        //button listener aanroepen
        addListenerOnButton();
        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();
        addListenerOnButton5();


    }

    //imagebutton onclick listener
    public void addListenerOnButton(){
        imageButton = (ImageButton) findViewById(R.id.next_btn5);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(OverviewActivity.this,
                        MainActivity.class);
                startActivity(myIntent);


                }

        });
    }

    public void addListenerOnButton1(){

        // Locate the button in activity_repeat_first.xml
    button = (Button) findViewById(R.id.btn_start_repeat_ex);

    // Capture button clicks
                button.setOnClickListener(new android.view.View.OnClickListener() {
        public void onClick(View arg0) {


            Intent myIntent = new Intent(OverviewActivity.this,
                    RepeatFirstActivity.class);
            startActivity(myIntent);
        }

                });
    }
    public void addListenerOnButton2(){

        // Locate the button in activity_repeat_first.xml
        button = (Button) findViewById(R.id.btn_start_repeat_ex1);

        // Capture button clicks
        button.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(OverviewActivity.this,
                        RepeatSecondActivity.class);
                startActivity(myIntent);
            }

        });
    }

    public void addListenerOnButton3(){

        // Locate the button in activity_repeat_first.xml
        button = (Button) findViewById(R.id.btn_start_repeat_ex2);

        // Capture button clicks
        button.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(OverviewActivity.this,
                        RepeatThirdActivity.class);
                startActivity(myIntent);
            }

        });
    }

    public void addListenerOnButton4(){

        // Locate the button in activity_repeat_first.xml
        button = (Button) findViewById(R.id.btn_start_repeat_ex3);

        // Capture button clicks
        button.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(OverviewActivity.this,
                        RepeatFourthActivity.class);
                startActivity(myIntent);
            }

        });
    }

    public void addListenerOnButton5(){

        // Locate the button in activity_repeat_first.xml
        button = (Button) findViewById(R.id.btn_start_repeat_ex4);

        // Capture button clicks
        button.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(OverviewActivity.this,
                        RepeatFifthActivity.class);
                startActivity(myIntent);
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
            Intent i = new Intent(OverviewActivity.this, Settings.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
