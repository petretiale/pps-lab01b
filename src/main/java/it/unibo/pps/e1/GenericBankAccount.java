package it.unibo.pps.e1;

public class GenericBankAccount implements BankAccount {

    private final BankAccount base;
    private final WithdrawStrategy strategy;

    public GenericBankAccount(BankAccount base, WithdrawStrategy strategy) {
        this.base = base;
        this.strategy = strategy;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        strategy.execute(this.base,amount);
    }
}
