package it.unibo.pps.e1;

public class BronzeStrategy implements WithdrawStrategy {
    @Override
    public void execute(BankAccount bankAccount, int amount) {
        int fee = (amount < 100)? 0 : 1;
        if(bankAccount.getBalance() < (fee + amount)) {
            throw new IllegalStateException();
        }
        bankAccount.withdraw(amount);
    }
}
