package classstructureintegrate;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("What is the number of the first account?");
        String accountNumber = scn.nextLine();
        System.out.println("What is the name of the owner?");
        String owner = scn.nextLine();
        System.out.println("How much money is in the bank account?");
        int amount = scn.nextInt();
        scn.nextLine();

        BankAccount account1 = new BankAccount(accountNumber,owner,amount);

        System.out.println("What is the number of the second account?");
        accountNumber = scn.nextLine();
        System.out.println("What is the name of the owner?");
        owner = scn.nextLine();
        System.out.println("How much money is in the bank account?");
        amount = scn.nextInt();
        scn.nextLine();

        BankAccount account2 = new BankAccount(accountNumber,owner,amount);

        System.out.println("Account1: " + account1.getInfo());
        System.out.println("Account2: " + account2.getInfo());

        System.out.println("How much money do you like to deposit in the account1?");
        amount = scn.nextInt();
        scn.nextLine();
        account1.deposit(amount);

        System.out.println("Account1: " + account1.getInfo());

        System.out.println("How much money do you like to withdraw from the account2?");
        amount = scn.nextInt();
        scn.nextLine();
        account2.withdraw(amount);

        System.out.println("Account2: " + account2.getInfo());

        System.out.println("How much money do you like to transfer from account1 to account2?");
        amount = scn.nextInt();
        scn.nextLine();
        account1.transfer(account2,amount);

        System.out.println("Account1: " + account1.getInfo());
        System.out.println("Account2: " + account2.getInfo());


    }
}
