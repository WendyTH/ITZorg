package com.example.dipak.imtpmd;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dipak.imtpmd.database.DatabaseHelper;
import com.example.dipak.imtpmd.database.DatabaseInfo;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class NoordActivity extends AppCompatActivity {

    Button addData, getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noord);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hello " + message);

        Context context = getApplicationContext();
        CharSequence text = "You are now logged in as " + message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        addData = (Button) findViewById(R.id.buttonAdd);
        getData = (Button) findViewById(R.id.buttonGet);


    }

    public void onClick (View v){

        // Roep een instantie van je class DatabaseHelper aan.
        // Merk op dat de DatabaseHelper synchronised is => 1 instantie.
        DatabaseHelper dbHelper = DatabaseHelper.getHelper(this);

        if(v.getId() == R.id.buttonAdd){
            ContentValues values = new ContentValues();
            values.put(DatabaseInfo.CourseColumn.NAME, "Inf Keuze Programming Mobile Devices");
            values.put(DatabaseInfo.CourseColumn.ECTS, "3");
            values.put(DatabaseInfo.CourseColumn.CODE, "IKPMD");
            values.put(DatabaseInfo.CourseColumn.GRADE, "5.5");

            // INSERT dit values object in DE (ZELFGEMAAKTE) RIJ COURSE,
            dbHelper.insert(DatabaseInfo.CourseTables.COURSE, null, values);
        }
        if(v.getId() == R.id.buttonGet){
            Cursor rs = dbHelper.query(DatabaseInfo.CourseTables.COURSE, new String[]{"*"}, null, null, null, null, null);

            rs.moveToFirst();   // Skip : de lege elementen vooraan de rij.
            // Maar : de rij kan nog steeds leeg zijn
            // Hoe : lossen we dit op ??

            // Haalt de name uit de resultset
            String name = (String) rs.getString(rs.getColumnIndex("name"));

            // Even checken of dit goed binnen komt
            Log.d("Michiel deze gevonden=", "deze :"+name);
        }
    }
}
