package bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account){

        if(account == null){
            System.out.println("Cannot add a null account");
            return;
        }

        if(accounts.containsKey(account.getAccountNumber())){
            System.out.println("Account already added");
            return;
        }

        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account with account number : " + account.getAccountNumber() + " is added");
    }

    public void removeAccount(String accountNumber){

        if(accounts.containsKey(accountNumber)){

            accounts.remove(accountNumber);
            System.out.println("Account with account number : " + accountNumber + " is removed");
        } else {
            System.out.println("Account does not exist");
        }
    }

    public BankAccount findAccount(String accountNumber){

        if(accounts.containsKey(accountNumber)){
            System.out.println("Account found");
            return accounts.get(accountNumber);
        } else {
            System.out.println("Account not found");
            return null;
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount){

        if(accounts.containsKey(fromAccountNumber) == false){
            System.out.println("Account with account number : " + fromAccountNumber + " does not exist");
            return;
        }
        if(accounts.containsKey(toAccountNumber) == false){
            System.out.println("Account with account number : " + toAccountNumber + " does not exist");
            return;
        }

        BankAccount sender = accounts.get(fromAccountNumber);
        BankAccount reciever = accounts.get(toAccountNumber);

        if(amount > 0 && sender.getBalance() >= amount) {
            sender.withdraw(amount);
            reciever.deposit(amount);
            System.out.println(amount + " is sent from account number : " + fromAccountNumber + " to account number : " + toAccountNumber);
        } else {
            System.out.println("Enter a valid amount");
        }
    }
}