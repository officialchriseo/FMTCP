package com.blogspot.officialceo.fmtcp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TranzactionsDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tranzactions.db";
    private static final int DATABASE_VERSION = 1;

    public TranzactionsDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TRANZACTIONS_TABLE = "CREATE TABLE " +
                TranzactionsContract.TranzactionsEntry.TABLE_NAME + " (" +
                TranzactionsContract.TranzactionsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TranzactionsContract.TranzactionsEntry.COLUMN_PAYMENT_METHOD + " TEXT NOT NULL, " +
                TranzactionsContract.TranzactionsEntry.COLUMN_FUND_USAGE + " TEXT NOT NULL, " +
                TranzactionsContract.TranzactionsEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                TranzactionsContract.TranzactionsEntry.COLUMN_DATE + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" + "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_TRANZACTIONS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TranzactionsContract.TranzactionsEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
