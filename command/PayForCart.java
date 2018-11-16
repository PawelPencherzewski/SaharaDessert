/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import cart.Cart;
import data.Data;
import java.util.Scanner;
import payment.PaymentType;
import payment.bitcoin;
import payment.bitcoinPay;
import payment.creditCard;
import payment.creditCardPay;
import receipt.ChainPatternDemo;
import store.Store;

/**
 *
 * @author Pawel
 */
public class PayForCart implements Command{
    Cart cart;
    Store shop;
    String usernamename;
    double totalPrice;
    String cartList;
    double disc;
    
     public PayForCart(Cart cart, Store shop, String usernamename, double totalPrice, String cartList, double disc){
        this.cart = cart;
        this.shop = shop;
        this.usernamename = usernamename;
        this.totalPrice = totalPrice;
        this.cartList = cartList;
        this.disc = disc;
    }

    @Override
    public void execute() {
        if(cart.getNumItems() == 0){
            System.out.println("The cart is empty. You can't pay for anything yet.");
            return;
        }
        else{
            Scanner reader = new Scanner(System.in);  // Reading from System.in

            System.out.print("PAY USING: \n[1] Bitcoin\n[2] Credit Card\n");
            String n = reader.nextLine();
            if (n.equals("1")){
                    PaymentType bitcoin = new bitcoin(new bitcoinPay());
                    bitcoin.applyPay();
                    ChainPatternDemo.printReceipt(usernamename, totalPrice, cartList, disc);
                    for(int j = 0; j < cart.size() ; j++){
                        for(int i = 0; i < shop.storeSize(); i++){
                            if(((cart.getProduct(j).getProdID()).equals(shop.getCatalog().get(i).getProdID())) ){
                                int difference = shop.getCatalog().get(i).getProdQuantity() - cart.quantity.get(j);
                                shop.getCatalog().get(i).changeQuantity(difference);
                                Data d = new Data();
                                d.editQuantityInFile(shop, shop.getCatalog().get(i).getProdID(), difference);
                            }
                        }
                    }
                    cart.clearCart();
            }
            else if(n.equals("2")){
                    PaymentType card = new creditCard(new creditCardPay());
                    card.applyPay();
                    ChainPatternDemo.printReceipt(usernamename, totalPrice, cartList, disc);
                    for(int j = 0; j < cart.size(); j++){
                        for(int i = 0; i < shop.storeSize(); i++){
                            if(((cart.getProduct(j).getProdID()).equals(shop.getCatalog().get(i).getProdID())) ){
                                int difference = shop.getCatalog().get(i).getProdQuantity() - cart.quantity.get(j);
                                shop.getCatalog().get(i).changeQuantity(difference);
                                Data d = new Data();
                                d.editQuantityInFile(shop, shop.getCatalog().get(i).getProdID(), difference);
                            }
                        }
                    }                    
                    cart.clearCart();
            }
            else
                System.out.println("invalid method of payment seelcted");
        }
    }
}