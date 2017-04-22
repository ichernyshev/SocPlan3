package ia.socplan3.database;

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
}
