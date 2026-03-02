package it.unibo.pps.e1;

public interface WithdrawStrategy {
    void execute(BankAccount bankAccount, int amount);
}
