package com.example.babilonsuxx.ctulchutravel;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity   {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //инициализируем меню
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv = (TextView) findViewById(R.id.textView);

    }
    //делаем чтобы закрывалось
    public  boolean onOptionsItemSelected(MenuItem item) {


        if (mToggle.onOptionsItemSelected(item)) {



          // mDrawerLayout.closeDrawers();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    //цепляем пункты меню

    public void onMenuItemClick(MenuItem item)
    {
        // выводим сообщение
        // Выведем в TextView информацию о нажатом пункте меню
        StringBuilder sb = new StringBuilder();
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        mDrawerLayout.closeDrawers();
        tv.setText(sb.toString());
    }

}
