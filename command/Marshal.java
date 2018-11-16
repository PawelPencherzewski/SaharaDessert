/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import payment.PaymentType;

/**
 *
 * @author Pawel
 */
public class Marshal implements Command{
    String message, type;
    double price;
    int cartID;
    
    public Marshal(String type, double price, int cartID) {
        this.type=type;
        this.price=price;
        this.cartID=cartID;
    }
    
    public void execute() {
        this.message = type + "," + price + "," + cartID;
    }
    
    public String getMessage() {
        return message;
    }
}
