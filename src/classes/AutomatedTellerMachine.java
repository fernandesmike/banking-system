package classes;

import classes.secured.BankAccount;
import classes.secured.BankAccountTransaction;
import customexceptions.*;
import interfaces.AtmOperations;
import utilities.AccountHolderPrinter;
import utilities.ReceiptPrinter;

import java.util.concurrent.locks.ReentrantLock;

public class AutomatedTellerMachine implements AtmOperations {

    /*  TODO:
    *   Make ATM a Singleton
    *
    *   Show menu
    *   Welcome screen
    *   Printer of receipt
    *   Transaction summary
    * */

    private TransactionReceipt receipt;
    private BankAccountTransaction transaction;
    private BankAccount account;
    private static volatile AutomatedTellerMachine instance = null;
    private final ReentrantLock atmLock = new ReentrantLock();

    private AutomatedTellerMachine(){}

    public static AutomatedTellerMachine getInstance() {
        if (instance == null) {
            synchronized (AutomatedTellerMachine.class) {
                instance = new AutomatedTellerMachine();
            }
        }
        return instance;
    }

    @Override
    public void showMenu() {
        System.out.println("""
                =================================
                            WELCOME!
                =================================
                
                What would you like to do today?
                
                1) Withdraw (max. 5,000)
                2) Deposit  (max. 10,000)
                
                =================================
                
                """);
    }

    @Override
    public void insertCard(BankAccount account) {
        try {
            atmLock.lock();
            System.out.println("Please insert your card...");
            Thread.sleep(1500);
            System.out.println("Scanning...");
            Thread.sleep(2000);
            System.out.println( "\n" + account.getHolder().getName() + "'s card has been inserted!\n");
            this.account = account;
            this.transaction = new BankAccountTransaction(account);
            System.out.println("Entering ATM. Please wait....\n");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void acceptDeposit(double amount) throws DepositLimitExceededException, BalanceLimitExceededException {
        receipt = transaction.deposit(amount);
    }

    @Override
    public void acceptWithdrawal(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {
        receipt = transaction.withdraw(amount);
    }

    @Override
    public synchronized void printAccountInfo() {
        AccountHolderPrinter printer = new AccountHolderPrinter(this.account.getHolder());
        printer.print();
    }

    @Override
    public void printReceipt() {
        if (receipt != null) {
            ReceiptPrinter receiptPrinter = new ReceiptPrinter(receipt);
            receiptPrinter.print();
        }
        else {
            System.out.println("No operation performed. Thank you for using our system!");
        }
        atmLock.unlock();
    }
}
