/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import store.Product;
import static store.Sahara.ordinalIndexOf;
import store.Store;

/**
 *
 * @author Mark
 */
public class Data {

    
    
    
    public Data()
    {
        
    }
    
    /**
     *
     * @param shop
     * @param catalog
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void populateStore(Store shop, String catalog) throws FileNotFoundException, IOException
    {
     String line = null;
            
           FileReader fr = new FileReader(catalog);
           BufferedReader br = new BufferedReader(fr);
           String[] splitPart = new String[4];
           String pid = "999", pname;
        double pprice;
        int pqty;
        
            while ((line = br.readLine()) != null) {
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
    
    public void editTextFile(Store shop, String id, double price) {
        
        ArrayList<String> contents = new ArrayList<>();
        String line;
        try {
            FileReader fr = new FileReader(shop.getFile());
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
        } catch (IOException a) {
        }

        for (int i = 0; i < contents.size(); i++) {
            if ((contents.get(i)).startsWith(id)) {
                int startPosition = ordinalIndexOf((contents.get(i)), ",", 2);
                int endPosition = ordinalIndexOf((contents.get(i)), ",", 3);
                String newLine = (contents.get(i)).substring(0, startPosition);
                newLine += "," + price;
                newLine += (contents.get(i)).substring(endPosition);
                contents.set(i, newLine);
            }
        }
        writeToFile(shop, contents);
    }
    
     public void editTextFile(Store shop,  String id, int quantity) {
         
        ArrayList<String> contents = new ArrayList<>();
        String line;
        try {
            FileReader fr = new FileReader(shop.getFile());
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
        } catch (IOException a) {
        }

        for (int i = 0; i < contents.size(); i++) {
            if ((contents.get(i)).startsWith(id)) {
                int startPosition = ordinalIndexOf(contents.get(i), ",", 3);
                String newLine = (contents.get(i)).substring(0, startPosition);
                newLine += "," + quantity;
                contents.set(i, newLine);
            }
        }
        writeToFile(shop, contents);
    }

    private void writeToFile(Store shop, ArrayList<String> contents) {
        try {
            FileWriter fw = new FileWriter(shop.getFile());
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < contents.size(); i++) {
                pw.println(contents.get(i));
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
        }
    }
    
    private void writeToUserfile(String userfile, ArrayList<String> usernamelist){
        try {
            FileWriter fw = new FileWriter(userfile);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < usernamelist.size(); i++) {
                pw.println(usernamelist.get(i));
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
        }
    }
    
    public void register(String username, String fileName){
        
        try{
		
		FileWriter fw = new FileWriter(fileName, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(username + ",0");
		pw.close();
		fw.close();                
		}
		catch(IOException e) {}
    }
    
    public void changeUserLevel(String username, int level){
        ArrayList<String> usernamelist = new ArrayList<String>();
	String usernameFile = "test/usernames.txt";
		try{
			// read in the list of usernames
			String line = null;
			FileReader fr = new FileReader (usernameFile);
			BufferedReader br = new BufferedReader (fr);
			while((line = br.readLine()) != null){
				usernamelist.add(line);
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException e) { }
		catch(IOException a) { }
                
        for (int i = 0; i < usernamelist.size(); i++) {
            if ((usernamelist.get(i)).startsWith(username)) {
                int startPosition = usernamelist.get(i).indexOf(",");
                String newLine = (usernamelist.get(i)).substring(0, startPosition);
                newLine += "," + level;
                usernamelist.set(i, newLine);
            }
        }
        writeToUserfile(usernameFile, usernamelist);
        System.out.println("RE-LOG IN TO APPLY YOUR MEMBERSHIP DISCOUNTS");
    }
    
    public void editQuantityInFile(Store shop, String id, int newQuantity) {
        ArrayList<String> contents = new ArrayList<>();
        String line;
        try {
            FileReader fr = new FileReader(shop.getFile());
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
        } catch (IOException a) {
        }

        for (int i = 0; i < contents.size(); i++) {
            if ((contents.get(i)).startsWith(id)) {
                int startPosition = contents.get(i).lastIndexOf(",");
                String newLine = (contents.get(i)).substring(0, startPosition);
                newLine += "," + newQuantity;
                contents.set(i, newLine);
            }
        }
        writeToFile(shop, contents);
    }
}
    
    

   
    

