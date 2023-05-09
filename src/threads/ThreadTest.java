package threads;

import classes.AutomatedTellerMachine;
import classes.secured.BankAccount;
import customexceptions.InsufficientBalanceException;
import customexceptions.WithdrawalLimitExceededException;


public class ThreadTest implements Runnable {

    private BankAccount account;
    private AutomatedTellerMachine atmInstance;

    public ThreadTest(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {

        atmInstance = AutomatedTellerMachine.getInstance();

        try {
            atmInstance.insertCard(account);
            atmInstance.acceptWithdrawal(5000);
            atmInstance.printReceipt();

            Thread.sleep(5000);
        } catch (WithdrawalLimitExceededException | InsufficientBalanceException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
