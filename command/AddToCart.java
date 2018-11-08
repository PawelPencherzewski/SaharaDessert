/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.Scanner;
import static store.Sahara.cart;
import static store.Sahara.checkIfNameExists;
import static store.Sahara.requestProdName;
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Scanner reader = new Scanner(System.in);
            
        System.out.print("ProductName: ");
        String name = reader.next();
        boolean found = checkIfNameExists(name, shop);
        if (found) {
            cart.addProduct(requestProdName(name, shop));
            System.out.println(cart.getString());

        }
    }

}
