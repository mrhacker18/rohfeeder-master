package shs2.rohfeedback.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import shs2.rohfeedback.BaseActivity;
import shs2.rohfeedback.R;
import shs2.rohfeedback.object.Settings;
import shs2.rohfeedback.technicalassist.sessionmanager;

//import android.support.design.widget.TextInputLayout;

//import com.shss.restaurantwaiter.BaseActivity;
//import com.shss.restaurantwaiter.R;
//import com.shss.restaurantwaiter.object.Settings;
//import com.shss.restaurantwaiter.technicalassist.BluetoothService;
//import com.shss.restaurantwaiter.technicalassist.sessionmanager;
//
//import static com.shss.restaurantwaiter.activity.CartActivity.DEVICE_NAME;
//import static com.shss.restaurantwaiter.activity.CartActivity.MESSAGE_CONNECTION_LOST;
//import static com.shss.restaurantwaiter.activity.CartActivity.MESSAGE_DEVICE_NAME;
//import static com.shss.restaurantwaiter.activity.CartActivity.MESSAGE_READ;
//import static com.shss.restaurantwaiter.activity.CartActivity.MESSAGE_STATE_CHANGE;
//import static com.shss.restaurantwaiter.activity.CartActivity.MESSAGE_TOAST;
//import static com.shss.restaurantwaiter.activity.CartActivity.MESSAGE_UNABLE_CONNECT;
//import static com.shss.restaurantwaiter.activity.CartActivity.MESSAGE_WRITE;
//import static com.shss.restaurantwaiter.activity.CartActivity.TOAST;
//import static com.shss.restaurantwaiter.technicalassist.stat.mbluetoothService;

public class Printersetting extends BaseActivity implements View.OnClickListener{

//    private BluetoothAdapter mBluetoothAdapter;
//    private BluetoothService mService;
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;


    private static BluetoothAdapter mBluetoothAdapter;
//    private static BluetoothService mbluetoothService;
    private String TAG= "printerSetting";
    private CheckBox check;

    private Button bluetoothScan, btnSave, btnCancel;
    private static String text;
    private EditText Shopname,Addressline2,Addressline1,printerFooter, GSTNum;
    private TextView txtview;
    private sessionmanager session;
    private Settings setter;
    private Resources res;
    private EditText ServerIP;
    private TextInputLayout printerLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        setContentView(R.layout.activity_printersetting);
//        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        session = new sessionmanager(this);
        setter = new Settings();

        setter = session.getSetting();
        InitView();
    }

    private void InitView() {

//        check = (CheckBox) findViewById(R.id.CheckEnablePrinter);
//        txtview = (EditText) findViewById(R.id.PrinterIP);
        ServerIP = (EditText) findViewById(R.id.ServerIP);
//        printerLayout = (TextInputLayout) findViewById(R.id.printerLayout);

//        bluetoothScan = (Button) findViewById(R.id.btnBluetoothscan);
        btnCancel = (Button) findViewById(R.id.btnCancel);
//        txtview = (TextView) findViewById(R.id.bluetoothAdress);
        btnSave = (Button) findViewById(R.id.btnSaveSettings);
//        Shopname = (EditText) findViewById(R.id.Shopname);
//        Addressline1 = (EditText) findViewById(R.id.Addressline1);
//        Addressline2 = (EditText) findViewById(R.id.Addressline2);
//        printerFooter = (EditText) findViewById(R.id.printerFooter);
//        GSTNum = (EditText) findViewById(R.id.GSTNum);

        if(setter==null){}
        else {
//            check.setChecked(setter.EnablePrinter);
//            txtview.setText(setter.IPADDRESS);
            ServerIP.setText(setter.ServerIP);

//            txtview.setText(setter.BluetoothAddress);
//            Shopname.setText(setter.ShopName);
//            Addressline1.setText(setter.AddressLine1);
//            Addressline2.setText(setter.AddressLine2);
//            GSTNum.setText(setter.GSTNumber);
//            printerFooter.setText(setter.printerFooter);
        }

//        check.setOnClickListener(this);
        btnSave.setOnClickListener(this);
//        bluetoothScan.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }


    @Override
    public void onStart() {
        super.onStart();

//        if (!mBluetoothAdapter.isEnabled()) {
//            Intent enableIntent = new Intent(
//                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
////            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
//            // Otherwise, setup the session
//        } else {
//            if (mbluetoothService == null)
//                mbluetoothService = new BluetoothService(this, mHandler);
//            //KeyListenerInit();//监听
//        }
    }




    @Override
    public void onClick(View view) {

        switch (view.getId()) {
//            case R.id.btnBluetoothscan: {
//                Intent serverIntent = new Intent(Printersetting.this, DeviceListActivity.class);
//                startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
//                break;
//            }

            case R.id.btnSaveSettings:
            {
                Settings s = new Settings();
//                s.EnablePrinter = check.isChecked();
//                s.IPADDRESS = txtview.getText().toString();
                s.ServerIP = ServerIP.getText().toString();


//                if(setter==null){
//                    s.ShopName = Shopname.getText().toString();
//                    s.AddressLine1 = Addressline1.getText().toString();
//                    s.AddressLine2 = Addressline2.getText().toString();
//                    s.BluetoothAddress = txtview.getText().toString();
//                    s.DisablePrinter = check.isChecked();
//                    s.GSTNumber = GSTNum.getText().toString();
//                    s.printerFooter = printerFooter.getText().toString();
                Boolean b = session.setSettings(s);
                if(b)
                {
                    Toast.makeText(this,"Successfully saved settings",Toast.LENGTH_SHORT).show();
                }
                break;

            }

            case R.id.btnCancel:{
                openQuitDialog();
                break;
            }

//            case R.id.CheckEnablePrinter:{
//                if(check.isChecked())
//                {
//                    printerLayout.setVisibility(View.VISIBLE);
////                    txtview.setVisibility(View.VISIBLE);
//                }
//            }
        }

    }


//         */
    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                Printersetting.this);
        quitDialog.setTitle(res.getString(R.string.dialog_quit));
        quitDialog.setPositiveButton(res.getString(R.string.quit), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton(res.getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        quitDialog.show();
    }
}
