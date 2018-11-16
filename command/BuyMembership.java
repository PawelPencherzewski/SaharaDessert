/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import data.Data;
import java.util.ArrayList;
import java.util.Scanner;
import payment.PaymentType;
import payment.bitcoin;
import payment.bitcoinPay;
import payment.creditCard;
import payment.creditCardPay;
import receipt.ChainPatternDemo;
import user.ScanForExistingUser;

public class BuyMembership implements Command {
    String usernamename;
    int userlevel;
    
    public BuyMembership(String usernamename, int userlevel){
        this.usernamename = usernamename;
        this.userlevel = userlevel;
    }
    
    @Override
    public void execute(){
        int userlevel = ScanForExistingUser.returnType(usernamename);
        String level = "";
        
        if(userlevel == 0){
            level = "Basic";
            System.out.println("Your current membership is: " + level);
            System.out.println("[1] Buy GOLD rank only for ...... $20!");
            System.out.println("[2] Buy PLATINUM rank only for .. $50!");
            System.out.println("[0] Back");
            System.out.println("");
            Scanner reader = new Scanner(System.in);
            int option = reader.nextInt();
            if(option == 1){
                payForMembership(20.00, "GOLD");
                Data d = new Data();
                d.changeUserLevel(usernamename, 1);
            }
            else if(option == 2){
                payForMembership(50.00, "PLATINUM");
                Data d = new Data();
                d.changeUserLevel(usernamename, 2);
            }
            else if(option == 0)
                return;
        }
        else if(userlevel == 1){
            level = "GOLD";
            System.out.println("Your current membership is: " + level);
            System.out.println("[1] Buy PLATINUM rank only for .. $50!");
            System.out.println("[0] Back");
            System.out.println("");
            Scanner reader = new Scanner(System.in);
            int option = reader.nextInt();
            if(option == 1){
                payForMembership(50.00, "PLATINUM");
                Data d = new Data();
                d.changeUserLevel(usernamename, 2);
            }
            else if(option == 0)
                return;
        }
        else if(userlevel == 2){
            level = "PLATINUM";
            System.out.println("Your current membership is: " + level);
            System.out.println("You can't upgrade your membership");
            System.out.println("[0] Back");
            System.out.println("");
            Scanner reader = new Scanner(System.in);
            int option = reader.nextInt();
            if(option == 0)
                return;
        }
        return;
    }
    
    public void payForMembership(double totalPrice, String boughtType)
    {
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.print("PAY USING: \n[1] Bitcoin\n[2] Credit Card\n");
        String n = reader.nextLine();
        if (n.equals("1")){
                System.out.print("Bitcoin Wallet Number: ");
                int nr = reader.nextInt();
		PaymentType bitcoin = new bitcoin(new bitcoinPay(), "Bitcoin");
		bitcoin.applyPay();
                ChainPatternDemo.printReceipt(usernamename, totalPrice, boughtType);
        }
        else if(n.equals("2")){
                System.out.print("Credit Cart Number: ");
                int nr = reader.nextInt();
		PaymentType card = new creditCard(new creditCardPay(), "Credit Card");
		card.applyPay();
                ChainPatternDemo.printReceipt(usernamename, totalPrice, boughtType);
        }
        else
            System.out.println("invalid method of payment seelcted");
    }
}
