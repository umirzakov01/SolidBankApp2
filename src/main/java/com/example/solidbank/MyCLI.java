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

    public double requestClientAmount(){
        System.out.println("Not yet");
        return 0;
    }

    public String requestClientAccountNumber(){
        System.out.println("Not yet");
        return "";
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
