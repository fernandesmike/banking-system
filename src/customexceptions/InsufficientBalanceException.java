package customexceptions;

public class InsufficientBalanceException extends  Exception{

    public  InsufficientBalanceException(String message, Throwable root) { super(message, root); }
}
