package utilities;

import classes.secured.BankAccount;
import interfaces.Printable;

public class BankAccountPrinter implements Printable {

    private BankAccount account;

    public BankAccountPrinter(BankAccount account){
        this.account = account;
    }

    @Override
    public void print(){
        System.out.println("Account holder  : " + account.getHolder().getName());
        System.out.println("Account balance : " + account.getBalance());
    }

}
