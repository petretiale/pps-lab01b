package it.unibo.pps.e1;

public class BankAccountFactory {

    public static BankAccount createSilverAccount() {
        return new GenericBankAccount(new CoreBankAccount(), new SilverStrategy());
    }

    public static BankAccount createGoldenAccount() {
        return new GenericBankAccount(new CoreBankAccount(), new GoldStrategy());
    }

    public static BankAccount createBronzeAccount() {
        return new GenericBankAccount(new CoreBankAccount(), new BronzeStrategy());
    }
}
