package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

//	getBuyItemInfoメソッドを作成！！
	public BuyItemDTO getBuyItemInfo(){

		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

//通常実行するtry部分
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
//SQL文をチェックして実行しました

//一つ一つ見ていってtrueなら（⇒１つでも値が入っていたなら）
			if (resultSet.next()){

//ゲットした項目を、buyItemDTOのセッターに入れるよ！
				buyItemDTO.setId(resultSet.getInt("Id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}

//例外が出たら実行するcatch文
		}catch (Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}

}
