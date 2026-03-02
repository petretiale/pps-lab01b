package it.unibo.pps.e1;

public class BankAccountFactory {

    public static BankAccount createSilverAccount() {
        return new SilverBankAccount(new CoreBankAccount(), new SilverStrategy());
    }

    public static BankAccount createGoldenAccount() {
        return new GoldBankAccount(new CoreBankAccount(), new GoldStrategy());
    }

    public static BankAccount createBronzeAccount() {
        return new BronzeBankAccount(new CoreBankAccount(), new BronzeStrategy());
    }
}
