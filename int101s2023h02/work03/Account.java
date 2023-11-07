package work03;

import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 1_000_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException("Owner cannot be null.");
        }
        
        this.owner = owner;
        this.no = Utilitor.computeIsbn10(nextNo);
        nextNo += 10;
        this.balance = 0.0;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        double positiveAmount = Utilitor.testPositive(amount);
        balance += positiveAmount;
        return balance;
    }

    public double withdraw(double amount) {
        double positiveAmount = Utilitor.testPositive(amount);
        if (balance >= positiveAmount) {
            balance -= positiveAmount;
            return balance;
        } else {
            throw new IllegalArgumentException("Insufficient balance to withdraw.");
        }
    }

    public void transfer(double amount, Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Target account cannot be null.");
        }
        double positiveAmount = Utilitor.testPositive(amount);
        withdraw(positiveAmount);
        account.deposit(positiveAmount);
    }

    @Override
    public String toString() {
        return "Account(" + no + "," + balance + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; 
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; 
        }
        Account other = (Account) obj;
        return no == other.no;
    }

}
