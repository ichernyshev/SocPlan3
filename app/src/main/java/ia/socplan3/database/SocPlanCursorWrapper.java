package ia.socplan3.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

import ia.socplan3.OneContact;
import ia.socplan3.database.SocPlanDbSchema.ContactTabel;

//Класс дополнения класса Cursor новыми методами

public class SocPlanCursorWrapper extends CursorWrapper {
    public SocPlanCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    //метод для извлечения данных столбцов
    public OneContact getOneContact() {
        String uuidString = getString(getColumnIndex(ContactTabel.Cols.UUID));
        String name = getString(getColumnIndex(ContactTabel.Cols.NAME));
        String secondName = getString(getColumnIndex(ContactTabel.Cols.SECOND_NAME));
        String phone = getString(getColumnIndex(ContactTabel.Cols.PHONE));

        OneContact oneContact = new OneContact(UUID.fromString(uuidString));
        oneContact.setName(name);
        oneContact.setSecondName(secondName);
        oneContact.setPhone(phone);

        return oneContact;
    }
}
