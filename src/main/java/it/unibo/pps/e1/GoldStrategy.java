package it.unibo.pps.e1;

public class GoldStrategy implements WithdrawStrategy {

    private static final int MAX_NEGATIVE_BALANCE = -500;
    @Override
    public void execute(BankAccount bankAccount, int amount) {
        if(bankAccount.getBalance() - amount < MAX_NEGATIVE_BALANCE) {
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount);
    }
}
