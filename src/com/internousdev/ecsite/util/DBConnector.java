package com.internousdev.ecsite.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

//	MySQL接続に必要な情報を設定
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost/ecsite_furubayashi2";
	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection(){

//念のため初期値を設定する
		Connection con = null;

		try{
//ClassクラスのforNameメソッドにドライバー名を渡す
		Class.forName(driverName);
//DriverManagerクラスのgetConnectionメソッドにIDやPWなどの情報を渡し、その結果をconに代入
		con = DriverManager.getConnection(url, user, password);

//もしクラスが発見できなかったら？のエラー処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

//もしSQLに不具合があれば？のエラー処理
		} catch (SQLException e){
			e.printStackTrace();
		}
//Mysqlに接続できたか？情報を渡す
		return con;
	}
}
