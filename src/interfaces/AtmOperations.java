package interfaces;

import classes.secured.BankAccount;

public interface AtmOperations {
    void acceptDeposit(double amount);
    void acceptWithdrawal(double amount);
    void printAccountInfo(BankAccount account);
}
