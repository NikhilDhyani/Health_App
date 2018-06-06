package com.example.nikhil.health_app_record;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by NIKHIL on 06-06-2018.
 */

/*

  ** This is our entity class. **

   Q1. What is entity class ?

   A.  Entity class is a class which represent a table in a database.

  Q2.  So, how does program come to know that this class is a (entity) table?

  A.   We, annotate our class (table) with @entity tag.
       PS: We can also give some other name to our table by doing like this.

           @Entity(tablename = "my_new_table_name")

  Q3.  Table also has a primary field which uniquely identifies element then how do that in this library ?

  A.  We do that by using @PrimaryKey and property set * autogenerate *
*/

@Entity(tableName = "records")
public class Record {

    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_bp")
    private int bp_reading;

    @ColumnInfo(name = "user_sugar")
    private int sugar_reading;

    //todo  : There are three main things in room Database
    //todo 1: Entity
    //todo 2: DAO
    //todo 3: Database


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBp_reading() {
        return bp_reading;
    }

    public void setBp_reading(int bp_reading) {
        this.bp_reading = bp_reading;
    }

    public int getSugar_reading() {
        return sugar_reading;
    }

    public void setSugar_reading(int sugar_reading) {
        this.sugar_reading = sugar_reading;
    }
}
