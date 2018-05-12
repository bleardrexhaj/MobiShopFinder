package com.sj.projekt.mobishopfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static DBHandler instance;

    public static synchronized DBHandler getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (instance == null) {
            instance = new DBHandler(context);
        }
        return instance;
    }

    private DBHandler(Context context) { super(context, DATABASE_NAME, null, 1); }


    //Emri i databases
    private static final String DATABASE_NAME = "MobileShop.db";



    //Emri i tabelave
    private static final String TABLE_USERS = "users";
    private static final String TABLE_MOBILESHOP = "mobileshop";
    private static final String TABLE_PHONES = "phones";
    private static final String TABLE_LOCATION = "location";

    //Tabela Lokacioni
    private static final String LOCATION_ID = "id";
    private static final String LOCATION_LONGITUDE = "longitude";
    private static final String LOCATION_LATITUDE = "latidude";

    //Tabela Phones
    private static final String PHONES_ID = "id";
    private static final String PHONES_MARK = "mark";
    private static final String PHONES_MODEL = "model";
    private static final String PHONES_DESCRIPTION = "description";
    private static final String PHONES_PRICE = "price";
    private static final String PHONES_YEAROFPRODUCE = "yearofproduce";
    private static final String PHONES_BELONGS_TO_MOBILESHOP = "mobileshop_id";

    //Tabela users
    private static final String USERS_ID = "id";
    private static final String USERS_NAME = "name";
    private static final String USERS_SURNAME = "surname";
    private static final String USERS_USER_TYPE = "user_type";
    private static final String USERS_USER_PASSWORD = "user_password";

    //Tabela MobileShop
    private static final String MOBILESHOP_ID = "id";
    private static final String MOBILESHOP_ADDRESS = "adress";
    private static final String MOBILESHOP_NAME = "name";
    private static final String MOBILESHOP_OWNER = "user_id";
    private static final String MOBILESHOP_QYTETI = "qyteti";
    private static final String MOBILESHOP_CONTACT = "email";


    //Komanda e krijimit te tabeles Lokacioni
    private static final String CREATE_TABLE_LOCATION = "CREATE TABLE " + TABLE_LOCATION
            + "( " +
            LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LOCATION_LATITUDE + " DOUBLE NOT NULL, " +
            LOCATION_LONGITUDE + " DOUBLE NOT NULL " + ");";

    //Komanda e krijimit te tabeles Phones
    private static final String CREATE_TABLE_PHONES = "CREATE TABLE " + TABLE_PHONES + "( " +
            PHONES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PHONES_MARK + " TEXT NOT NULL, " +
            PHONES_MODEL + " TEXT NOT NULL, " +
            PHONES_DESCRIPTION + " TEXT NOT NULL, " +
            PHONES_PRICE + " INTEGER NOT NULL, " +
            PHONES_YEAROFPRODUCE + " INTEGER NOT NULL, " +
            PHONES_BELONGS_TO_MOBILESHOP + " INTEGER NOT NULL, " +
            " FOREIGN KEY (" + PHONES_BELONGS_TO_MOBILESHOP + ") REFERENCES " + TABLE_MOBILESHOP + "(" + MOBILESHOP_ID + ")); ";

    //Komanda e krijimit te tabeles Users
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + "( " +
            USERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USERS_NAME + " TEXT NOT NULL, " +
            USERS_SURNAME + " TEXT NOT NULL, " +
            USERS_USER_PASSWORD + " TEXT NOT NULL, "+
            USERS_USER_TYPE + " INTEGER NOT NULL );";

    //Komanda e krijimit te tabeles Mobile Shop
    private static final String CREATE_TABLE_MOBILE_SHOP = "CREATE TABLE " + TABLE_MOBILESHOP + "( " +
            MOBILESHOP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MOBILESHOP_ADDRESS + " INTEGER NOT NULL, " +
            MOBILESHOP_NAME + " TEXT NOT NULL, " +
            MOBILESHOP_QYTETI +" TEXT NOT NULL, " +
            MOBILESHOP_CONTACT + " TEXT NOT NULL, "+
            MOBILESHOP_OWNER + " INTEGER NOT NULL, " +
            " FOREIGN KEY (" + MOBILESHOP_OWNER + ") REFERENCES " + TABLE_USERS + "(" + USERS_ID + "), " +
            " FOREIGN KEY (" + MOBILESHOP_ADDRESS + ") REFERENCES " + TABLE_LOCATION + "(" + LOCATION_ID + "));";


    @Override
    public void onCreate(SQLiteDatabase DB) {

            DB.execSQL(CREATE_TABLE_LOCATION);
            DB.execSQL(CREATE_TABLE_PHONES);
            DB.execSQL(CREATE_TABLE_USERS);
            DB.execSQL(CREATE_TABLE_MOBILE_SHOP);

    }



    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONES);
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_MOBILESHOP);
        onCreate(DB);
    }

    public void insertIntoUsers(String name, String surname, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        //USER TYPE 1 = ADMIN;
        //USER TYPE 2 = ADMINISTRATOR;
        ContentValues cv = new ContentValues();
        cv.put(USERS_NAME, name);
        cv.put(USERS_SURNAME, surname);
        cv.put(USERS_USER_PASSWORD,password);
        cv.put(USERS_USER_TYPE, 1);

        DB.insert(TABLE_USERS, null, cv);
    }


    public void insertIntoLocations(double latitude,double longitude) {
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(LOCATION_LATITUDE, latitude);
        cv.put(LOCATION_LONGITUDE, longitude);

        DB.insert(TABLE_LOCATION, null, cv);
    }

    public void insertIntoMobileShop(int location_id,String emri,String qyteti,String email,int ownerid) {
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(MOBILESHOP_ADDRESS, location_id);
        cv.put(MOBILESHOP_NAME, emri);
        cv.put(MOBILESHOP_QYTETI, qyteti);
        cv.put(MOBILESHOP_CONTACT, email);
        cv.put(MOBILESHOP_OWNER,ownerid);

        DB.insert(TABLE_MOBILESHOP, null, cv);
    }
    public ArrayList<String> getinfo() {
        List<ArrayList> list = new ArrayList<>();
        String query = "Select * from users " + " where id = 1";
        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor cursor = sql.rawQuery(query, null);

        cursor.getString(1);
        cursor.getString(2);
        cursor.getString(3);
        ArrayList<String> str = new ArrayList<>();
        str.add(cursor.getString(1));
        str.add(cursor.getString(2));


        return str;
    }
    public Cursor getMobileshopLocation(String name){
        Cursor query = this.getWritableDatabase().rawQuery("Select "+TABLE_LOCATION+"."+LOCATION_LATITUDE+","+TABLE_LOCATION+"."+LOCATION_LONGITUDE+" from "+TABLE_MOBILESHOP+", "+TABLE_LOCATION+" WHERE "+TABLE_MOBILESHOP+"."+MOBILESHOP_ID+" = "+ TABLE_LOCATION+"."+LOCATION_ID+" AND "+ MOBILESHOP_NAME +" = "+"'"+name+"'",null);
        return query;
    }
    public Cursor getLocationData() {
        Cursor cursor = this.getWritableDatabase().query(TABLE_LOCATION, new String[]{LOCATION_ID, LOCATION_LATITUDE, LOCATION_LONGITUDE}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public Cursor getUserData(){
        Cursor cursor = this.getWritableDatabase().query(TABLE_USERS, new String[]{USERS_ID, USERS_NAME, USERS_SURNAME}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getMobileShopData() {
        Cursor cursor = this.getWritableDatabase().query(TABLE_MOBILESHOP, new String[]{MOBILESHOP_ID, MOBILESHOP_NAME, MOBILESHOP_QYTETI, MOBILESHOP_CONTACT,MOBILESHOP_ADDRESS}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
