/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.util.ArrayList;
import store.Product;

/**
 *
 * @author Mark
 */
public class Cart implements Icart{
  
    double totalPrice = 0;
    int items = 0;
    public ArrayList<Product> cart;
    
    public Cart()
    {
        this.cart = new ArrayList<>();
        
    }
    
    @Override
    public void addProduct(Product p)
    {
        cart.add(p);
        totalPrice += p.getProdPrice();
        items++;
    }
    
    @Override
    public void removeProduct(Product p)
    {
        cart.remove(p);
        totalPrice -= p.getProdPrice();
        items--;
    }

    @Override
    public String getString()
    {
        String out = "";
        for(int i =0; i< cart.size(); i++)
        {
           out += cart.get(i).getProdName() + ", ";
        }
        out += "\n price: $" +totalPrice;
        return out;
        //return cart.toString();
    }

    @Override
    public double getPrice() {
        return totalPrice;
    }

    @Override
    public Product getProduct(int i) {
        return cart.get(i);
    }

    @Override
    public int getNumItems() {
        return items;
    }
    
    public void applyDiscount(int type)
    {
                        
        double discount = getDiscount(type);
        
        double temp = totalPrice * discount;
        totalPrice -= temp;
    }
    
    public double getDiscount(int type){
        DiscountFacade facade = new DiscountFacade();
                
        double discount = facade.discount(this,type );
        return discount;
    }
    
    public void clearCart() {
        for(int i = items-1; i >= 0; i-- ){
            cart.remove(i);
        }
        totalPrice = 0;
        items = 0;
    }
}