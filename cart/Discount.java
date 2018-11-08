/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;



/**
 *
 * @author Mark
 */
public interface Discount {
    
    /**
     *  -> discount for large bulk orders
     *  -> discount dependant on type of customer ( premium, gold, etc...)
     *  -> 
     * 
     * @param user
     * @return 
     */
    
    abstract double calculateDiscount(Cart cart);
    abstract double getBulkOrderDiscount(Cart cart);
    abstract double getMembershipDiscount();
    
    
    
    
}
