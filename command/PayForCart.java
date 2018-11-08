/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import cart.Cart;
import java.util.Scanner;
import payment.PaymentType;
import payment.bitcoin;
import payment.bitcoinPay;
import payment.creditCard;
import payment.creditCardPay;
import receipt.ChainPatternDemo;
import static store.Sahara.cart;

/**
 *
 * @author Pawel
 */
public class PayForCart implements Command{
    Cart cart; 
    String usernamename;
    double totalPrice;
    String cartList;
    double disc;
    
     public PayForCart(Cart cart, String usernamename, double totalPrice, String cartList, double disc){
        this.cart = cart;
        this.usernamename = usernamename;
        this.totalPrice = totalPrice;
        this.cartList = cartList;
        this.disc = disc;
    }

    @Override
    public void execute() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.print("PAY USING: \n[1] Bitcoin\n[2] Credit Card\n");
        String n = reader.nextLine();
        if (n.equals("1")){
		PaymentType bitcoin = new bitcoin(new bitcoinPay());
		bitcoin.applyPay();
                ChainPatternDemo.printReceipt(usernamename, totalPrice, cartList, disc);
                cart.clearCart();
        }
        else if(n.equals("2")){
		PaymentType card = new creditCard(new creditCardPay());
		card.applyPay();
                ChainPatternDemo.printReceipt(usernamename, totalPrice, cartList, disc);
                cart.clearCart();
        }
        else
            System.out.println("invalid method of payment seelcted");
    }
}