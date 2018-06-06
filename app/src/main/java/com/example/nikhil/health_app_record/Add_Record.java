package com.example.nikhil.health_app_record;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Record extends AppCompatActivity {

    EditText name,bp_reading,sugar_reading;
    Button savenow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        name = findViewById(R.id.name);
        bp_reading = findViewById(R.id.BP);
        sugar_reading =  findViewById(R.id.sugar);
        savenow = (Button) findViewById(R.id.saveBtn);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__record);

     //   save.setOnClickListener(this);
      


    }

    /*public void clicknow(View view)
    {
        Toast.makeText(getApplicationContext(),"Whatsapp!",Toast.LENGTH_LONG).show();
    }
   */

}
