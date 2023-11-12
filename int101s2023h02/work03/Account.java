package work03;

import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner)  {
        if (owner == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
        this.balance = 0.0;
        long result = 0;
        while (true) {
            result = Utilitor.computeIsbn10(Account.nextNo);
            if (result != 10) {
                break;
            }
            Account.nextNo += 1;
        }
        this.no = 10 * Account.nextNo + result;
        Account.nextNo++;

    }

    public long getNo() {
        return this.no;
    }

    public Person getOwner() {
        return this.owner;
    }

    public double getBalance() {
        return this.balance;
    }

    public double deposit(double amount) {
        return this.balance += Utilitor.testPositive(amount);
    }

    public double withdraw(double amount) {
        if (amount > this.balance){
            throw new IllegalArgumentException();
        }
        this.balance -= Utilitor.testPositive(amount);
        return this.balance;
    }

    public void transfer(double amount, Account account) {
        if (account == null || amount > this.balance || amount < 0) {
            throw new IllegalArgumentException();
        }
        this.withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account [no = " + this.no + ", balance = " + this.balance + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (no != other.no)
            return false;
        if (owner == null) {
            if (other.owner != null)
                return false;
        } else if (!owner.equals(other.owner))
            return false;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        return true;
    }

}


