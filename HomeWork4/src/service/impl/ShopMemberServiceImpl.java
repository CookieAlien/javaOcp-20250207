package service.impl;

import java.util.List;

import dao.impl.ShopMemberDaoImpl;
import model.ShopMember;
import service.ShopMemberService;

public class ShopMemberServiceImpl implements ShopMemberService{
	private static ShopMemberDaoImpl shopMemberDaoImpl = new ShopMemberDaoImpl();
	@Override
	public void addMember(ShopMember member) {
		shopMemberDaoImpl.add(member);
		
	}

	@Override
	public ShopMember login(String username, String password) {
		List<ShopMember> mList = shopMemberDaoImpl.selectByUsernameAndPassword(username, password);
		ShopMember member = null;
		if (mList.size()>0) {
			member = mList.get(0);
		}
		return member;
	}

	@Override
	public boolean isUsernameTaken(String username) {
		// TODO Auto-generated method stub
		return !shopMemberDaoImpl.selectByUsername(username).isEmpty();
	}

	@Override
	public List<ShopMember> getAllMembers() {
		return shopMemberDaoImpl.selectAllMembers();
	}

	@Override
	public void updateMember(ShopMember member) {
		shopMemberDaoImpl.update(member);
		
	}

}
