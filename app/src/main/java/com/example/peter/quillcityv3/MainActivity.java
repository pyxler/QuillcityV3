package com.example.peter.quillcityv3;

import android.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import Fragment.AddQuill;
import Fragment.QuillList;
import Fragment.Reader;
import Model.Poem;


public class MainActivity extends ActionBarActivity implements QuillList.Selection {

    private Reader reader;
    private QuillList qList;
    private SlidingPaneLayout slidingPaneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.slidingpanelayout);

        setTitle("Quill City");

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        reader = Reader.getInstance();
        fragmentTransaction.add(R.id.container_1, reader);
        fragmentTransaction.commit();

        FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
        qList = QuillList.getInstance();
        fragmentTransaction2.add(R.id.container_2, qList);
        fragmentTransaction2.commit();
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
        if (id == R.id.add_quilled) {
            AddQuill addQuill = new AddQuill();
            addQuill.show(getFragmentManager(), null);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Selected(Poem poem) {
        reader.setPoem(poem);
        slidingPaneLayout.closePane();
    }
}
