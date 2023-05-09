package interfaces;

import classes.TransactionReceipt;
import customexceptions.*;

public interface AtmOperations {
    TransactionReceipt acceptDeposit(double amount) throws DepositLimitExceededException, BalanceLimitExceededException;
    TransactionReceipt acceptWithdrawal(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException;
    void printAccountInfo();
}
