package customexceptions;

public class BalanceLimitExceededException extends Exception {

    public BalanceLimitExceededException(String message, Throwable root) {
        super(message, root);
    }
}
