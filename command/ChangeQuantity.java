/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import data.Data;
import java.util.Scanner;
import store.Product;
import static store.Sahara.checkIfIDExists;
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
        Data d = new Data();
        System.out.print("Product number: ");
        int id = reader.nextInt() + 999;
        boolean found = checkIfIDExists(Integer.toString(id), shop);
        if (found) {
            d.editTextFile(shop, Integer.toString(id), changeQuantity(requestProdID(Integer.toString(id), shop)));
        }

    }
    
    public int changeQuantity(Product p){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		System.out.print("New quantity: ");
		int quantity = reader.nextInt();
		p.setQuantity(quantity);
		return quantity;
	}

}
