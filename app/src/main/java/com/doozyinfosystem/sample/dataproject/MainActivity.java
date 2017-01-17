package com.doozyinfosystem.sample.dataproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.doozyinfosystem.sample.dataproject.category.DataItem;
import com.doozyinfosystem.sample.dataproject.sample.DataItemAdapter;
import com.doozyinfosystem.sample.dataproject.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private static final String SIGN_IN = "Sign In";
    private List<DataItem> dataItemList = SampleDataProvider.getItemList();
    private List<String> dataNameList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        TextView textView = (TextView) findViewById(R.id.data_display_list);
//        dataItemList.sort(new Comparator<DataItem>() {
//            @Override
//            public int compare(DataItem o1, DataItem o2) {
//                return o1.getItemName().compareTo(o2.getItemName());
//            }
//        });

        for (DataItem d : dataItemList) {
            dataNameList.add(d.getItemName());
        }
        Collections.sort(dataNameList);
        DataItemAdapter adapter = new DataItemAdapter(this, dataNameList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_items);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(SIGN_IN);

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
switch (item.getItemId())
{
    case R.id.sign_in :
        Toast.makeText(this,"Sign form",Toast.LENGTH_LONG).show();
}
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
