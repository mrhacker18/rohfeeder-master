package shs2.rohfeedback.database.mapper;

import android.database.Cursor;

import shs2.rohfeedback.database.DBKeyConfig;
import shs2.rohfeedback.object.AccountInfo;

//import com.shss.restaurantwaiter.database.DBKeyConfig;
//import com.shss.restaurantwaiter.object.AccountInfo;

public class AccountInfoMapper implements RowMapper<AccountInfo> {

	@Override
	public AccountInfo mapRow(Cursor row, int rowNum) {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setId(CursorParseUtility.getString(row,
				DBKeyConfig.KEY_ACCOUNT_ID));
		accountInfo.setCode(CursorParseUtility.getInt(row,
				DBKeyConfig.KEY_ACCOUNT_CODE));
		accountInfo.setName(CursorParseUtility.getString(row,
				DBKeyConfig.KEY_ACCOUNT_NAME));
		accountInfo.setPrice(CursorParseUtility.getDouble(row,
				DBKeyConfig.KEY_ACCOUNT_PRICE));
		return accountInfo;
	}

}
