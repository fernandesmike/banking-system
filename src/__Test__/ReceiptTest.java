package __Test__;

import classes.TransactionReceipt;
import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import classes.secured.BankAccountTransaction;
import customexceptions.BalanceLimitExceededException;
import customexceptions.DepositLimitExceededException;
import enums.TransactionType;
import utilities.AccountHolderPrinter;
import utilities.BankAccountPrinter;

public class ReceiptTest {
    public static void main(String[] args) {

        AccountHolder newAccount = new AccountHolder("James", 6000);
        AccountHolderPrinter holderPrinter = new AccountHolderPrinter(newAccount);
        BankAccountPrinter accountPrinter = new BankAccountPrinter(newAccount.getAccount());
        BankAccount account = newAccount.getAccount();

        holderPrinter.print();
        accountPrinter.print();

        // Transactions
        BankAccountTransaction transaction = new BankAccountTransaction(account);

        try {
            transaction.deposit(4000);
            System.out.println("Balance: " + account.getBalance());
        } catch (DepositLimitExceededException | BalanceLimitExceededException err) {
            System.out.println(err.getMessage());
        }

        System.out.println(account.getBalance());

        TransactionReceipt receipt = new TransactionReceipt(account, 4000, TransactionType.DEPOSIT);


    }
}
