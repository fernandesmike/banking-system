package threads;

import classes.AutomatedTellerMachine;
import classes.secured.BankAccount;

import java.util.concurrent.locks.ReentrantLock;

public class AtmThread implements Runnable {

    private final ReentrantLock atmLock = new ReentrantLock();
    private BankAccount account;

    public AtmThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {

        atmLock.lock();

        AutomatedTellerMachine atm = AutomatedTellerMachine.getInstance();

        atmLock.unlock();
    }
}
