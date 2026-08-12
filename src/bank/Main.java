package bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Bank bank = new Bank();
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while(running){

            System.out.println("\n--------Bank System Menu --------");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Find Account");
            System.out.println("6. Remove Account");
            System.out.println("7. Exit");

            int choice = in.nextInt();
            in.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Account Number : ");
                    String accountNumber = in.nextLine();
                    System.out.println("Enter Account Holder Name : ");
                    String name = in.nextLine();
                    System.out.println("Enter initial deposit : ");
                    double amount = in.nextDouble();
                    in.nextLine();
                    bank.addAccount(new BankAccount(accountNumber, name, amount));
                    break;

                case 2:
                    System.out.println("Enter Account Number");
                    accountNumber = in.nextLine();
                    BankAccount accountToDeposit = bank.findAccount(accountNumber);
                    if(accountToDeposit != null) {
                        System.out.println("Enter deposit amount : ");
                        amount = in.nextDouble();
                        in.nextLine();
                        accountToDeposit.deposit(amount);
                    }
                    break;

                case 3:
                    System.out.println("Enter Account Number");
                    accountNumber = in.nextLine();
                    BankAccount accountToWithdraw = bank.findAccount(accountNumber);
                    if(accountToWithdraw != null) {
                        System.out.println("Enter withdrawl amount : ");
                        amount = in.nextDouble();
                        in.nextLine();
                        accountToWithdraw.withdraw(amount);
                    }
                    break;

                case 4:
                    System.out.println("Enter sender account number : ");
                    String senderAccountNumber = in.nextLine();
                    System.out.println("Enter reciever account number : ");
                    String recieverAccountNumber = in.nextLine();
                    System.out.println("Enter transfer amount : ");
                    amount = in.nextDouble();
                    in.nextLine();
                    bank.transfer(senderAccountNumber, recieverAccountNumber, amount);
                    break;

                case 5:
                    System.out.println("Enter account number : ");
                    accountNumber = in.nextLine();
                    BankAccount account = bank.findAccount(accountNumber);
                    if(account != null){
                        System.out.println("Current balance : " + account.getBalance());
                    }
                    break;

                case 6:
                    System.out.println("Enter account number : ");
                    accountNumber = in.nextLine();
                    bank.removeAccount(accountNumber);
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting System");
                    break;

                default:
                    System.out.println("Invalid Option. Please try again");
            }
        }
        in.close();

    }
}