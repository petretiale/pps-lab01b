package it.unibo.pps.e1;

public class BronzeStrategy implements WithdrawStrategy {
    @Override
    public void execute(BankAccount bankAccount, int amount) {
        int fee = calculateFee(amount);
        if(bankAccount.getBalance() < (fee + amount)) {
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount);
    }

    private static int calculateFee(int amount) {
        int fee;
        return fee = (amount < 100)? 0 : 1;
    }
}
