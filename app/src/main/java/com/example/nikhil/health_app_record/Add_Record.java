package com.example.nikhil.health_app_record;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Record extends AppCompatActivity implements  View.OnClickListener{

    EditText name,bp_reading,sugar_reading;
    Button savenow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /* PS : I have convert the following lines of code into
                comments because I was getting null pointer exception.
                Then after searching for it on SO & I got an answer why it happens.
                 Link: https://stackoverflow.com/a/16838145/5003906

       Explaination: We usually get nullpointer Exception with findViewById()
                     when we initialise before setContentView().

        Solution :  Always initialize after super.onCreate() and setContentView().

       To, see please run it by uncommenting the code.

        name = findViewById(R.id.name);
        bp_reading = findViewById(R.id.BP);
        sugar_reading =  findViewById(R.id.sugar);
        savenow = (Button) findViewById(R.id.saveBtn);

        */
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add__record);

        name = findViewById(R.id.name);
        bp_reading = findViewById(R.id.BP);
        sugar_reading =  findViewById(R.id.sugar);
        savenow = (Button) findViewById(R.id.saveBtn);

        savenow.setOnClickListener(this);



    }



    @Override
    public void onClick(View view) {

       switch (view.getId())
       {
           case R.id.saveBtn :  Toast.makeText(getApplicationContext(),"Whatsapp!",Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(Add_Record.this,MainActivity.class);
                                startActivity(intent);

       }


    }



    /*public void clicknow(View view)
    {
        Toast.makeText(getApplicationContext(),"Whatsapp!",Toast.LENGTH_LONG).show();
    }
   */

}
