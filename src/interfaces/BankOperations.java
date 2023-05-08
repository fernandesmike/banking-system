package interfaces;

import customexceptions.*;

public interface BankOperations {
    void withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException;
    void deposit(double amount) throws  DepositLimitExceededException, BalanceLimitExceededException;
}
