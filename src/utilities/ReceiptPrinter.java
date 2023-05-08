package utilities;

import classes.TransactionReceipt;
import enums.TransactionType;
import interfaces.Printable;

public class ReceiptPrinter implements Printable {

    private final TransactionReceipt receipt;

    public ReceiptPrinter(TransactionReceipt receipt) { this.receipt = receipt; }

    @Override
    public void print(){
        System.out.println("======== TRANSACTION DETAILS ========");
        System.out.println(receipt.generateTransacId());
        System.out.println(receipt.generateTimestamp());

        if (receipt.getTransactionType() == TransactionType.DEPOSIT) {
            System.out.println(generateDepositContents());
        }

        else if (receipt.getTransactionType() == TransactionType.WITHDRAW) {
            System.out.println(generateWithdrawContents());
        }
    }

    private String generateDepositContents(){
        return String.format("""
                =====================================
                Transaction type  : ACCOUNT %s\s
                Deposit amount    : %.2f
                Original balance  : %.2f
                New balance       : %.2f
                =====================================""", receipt.getTransactionType().toString(), receipt.getAmount(), receipt.getOriginalBalance(), receipt.getNewBalance());
    }

    private String generateWithdrawContents(){
        return String.format("""
                =====================================
                Transaction type  : ACCOUNT %s\s
                Withdraw amount   : %.2f
                Original balance  : %.2f
                New balance       : %.2f
                =====================================""", receipt.getTransactionType().toString(), receipt.getAmount(), receipt.getOriginalBalance(), receipt.getNewBalance());
    }
}
