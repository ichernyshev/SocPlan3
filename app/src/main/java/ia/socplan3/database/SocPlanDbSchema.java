package ia.socplan3.database;

import java.sql.Time;

public class SocPlanDbSchema {
    public static final class ContactTabel {
        public static final String TABLE_NAME = "contacts";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String SECOND_NAME = "second_name";
            public static final String PHONE = "phone";
        }
    }
    public static final class EventTable {
        public static final String TABLE_NAME_EVENT = "evnts";

        public static final class ColsEvents {
            public static final String UUID_EVENT = "id";
            public static final String EVENT = "event";
            public static final String TIME_START = "start";
            public static final String TIME_FINISH = "finish";
            public static final String DATE = "date";
            public static final String STATUS = "status";
            public static final String DESCRIPTION ="description";
            public static final String CONTACT_ID = "contact_id";
        }
    }
}
