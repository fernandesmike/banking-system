package interfaces;

import classes.secured.BankAccount;
import customexceptions.*;

public interface AtmOperations {
    void showMenu();
    void insertCard(BankAccount account);

    void acceptDeposit(double amount) throws DepositLimitExceededException, BalanceLimitExceededException;

    void acceptWithdrawal(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException;

    void printAccountInfo();
    void printReceipt();
}
