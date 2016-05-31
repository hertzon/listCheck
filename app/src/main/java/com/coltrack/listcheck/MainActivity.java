package com.coltrack.listcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {
    List<Row> rows;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listView = (ListView) findViewById(android.R.id.list);
        rows = new ArrayList<Row>(30);
        Row row = null;
        for (int i = 1; i < 31; i++) {
            row = new Row();
            row.setTitle("Title " + i);
            row.setSubtitle("Subtitle " + i);
            rows.add(row);
        }

        rows.get(3).setChecked(true);
        rows.get(6).setChecked(true);
        rows.get(9).setChecked(true);

        listView.setAdapter(new CustomArrayAdapter(this, rows));

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this,
                        rows.get(position).getTitle(), Toast.LENGTH_SHORT)
                        .show();
            }
        });


    }
}
