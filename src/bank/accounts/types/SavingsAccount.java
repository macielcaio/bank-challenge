package bank.accounts.types;

import bank.Account;

public class SavingsAccount extends Account {
    @Override
    public boolean transferNew(int transferValue, int numberAcc) {
        return super.transferNew(transferValue, numberAcc);
    }
}
