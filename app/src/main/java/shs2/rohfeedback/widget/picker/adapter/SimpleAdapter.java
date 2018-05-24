package shs2.rohfeedback.widget.picker.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.Vector;

/**
 * Adapter for countries
 */
public class SimpleAdapter extends AbstractWheelTextAdapter {
	
	Vector<String> data = new Vector<String>();
	String currentPos;
    /**
     * Constructor
     */
    public SimpleAdapter(Context context,Vector<String> data, String currentPos) {
        super(context);
        this.data = data;
        this.currentPos = currentPos;
        setTextSize(17);
    }

    @Override
    protected void configureTextView(TextView view) {
    	super.configureTextView(view);
    	
    	if (currentPos.equals(view.getText().toString())) {
			view.setTextColor(Color.BLUE);
		}else
			view.setTextColor(Color.BLACK);
		view.setTypeface(Typeface.SANS_SERIF);
    }
    
    @Override
    public int getItemsCount() {
        return data.size();
    }
    
    @Override
    protected CharSequence getItemText(int index) {
        return data.elementAt(index);
    }
}