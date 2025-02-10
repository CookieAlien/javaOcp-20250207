package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.productDao;
import util.DBConnection;

public class ProductDaoImpl implements productDao{
	private static Connection connection = DBConnection.getConnection();
	@Override
	public Integer selectByName(String name) {
		String sql = "select price from product where productname=?";
		Integer price = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				price = resultSet.getInt("price");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	@Override
	public void updateByName(String name, int price) {
		String sql = "update product set price=? where productname=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, price);
			preparedStatement.setString(2, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
