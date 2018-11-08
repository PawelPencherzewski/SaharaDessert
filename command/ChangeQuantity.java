/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.Scanner;
import static store.Sahara.changeQuantity;
import static store.Sahara.checkIfIDExists;
import static store.Sahara.editTextFile;
import static store.Sahara.requestProdID;
import store.Store;

/**
 *
 * @author Mark
 */
public class ChangeQuantity implements Command {

    Store shop;
    
    public ChangeQuantity(Store store){
        this.shop = store;
    }
    
    
    
    @Override
    public void execute() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Scanner reader = new Scanner(System.in);

        System.out.print("ProductID: ");
        String id = reader.next();
        boolean found = checkIfIDExists(id, shop);
        if (found) {
            editTextFile(shop, id, changeQuantity(requestProdID(id, shop)));
        }

    }

}
