package com.example.ante.sqliteandroid.Data;

import android.provider.BaseColumns;

/**
 * Created by Ante on 20/07/2017.
 */

public class Contract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private Contract() {
    }

    /**
     * Inner class that defines constant values for database table.
     */
    public static final class HabitEntry implements BaseColumns {

        /**
         * Name of database table
         */
        public final static String TABLE_NAME = "user_habits";

        /**
         * Unique ID number for each row in table (only for use in the database table).
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the user.
         * Type: TEXT
         */
        public final static String USER_NAME = "name";

        /**
         * User outdoor activity's.
         * The only possible values are {@link  #ACTIVITY_RUN}, {@link #ACTIVITY_SWIM},
         * or {@link #ACTIVITY_CYCLING}.
         * Type: INTEGER
         */
        public final static String USER_ACTIVITY = "activity";

        /**
         * Date of activity.
         * Type: INTEGER
         */
        public final static String ACTIVITY_DATE = "date";

        /**
         * Possible values for the {@link #USER_ACTIVITY}
         */
        public static final int ACTIVITY_RUN = 0;
        public static final int ACTIVITY_SWIM = 1;
        public static final int ACTIVITY_CYCLING = 2;
    }

}


