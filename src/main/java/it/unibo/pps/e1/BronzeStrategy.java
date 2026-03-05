package it.unibo.pps.e1;

public class BronzeStrategy implements WithdrawStrategy {

    private static final int FEE_THRESHOLD = 100;
    @Override
    public void execute(BankAccount bankAccount, int amount) {
        int fee = calculateFee(amount);
        if(bankAccount.getBalance() < (fee + amount)) {
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount + fee);
    }

    private static int calculateFee(int amount) {
        return  (amount < FEE_THRESHOLD)? 0 : 1;
    }
}
