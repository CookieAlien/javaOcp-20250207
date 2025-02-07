package dao;

import java.util.List;

import model.ShopMember;

public interface ShopMemberDao {
	//create
	void add(ShopMember member);
	//read
	List<ShopMember> selectAllMembers();
	List<ShopMember> selectByUsername(String username);
	List<ShopMember> selectByUsernameAndPassword(String username, String password);
	//update
	void update(ShopMember member);
	//delete
	void delete(int id);
}
