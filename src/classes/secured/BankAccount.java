package classes.secured;

public class BankAccount {

    private final AccountHolder holder;
    private double balance;

    protected BankAccount(AccountHolder holder, double balance ) {
        this.holder = holder;
        this.balance = balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountHolder getHolder(){
        return holder;
    }

    public double getBalance(){
        return balance;
    }

}
