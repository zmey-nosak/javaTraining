package Accounts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Echetik on 15.10.2016.
 */
public class Account {
    private int balance;
    private int id;
    private Lock lock = new ReentrantLock();

    public Account(int balance, int id) {
        this.balance = balance;
        this.id = id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Lock getLock() {
        return lock;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
