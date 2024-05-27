package bank;

import java.util.Random;

public abstract class Account implements Agency {
    protected int numberAcc;
    protected int agencyNum;
    protected int balance;

    @Override
    public void accountNew(int agencyNum) {
        Random rand = new Random();
        this.numberAcc = rand.nextInt(90000000) + 10000000; // Gera um número de 8 dígitos (de 10000000 a 99999999)
        this.agencyNum = agencyNum;
        this.balance = 0; // Saldo inicial é zero
        System.out.println("New account created with Number: " + this.numberAcc + " and Agency: " + this.agencyNum);
    }

    public int getNumberAcc() {
        return numberAcc;
    }

    public int getAgencyNum() {
        return agencyNum;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void depositNew(int depositValue) {
        if (depositValue > 0) {
            balance += depositValue;
            System.out.println("Deposited: " + depositValue + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit value.");
        }
    }

    @Override
    public boolean transferNew(int transferValue, int numberAcc) {
        if (transferValue > 0 && transferValue <= balance) {
            balance -= transferValue;
            System.out.println("Transferred: " + transferValue + ". New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance for transfer.");
            return false;
        }
    }
}
