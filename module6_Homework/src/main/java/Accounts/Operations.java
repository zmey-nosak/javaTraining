package Accounts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Echetik on 15.10.2016.
 */
public class Operations {
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static final long WAIT_LOCK = 100;
    static Account a;
    static Account b;

    static {
        a = new Account(1000, 1);
        b = new Account(2000, 2);
        accounts.put(a.getId(), a);
        accounts.put(b.getId(), b);
    }


    public static void main(String[] args) {
        //    readTransactions("D:\\Downloads\\javaTraining\\module6_Homework\\src\\main\\resources\\transfers.txt");
        readTransactions2("D:\\Downloads\\javaTraining\\module6_Homework\\src\\main\\resources\\transfers.txt");
    }

    static void readTransactions(String path) {
        File file = new File(path);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] param = str.split(",");
                if (param.length == 3) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            transfer(accounts.get(Integer.parseInt(param[0])), accounts.get(Integer.parseInt(param[1])), Integer.parseInt(param[2]));
                        }
                    }).start();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void readTransactions2(String path) {
        File file = new File(path);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] param = str.split(",");
                if (param.length == 3) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            transferVar2(accounts.get(Integer.parseInt(param[0])), accounts.get(Integer.parseInt(param[1])), Integer.parseInt(param[2]));
                        }
                    }).start();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void transfer(Account a, Account b, int amount) {
        Account acc1 = null;
        Account acc2 = null;
        if (a.hashCode() > b.hashCode()) {
            acc1 = b;
            acc2 = a;
        } else {
            acc1 = a;
            acc2 = b;
        }
        synchronized (acc1) {
            System.out.println(Thread.currentThread().toString() + ": account " + a.getId() + " was taken");
            synchronized (acc2) {
                System.out.println(Thread.currentThread().toString() + ": account " + b.getId() + " was taken");
                a.withdraw(amount);
                b.deposit(amount);
                System.out.println(a.getId() + ": " + a.getBalance());
                System.out.println(b.getId() + ": " + b.getBalance());
            }
            System.out.println(Thread.currentThread().toString() + ": account " + b.getId() + " was released");
        }
        System.out.println(Thread.currentThread().toString() + ": account " + a.getId() + " was released");
    }

    static void transferVar2(Account a, Account b, int amount) {
        boolean aa = true;
        try {
            while (aa) {
                if (a.getLock().tryLock(WAIT_LOCK, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().toString() + ": account " + a.getId() + " was taken");
                    try {
                        if (b.getLock().tryLock(WAIT_LOCK, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println(Thread.currentThread().toString() + ": account " + b.getId() + " was taken");
                                a.withdraw(amount);
                                b.deposit(amount);
                                System.out.println(a.getId() + ": " + a.getBalance());
                                System.out.println(b.getId() + ": " + b.getBalance());
                            } finally {
                                aa = false;
                                b.getLock().unlock();
                                System.out.println(Thread.currentThread().toString() + ": account " + b.getId() + " was released");
                            }
                        }
                    } finally {
                        a.getLock().unlock();
                        System.out.println(Thread.currentThread().toString() + ": account " + a.getId() + " was released");
                    }

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

