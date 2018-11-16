package store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import cart.Cart;
import command.AddToCart;
import command.BuyMembership;
import command.ChangePrice;
import command.ChangeQuantity;
import command.Command;
import command.PayForCart;
import command.CreateProduct;

import command.ShowCatalog;
import command.ViewCart;
import data.Data;

/**
 *
 * @author Pawel
 */
public class Sahara {

    public static Cart cart = new Cart();
    //public static Store shop = new Store("SAHARA");

    public static void letsgo(String usertype, String usernamename, int userlevel) throws IOException {
        Store shop = new Store("SAHARA"); 														 // Create Store
        String pid = "999";
        
        Data d = new Data();
        d.populateStore(shop, shop.getFile());

        ArrayList<Command> con = new ArrayList();
        ChangePrice changePrice = new ChangePrice(shop);
        CreateProduct createProduct = new CreateProduct(shop, pid);
        ChangeQuantity changeQuantity = new ChangeQuantity(shop);
        ShowCatalog showCatalog = new ShowCatalog(shop);
        con.add(showCatalog);
        con.add(createProduct);
        con.add(changePrice);
        con.add(changeQuantity);

        ArrayList<Command> con2 = new ArrayList();
        AddToCart addToCart = new AddToCart(shop);
        ViewCart viewCart = new ViewCart(cart);
        PayForCart payForCart = new PayForCart(cart, shop, usernamename, cart.getPrice(), cart.getString(), cart.getDiscount(userlevel));
        BuyMembership buyMembership = new BuyMembership(usernamename, userlevel);
        con2.add(showCatalog);
        con2.add(addToCart);
        con2.add(viewCart);
        con2.add(payForCart);
        con2.add(buyMembership);

        boolean loop = true;
        if (usertype.equals("staff")) {
            while (loop) {
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("-----------------------\n[1] Show catalog\n"
                        + "[2] Create product\n"
                        + "[3] Change price\n"
                        + "[4] Change quantity\n"
                        + "[0] EXIT \n");
                int n = reader.nextInt();
                if (n == 0)
                    System.exit(0);
                else
                    con.get(n - 1).execute();
            }
        } else if (usertype.equals("customer")) {
            while (loop) {
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("-----------------------\n[1] Show catalog\n"
                        + "[2] Add Product to cart\n"
                        + "[3] View cart\n"
                        + "[4] PAY\n"
                        + "[5] Buy membership\n"
                        + "[0] EXIT \n");
                int n = reader.nextInt();
                if (n == 0)
                    System.exit(0);
                else
                    con2.get(n - 1).execute();
            }
        }
    }

    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        String sub;
        for (int i = 1; i < n; i++) {
            sub = str.substring(pos + 1);
            pos += sub.indexOf(substr) + 1;
        }
        return pos;
    }

    public static boolean checkIfIDExists(String id, Store shop) {
        ArrayList<Product> catalog = shop.getCatalog();
        for (int i = 0; i < catalog.size(); i++) {
            if ((catalog.get(i)).getProdID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfNameExists(String name, Store shop) {
        ArrayList<Product> catalog = shop.getCatalog();
        for (int i = 0; i < catalog.size(); i++) {
            if ((catalog.get(i)).getProdName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkIfProdExists(int id, Store shop) {
        ArrayList<Product> catalog = shop.getCatalog();
        for (int i = 0; i < catalog.size(); i++) {
            if ((catalog.get(i)).getProdID().equals(Integer.toString(id))) {
                return true;
            }
        }
        return false;
        
    }
    
    public static boolean checkForAvailability(int id, Store shop, int quantity) {
        ArrayList<Product> catalog = shop.getCatalog();
        
        for (int i = 0; i < catalog.size(); i++) {
            if (Integer.parseInt(catalog.get(i).getProdID()) == id) {
                if ((catalog.get(i)).getProdQuantity() >= quantity){
                    return true;
                }
            }
        }
        
        return false;
    }

    public static Product requestProdID(String id, Store shop) {
        ArrayList<Product> catalog = shop.getCatalog();
        for (int i = 0; i < catalog.size(); i++) {
            if ((catalog.get(i)).getProdID().equals(id)) {
                return catalog.get(i);
            }
        }
        return null;
    }

    public static Product requestProdName(String name, Store shop) {
        ArrayList<Product> catalog = shop.getCatalog();
        for (int i = 0; i < catalog.size(); i++) {
            if ((catalog.get(i)).getProdName().equals(name)) {
                return catalog.get(i);
            }
        }
        return null;
    }
}