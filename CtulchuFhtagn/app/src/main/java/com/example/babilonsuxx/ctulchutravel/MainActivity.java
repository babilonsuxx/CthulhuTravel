package com.example.babilonsuxx.ctulchutravel;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Button requestButton;
    private JSONObject answer;
    private TextView answerTextView;
    private HttpURLConnection urlConnection = null;

    private BufferedReader reader = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        requestButton = (Button) findViewById(R.id.requestButton);
        answerTextView = (TextView) findViewById(R.id.answerTextView);
        requestButton.setOnClickListener(this);

    }

    public  boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == requestButton.getId()) {
            answerTextView.setText(sendRequest());
        }
    }

    private String sendRequest(){
        String answ = "";
        try {
            URL url = new URL("http://module.sletat.ru/Main.svc/GetTours?login=mid@sletat.ru&password=Kobe24-24&cityFromId=1323&countryId=119&s_departFrom=17/09/2017&s_departTo=27/09/2017");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream is = urlConnection.getInputStream();
            StringBuilder sb = new StringBuilder();

            reader =  new BufferedReader(new InputStreamReader(is));
            while (reader.ready()) {
                sb.append(reader.readLine());
            }

            answ = sb.toString();

            reader.close();
            is.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return answ;
    }
}
