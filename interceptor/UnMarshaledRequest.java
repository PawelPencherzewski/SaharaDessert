/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import payment.PaymentType;

/**
 *
 * @author Pawel
 */
public class UnMarshaledRequest {
    
    String message;
    PaymentType type;
    double price;
    int cartID;
    
    public UnMarshaledRequest(PaymentType type, double price, int cartID) {
        this.type=type;
        this.price=price;
        this.cartID=cartID;
        this.message = type.name + "," + price + "," + cartID;
        //this.message = "PaymentType " + this.type.name + " = new " + this.type + " (new" + this.type + "Pay(), " + this.price + ", " + this.cartID + ")";
    }
    
    public String getObj() {
        return message;
    }
}
