package __Test__;

import classes.*;
import classes.secured.*;
import customexceptions.*;
import utilities.*;


public class WithdrawTest {
    public static void main(String[] args) {

        AccountHolder testHolder = new AccountHolder("Mike Andrew");
        AccountHolderPrinter holderPrinter = new AccountHolderPrinter(testHolder);
        BankAccountPrinter accountPrinter = new BankAccountPrinter(testHolder.getAccount());
        BankAccount account = testHolder.getAccount();

        holderPrinter.print();
        accountPrinter.print();

        // Transactions
        BankAccountTransaction transaction = new BankAccountTransaction(account);

        // Deposit first
        try {
            transaction.deposit(4000);
            System.out.println("Balance: " + account.getBalance());
        } catch (DepositLimitExceededException | BalanceLimitExceededException err) {
            System.out.println(err.getMessage());
        }

        // Withdrawing
        try {
            transaction.withdraw(4001);
        } catch (WithdrawalLimitExceededException | InsufficientBalanceException err) {
            System.out.println(err.getMessage());
        }

        System.out.println("New balance: " + account.getBalance());


    }
}

