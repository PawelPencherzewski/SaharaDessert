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
public class CustomerDiscount implements Discount {

   
 
    
    
    
    @Override
    public double getBulkOrderDiscount(int items) {
        double discount = 0;
        if(items > 75)
        {
            discount = 0.15;
        }
        else if(items > 50)
        {
            discount = 0.1;
        }
        
        else if(items > 20)
        {
            discount = 0.05;
        }
        return discount;
    }

    @Override
    public double getMembershipDiscount() {
        return 0.0;
    }



    @Override
    public double calculateDiscount(int items) {
        double discount =0;
        discount += getBulkOrderDiscount(items);
        discount += getMembershipDiscount();
        return discount;
    }

    
    
}
