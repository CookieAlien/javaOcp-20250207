package service;

import java.util.List;

import model.ShopMember;

public interface ShopMemberService {
	//create
	void addMember(ShopMember member);
	//read
	ShopMember login(String username, String password);
	ShopMember findMember(String username);
	boolean isUsernameTaken(String username);
	List<ShopMember> getAllMembers();
	//update
	void updateMember(ShopMember member);
	//delete
}
