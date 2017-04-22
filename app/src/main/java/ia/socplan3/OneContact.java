package ia.socplan3;

import java.util.UUID;

//Класс описания одного контакта

public class OneContact {

    private UUID mId;
    private String mName;
    private String mSecondName;
    private String mPhone;

    public OneContact() {
        //Генерирование уникального идентификатора
        this(UUID.randomUUID());
    }

    public OneContact(UUID id){
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSecondName() {
        return mSecondName;
    }

    public void setSecondName(String secondName) {
        mSecondName = secondName;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }
}
