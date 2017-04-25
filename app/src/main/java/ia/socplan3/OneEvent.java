package ia.socplan3;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

//Класс описания события

public class OneEvent {

    private UUID mId;
    private String mEvent;
    private Time mStart;
    private Time mFinish;
    private Date mDate;
    private String mStatus;
    private String mDescription;
    private Integer mContactId;

    public OneEvent() {
        this(UUID.randomUUID());
    }

    public OneEvent(UUID id){
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getEvent() {
        return mEvent;
    }

    public void setEvent(String event) {
        mEvent = event;
    }

    public Time getStart() {
        return mStart;
    }

    public void setStart(Time start) {
        mStart = start;
    }

    public Time getFinish() {
        return mFinish;
    }

    public void setFinish(Time finish) {
        mFinish = finish;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Integer getContactId() {
        return mContactId;
    }

    public void setContactId(Integer contactId) {
        mContactId = contactId;
    }
}
