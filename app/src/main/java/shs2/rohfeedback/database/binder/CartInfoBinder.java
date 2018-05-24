package shs2.rohfeedback.database.binder;

//import com.shss.restaurantwaiter.object.CartInfo;

import android.database.sqlite.SQLiteStatement;

import shs2.rohfeedback.object.CartInfo;

public class CartInfoBinder implements ParameterBinder {

	@Override
	public void bind(SQLiteStatement st, Object object) {
		CartInfo cartInfo = (CartInfo) object;
		st.bindString(1, cartInfo.getId());
		st.bindString(2, cartInfo.getIdTable());
		st.bindString(3, cartInfo.getImgUrl());
		st.bindString(4, cartInfo.getNameCart());
		st.bindDouble(5, cartInfo.getPrice());
		st.bindString(6, String.valueOf(cartInfo.getNumberCart()));
		st.bindString(7, cartInfo.getNote());
	}

}
