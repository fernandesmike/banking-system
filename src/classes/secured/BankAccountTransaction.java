package classes.secured;

// Packages
import classes.TransactionReceipt;
import enums.TransactionType;
import interfaces.BankOperations;
import static enums.ExceptionMessages.*;
import static enums.AmountLimits.*;

// Exceptions
import customexceptions.*;

public class BankAccountTransaction implements BankOperations {

    private final BankAccount account;
    private TransactionType transactionType;

    public BankAccountTransaction(BankAccount account) {
        this.account = account;
        this.transactionType = null;
    }

    @Override
    public TransactionReceipt withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {

        double accountBalance = account.getBalance();
        transactionType = TransactionType.WITHDRAW;

        if (amount > MAX_WITHDRAW_AMT.getAmount()){
            throw  new WithdrawalLimitExceededException(MAX_WITHDRAW_AMT_MSG.getMessage(), new Throwable());
        }

        if (amount > accountBalance) {
            throw new InsufficientBalanceException(INSUFFICIENT_BAL_MSG.getMessage(), new Throwable());
        }

        account.setBalance(accountBalance - amount);
        return new TransactionReceipt(account, amount, accountBalance, transactionType );
    }

    @Override
    public TransactionReceipt deposit(double amount) throws  DepositLimitExceededException, BalanceLimitExceededException {

        double accountBalance = account.getBalance();
        double _newBalance = accountBalance + amount;
        transactionType = TransactionType.DEPOSIT;

        if (amount > MAX_DEPOSIT_AMT.getAmount()){
            throw new DepositLimitExceededException(MAX_DEPOSIT_AMT_MSG.getMessage(), new Throwable());
        }

        if ( _newBalance > MAX_BALANCE_AMT.getAmount()) {
            throw new BalanceLimitExceededException(MAX_BALANCE_AMT_MSG.getMessage(), new Throwable());
        }

        account.setBalance(_newBalance);
        return new TransactionReceipt(account, amount, accountBalance, transactionType );
    }
}
