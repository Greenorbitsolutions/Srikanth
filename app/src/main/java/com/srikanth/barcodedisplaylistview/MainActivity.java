package com.srikanth.barcodedisplaylistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    EditText editText;
    Button addButton;
    ListView listView,listView1;
    ArrayList<String> listItems;
    ArrayList<String> listItems1;

    ArrayAdapter<String> adapter,adapter1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.addItem);
        listView = (ListView) findViewById(R.id.listView);
        listView1 = (ListView) findViewById(R.id.listView1);
        listItems = new ArrayList<String>();
        listItems1 = new ArrayList<String>();
        listItems.add("First Item - added on Activity Create");
        listItems1.add("First Item - added on Activity Create");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);

        adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems1);
        listView.setAdapter(adapter);
        listView1.setAdapter(adapter1);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                listItems.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
                listItems1.add(editText.getText().toString());
                adapter1.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Succcess", Toast.LENGTH_LONG)
                        .show();
                editText.setText("");

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}

