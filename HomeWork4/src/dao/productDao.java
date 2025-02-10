package dao;

public interface productDao {
	//read & update only
	Integer selectByName(String name);
	
	void updateByName(String name, int price);
}
