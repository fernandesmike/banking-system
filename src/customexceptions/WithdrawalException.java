package customexceptions;

public class WithdrawalException extends Exception {

    public WithdrawalException(String message, Throwable root) {
        super(message, root);
    }
}
