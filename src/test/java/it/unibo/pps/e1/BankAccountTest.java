package it.unibo.pps.e1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {



    @Nested
    public class SilverBankAccountTests {

        public static final int DEPOSIT_AMOUNT = 1000;
        public static final int WITHDRAW_AMOUNT = 200;
        public static final int FEE = 1;

        private final BankAccount account = BankAccountFactory.createSilverAccount();

        @Test
        public void testInitiallyEmpty() {
            assertEquals(0, this.account.getBalance());
        }

        @Test
        public void testCanDeposit() {
            this.account.deposit(DEPOSIT_AMOUNT);
            assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
        }

        @Test
        public void testCanWithdraw() {
            this.account.deposit(DEPOSIT_AMOUNT);
            this.account.withdraw(WITHDRAW_AMOUNT);
            assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - FEE, this.account.getBalance());
        }

        @Test
        public void testCannotWithdrawMoreThanAvailable() {
            this.account.deposit(DEPOSIT_AMOUNT);
            assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
        }
    }

    @Nested
    public class GoldAccountTests {
        public static final int DEPOSIT_AMOUNT = 100;
        public static final int WITHDRAW_AMOUNT = 500;
        private final BankAccount account = BankAccountFactory.createGoldenAccount();
        private int expected;

        @Test
        void testAllowsOverdraft() {
            account.deposit(DEPOSIT_AMOUNT);
            account.withdraw(WITHDRAW_AMOUNT);
            int expectedResult = -400;
            assertEquals(expectedResult, account.getBalance());
        }

        @Test
        void testBlocksExcessiveOverdraft() {
            account.deposit(DEPOSIT_AMOUNT);
            assertThrows(IllegalStateException.class, () -> account.withdraw(601));
        }
    }

    @Nested
    public class BronzeAccountTests {

        private static final int INITIAL_DEPOSIT = 100;
        private static final int SMALL_WITHDRAWAL = 50;
        private static final int LARGE_WITHDRAWAL = 100;
        private static final int FEE = 1;

        private final BankAccount account = BankAccountFactory.createBronzeAccount();

        @Test
        void testNoFeeForSmallWithdrawal() {
            account.deposit(INITIAL_DEPOSIT);
            account.withdraw(SMALL_WITHDRAWAL);
            assertEquals(INITIAL_DEPOSIT - SMALL_WITHDRAWAL, account.getBalance());
        }

        @Test
        void testFeeForLargeWithdrawal() {
            int depositAmount = 200;
            account.deposit(depositAmount);
            account.withdraw(LARGE_WITHDRAWAL);
            assertEquals(depositAmount - LARGE_WITHDRAWAL - FEE, account.getBalance());
        }

        @Test
        void testBlocksOverdraft() {
            account.deposit(INITIAL_DEPOSIT);
            assertThrows(IllegalStateException.class, () -> account.withdraw(LARGE_WITHDRAWAL));
        }
    }
}
