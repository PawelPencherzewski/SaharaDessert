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
    
   
    
    
    abstract double calculateDiscount(int items);
    abstract double getBulkOrderDiscount(int items);
    abstract double getMembershipDiscount();
    
    
    
    
}
