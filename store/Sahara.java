/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import cart.Cart;
import command.AddToCart;
import command.ChangePrice;
import command.ChangeQuantity;
import command.Command;
import command.PayForCart;
import command.CreateProduct;
import command.RemoteControl;
import command.ShowCatalog;
import command.ViewCart;


/**
 *
 * @author Pawel
 */
public class Sahara
{

    public static Cart cart = new Cart();
    //public static Store shop = new Store("SAHARA");
    
    public static void letsgo(String usertype, String usernamename) {
        Store shop = new Store("SAHARA"); 														 // Create Store
		
        
        
		String pid = "999", pname;
		double pprice;
		int pqty;
		String[] splitPart = new String[4];
		try{
			// read in the products and place them in the store
			String catalogTextfile = "test/" + shop.getName() + "catalog.txt";
			String line = null;
			FileReader fr = new FileReader (catalogTextfile);
			BufferedReader br = new BufferedReader (fr);
			while((line = br.readLine()) != null){
				splitPart = line.split(",");
				pid = splitPart[0];
				pname = splitPart[1];
				pprice = Double.parseDouble(splitPart[2]);
				pqty = Integer.parseInt(splitPart[3]);
				Product newItem = new Product.ProductBuilder(pid, pname).price(pprice).quantity(pqty).build(); // Create product
				shop.addProduct(newItem);														                                         	     // add product to store
			}
                        
			br.close();
			fr.close();
		}
		catch(FileNotFoundException e) { }
		catch(IOException a) { }
		
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
                PayForCart payForCart = new PayForCart(cart, usernamename, cart.getPrice(), cart.getString(), cart.getDiscount(1));
                con2.add(showCatalog);
                con2.add(addToCart);
                con2.add(viewCart);
                con2.add(payForCart);
                        
		boolean loop = true;
                if(usertype.equals("staff")){
                    while(loop){
                            Scanner reader = new Scanner(System.in);  // Reading from System.in
                                    System.out.println("\n\n[1] Show catalog\n" +
                                                       "[2] Create product\n" +
                                                       "[3] Change price\n" +
                                                       "[4] Change quantity\n" +
                                                       "[0] EXIT \n");
                                    int n = reader.nextInt();
                                    if(n == 0)
                                        System.exit(0);
                                    else
                                    con.get(n - 1).execute();
                    }
                }
                else if(usertype.equals("customer")){
                    while(loop){
                            Scanner reader = new Scanner(System.in);  // Reading from System.in
                                    System.out.println("\n\n[1] Show catalog\n" +
                                                       "[2] Add Product to cart\n" +
                                                       "[3] View cart\n" +
                                                       "[4] PAY\n" +
                                                       "[0] EXIT \n");
                                    int n = reader.nextInt();
                                    if(n == 0)
                                        System.exit(0);
                                    else
                                    con2.get(n - 1).execute();
                    }
                }
    }
				
	public static void editTextFile(Store shop, String id, double price){
		String catalogTextFile = "test/" + shop.getName() + "catalog.txt";
		ArrayList<Product> catalog = shop.getCatalog();
		ArrayList<String> contents = new ArrayList<String>();				
		String line;
		try{
			FileReader fr = new FileReader(catalogTextFile);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null)
					contents.add(line);
			br.close();
			fr.close();
		}
		catch(FileNotFoundException e) { }
		catch(IOException a) { }
		
		for(int i = 0; i < contents.size(); i++){
			if((contents.get(i)).startsWith(id)){
				int startPosition = ordinalIndexOf((contents.get(i)), ",", 2);
				int endPosition = ordinalIndexOf((contents.get(i)), ",", 3);
				String newLine = (contents.get(i)).substring(0,startPosition);
				newLine += "," + price;
				newLine += (contents.get(i)).substring(endPosition);
				contents.set(i, newLine);				
			}
		}
		writeToFile(shop, contents);
	}
	
	public static void editTextFile(Store shop, String id, int quantity){
		String catalogTextFile = "test/" + shop.getName() + "catalog.txt";
		ArrayList<Product> catalog = shop.getCatalog();
		ArrayList<String> contents = new ArrayList<String>();
		String line;
		try{
			FileReader fr = new FileReader(catalogTextFile);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) 
					contents.add(line);
			br.close();
			fr.close();
		}
		catch(FileNotFoundException e) { }
		catch(IOException a) { }
		
		for(int i = 0; i < contents.size(); i++){
			if((contents.get(i)).startsWith(id)){
				int startPosition = ordinalIndexOf(contents.get(i), ",", 3);
				String newLine = (contents.get(i)).substring(0, startPosition);
				newLine += "," + quantity;
				contents.set(i, newLine);
			}
		}
		writeToFile(shop, contents);
	}
	
	public static void writeToFile(Store shop, ArrayList<String> contents){
		String catalogTextFile = "test/" + shop.getName() + "catalog.txt";
		try{
			FileWriter fw = new FileWriter(catalogTextFile);
			PrintWriter pw = new PrintWriter(fw);
			for(int i = 0; i < contents.size(); i++){
				pw.println(contents.get(i));
			}
			pw.close();
			fw.close();
		}
		catch(IOException e) {}
	}
	
	public static int ordinalIndexOf(String str, String substr, int n) {
		int pos = str.indexOf(substr);
		String sub;
		for(int i = 1; i < n; i++){
			sub = str.substring(pos+1);
			pos += sub.indexOf(substr) + 1;
		}
		return pos;
	}
				
	public static boolean checkIfIDExists(String id, Store shop){
		ArrayList<Product> catalog = shop.getCatalog();
		for(int i = 0; i < catalog.size(); i++){
			if((catalog.get(i)).getProdID().equals(id))
				return true;
		}
		return false;
	}	
        
        public static boolean checkIfNameExists(String name, Store shop){
		ArrayList<Product> catalog = shop.getCatalog();
		for(int i = 0; i < catalog.size(); i++){
			if((catalog.get(i)).getProdName().equals(name))
				return true;
		}
		return false;
	}	
	
	public static Product requestProdID(String id, Store shop){
		ArrayList<Product> catalog = shop.getCatalog();
		for(int i = 0; i < catalog.size(); i++){
			if((catalog.get(i)).getProdID().equals(id))
				return catalog.get(i);
		}
		return null;
	}
        
        public static Product requestProdName(String name, Store shop){
		ArrayList<Product> catalog = shop.getCatalog();
		for(int i = 0; i < catalog.size(); i++){
			if((catalog.get(i)).getProdName().equals(name))
				return catalog.get(i);
		}
		return null;
	}
	
	public static Product createNewItem(String lastID){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
			
		System.out.print("Product name: ");
		String n = reader.nextLine();
		System.out.print("Price (0 for default): ");
		double p = reader.nextDouble();
		System.out.print("Quantity (0 for default): ");
		int q = reader.nextInt();
			
		int id = Integer.parseInt(lastID)+1;
		String idS = Integer.toString(id);
		Product newItem = new Product.ProductBuilder(idS, n).price(p).quantity(q).build(); // Create product
		return newItem;
	}
		
	public static double changePrice(Product p){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		System.out.print("New price: ");
		double price = reader.nextDouble();
		p.changePrice(price);
		return price;
	}
		
	public static int changeQuantity(Product p){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		System.out.print("New quantity: ");
		int quantity = reader.nextInt();
		p.changeQuantity(quantity);
		return quantity;
	}
		
	public static void printCatalog(Store shop){
		ArrayList<Product> catalog = shop.getCatalog(); 											 // load in the catalog
		System.out.println( "@@@@@@@@@@@@ " + shop.getName() + " CATALOG @@@@@@@@@@@");
		for(int i = 0 ; i < catalog.size() ; i++){													 // print catalog
			Product product = catalog.get(i);
			System.out.printf("%-25s", (i+1) + ": " + product.getProdName());
			System.out.printf("%10s", " $");
			System.out.printf("%.2f\n", product.getProdPrice());
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
}