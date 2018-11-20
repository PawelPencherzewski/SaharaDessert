package store;
public class Product {
    private String productID;
    private String name;
    private double price;
    private int quantity;
    
    public Product(){
        
    }
 
    public String getProdID() {
	return productID;
    }

    public String getProdName() {
	return name;
    }
    
    public double getProdPrice() {
	return price;
    }
       
    public int getProdQuantity() {
	return quantity;
    }

    public void setProdID(String productID) {
	this.productID = productID;
    }

    public void setProdName(String name) {
	this.name = name;
    }
       
    public void setPrice(double price) {
	this.price = price;
    }
	
    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }
       
    @Override
    public String toString() {
        return "Product [name = " + name + ", product id = " + productID +  ", price = " + price + ", quantity = " + quantity + "]";
    } 
}