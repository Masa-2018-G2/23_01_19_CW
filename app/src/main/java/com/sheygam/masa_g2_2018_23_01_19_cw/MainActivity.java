package com.sheygam.masa_g2_2018_23_01_19_cw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, View.OnClickListener {

    private MyAdapter adapter;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.my_list);
        addBtn = findViewById(R.id.add_btn);
        adapter = new MyAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = adapter.getItem(position);
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Long click " + position, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_btn){
            adapter.add("New name");
        }
    }
}
