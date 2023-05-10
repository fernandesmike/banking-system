package threads;

import classes.AutomatedTellerMachine;
import classes.secured.BankAccount;
import customexceptions.InsufficientBalanceException;
import customexceptions.WithdrawalLimitExceededException;

import java.util.Random;


public class ThreadTest implements Runnable {

    private BankAccount account;
    private AutomatedTellerMachine atmInstance;

    public ThreadTest(BankAccount account, AutomatedTellerMachine atmInstance) {
        this.account = account;
        this.atmInstance = atmInstance;
    }

    @Override
    public void run() {
        try {
            System.out.println( account.getHolder().getName() + " used ATM : " + atmInstance.toString());
            Thread.sleep(1500);
            atmInstance.insertCard(account);
            atmInstance.acceptWithdrawal(4000);
            atmInstance.printReceipt();
            System.out.println("\nLeaving ATM\n");
            Thread.sleep(5000);
        } catch (InterruptedException | WithdrawalLimitExceededException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
