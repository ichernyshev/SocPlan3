package ia.socplan3.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ia.socplan3.database.SocPlanDbSchema.ContactTabel;

import static ia.socplan3.database.SocPlanDbSchema.ContactTabel.TABLE_NAME;

public class SocPlanBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "socplanBase.db";

    public SocPlanBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" +
                " _id integer primary key autoincrement, " +
                ContactTabel.Cols.UUID + ", " +
                ContactTabel.Cols.NAME + ", " +
                ContactTabel.Cols.SECOND_NAME + ", " +
                ContactTabel.Cols.PHONE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
}
