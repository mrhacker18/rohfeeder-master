package shs2.rohfeedback.database.mapper;

import android.database.Cursor;

import shs2.rohfeedback.database.DBKeyConfig;
import shs2.rohfeedback.object.TablesInfo;

//import com.shss.restaurantwaiter.database.DBKeyConfig;
//import com.shss.restaurantwaiter.object.TablesInfo;

public class TablesInfoMapper implements RowMapper<TablesInfo> {

	@Override
	public TablesInfo mapRow(Cursor row, int rowNum) {
		TablesInfo tablesInfo = new TablesInfo();
		tablesInfo.setTablesId(CursorParseUtility.getString(row,
				DBKeyConfig.KEY_TABLES_ID));
		tablesInfo.setStatus(CursorParseUtility.getInt(row,
				DBKeyConfig.KEY_TABLES_STATUS));

		return tablesInfo;
	}

}
