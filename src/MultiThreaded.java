import classes.AutomatedTellerMachine;
import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import threads.ThreadTest;

import java.util.ArrayList;

public class MultiThreaded {
    public static void main(String[] args) {
        /*
        *   TODO:
        *
        *   Create multiple account ho
        * lders
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
        AccountHolder reymar = new AccountHolder("Reymar", 20000);
        AccountHolder paul = new AccountHolder("Paul", 5000);

        // Bank accounts
        BankAccount mikeAcc = mike.getAccount();
        BankAccount jamesAcc = james.getAccount();
        BankAccount reymarAcc = reymar.getAccount();
        BankAccount paulAcc = paul.getAccount();

        // Singleton ATM
        AutomatedTellerMachine atmInstance = AutomatedTellerMachine.getInstance();

        // Runnable instances
        ThreadTest mikeRunnable = new ThreadTest(mikeAcc, atmInstance);
        ThreadTest jamesRunnable = new ThreadTest(jamesAcc, atmInstance);
        ThreadTest reymarRunnable = new ThreadTest(reymarAcc, atmInstance);
        ThreadTest paulRunnable = new ThreadTest(paulAcc, atmInstance);

        // Threads
        Thread threadMike = new Thread(mikeRunnable);
        Thread threadJames = new Thread(jamesRunnable);
        Thread threadReymar = new Thread(reymarRunnable);
        Thread threadPaul = new Thread(paulRunnable);

        System.out.println("MAIN THREAD STARTED!\n");

        atmInstance.showMenu();

        threadMike.start();
        threadJames.start();
        threadPaul.start();
        threadReymar.start();
    }
}
