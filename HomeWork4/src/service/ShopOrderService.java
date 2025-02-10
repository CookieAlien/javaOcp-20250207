package service;

import java.util.List;

import model.ShopOrder;

public interface ShopOrderService {
	//create
	void addOrder(ShopOrder order);
	//read
	List<ShopOrder> getAllOrders();
	List<ShopOrder> getOrdersByName(String username);
	ShopOrder getOrderById(int id);
	//update
	
	//delete
	void deleteOrder(int id);
}
