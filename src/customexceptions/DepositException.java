package customexceptions;

public class DepositException extends Exception {

    public DepositException(String message, Throwable root){
        super(message, root);
    }
}
