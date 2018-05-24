package shs2.rohfeedback.config;

import android.content.Context;

public class WebServiceConfig {

    public static final int REQUEST_TIME_OUT = 30000;

    // Protocol
    public static final String API_LINK_APP = "/index.php/api/";
    // -------------------
    public static final String LOGIN = "login";
    public static final String TABLE = "tables";
    public static final String CATEGORY = "category";
    public static final String PRODUCT = "product";
    public static final String UPDATE_TABLE = "upstatus";
    public static final String JSONCART =  "addBooking";
    public static final String SHOWCART = "showcart";
    public static final String BOOKING = "addHistory";
    public static final String CDETAILS = "custDetails";
    public static final String RATING = "rating";

    public static String Serverbackendlink= "http://shs2apicalls.pe.hu/backend";
//    public static String Serverbackendlink= "http://192.168.0.105/restohelper";


//    public sessionmanager session1;

    public WebServiceConfig()
    {
//        session1 = new sessionmanager(getApplicationContext);

    }
    // --------------------


    public static String getURLLogIn(Context context) {
                return Serverbackendlink+ API_LINK_APP + LOGIN;

//        return context.getString(R.string.server_backend_link) + API_LINK_APP + LOGIN;
    }

    public static String getURLTable(Context context) {
        return Serverbackendlink + API_LINK_APP + TABLE;
    }

    public static String getURLUpdateTable(Context context) {
        return Serverbackendlink + API_LINK_APP + UPDATE_TABLE;
    }

    public static String getURLAllCategory(Context context) {
        return Serverbackendlink + API_LINK_APP + CATEGORY;
    }
    public static String getURLProduct(Context context) {
        return Serverbackendlink+API_LINK_APP+PRODUCT;
    }
    public static String getURLJsonCart(Context context) {
        return Serverbackendlink+API_LINK_APP+JSONCART;
    }
    public static String getURLShowCart(Context context) {
        return Serverbackendlink+API_LINK_APP+SHOWCART;
    }
    public static String getURLBooking(Context context) {
        return Serverbackendlink+API_LINK_APP+BOOKING;
    }

    public static String putURLCustomerDetails(Context context)
    {
        return Serverbackendlink+API_LINK_APP+CDETAILS;
    }
    public static String putURLRating(Context context)
    {
        return Serverbackendlink+API_LINK_APP+RATING;
    }
}