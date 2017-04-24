package ia.socplan3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ia.socplan3.database.SocPlanBaseHelper;
import ia.socplan3.database.SocPlanCursorWrapper;
import ia.socplan3.database.SocPlanDbSchema;
import ia.socplan3.database.SocPlanDbSchema.ContactTabel;

/**
 * Синглетный класс
 */


public class ContactLab {
    private static ContactLab sContactLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ContactLab get(Context context) {
        if (sContactLab == null) {
            sContactLab = new ContactLab(context);
        }
        return sContactLab;
    }

    public void addContact(OneContact c) {
        ContentValues values = getContentValues(c);

        mDatabase.insert(ContactTabel.TABLE_NAME, null, values);

    }

    private ContactLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new SocPlanBaseHelper(mContext)
                .getWritableDatabase();
    }

    public List<OneContact> getContacts() {
        List<OneContact> oneContacts = new ArrayList<>();

        SocPlanCursorWrapper cursor = queryContacts(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                oneContacts.add(cursor.getOneContact());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return oneContacts;
    }

    public OneContact getOneContact(UUID id) {
        SocPlanCursorWrapper cursor = queryContacts(
                ContactTabel.Cols.UUID + " = ?",
                new String[] { id.toString() }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getOneContact();
        } finally {
            cursor.close();
        }
    }

    public void updateOneContact(OneContact oneContact) {
        String uuidString = oneContact.getId().toString();
        ContentValues values = getContentValues(oneContact);

        mDatabase.update(ContactTabel.TABLE_NAME, values, ContactTabel.Cols.UUID + " = ?", new String[] {uuidString});

    }

    //Обеспечивает хранение пар ключ-значение. Запись и обновление.
    private static ContentValues getContentValues(OneContact oneContact) {
        ContentValues values = new ContentValues();
        values.put(ContactTabel.Cols.UUID, oneContact.getId().toString());
        values.put(ContactTabel.Cols.NAME, oneContact.getName());
        values.put(ContactTabel.Cols.SECOND_NAME, oneContact.getSecondName());
        values.put(ContactTabel.Cols.PHONE, oneContact.getPhone());

        return values;
    }

    //Запрос для получения данных
    private SocPlanCursorWrapper queryContacts(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ContactTabel.TABLE_NAME, //table
                null, //columns
                whereClause, //where
                whereArgs, //whereArgs
                null, //groupBy
                null, //having
                null //orderBy
        );
        return new SocPlanCursorWrapper(cursor);
    }


}
