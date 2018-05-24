package shs2.rohfeedback.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import shs2.rohfeedback.BaseActivity;
import shs2.rohfeedback.CustomerDetailsActivity;
import shs2.rohfeedback.R;
import shs2.rohfeedback.adapter.ListOfQuestionAdapter;
import shs2.rohfeedback.modelmanager.ErrorNetworkHandler;
import shs2.rohfeedback.modelmanager.ModelManager;
import shs2.rohfeedback.modelmanager.ModelManagerListener;
import shs2.rohfeedback.utility.GlobalVariable;
import shs2.rohfeedback.utility.NonScrollListView;

public class RatingActivity extends BaseActivity {

    private NonScrollListView lstRating;
    private Button btnSubmit;
    private EditText edSuggestions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        lstRating =(NonScrollListView) findViewById(R.id.lstRating);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        edSuggestions = (EditText)findViewById(R.id.edSuggestions);

        for (int i = 0; i < GlobalVariable.questionName.size(); i++) {
            GlobalVariable.questionResult.add("0");
        }

        lstRating.setAdapter(new ListOfQuestionAdapter(getApplicationContext(), GlobalVariable.questionName,GlobalVariable.questionId));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suggestion = "";
                if(GlobalVariable.questionResult.contains("0"))
                {
                    Toast.makeText(RatingActivity.this, "Please Fill out all the questions", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    final JSONObject jsonObject =new JSONObject();
                    for (int i=0;i<GlobalVariable.questionId.size();i++)
                    {
                        try {
                            jsonObject.put(""+GlobalVariable.questionId.get(i),GlobalVariable.questionResult.get(i));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.w("JSOnFormat",jsonObject.toString());
                    if(edSuggestions.getText().toString().trim().length()==0)
                    {
                        suggestion="0";
                    }
                    else
                    {
                        suggestion = edSuggestions.getText().toString().trim();
                    }
                    ModelManager.putRatings(self, jsonObject.toString(), suggestion,""+GlobalVariable.custid, true, new ModelManagerListener() {
                        @Override
                        public void onError(VolleyError error) {
                            ErrorNetworkHandler.processError(RatingActivity.this, error);
                        }

                        @Override
                        public void onSuccess(Object object) {
                            int error=0;
                            try {
                                JSONObject jsonObject1 = new JSONObject(object.toString());
                                error = jsonObject1.getInt("error");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            GlobalVariable.questionResult.clear();
                            GlobalVariable.questionId.clear();
                            GlobalVariable.questionName.clear();
                            if(error==0)
                            {
                                Toast.makeText(RatingActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(RatingActivity.this,CustomerDetailsActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(RatingActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog  = new AlertDialog.Builder(RatingActivity.this);
        alertDialog.setMessage("Are you sure want to exit?");
        alertDialog.setTitle("Warning");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                GlobalVariable.questionName.clear();
                GlobalVariable.questionId.clear();
                GlobalVariable.questionResult.clear();
                Intent intent = new Intent(RatingActivity.this,CustomerDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }
}
