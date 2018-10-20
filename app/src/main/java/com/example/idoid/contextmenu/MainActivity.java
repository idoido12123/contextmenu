package com.example.idoid.contextmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1,rb2;
    Button btn1;
    EditText et1,et2;
    Intent t1;
    double num1,d;
    String st;
    int typeProg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.firstNum);
        et2 = (EditText) findViewById(R.id.MultOrDif);
        rb1 = (RadioButton) findViewById(R.id.aritProg);
        rb2 = (RadioButton) findViewById(R.id.geoProg);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void go(View view) {
        t1 = new Intent(this, Main2Activity.class);
        st = et1.getText().toString();
        num1 = Double.parseDouble(st);
        st = et2.getText().toString();
        d = Double.parseDouble(st);
        if (rb1.isChecked()) typeProg=1;
        if (rb2.isChecked()) typeProg=2;
        t1.putExtra("typeProg",typeProg);
        t1.putExtra("firstNum",num1);
        t1.putExtra("d",d);
        startActivity(t1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st=item.getTitle().toString();
        if(st.equals("credits")){
            Toast.makeText(this,"created by Ido",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
