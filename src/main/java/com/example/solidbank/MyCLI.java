package com.example.solidbank;

import java.util.Scanner;

public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }
    public MyCLI(Scanner scanner) {

        this.scanner = scanner;
    }

    private void tryAgain(){
        System.out.print("error, try again");
        this.scanner.next();
    }




    public double requestClientAmount(){
        System.out.println("Client amount of money");
        double amount;
        while(true){
            if(!this.scanner.hasNextDouble()){
                tryAgain();
                continue;

            }
            amount= this.scanner.nextDouble();
            if(amount<0){
                tryAgain();
                continue;
            }
            break;

        }
        this.scanner.nextLine();
        return amount;
    }

    @Override
    public double requestCLientAmount() {
        System.out.println("Enter the amount of money");
        double amount;
        while (true) {
            if (!this.scanner.hasNextDouble()) {
                tryAgain();
                continue;
            }
            amount = this.scanner.nextDouble();
            if (amount < 0) {
                tryAgain();
                continue;
            }
            break;
        }
        this.scanner.nextLine();
        return amount;
    }

    public String requestClientAccountNumber(){
        System.out.println("Client Acccount Number");
        return this.scanner.nextLine();
    }
    public String requestAccountType(){
        System.out.println("Choose AccountType \n[CHECKING,SAVING,FIXED]");
        while(true){
            String accountTypeName = this.scanner.nextLine();
            if(!accountTypeName.equals("CHECKING")&&!accountTypeName.equals("SAVING")&&!accountTypeName.equals("FIXED")){
                System.out.print("Please enter right type");
            }
            else{
                return accountTypeName;
            }
        }
    }
}
