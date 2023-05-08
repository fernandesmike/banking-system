package interfaces;

import classes.TransactionReceipt;
import customexceptions.*;

public interface BankOperations {
    TransactionReceipt withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException;
    TransactionReceipt deposit(double amount) throws  DepositLimitExceededException, BalanceLimitExceededException;
}
