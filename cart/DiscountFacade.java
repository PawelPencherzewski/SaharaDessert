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
public class DiscountFacade {
    
    private CustomerDiscount customerDiscount;
    private GoldCustomerDiscount goldCustomerDiscount; 
    private PlatinumCustomerDiscount platinumCustomerDiscount;
    
    public DiscountFacade()
    {
        customerDiscount = new CustomerDiscount();
        goldCustomerDiscount = new GoldCustomerDiscount();
        platinumCustomerDiscount = new PlatinumCustomerDiscount();
        
    }
    
    public double discount(int items, int type)
    {
        double discount = 0;
        switch (type) {
            case 0:
                discount = customerDiscount.calculateDiscount(items);
                break;
            case 1:
                discount = goldCustomerDiscount.calculateDiscount(items);
                break;
            case 2:
                discount = platinumCustomerDiscount.calculateDiscount(items);
                break;
            default:
                break;
        }
        return discount;
    }
}