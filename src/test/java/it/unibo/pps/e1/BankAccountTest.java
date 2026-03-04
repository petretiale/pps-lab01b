package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    @Nested
    public class SilverBankAccountTests {
        private final BankAccount account = BankAccountFactory.createSilverAccount();

        @Test
        public void testInitiallyEmpty() {
            assertEquals(0, this.account.getBalance());
        }

        @Test
        public void testCanDeposit() {
            this.account.deposit(1000);
            assertEquals(1000, this.account.getBalance());
        }

        @Test
        public void testCanWithdraw() {
            this.account.deposit(1000);
            this.account.withdraw(200);
            assertEquals(799, this.account.getBalance());
        }

        @Test
        public void testCannotWithdrawMoreThanAvailable() {
            this.account.deposit(1000);
            assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
        }

    }

    @Nested
    public class GoldAccountTests {
        private final BankAccount account = BankAccountFactory.createGoldenAccount();

        @Test
        void testAllowsOverdraft() {
            account.deposit(100);
            account.withdraw(500);
            assertEquals(-400, account.getBalance());
        }

        @Test
        void testBlocksExcessiveOverdraft() {
            account.deposit(100);
            assertThrows(IllegalStateException.class, () -> account.withdraw(601));
        }
    }

    @Nested
    public class BronzeAccountTests {

        private int depositAmount = 200;
        private final BankAccount account = BankAccountFactory.createBronzeAccount();

        @Test
        void testNoFeeForSmallWithdrawal() {
            account.deposit(depositAmount);
            account.withdraw(50);
            assertEquals(100, account.getBalance());
        }

        @Test
        void testFeeForLargeWithdrawal() {
            account.deposit(depositAmount);
            account.withdraw(100);
            assertEquals(99, account.getBalance());
        }

        @Test
        void testBlocksOverdraft() {
            account.deposit(100);
            assertThrows(IllegalStateException.class, () -> account.withdraw(100));
        }
    }

}
