package classes.secured;

// Packages
import classes.TransactionReceipt;
import interfaces.BankOperations;
import static enums.ExceptionMessages.*;
import static enums.AmountLimits.*;

// Exceptions
import customexceptions.*;

public class BankAccountTransaction implements BankOperations {

    private BankAccount account;
    private TransactionReceipt receipt;

    public BankAccountTransaction(BankAccount account) {
        this.account = account;
    }

    @Override
    public void withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {

        double accountBalance = account.getBalance();
        BankAccount _newAccount;

        if (amount > MAX_WITHDRAW_AMT.getAmount()){
            throw  new WithdrawalLimitExceededException(MAX_WITHDRAW_AMT_MSG.getMessage(), new Throwable());
        }

        if (amount > accountBalance) {
            throw new InsufficientBalanceException(INSUFFICIENT_BAL_MSG.getMessage(), new Throwable());
        }

        account.setBalance(accountBalance - amount);

        // TODO: Return a Receipt obj
    }

    @Override
    public void deposit(double amount) throws  DepositLimitExceededException, BalanceLimitExceededException {

        double accountBalance = account.getBalance();
        double _newBalance = accountBalance + amount;

        if (amount > MAX_DEPOSIT_AMT.getAmount()){
            throw new DepositLimitExceededException(MAX_DEPOSIT_AMT_MSG.getMessage(), new Throwable());
        }

        if ( _newBalance > MAX_BALANCE_AMT.getAmount()) {
            throw new BalanceLimitExceededException(MAX_BALANCE_AMT_MSG.getMessage(), new Throwable());
        }

        account.setBalance(_newBalance);

        // TODo: Return a Receipt obj
    }
}
