package enums;

public enum AmountLimits {
    MAX_WITHDRAW_AMT(5000),
    MAX_DEPOSIT_AMT(10000),
    MAX_BALANCE_AMT(100000);

    private final double amount;
    private  AmountLimits(int amount){
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }
}
