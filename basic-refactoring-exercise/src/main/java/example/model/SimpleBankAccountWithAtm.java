package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {

    private static final int FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    public void depositWithAtm(final int userID, final double amount) {
        deposit(userID, amount - FEE);
    }

    public void withdrawWithAtm(final int userID, final double amount) {
        withdraw(userID, amount + FEE);
    }
}
