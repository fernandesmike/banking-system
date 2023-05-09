package threads;

import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import utilities.AccountHolderPrinter;
import utilities.BankAccountPrinter;

public class AtmUserThread implements Runnable{

    private final BankAccount account;

    public AtmUserThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {

        // Access the ATM instance here
        // and perform some operations
        Thread.currentThread().setName(account.getHolder().getName());
        System.out.println( "\n" + account.getHolder().getName() + "'s THREAD STARTED!\n");

        AccountHolderPrinter holderPrinter = new AccountHolderPrinter(account.getHolder());
        BankAccountPrinter accountPrinter = new BankAccountPrinter(account);

        System.out.println("User details");
        holderPrinter.print();

        System.out.println("\nAccount details");
        accountPrinter.print();
    }
}
