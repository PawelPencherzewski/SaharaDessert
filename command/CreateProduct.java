/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import store.Product;
import store.Store;

/**
 *
 * @author Mark
 */
public class CreateProduct implements Command {
    Store shop;
    String pid;
    
    public CreateProduct(Store store, String pid){
        this.shop = store;
        this.pid = pid;
    }

    @Override
    public void execute() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Product p = createNewItem(pid);
        int up = Integer.parseInt(pid) + 1;
        pid = Integer.toString(up);
        shop.addProduct(p);

        try {
            String catalogTextFile = "test/" + shop.getName() + "catalog.txt";
            FileWriter fw = new FileWriter(catalogTextFile, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(p.getProdID() + "," + p.getProdName() + "," + p.getProdPrice() + "," + p.getProdQuantity());
            pw.close();
            fw.close();
        } catch (IOException e) {
        }

    }

    private Product createNewItem(String lastID) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.print("Product name: ");
        String n = reader.nextLine();
        System.out.print("Price (0 for default): ");
        double p = reader.nextDouble();
        System.out.print("Quantity (0 for default): ");
        int q = reader.nextInt();

        int id = Integer.parseInt(lastID) + 1;
        String idS = Integer.toString(id);
        Product newItem = new Product.ProductBuilder(idS, n).price(p).quantity(q).build(); // Create product
        return newItem;
    }

}
