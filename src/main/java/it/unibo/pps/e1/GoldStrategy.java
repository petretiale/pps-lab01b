package it.unibo.pps.e1;

public class GoldStrategy implements WithdrawStrategy {
    @Override
    public void execute(BankAccount bankAccount, int amount) {
        if(bankAccount.getBalance() - amount < -500) {
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount);
    }
}
