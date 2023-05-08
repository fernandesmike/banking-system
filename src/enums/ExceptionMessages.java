package enums;

public enum ExceptionMessages {

    //Withdrawal exception messages
    MAX_WITHDRAW_AMT_MSG("Our system cannot accept withdrawal amount exceeding 5,000!"),
    MAX_DEPOSIT_AMT_MSG("Our system cannot accept deposit amount exceeding 10,000!"),
    MAX_BALANCE_AMT_MSG("You can only have a maximum of 100,000 available account balance!"),
    INSUFFICIENT_BAL_MSG("You have insufficient account balance!");

    private final String message;

    private ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return  message;
    }
}
