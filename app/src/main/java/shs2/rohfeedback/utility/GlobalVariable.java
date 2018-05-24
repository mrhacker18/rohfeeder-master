package shs2.rohfeedback.utility;

import android.app.Application;

import java.util.ArrayList;

import shs2.rohfeedback.object.RestAddress;

//import com.shss.restaurantwaiter.object.RestAddress;

/**
 * Created by abc on 3/12/2018.
 */

public class GlobalVariable extends Application {

    public static int taxAmount=0;
    public static RestAddress restAddress;
    public static int custid;
    public static String details;
    public static ArrayList<String> questionName = new ArrayList<>();
    public static ArrayList<Integer> questionId = new ArrayList<>();
    public static ArrayList<String> questionResult =  new ArrayList<>();
}
