package shs2.rohfeedback;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tsongkha.spinnerdatepicker.DatePicker;
import com.tsongkha.spinnerdatepicker.DatePickerDialog;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import shs2.rohfeedback.activity.RatingActivity;
import shs2.rohfeedback.json.util.ParserUtility;
import shs2.rohfeedback.modelmanager.ErrorNetworkHandler;
import shs2.rohfeedback.modelmanager.ModelManager;
import shs2.rohfeedback.modelmanager.ModelManagerListener;
import shs2.rohfeedback.object.CustomerDetails;
import shs2.rohfeedback.object.Query;
import shs2.rohfeedback.utility.GlobalVariable;

public class CustomerDetailsActivity extends BaseActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {



@BindView(R.id.input_name)
TextView custName;

@BindView(R.id.input_remail)
TextView custEmail;

@BindView(R.id.input_phone)
TextView custPhone;

@BindView(R.id.btnnext) Button btnNext;

@BindView(R.id.imgcalendar)
    ImageView CalendarClick;

@BindView(R.id.edt_dob)
    EditText edtdob;

private SimpleDateFormat simpleDateFormat;

private CustomerDetails custDetails;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerdetails);
        ButterKnife.bind(this);
        String waiterid = getIntent().getStringExtra("UserID");
        String waitername = getIntent().getStringExtra("UserName");
        simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.US);


        custDetails = new CustomerDetails();
        CalendarClick.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnnext: {
                if (validate()) {
                     Gson gson = new GsonBuilder().create();
                     String json = gson.toJson(custDetails);
                     ModelManager.putCustomerDetails(self, json, true, new ModelManagerListener() {
                        @Override
                        public void onError(VolleyError error) {
                            ErrorNetworkHandler.processError(CustomerDetailsActivity.this, error);
                        }

                        @Override
                        public void onSuccess(Object object) {
                           ArrayList<Query> queries =  ParserUtility.parseCustdetails(object.toString());
                           Bundle b = new Bundle();
                           b.putString("queries",queries.toString());
                            Log.w("QueriesList",queries.toString());
                           Intent intent  =new Intent(CustomerDetailsActivity.this, RatingActivity.class);
                           startActivity(intent);
                           finish();

//                            GlobalVariable.details
//                           /*Toast.makeText(CustomerDetailsActivity.this, "Connected Now"+ GlobalVariable.details, Toast.LENGTH_SHORT).show();*/
                        }
                    });
                }
                break;
            }
//
            case R.id.imgcalendar:
            {
                builddate();
                break;
            }
//case
        }
    }

    private Boolean validate() {

        String sname = custName.getText().toString();
        String sphone = custPhone.getText().toString();
        String semail = custEmail.getText().toString();
        String sdob = edtdob.getText().toString();
        Log.w("DOB",sdob);
        Log.w("DOB",sname);
        Log.w("DOB",semail);
        Log.w("DOB",sphone);

        Boolean valid = true;
//        if(sphone.length()>0) {
            if (sphone.isEmpty() || !Patterns.PHONE.matcher(sphone).matches() || sphone.length() != 10) {
                Toast.makeText(this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                valid = false;
                return valid;
            }
//        }//
        if(semail.length()>0)
        {
            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(semail).matches()) {
                Toast.makeText(this, "Please enter valid email number", Toast.LENGTH_SHORT).show();
                valid = false;
                return valid;
            }
        }

        if(sname.isEmpty()){

            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            valid = false;
            return valid;
        }

//        if(sdob.length()>1)
//        {
//            if(sdob.length()!=10)
//            {
////                Toast.makeText(this, "Please Provide email number", Toast.LENGTH_SHORT).show();
//            }
//        }
        custDetails.setDob(sdob);
        custDetails.setName(sname);
        custDetails.setEmailID(semail);
        custDetails.setPhone(sphone);

        return valid;
    }

    public void builddate()
    {

        DatePickerDialog b = new SpinnerDatePickerDialogBuilder()
                .context(CustomerDetailsActivity.this)
                .callback(CustomerDetailsActivity.this)
                .showTitle(true)
                .showDaySpinner(true)
                .defaultDate(2000, 0, 1)
                .maxDate(2500, 0, 1)
                .minDate(1900, 0, 1)
                .build();

        b.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        edtdob.setText(simpleDateFormat.format(calendar.getTime()));
    }
}
