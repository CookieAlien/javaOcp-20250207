package service.impl;

import java.util.List;

import dao.impl.ShopOrderDaoImpl;
import model.ShopOrder;
import service.ShopOrderService;

public class ShopOrderServiceImpl implements ShopOrderService{
	private static ShopOrderDaoImpl shopOrderDaoImpl = new ShopOrderDaoImpl();
	@Override
	public void addOrder(ShopOrder order) {
		if (order.getPs5pro()>=0 && order.getPs5slim()>=0 && order.getNswitch()>=0 && order.getSteamdeck()>=0 && order.getXboxcontroller() >=0) {
			shopOrderDaoImpl.add(order);
		}
	}

	@Override
	public List<ShopOrder> getAllOrders() {
		
		return shopOrderDaoImpl.selectAllOrders();
	}

	@Override
	public List<ShopOrder> getOrdersByName(String username) {
		return shopOrderDaoImpl.selectByUsername(username);
	}

	@Override
	public ShopOrder getOrderById(int id) {
		ShopOrder order = null;
		try {
			order = shopOrderDaoImpl.selectById(id).get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("no results");
		}
		return order;
	}
	@Override
	public void updateOrder(ShopOrder order) {
		if (order.getPs5pro()>=0 && order.getPs5slim()>=0 && order.getNswitch()>=0 && order.getSteamdeck()>=0 && order.getXboxcontroller() >=0) {
			shopOrderDaoImpl.update(order);
		}
	}
	@Override
	public void deleteOrder(int id) {
		shopOrderDaoImpl.delete(id);
	}

	

}
