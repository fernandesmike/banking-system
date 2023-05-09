import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import threads.AtmUserThread;
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
        AccountHolder joshua = new AccountHolder("Joshua", 20000);
        AccountHolder reymar = new AccountHolder("Reymar", 25000);

        // Bank accounts
        BankAccount mikeAcc = mike.getAccount();
        BankAccount jamesAcc = james.getAccount();
        BankAccount joshuaAcc = joshua.getAccount();
        BankAccount reymarAcc = reymar.getAccount();

        // Threads
        Thread threadMike = new Thread(new AtmUserThread(mikeAcc));
        Thread threadJames = new Thread(new AtmUserThread(jamesAcc));
        Thread threadJoshua = new Thread(new AtmUserThread(joshuaAcc));
        Thread threadReymar = new Thread(new AtmUserThread(reymarAcc));


        System.out.println("MAIN THREAD STARTED!\n");


        AccountHolderPrinter holderPrinter = new AccountHolderPrinter(jamesAcc.getHolder());
        BankAccountPrinter accountPrinter = new BankAccountPrinter(james.getAccount());

        System.out.println("User details");
        holderPrinter.print();

        System.out.println("\nAccount details");
        accountPrinter.print();

        threadMike.start();

//        threadJames.start();
//        threadJoshua.start();
//        threadReymar.start();
    }
}
