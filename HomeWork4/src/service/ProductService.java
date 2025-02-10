package service;

public interface ProductService {
	Integer getPrice(String product);
	void updatePrice(String product, int price);
}
