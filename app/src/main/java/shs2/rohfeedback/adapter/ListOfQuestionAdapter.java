package shs2.rohfeedback.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import shs2.rohfeedback.R;
import shs2.rohfeedback.utility.GlobalVariable;

/**
 * Created by abc on 5/22/2018.
 */

public class ListOfQuestionAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    Context context;
    ArrayList<String> arrQuestion= new ArrayList<>();
    ArrayList<Integer> arrId = new ArrayList<>();

    public ListOfQuestionAdapter(Context context,ArrayList<String> name,ArrayList<Integer> id)
    {
        arrQuestion = name;
        arrId = id;
        this.context=context;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrId.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView txtQuestion;
        RatingBar ratingBar;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.custom_listofquestion, null);
        holder.txtQuestion  = (TextView)rowView.findViewById(R.id.txtQuestion);
        holder.ratingBar =  (RatingBar)rowView.findViewById(R.id.ratingBar);

        holder.txtQuestion.setText(arrQuestion.get(position));

        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                GlobalVariable.questionResult.set(position,Float.toString(rating));
            }
        });

        return rowView;
    }

}
