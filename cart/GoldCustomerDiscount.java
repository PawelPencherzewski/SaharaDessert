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
public class GoldCustomerDiscount implements Discount {

    


    
    @Override
    public double getBulkOrderDiscount(Cart cart) {
    double discount = 0;
        if(cart.getNumItems() > 50)
        {
            discount = 0.15;
        }
    else if(cart.getNumItems() > 30)
        {
            discount = 0.1;
        }
        
    else if(cart.getNumItems() > 20)
        {
            discount = 0.05;
        }
        return discount;
    }

    @Override
    public double getMembershipDiscount() {
        return 0.05;
    }


    @Override
    public double calculateDiscount(Cart cart) {
        double discount =0;
        discount += getBulkOrderDiscount(cart);
        discount += getMembershipDiscount();
        return discount;
    }
}
