/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import cart.Cart;

/**
 *
 * @author Pawel
 */
public class ViewCart implements Command {
    Cart cart; 
    
    public ViewCart(Cart cart){
        this.cart = cart;
    }
    
    public void execute() {
        System.out.println(cart.getString());
    }    
}
