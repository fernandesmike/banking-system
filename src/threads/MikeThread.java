package threads;

import classes.AutomatedTellerMachine;
import classes.secured.BankAccount;
import customexceptions.InsufficientBalanceException;
import customexceptions.WithdrawalLimitExceededException;

public class MikeThread implements Runnable {

    private AutomatedTellerMachine atmInstance;
    private BankAccount account;

    public MikeThread(AutomatedTellerMachine atmInstance, BankAccount account){
        this.atmInstance = atmInstance;
        this.account = account;
    }

    @Override
    public void run() {
        atmInstance.insertCard(account);
        try {
            atmInstance.acceptWithdrawal(3000);
        } catch (WithdrawalLimitExceededException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
