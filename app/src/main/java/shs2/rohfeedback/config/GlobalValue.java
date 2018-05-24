package shs2.rohfeedback.config;

import android.content.Context;

import java.util.HashMap;

import shs2.rohfeedback.database.DatabaseUtility;

//import com.shss.restaurantwaiter.database.DatabaseUtility;

/**
 * GlobalValue class contains global static values
 *
 * @author FruitySolution
 */
public final class GlobalValue {
    public static MySharedPreferences preferences;

    public static final String EVANDRO_DROID_PREFERENCES = "EVANDRO_DROID_PREFERENCES";
    public static DatabaseUtility databaseUtility;

    public static void constructor(Context context) {
        if (preferences == null) {
            preferences = new MySharedPreferences(context);
        }
    }

    public static HashMap<String, String> timeStampForTable = new HashMap<>();

}
