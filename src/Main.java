import bank.accounts.types.CurrentAccount;
import bank.accounts.types.SavingsAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("======== Hello to the Maciel Bank S.A ============");
        System.out.println("=================== Welcome! =====================");
        System.out.println("=================== ++++++++ =====================");
        System.out.println("What are your desires today?");
        Scanner scanner = new Scanner(System.in);

        // Criação de contas
        CurrentAccount account1 = null;
        SavingsAccount account2 = null;

        while (true) {
            System.out.println("1. Create new account");
            System.out.println("2. Make a deposit");
            System.out.println("3. Check account balance");
            System.out.println("4. Make a transfer");
            System.out.println("0. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (account1 == null) {
                        account1 = new CurrentAccount();
                        System.out.print("Enter agency number for your current account: ");
                        int agencyNum1 = scanner.nextInt();
                        account1.accountNew(agencyNum1);
                    } else if (account2 == null) {
                        System.out.println("A current account already exists. Now, please create a savings account.");
                        account2 = new SavingsAccount();
                        System.out.print("Enter agency number for your savings account: ");
                        int agencyNum2 = scanner.nextInt();
                        account2.accountNew(agencyNum2);
                    } else {
                        System.out.println("Two accounts have already been created.");
                    }
                    break;
                case 2:
                    if (account1 == null && account2 == null) {
                        System.out.println("No accounts have been created.");
                        break;
                    }
                    System.out.print("Which account do you want to deposit into (1 for current or 2 for savings)? ");
                    int accNum = scanner.nextInt();
                    if (accNum == 1 && account1 != null) {
                        System.out.print("Enter deposit value for your current account: ");
                        int depositValue = scanner.nextInt();
                        account1.depositNew(depositValue);
                    } else if (accNum == 2 && account2 != null) {
                        System.out.print("Enter deposit value for your savings account: ");
                        int depositValue = scanner.nextInt();
                        account2.depositNew(depositValue);
                    } else {
                        System.out.println("Invalid account.");
                    }
                    break;
                case 3:
                    if (account1 == null && account2 == null) {
                        System.out.println("No accounts have been created.");
                        break;
                    }
                    System.out.print("Which account do you want to check the balance of (1 for current or 2 for savings)? ");
                    int checkAccNum = scanner.nextInt();
                    if (checkAccNum == 1 && account1 != null) {
                        System.out.println("Current Account Balance: " + account1.getBalance());
                    } else if (checkAccNum == 2 && account2 != null) {
                        System.out.println("Savings Account Balance: " + account2.getBalance());
                    } else {
                        System.out.println("Invalid account.");
                    }
                    break;
                case 4:
                    if (account1 == null || account2 == null) {
                        System.out.println("Two accounts need to be created to make a transfer.");
                        break;
                    }
                    System.out.print("From which account do you want to transfer (1 for current or 2 for savings)? ");
                    int fromAccNum = scanner.nextInt();
                    System.out.print("To which account do you want to transfer (1 for current or 2 for savings)? ");
                    int toAccNum = scanner.nextInt();
                    System.out.print("Enter transfer value: ");
                    int transferValue = scanner.nextInt();
                    boolean transferSuccess = false;
                    if (fromAccNum == 1 && toAccNum == 2 && account1 != null && account2 != null) {
                        transferSuccess = account1.transferNew(transferValue, account2.getNumberAcc());
                        if (transferSuccess) {
                            account2.depositNew(transferValue); // Credit to savings account
                        }
                    } else if (fromAccNum == 2 && toAccNum == 1 && account1 != null && account2 != null) {
                        transferSuccess = account2.transferNew(transferValue, account1.getNumberAcc());
                        if (transferSuccess) {
                            account1.depositNew(transferValue); // Credit to current account
                        }
                    } else {
                        System.out.println("Invalid account.");
                    }
                    break;
                case 0:
                    System.out.println("Program terminated.");
                    scanner.close(); // Close the scanner before terminating the program
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
