package com.example.peter.quillcityv3;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import Fragment.QuillList;
import Fragment.Reader;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Reader reader = new Reader();
        fragmentTransaction.add(R.id.container_reader, reader);
        fragmentTransaction.commit();

        FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
        QuillList qList = new QuillList();
        fragmentTransaction2.replace(R.id.container_list, qList);
        fragmentTransaction2.addToBackStack(null);
        fragmentTransaction2.commit();*/
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
