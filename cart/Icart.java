/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import store.Product;

/**
 *
 * @author Mark
 */
public interface Icart {
    
    
    
    public void addProduct(Product p, int numOfProduct);
    public void removeProduct(Product p);
    
    /**
     *
     * @param i
     * @return
     */
    public Product getProduct(int i);
    public int getQuantity(int i);
    public String getString();
    public double getPrice();
    public int getNumItems();
    
}
