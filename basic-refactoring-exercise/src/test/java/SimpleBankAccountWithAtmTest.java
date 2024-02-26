import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccountWithAtm;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccountWithAtm bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDepositWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.depositWithAtm(2, 50);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(29, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }
}
