package threads;

import classes.AutomatedTellerMachine;
import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import customexceptions.InsufficientBalanceException;
import customexceptions.WithdrawalLimitExceededException;
import utilities.AccountHolderPrinter;
import utilities.BankAccountPrinter;

public class AtmUserThread implements Runnable{

    private final BankAccount account;
    private final AutomatedTellerMachine atmInstance;

    public AtmUserThread(BankAccount account, AutomatedTellerMachine atmInstance) {
        this.account = account;
        this.atmInstance = atmInstance;
    }

    @Override
    public void run() {

        // Access the ATM instance here
        // and perform some operations
        Thread.currentThread().setName(account.getHolder().getName());

        AccountHolderPrinter holderPrinter = new AccountHolderPrinter(account.getHolder());
        BankAccountPrinter accountPrinter = new BankAccountPrinter(account);

        atmInstance.insertCard(account);

        try {
            atmInstance.acceptWithdrawal(4000);
            atmInstance.printReceipt();
        } catch (WithdrawalLimitExceededException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
