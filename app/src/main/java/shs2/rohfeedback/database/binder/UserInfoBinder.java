package shs2.rohfeedback.database.binder;

import android.database.sqlite.SQLiteStatement;

import shs2.rohfeedback.object.UserInfo;

//import com.shss.restaurantwaiter.object.UserInfo;

public class UserInfoBinder implements ParameterBinder {

	@Override
	public void bind(SQLiteStatement st, Object object) {
		// TODO Auto-generated method stub
		UserInfo userInfo = (UserInfo) object;
		st.bindString(1, userInfo.getUserId());
		st.bindString(2, userInfo.getUserName());
		st.bindString(3, userInfo.getUserPassword());
	}

}
