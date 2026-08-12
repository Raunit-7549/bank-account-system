package bank;

public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance){

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount){

        if(amount > 0){
            balance += amount;
            System.out.println(amount + " is deposited");
        } else {
            System.out.println("Enter a valid amount");
        }
    }

    public void withdraw(double amount){

        if(amount > 0 && balance >= amount){
            balance -= amount;
            System.out.println(amount + " is withdrawn");
        } else {
            System.out.println("Enter a valid amount");
        }
    }

    public double getBalance(){

        return balance;
    }

    public String getAccountNumber(){

        return accountNumber;
    }
}