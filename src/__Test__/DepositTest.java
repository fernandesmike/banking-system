package __Test__;

import classes.*;
import classes.secured.*;
import customexceptions.*;
import utilities.*;


public class DepositTest {
    public static void main(String[] args) {

        AccountHolder testHolder = new AccountHolder("Mike Andrew");
        AccountHolderPrinter holderPrinter = new AccountHolderPrinter(testHolder);
        BankAccountPrinter accountPrinter = new BankAccountPrinter(testHolder.getAccount());
        BankAccount account = testHolder.getAccount();

        holderPrinter.print();
        accountPrinter.print();

        // Transactions
        BankAccountTransaction transaction = new BankAccountTransaction(account);

        // Withdrawing

        // Depositing
        try {
            transaction.deposit(9000);
        } catch (DepositLimitExceededException | BalanceLimitExceededException err) {
            System.out.println(err.getMessage());
        }

        System.out.println("New balance: " + account.getBalance());

        for (int i = 0; i < 9; i++ ){
            try {
                transaction.deposit(10000);
            } catch (DepositLimitExceededException | BalanceLimitExceededException err) {
                System.out.println(err.getMessage());
            }
        }

        System.out.println("New balance: " + account.getBalance());

        try {
            transaction.deposit(1001);
        } catch (DepositLimitExceededException | BalanceLimitExceededException err) {
            System.out.println(err.getMessage());
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
