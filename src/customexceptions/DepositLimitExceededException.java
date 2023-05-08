package customexceptions;

public class DepositLimitExceededException extends Exception {

    public DepositLimitExceededException(String message, Throwable root){
        super(message, root);
    }
}
