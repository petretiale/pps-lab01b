package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {

    private BankAccount bronzeAccount;
    private final WithdrawStrategy strategy;

    public BronzeBankAccount(BankAccount bronzeAccount, WithdrawStrategy strategy) {
        this.bronzeAccount = bronzeAccount;
        this.strategy = strategy ;
    }

    @Override
    public int getBalance() {
        return this.bronzeAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.bronzeAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        strategy.execute(this.bronzeAccount,amount);
    }
}
