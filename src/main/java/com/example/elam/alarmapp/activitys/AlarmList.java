package com.example.elam.alarmapp.activitys;

/**
 * Created by elam on 24-07-2017.
 */


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.elam.alarmapp.R;
import com.example.elam.alarmapp.adapters.AlarmListAdapter;
import com.example.elam.alarmapp.alarm.AlarmActivity;
import com.example.elam.alarmapp.beans.DrugsData;
import com.example.elam.alarmapp.databes.AlarmDb;
import com.example.elam.alarmapp.databes.dbHelper;

import java.util.ArrayList;

public class AlarmList extends AppCompatActivity {

    ListView listView;

    AlarmDb db;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<DrugsData> alarmData;
    AlarmListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_list);
        listView = (ListView)findViewById(R.id.alarmList);
        db=new AlarmDb(this);

        dbHelper handler = new dbHelper(this);
        sqLiteDatabase = handler.getWritableDatabase();

        alarmData = db.getAlarmData();
        adapter= new AlarmListAdapter(alarmData,this);

        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addDrug) {

            Intent addAlrm = new Intent(AlarmList.this, AlarmActivity.class);
            startActivity(addAlrm);



        } else if (id == R.id.alarmList) {


        } else if (id == R.id.shopping) {

        }

        return super.onOptionsItemSelected(item);
    }
}
