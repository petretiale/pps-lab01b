package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount{

    private final BankAccount silverAccount;
    private final WithdrawStrategy strategy;

    public SilverBankAccount(BankAccount base, WithdrawStrategy strategy) {
        this.silverAccount = base;
        this.strategy = strategy;
    }

    public int getBalance() {
        return silverAccount.getBalance();
    }

    public void deposit(int amount) {
        this.silverAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        strategy.execute(this.silverAccount, amount);
    }
}
