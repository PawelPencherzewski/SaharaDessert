/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.Scanner;
import static store.Sahara.cart;
import static store.Sahara.checkForAvailability;
import static store.Sahara.checkIfProdExists;
import static store.Sahara.requestProdID;
import store.Store;

/**
 *
 * @author Mark
 */
public class AddToCart implements Command {

    Store shop;
    
    public AddToCart(Store store){
        shop = store;
    }
    
    @Override
    public void execute() {
        
        Scanner reader = new Scanner(System.in);
            
        System.out.print("Product Number: ");
        int productnumber = reader.nextInt() + 999;
        System.out.print("amount to puchase: ");
        int amount = reader.nextInt();
        boolean found = checkIfProdExists(productnumber, shop);
        boolean available = checkForAvailability(productnumber, shop, amount);
        if(!available){
            System.out.println("Quantity entered doesn't match store stock. \nTry Different amount.");
            
        }            
        else {
            cart.addProduct(requestProdID(Integer.toString(productnumber), shop), amount);
            System.out.println(cart.getString());
        }
    }

}
