package classes;

import classes.secured.BankAccount;

public class AccountHolder {

    private String name;
    private final BankAccount account;

    public AccountHolder(String name){
        this.name = name;
        this.account = new BankAccount(this, 0.00);
    }

    public AccountHolder(String name, double balance){
        this.name = name;
        this.account = new BankAccount(this, balance);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return  name;
    }

    public BankAccount getAccount(){
        return this.account;
    }
}
