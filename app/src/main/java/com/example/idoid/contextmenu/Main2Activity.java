package com.example.idoid.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener {

    double num1, d;
    int typeprog;
    ListView lv1;
    TextView tv1;
    Double[] numbers = new Double[20];
    String[] numbers2 = new String[20];
    Double schum = 0.0;
    int posi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv1 = (ListView) findViewById(R.id.listview);
        tv1 = (TextView) findViewById(R.id.textView2);

        Intent get = getIntent();
        typeprog = get.getIntExtra("typeProg", 666666666);
        num1 = get.getDoubleExtra("firstNum", 6666666);
        d = get.getDoubleExtra("d", 66666666);

        numbers[0] = num1;
        numbers2[0] = "" + num1;
        if (typeprog == 1) {
            for (int i = 1; i < 20; i++) {
                numbers[i] = d + numbers[i - 1];
                numbers2[i] = "" + numbers[i];


            }
        } else {
            for (int i = 1; i < 20; i++) {
                numbers[i] = d * numbers[i - 1];
                numbers2[i] = "" + numbers[i];
            }
        }
        lv1.setOnItemClickListener(this);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, numbers2);
        lv1.setAdapter(adp);
        lv1.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> AdapterView, View view, int position, long id) {
        schum=0.0;
        for (int i = 0; i <= position; i++) {
            schum = schum + numbers[i];
        }
        posi=position;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("credits")) {
            Toast.makeText(this, "created by Ido", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View V, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("sum until here");
        menu.add("position");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("sum until here")) {
            tv1.setText("sum = " + schum);
        }
        if (st.equals("position")) {
            tv1.setText("the position=" + posi);
        }
        return super.onContextItemSelected(item);
    }
}



