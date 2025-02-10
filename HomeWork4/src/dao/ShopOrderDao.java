package dao;

import java.util.List;

import model.ShopOrder;

public interface ShopOrderDao {
	//create
	void add(ShopOrder shoporder);
	//read
	List<ShopOrder> selectAllOrders();
	List<ShopOrder> selectById(int id);
	List<ShopOrder> selectByUsername(String username);
	//update
	void update(ShopOrder shoporder);
	//delete
	void delete(int id);
}
