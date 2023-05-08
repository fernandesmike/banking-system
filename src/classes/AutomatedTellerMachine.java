package classes;

import classes.secured.BankAccount;
import interfaces.AtmOperations;

public class AutomatedTellerMachine implements AtmOperations {

    /*
    *   An Object representation of an actual ATM which performs basic transaction operations
    *   such as Deposit, Withdrawals, Printing account info, and Generating transaction receipts
    * */

    private BankAccount account;

    @Override
    public void acceptDeposit(double amount) {

    }

    @Override
    public void acceptWithdrawal(double amount) {

    }

    @Override
    public  void printAccountInfo(BankAccount account) {

    }
}
