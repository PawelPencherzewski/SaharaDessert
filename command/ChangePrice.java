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
public class ChangePrice implements Command {

    Store shop;
    
    public ChangePrice(Store store){
        this.shop = store;
    }
    
    @Override
    public void execute() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Scanner reader = new Scanner(System.in);
        Data d = new Data();
        System.out.print("ProductID: ");
        String id = reader.next();
        boolean found = checkIfIDExists(id, shop);
        if (found) {
            //editTextFile(shop, id, changePrice(requestProdID(id, shop)));
            d.editTextFile(shop, id, changePrice(requestProdID(id, shop)));
        }

    }

    public double changePrice(Product p){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		System.out.print("New price: ");
		double price = reader.nextDouble();
		p.changePrice(price);
		return price;
	}
}
