package it.unibo.pps.e1;

public class SilverStrategy implements WithdrawStrategy {

    private static final int FEE = 1;
    @Override
    public void execute(BankAccount bankAccount, int amount) {
        if (bankAccount.getBalance() < amount){
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount + FEE);
    }
}
