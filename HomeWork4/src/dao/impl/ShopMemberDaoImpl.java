package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ShopMemberDao;
import model.DBConnection;
import model.ShopMember;

public class ShopMemberDaoImpl implements ShopMemberDao{
	private static Connection connection = DBConnection.getConnection();
	@Override
	public void add(ShopMember member) {
		String sql = "insert into shopmember(username,password,name,address,email,phone,role) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getUsername());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getName());
			preparedStatement.setString(4, member.getAddress());
			preparedStatement.setString(5, member.getEmail());
			preparedStatement.setString(6, member.getPhone());
			preparedStatement.setString(7, member.getRole());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ShopMember> selectAllMembers() {
		String sql = "select * from shopmember";
		List<ShopMember> members = new ArrayList<ShopMember>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ShopMember shopMember = new ShopMember();
				shopMember.setId(resultSet.getInt("id"));
				shopMember.setUsername(resultSet.getString("username"));
				shopMember.setPassword(resultSet.getString("password"));
				shopMember.setName(resultSet.getString("name"));
				shopMember.setAddress(resultSet.getString("address"));
				shopMember.setEmail(resultSet.getString("email"));
				shopMember.setPhone(resultSet.getString("phone"));
				shopMember.setRole(resultSet.getString("role"));
				members.add(shopMember);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public List<ShopMember> selectByUsername(String username) {
		String sql = "select * from shopmember where username=?";
		List<ShopMember> members = new ArrayList<ShopMember>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ShopMember shopMember = new ShopMember();
				shopMember.setId(resultSet.getInt("id"));
				shopMember.setUsername(resultSet.getString("username"));
				shopMember.setPassword(resultSet.getString("password"));
				shopMember.setName(resultSet.getString("name"));
				shopMember.setAddress(resultSet.getString("address"));
				shopMember.setEmail(resultSet.getString("email"));
				shopMember.setPhone(resultSet.getString("phone"));
				shopMember.setRole(resultSet.getString("role"));
				members.add(shopMember);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public List<ShopMember> selectByUsernameAndPassword(String username, String password) {
		String sql = "select * from shopmember where username=? and password=?";
		List<ShopMember> members = new ArrayList<ShopMember>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ShopMember shopMember = new ShopMember();
				shopMember.setId(resultSet.getInt("id"));
				shopMember.setUsername(resultSet.getString("username"));
				shopMember.setPassword(resultSet.getString("password"));
				shopMember.setName(resultSet.getString("name"));
				shopMember.setAddress(resultSet.getString("address"));
				shopMember.setEmail(resultSet.getString("email"));
				shopMember.setPhone(resultSet.getString("phone"));
				shopMember.setRole(resultSet.getString("role"));
				members.add(shopMember);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public void update(ShopMember member) {
		String sql = "update shopmember set username=?,password=?,name=?,address=?,email=?,phone=?,role=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getUsername());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getName());
			preparedStatement.setString(4, member.getAddress());
			preparedStatement.setString(5, member.getEmail());
			preparedStatement.setString(6, member.getPhone());
			preparedStatement.setString(7, member.getRole());
			preparedStatement.setInt(8, member.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from shopmember where id=?";
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
