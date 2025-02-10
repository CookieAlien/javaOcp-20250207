package service.impl;

import dao.impl.ProductDaoImpl;
import service.ProductService;

public class ProductServiceImpl implements ProductService{
	private static ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	@Override
	public Integer getPrice(String product) {
		return productDaoImpl.selectByName(product);
	}

	@Override
	public void updatePrice(String product, int price) {
		productDaoImpl.updateByName(product, price);
	}

}
