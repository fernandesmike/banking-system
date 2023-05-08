package classes;

import classes.secured.BankAccount;
import enums.TransactionType;
import interfaces.ReceiptOperations;

// Utilities
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TransactionReceipt implements ReceiptOperations {

    private final BankAccount account;
    private final TransactionType transactionType;
    private final double amount;

    public TransactionReceipt(BankAccount account, double amount,TransactionType transactionType ) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public double getNewBalance() {
        return account.getBalance();
    }

    public TransactionType getTransactionType(){
        return transactionType;
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public String generateTimestamp(){

        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        return "Timestamp: " + date + "  " + time.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    @Override
    public String generateTransacId() {
        return "Transaction ID: " + UUID.randomUUID().toString();
    }
}
