package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.ShopOrderDao;
import model.ShopOrder;
import util.DBConnection;

public class ShopOrderDaoImpl implements ShopOrderDao{
	private static Connection connection = DBConnection.getConnection();
	@Override
	public void add(ShopOrder shoporder) {
		String sql = "insert into shoporder(username,ps5pro,ps5slim,nswitch,steamdeck,xboxcontroller) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, shoporder.getUsername());
			preparedStatement.setInt(2, shoporder.getPs5pro());
			preparedStatement.setInt(3, shoporder.getPs5slim());
			preparedStatement.setInt(4, shoporder.getNswitch());
			preparedStatement.setInt(5, shoporder.getSteamdeck());
			preparedStatement.setInt(6, shoporder.getXboxcontroller());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ShopOrder> selectAllOrders() {
		String sql = "select * from shoporder";
		List<ShopOrder> orders = new ArrayList<ShopOrder>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ShopOrder order = new ShopOrder();
				order.setId(resultSet.getInt("id"));
				order.setUsername(resultSet.getString("username"));
				order.setPs5pro(resultSet.getInt("ps5pro"));
				order.setPs5slim(resultSet.getInt("ps5slim"));
				order.setNswitch(resultSet.getInt("nswitch"));
				order.setSteamdeck(resultSet.getInt("steamdeck"));
				Timestamp timestamp = resultSet.getTimestamp("last_modified");
				LocalDateTime dateTime = timestamp.toLocalDateTime();
				order.setLastModified(dateTime);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public List<ShopOrder> selectById(int id) {
		String sql = "select * from shoporder where id=?";
		List<ShopOrder> orders = new ArrayList<ShopOrder>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ShopOrder order = new ShopOrder();
				order.setId(resultSet.getInt("id"));
				order.setUsername(resultSet.getString("username"));
				order.setPs5pro(resultSet.getInt("ps5pro"));
				order.setPs5slim(resultSet.getInt("ps5slim"));
				order.setNswitch(resultSet.getInt("nswitch"));
				order.setSteamdeck(resultSet.getInt("steamdeck"));
				Timestamp timestamp = resultSet.getTimestamp("last_modified");
				LocalDateTime dateTime = timestamp.toLocalDateTime();
				order.setLastModified(dateTime);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public List<ShopOrder> selectByUsername(String username) {
		String sql = "select * from shoporder where username=?";
		List<ShopOrder> orders = new ArrayList<ShopOrder>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ShopOrder order = new ShopOrder();
				order.setId(resultSet.getInt("id"));
				order.setUsername(resultSet.getString("username"));
				order.setPs5pro(resultSet.getInt("ps5pro"));
				order.setPs5slim(resultSet.getInt("ps5slim"));
				order.setNswitch(resultSet.getInt("nswitch"));
				order.setSteamdeck(resultSet.getInt("steamdeck"));
				Timestamp timestamp = resultSet.getTimestamp("last_modified");
				LocalDateTime dateTime = timestamp.toLocalDateTime();
				order.setLastModified(dateTime);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public void update(ShopOrder shoporder) {
		String sql = "update shoporder set ps5pro=?,ps5slim=?,nswitch=?,steamdeck=?,xboxcontroller=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, shoporder.getPs5pro());
			preparedStatement.setInt(2, shoporder.getPs5slim());
			preparedStatement.setInt(3, shoporder.getNswitch());
			preparedStatement.setInt(4, shoporder.getSteamdeck());
			preparedStatement.setInt(5, shoporder.getXboxcontroller());
			preparedStatement.setInt(6, shoporder.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql ="delete from shoporder where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
