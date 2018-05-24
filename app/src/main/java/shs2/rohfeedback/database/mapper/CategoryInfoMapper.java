package shs2.rohfeedback.database.mapper;

import android.database.Cursor;

import shs2.rohfeedback.database.DBKeyConfig;
import shs2.rohfeedback.object.CategoryInfo;
//
//import com.shss.restaurantwaiter.database.DBKeyConfig;
//import com.shss.restaurantwaiter.object.CategoryInfo;

public class CategoryInfoMapper implements RowMapper<CategoryInfo> {

	@Override
	public CategoryInfo mapRow(Cursor row, int rowNum) {
		CategoryInfo categoryInfo = new CategoryInfo();
		categoryInfo.setImgUrl(CursorParseUtility.getString(row,
				DBKeyConfig.KEY_CATEGORY_IMAGE_URL));
		categoryInfo.setName(CursorParseUtility.getString(row,
				DBKeyConfig.KEY_CATEGORY_NAME));
		return categoryInfo;
	}

}
