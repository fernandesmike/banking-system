package utilities;

import classes.TransactionReceipt;
import enums.TransactionType;
import interfaces.Printable;

public class ReceiptPrinter implements Printable {

    private final TransactionReceipt receipt;

    public ReceiptPrinter(TransactionReceipt receipt) { this.receipt = receipt; }

    @Override
    public void print(){
        System.out.println("=========================");
        receipt.generateTransacId();
        receipt.generateTimestamp();

        if (receipt.getTransactionType() == TransactionType.DEPOSIT) {
            generateDepositContents();
        }

        else if (receipt.getTransactionType() == TransactionType.WITHDRAW) {
            generateWithdrawContents();
        }
    }

    private String generateDepositContents(){
        return String.format("==================================" +
                "Transaction type  : ACCOUNT %s " +
                "Deposit amount    : %.2f" +
                "New balance       : %.2f" , receipt.getTransactionType().toString(), receipt.getAmount(), receipt.getNewBalance());
    }

    private String generateWithdrawContents(){
        return String.format("==================================" +
                "Transaction type  : ACCOUNT %s " +
                "Withdraw amount   : %.2f" +
                "New balance       : %.2f" , receipt.getTransactionType().toString(), receipt.getAmount(), receipt.getNewBalance());
    }
}
