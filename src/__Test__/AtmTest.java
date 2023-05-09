package __Test__;

import classes.AutomatedTellerMachine;
import classes.TransactionReceipt;
import classes.secured.AccountHolder;
import classes.secured.BankAccount;
import customexceptions.InsufficientBalanceException;
import customexceptions.WithdrawalLimitExceededException;
import utilities.ReceiptPrinter;

public class AtmTest {
    public static void main(String[] args) {

        AccountHolder accountHolder = new AccountHolder("Andrew", 15000);
        BankAccount account = accountHolder.getAccount();

        TransactionReceipt receipt = null;
        ReceiptPrinter receiptPrinter = null;

        AutomatedTellerMachine atm = new AutomatedTellerMachine(account);

        try {
           receipt = atm.acceptWithdrawal(1000);
           receiptPrinter = new ReceiptPrinter(receipt);
        } catch (WithdrawalLimitExceededException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        receiptPrinter.print();

    }
}
