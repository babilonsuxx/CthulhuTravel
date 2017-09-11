package com.example.babilonsuxx.ctulchutravel;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity   {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView tv;
    fragment_send fragment_send;
    fragment_search fragment_search;
    fragment_hot fragment_hot;
    fragment_contact fragment_contact;
    FragmentTransaction fragmentMenuTransaction;


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



        // инициализируем фрагменты
        fragment_send=new fragment_send();
        fragment_contact=new fragment_contact();
        fragment_search=new fragment_search();
        fragment_hot=new fragment_hot();

        //загружаем по умолчанию фрагмент с формой поиска
        fragmentMenuTransaction=getFragmentManager().beginTransaction();
        fragmentMenuTransaction.replace(R.id.fragment_container,fragment_search);
        fragmentMenuTransaction.addToBackStack(null);
        fragmentMenuTransaction.commit();

        //

      //  tv = (TextView) findViewById(R.id.textView);

    }
    //делаем чтобы закрывалось
    public  boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //цепляем пункты меню

    public void onMenuItemClick(MenuItem item)
    {
        // выводим сообщение
        // Выведем в TextView информацию о нажатом пункте меню
    //   StringBuilder sb = new StringBuilder();
    //    sb.append("Item Menu");
     //   sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
     //   sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
     //   sb.append("\r\n order: " + String.valueOf(item.getOrder()));
     //  sb.append("\r\n title: " + item.getTitle());


        fragmentMenuTransaction=getFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.search_menu:
                fragmentMenuTransaction.replace(R.id.fragment_container,fragment_search);
                break;
            case R.id.hot_menu:
                fragmentMenuTransaction.replace(R.id.fragment_container,fragment_hot);
                break;
            case R.id.send_menu:
                fragmentMenuTransaction.replace(R.id.fragment_container,fragment_send);
                break;
            case R.id.contact_menu:
                fragmentMenuTransaction.replace(R.id.fragment_container,fragment_contact);
                break;
            default:
                break;
        }
        fragmentMenuTransaction.addToBackStack(null);
        fragmentMenuTransaction.commit();


        mDrawerLayout.closeDrawers();
      //  tv.setText(sb.toString());
    }

}
