package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CleanInfoDao{
	
}

public static list<CleanInfo_List> findCleanInfoDao(String CleanInfotext) {
	Connection con = null;
	PreparedStatement ps = null;
	List<CleanInfo_List> foodList = new ArrayList<FoodCleanInfo_List>();try
	{
		con = DBManager.getConnection();
		ps = con.prepareStatement("SELECT * FROM foods f INNER JOIN type t"
				+ " ON f.type_id = t.type_id WHERE food_name LIKE ?");
		ps.setString(1, "%" + Serch_CleanInfo + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Food food = new Food();
			food.setFoodId(rs.getString("food_id"));
			food.setFoodName(rs.getString("food_name"));
			food.setPrice(rs.getInt("price"));
			Type type = new Type();
			type.setTypeId(rs.getString("type_id"));
			type.setTypeName(rs.getString("type_name"));
			food.setType(type);
			foodList.add(food);
		}
	}catch(
	SQLException e)
	{
		e.printStackTrace();
	}finally
	{
		DBManager.close(ps, con);
	}return foodList;
}

}
