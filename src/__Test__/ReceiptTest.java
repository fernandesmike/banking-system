package __Test__;

import classes.TransactionReceipt;
import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import classes.secured.BankAccountTransaction;
import customexceptions.BalanceLimitExceededException;
import customexceptions.DepositLimitExceededException;
import customexceptions.InsufficientBalanceException;
import customexceptions.WithdrawalLimitExceededException;
import enums.TransactionType;
import utilities.AccountHolderPrinter;
import utilities.BankAccountPrinter;
import utilities.ReceiptPrinter;

public class ReceiptTest {
    public static void main(String[] args) {

        AccountHolder newAccount = new AccountHolder("James", 5000);
        AccountHolder newAccountB = new AccountHolder("Mike", 4000);

        AccountHolderPrinter holderPrinter = new AccountHolderPrinter(newAccount);
        AccountHolderPrinter holderPrinterB = new AccountHolderPrinter(newAccountB);

        BankAccountPrinter accountPrinter = new BankAccountPrinter(newAccount.getAccount());
        BankAccountPrinter accountPrinterB = new BankAccountPrinter(newAccountB.getAccount());

        BankAccount account = newAccount.getAccount();
        BankAccount accountB = newAccountB.getAccount();

        TransactionReceipt withdrawReceipt = null;
        TransactionReceipt depositReceipt = null;

        holderPrinter.print();
        accountPrinter.print();
        System.out.println();
        holderPrinterB.print();
        accountPrinterB.print();
        System.out.println();

        // Transactions
        BankAccountTransaction transaction = new BankAccountTransaction(account);
        BankAccountTransaction transactionB = new BankAccountTransaction(accountB);
        BankAccountTransaction transactionC = new BankAccountTransaction(accountB);

        try {
            withdrawReceipt = transaction.withdraw(1000);
        } catch (WithdrawalLimitExceededException | InsufficientBalanceException err) {
            System.out.println(err.getMessage());
        }

        try {
            depositReceipt = transactionB.deposit(5000);
        } catch (DepositLimitExceededException | BalanceLimitExceededException err) {
            System.out.println(err.getMessage());
        }


        ReceiptPrinter receiptPrinterA = new ReceiptPrinter(depositReceipt);
        ReceiptPrinter receiptPrinterB = new ReceiptPrinter(withdrawReceipt);

        receiptPrinterB.print();
        System.out.println("\n");
        receiptPrinterA.print();

        System.out.println();

        TransactionReceipt r = null;
        ReceiptPrinter p = null;

        try {
            r = transactionB.withdraw(1000);
            p = new ReceiptPrinter(r);
        } catch (WithdrawalLimitExceededException | InsufficientBalanceException err) {
            System.out.println(err.getMessage());
        }

        p.print();
    }
}
