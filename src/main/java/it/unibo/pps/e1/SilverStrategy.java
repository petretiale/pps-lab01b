package it.unibo.pps.e1;

public class SilverStrategy implements WithdrawStrategy{
    @Override
    public void execute(BankAccount bankAccount, int amount) {
        if (bankAccount.getBalance() < amount){
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount + 1);
    }
}
