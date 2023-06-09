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

        AccountHolder accountHolder = new AccountHolder("Andrew", 3000);
        BankAccount account = accountHolder.getAccount();

        TransactionReceipt receipt = null;
        ReceiptPrinter receiptPrinter = null;

        AutomatedTellerMachine atm = AutomatedTellerMachine.getInstance();

        System.out.println(atm.toString());
        atm.insertCard(account);
        atm.printAccountInfo();

    }
}
