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
    public ArrayList<Integer> quantity = new ArrayList<>();
    
    
    public Cart()
    {
        this.cart = new ArrayList<>();
        
    }
    
    @Override
    public void addProduct(Product p, int numOfProduct)
    {
        cart.add(p);
        
        quantity.add(numOfProduct);
        totalPrice += (numOfProduct * p.getProdPrice());
        items += numOfProduct;
        
    }
    
    @Override
    public void removeProduct(Product p)
    {
        int x = cart.indexOf(p);
        cart.remove(p);
        totalPrice = totalPrice - (p.getProdPrice() * quantity.get(x));
        items = items - quantity.get(x);
        quantity.remove(x);
    }

    @Override
    public String getString()
    {
        String out = "";
        System.out.println("");
        System.out.println("YOUR CART:");
        for(int i =0; i< cart.size(); i++)
        {
           out += cart.get(i).getProdName() + ", " + quantity.get(i) + "\n";
        }
        out += "\n price: $" +totalPrice + "\n";
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
                
        double discount = facade.discount(this.getNumItems(),type );
        return discount;
    }
    
    public void clearCart() {
        for(int i = cart.size()-1; i >= 0; i--) {
            cart.remove(i);
            quantity.remove(i);
        }
        totalPrice = 0;
        items = 0;
    }

    @Override
    public int getQuantity(int i) {
        return quantity.get(i);
    }

    public int size() {
        return cart.size();
    }
}