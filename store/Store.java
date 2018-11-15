package store;
import java.util.*;

public class Store {
								// Creates the Store and its contents.
	String name;
	ArrayList<Product> catalogList = new ArrayList<Product>();
	String catalogTextfile;
        
	public Store(String name) {
		this.name = name;
                catalogTextfile = "test/" + name + "catalog.txt";
	}
	
	public void addProduct(Product p) {
		catalogList.add(p);
	}
        
        public int storeSize() {
            return catalogList.size();
        }
	
	public String getName() {
		return name;
	}
        public String getFile()
        {
            return catalogTextfile;
        }
	
	public ArrayList<Product> getCatalog() {
		return catalogList;
	}
}