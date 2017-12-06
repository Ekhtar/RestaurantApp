package net.ekhtar.restaurantapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Hossam Magdy on 12/6/2017.
 */

public class DatabaseConnection extends SQLiteOpenHelper {

    private final static String DB_Name="restaurants";
    private final static int DB_Version=1;

    public DatabaseConnection(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `restaurant`"+
                "(`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`name` TEXT NOT NULL," +
                "`phoneNumber` TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists restaurant");
        onCreate(db);
    }

    public void insertNewRestaurant(String name, String phoneNumber){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phoneNumber",phoneNumber);
        database.insert("restaurant",null,values);
    }

    public ArrayList<Restaurant> getAllRestaurants(){
        SQLiteDatabase database=this.getReadableDatabase();
        ArrayList<Restaurant> arrayList=new ArrayList();
        Cursor cursor=database.rawQuery("select * from restaurant",null);
        cursor.moveToFirst();
        if (cursor.moveToFirst()){
            do {
                Restaurant restaurant=new Restaurant();
                restaurant.setName(cursor.getString(cursor.getColumnIndex("name")));
                restaurant.setPhoneNumber(cursor.getString(cursor.getColumnIndex("phoneNumber")));
                arrayList.add(restaurant);
            }while (cursor.moveToNext());
        }
        return arrayList;
    }
}
