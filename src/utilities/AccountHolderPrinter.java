package utilities;

import classes.secured.AccountHolder;
import interfaces.Printable;

public class AccountHolderPrinter implements Printable {

    private AccountHolder holder;

    public AccountHolderPrinter(AccountHolder holder) {
        this.holder = holder;
    }

    @Override
    public void print(){
        System.out.println("Name: " + holder.getName());
    }
}
