package classes;

import classes.secured.BankAccount;
import classes.secured.BankAccountTransaction;
import customexceptions.*;
import interfaces.AtmOperations;
import utilities.AccountHolderPrinter;
import utilities.ReceiptPrinter;

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
    private static AutomatedTellerMachine instance = null;

    private AutomatedTellerMachine(){}

    public static synchronized AutomatedTellerMachine getInstance() {
        if (instance == null) {
            instance = new AutomatedTellerMachine();
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
                
                Please insert your card...
                
                =================================
                """);
    }

    @Override
    public synchronized void insertCard(BankAccount account) {
        System.out.println( "\n" + account.getHolder().getName() + "'s card has been inserted!\n");
        this.account = account;
        this.transaction = new BankAccountTransaction(account);
    }

    @Override
    public synchronized void acceptDeposit(double amount) throws DepositLimitExceededException, BalanceLimitExceededException {
        receipt = transaction.deposit(amount);
    }

    @Override
    public synchronized void acceptWithdrawal(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {
        receipt = transaction.withdraw(amount);
    }

    @Override
    public synchronized void printAccountInfo() {
        AccountHolderPrinter printer = new AccountHolderPrinter(this.account.getHolder());
        printer.print();
    }

    @Override
    public synchronized void printReceipt() {
        if (receipt != null) {
            ReceiptPrinter receiptPrinter = new ReceiptPrinter(receipt);
            receiptPrinter.print();
        }
        else {
            System.out.println("No operation performed. Thank you for using our system!");
        }
    }
}
