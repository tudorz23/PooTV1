package database;

import fileInput.CredentialsInput;

/**
 * Adds int field for storing balance to CredentialsInput Class.
 */
public class Credentials extends CredentialsInput {
    private int intBalance;

    /* Constructor */
    public Credentials(CredentialsInput credentialsInput) {
        this.setName(credentialsInput.getName());
        this.setPassword(credentialsInput.getPassword());
        this.setAccountType(credentialsInput.getAccountType());
        this.setCountry(credentialsInput.getCountry());
        this.setBalance(credentialsInput.getBalance());

        int balanceToInt = Integer.parseInt(this.getBalance());
        this.setIntBalance(balanceToInt);
    }

    /* Getters and Setters */
    public int getIntBalance() {
        return intBalance;
    }
    public void setIntBalance(int intBalance) {
        this.intBalance = intBalance;
    }
}
