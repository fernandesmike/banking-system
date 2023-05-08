package customexceptions;

public class WithdrawalLimitExceededException extends Exception {

    public WithdrawalLimitExceededException(String message, Throwable root){
        super(message, root);
    }
}
