package com.siu.Global;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 02/07/12
 * Time: 18:32
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "findprice.db", null, 1);                     //context: activité
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {                              //
        sqLiteDatabase.execSQL("CREATE TABLE scores (" +
                "id integer auto increment primary key," +
                "name text," +
                "score integer);");

        sqLiteDatabase.execSQL("CREATE TABLE scoresmulti ("+
        "id integer auto increment primary key,"+
        "name1 text, "+
        "name2 text);");
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {                //ne rien mettre dedans

    }
}