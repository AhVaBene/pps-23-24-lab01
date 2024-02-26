package example.model;

public interface BankAccountWithAtm extends BankAccount {

    void depositWithAtm(int userID, double amount);

    void withdrawWithAtm(int userID, double amount);
}
