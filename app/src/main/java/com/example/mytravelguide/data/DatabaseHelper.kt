package com.example.mytravelguide.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mytravelguide.model.User
import com.example.mytravelguide.utilities.DatabaseConstants.COLUMN_USER_EMAIL
import com.example.mytravelguide.utilities.DatabaseConstants.COLUMN_USER_ID
import com.example.mytravelguide.utilities.DatabaseConstants.COLUMN_USER_NAME
import com.example.mytravelguide.utilities.DatabaseConstants.COLUMN_USER_PASSWORD
import com.example.mytravelguide.utilities.DatabaseConstants.TABLE_USER

class DatabaseHelper(context : Context) : SQLiteOpenHelper(context, "user_database", null,
    1) {

    private val createTable = ("CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")


    private val dropTable = "DROP TABLE IF EXISTS $TABLE_USER"


    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(dropTable)
        onCreate(p0)
    }



    fun addUser(user: User)  {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.name)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)
        db.insert(TABLE_USER, null, values)
        db.close()
    }


    fun checkUserMail(email : String): Boolean{
        val columns = arrayOf(COLUMN_USER_ID)
        val db = this.readableDatabase

        val selection = "$COLUMN_USER_EMAIL = ?"

        val selectionArgs = arrayOf(email)

        val cursor = db.query(TABLE_USER,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if(cursorCount > 0){
            return true
        }
        return false
    }
    fun checkUserMailPass(email:String,pass:String):Boolean {
        val columns = arrayOf(COLUMN_USER_ID)
        val db = this.readableDatabase

        val selection = "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD=?"

        val selectionArgs = arrayOf(email,pass)

        val cursor = db.query(TABLE_USER,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if(cursorCount > 0){
            return true
        }
        return false
    }
    fun getName(userM:String):String
    {
        val cols= arrayOf(COLUMN_USER_NAME)
        val d=this.readableDatabase
        val select="$COLUMN_USER_EMAIL=?"
        val selectArgs= arrayOf(userM)
        val nameCursor=d.query(TABLE_USER,cols,select,selectArgs,null,null,null)
        val index:Int=nameCursor.getColumnIndex("COLUMN_USER_NAME")
        val userN:String=nameCursor.getString(index)
        nameCursor.close()
        d.close()
        return userN
    }
    /*SQLiteDatabase db = getDatabase();

    String[] columns = {"first_name",
        "last_name",
        "id"};

    Cursor cursor = db.query("people",
    columns,
    null,
    null,
    null,
    null,
    null);

    while(cursor.moveToNext()) {
        int index;

        index = cursor.getColumnIndexOrThrow("first_name");
        String firstName = cursor.getString(index);

        index = cursor.getColumnIndexOrThrow("last_name");
        String lastName = cursor.getString(index);

        index = cursor.getColumnIndexOrThrow("id");
        long id = cursor.getLong(index);*/



}