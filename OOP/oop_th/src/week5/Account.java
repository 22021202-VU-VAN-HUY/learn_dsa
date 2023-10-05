//package week5;

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList;

    public Account() {
        balance = 0;
        transitionList = new ArrayList<Transaction>();
    }

    /**
     * nap tien.
     *
     * @param amount so tien nap
     */
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**
     * rut tien.
     *
     * @param amount so tien rut
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            balance -= amount;
        }
    }

    /**
     * them giao dich.
     *
     * @param amount    so tien giao dich
     * @param operation loai giao dich
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            transitionList.add(new Transaction(operation, amount, balance));
        } else {
            System.out.println("Yeu cau khong hop le!");
        }


    }

    /**
     * in ra cac giao dich.
     */
    public void printTransaction() {
        int count = 1;
        for (Transaction transaction : transitionList) {
            if (transaction.getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf("Giao dich " + count + ": Nap tien $%.2f. "
                                + "So du luc nay: $%.2f.\n",
                        transaction.getAmount(), transaction.getBalance());
            } else {
                System.out.printf("Giao dich " + count + ": Rut tien $%.2f. "
                                + "So du luc nay: $%.2f.\n",
                        transaction.getAmount(), transaction.getBalance());
            }
            count++;
        }

        //System.out.println((double) Math.round(rate * 100) / 100);
    }


}
