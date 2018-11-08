/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.ArrayList;
import store.Product;
import store.Store;


/**
 *
 * @author Mark
 */
public class ShowCatalog implements Command {

    
    Store shop;
    
    public ShowCatalog(Store store){
        this.shop = store;
    }
    
    @Override
    public void execute() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        ArrayList<Product> catalog = shop.getCatalog(); 											 // load in the catalog
        System.out.println("@@@@@@@@@@@@ " + shop.getName() + " CATALOG @@@@@@@@@@@");
        for (int i = 0; i < catalog.size(); i++) {													 // print catalog
            Product product = catalog.get(i);
            System.out.printf("%-25s", (i + 1) + ": " + product.getProdName());
            System.out.printf("%10s", " $");
            System.out.printf("%.2f\n", product.getProdPrice());
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    }

}
