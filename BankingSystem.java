class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public Account(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: NPR" + balance);
    }

}

class Customer {
    private final String name;
    private final String customerId;
    private final Account account;

    public Customer(String name, String customerId, Account account) {
        this.name = name;
        this.customerId = customerId;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Account getAccount() {
        return account;
    }

    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer ID: " + customerId);
        account.displayAccountInfo();
    }

}

class Bank {
    private final String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void welcomeMessage() {
        System.out.println("Welcome to " + bankName + "!");
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("Global IME Bank");
        bank.welcomeMessage();

        Account acc1 = new Account("123456789011", 1000.0);
        Customer cust1 = new Customer("Milan Shrestha", "C9848", acc1);

        acc1.deposit(5000);
        acc1.withdraw(1000);

        System.out.println("\n--- Account Details ---");
        cust1.displayCustomerInfo();

    }
}
