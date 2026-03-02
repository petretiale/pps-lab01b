package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private BankAccount goldAccount;
    private final WithdrawStrategy strategy;

    public GoldBankAccount(BankAccount gold, WithdrawStrategy strategy) {
        this.goldAccount = gold;
        this.strategy = strategy;
    }

    @Override
    public int getBalance() {
        return this.goldAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        goldAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        strategy.execute(this.goldAccount,amount);
    }
}
