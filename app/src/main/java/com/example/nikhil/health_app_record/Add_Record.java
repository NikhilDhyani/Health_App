package com.example.nikhil.health_app_record;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Record extends AppCompatActivity {

    EditText name,bp_reading,sugar_reading;
    Button savenow;

    //Here we are creating a variable of type database

     AppDatabase appDatabase;

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

        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"userdb").build();

        String myname = name.getText().toString();
        int bpreading = Integer.parseInt( bp_reading.toString());
        int sugarreading = Integer.parseInt( sugar_reading.toString());


        final Record record = new Record();

        record.setName(myname);
        record.setBp_reading(bpreading);
        record.setSugar_reading(sugarreading);




        savenow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Whatsapp!",Toast.LENGTH_LONG).show();
                insertUser(record);

            }
        });



    }


/*
    @Override
    public void onClick(View view) {

       switch (view.getId())
       {
           case R.id.saveBtn :  Toast.makeText(getApplicationContext(),"Whatsapp!",Toast.LENGTH_LONG).show();

                               insertUser(Record r);

                                //Intent intent = new Intent(Add_Record.this,MainActivity.class);
                                //startActivity(intent);

       }


    }
*/

    public void insertUser(final Record user) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void...voids) {

                appDatabase.daoClass().addEntry(user);



                return null;
            }
        }.execute();



    }


    private class AsyncTaskRunner extends AsyncTask<Record,Void,String>
    {


        @Override
        protected String  doInBackground(Record... records) {

            Record one = records[0];
            appDatabase.daoClass().addEntry(one);


            return null;
        }

        @Override
        protected void onPostExecute(String two) {
            super.onPostExecute(two);
            Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_LONG).show();
        }

    }



    /*public void clicknow(View view)
    {
        Toast.makeText(getApplicationContext(),"Whatsapp!",Toast.LENGTH_LONG).show();
    }
   */

}
