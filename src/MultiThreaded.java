import classes.AutomatedTellerMachine;
import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import customexceptions.InsufficientBalanceException;
import customexceptions.WithdrawalLimitExceededException;
import threads.AtmThread;
import threads.AtmUserThread;
import threads.ThreadTest;
import utilities.AccountHolderPrinter;
import utilities.BankAccountPrinter;

import java.awt.*;
import java.sql.SQLOutput;

public class MultiThreaded {
    public static void main(String[] args) {
        /*
        *   TODO:
        *
        *   Create multiple account holders
        *   Create multiple threads
        *   The ATM should be on the main Thread
        *
        *   And assign account holders to their corresponding threads
        *   Those threads should contain BankAccount instances
        *   Use those BankAccount instance to pass to the insertCard() method of the ATM
        *
        *   ATM MUST BE SYNCHRONIZED!
        *
        *   So that it can only perform operations one at a time to each threads
        * */

        // Account holders
        AccountHolder mike = new AccountHolder("Mike", 15000);
        AccountHolder james = new AccountHolder("James", 25000);

        // Bank accounts
        BankAccount mikeAcc = mike.getAccount();
        BankAccount jamesAcc = james.getAccount();

        // Threads
        ThreadTest mikeRunnable = new ThreadTest(mikeAcc);
        ThreadTest jamesRunnable = new ThreadTest(jamesAcc);

        Thread threadMike = new Thread(mikeRunnable);
        Thread threadJames = new Thread(jamesRunnable);

        System.out.println("MAIN THREAD STARTED!\n");

        threadMike.start();
        threadJames.start();
    }
}
