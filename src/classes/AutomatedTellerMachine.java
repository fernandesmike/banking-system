package classes;

import classes.secured.BankAccount;
import classes.secured.BankAccountTransaction;
import customexceptions.*;
import interfaces.AtmOperations;
import utilities.AccountHolderPrinter;

public class AutomatedTellerMachine implements AtmOperations {

    /*  TODO:
    *   Make ATM a Singleton
    * */

    private TransactionReceipt receipt;
    private final BankAccountTransaction transaction;
    private final BankAccount account;

    public AutomatedTellerMachine(BankAccount account) {
        this.account = account;
        transaction = new BankAccountTransaction(this.account);
    }

    @Override
    public TransactionReceipt acceptDeposit(double amount) throws DepositLimitExceededException, BalanceLimitExceededException {

        receipt = transaction.deposit(amount);

        return  receipt;
    }

    @Override
    public TransactionReceipt acceptWithdrawal(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {

        receipt = transaction.withdraw(amount);

        return  receipt;
    }

    @Override
    public  void printAccountInfo() {

        AccountHolderPrinter printer = new AccountHolderPrinter(this.account.getHolder());
        printer.print();
    }
}
