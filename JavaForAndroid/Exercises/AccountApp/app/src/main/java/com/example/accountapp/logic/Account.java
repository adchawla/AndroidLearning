package com.example.accountapp.logic;

import com.example.accountapp.ui.OutputInterface;

/**
 * This file defines the Account class.  It provides the basis for a
 * series of improvements you'll need to make as you progress through
 * the lessons in Module 6.
 */
public class Account {
    /**
     * This is the variable that stores our OutputInterface instance.
     * <p/>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * </p>
     * This was renamed to 'mOut' from 'out', as it is in the video
     * lessons, to better match Android/Java naming guidelines.
     */
    final private OutputInterface mOut;

    /**
     * Name of the account holder.
     */
    private String mName;

    /**
     * Number of the account.
     */
    private int mNumber;

    /**
     * Current balance in the account.
     */
    private double mBalance;

    /**
     * Constructor initializes the field
     */
    public Account(OutputInterface out) {
        mOut = out;
    }

    public Account(OutputInterface out, String name, int number ) {
        this(out);
        mName = name;
        mNumber = number;
    }

    public Account(OutputInterface out, String name, int number, double initialBalance ) {
        this(out, name, number);
        mBalance = initialBalance;
    }
    /**
     * Deposit @a amount into the account.
     */
    public void deposit(double amount) {
        mBalance += amount;
    }

    /**
     * Withdraw @a amount from the account.  Prints "Insufficient
     * Funds" if there's not enough money in the account.
     */
    public void withdrawal(double amount) {
        if (mBalance > amount)
            mBalance -= amount;
        else 
            mOut.println("Insufficient Funds");
    }

    /**
     * Display the current @a amount in the account.
     */
    public void displayBalance() {
        mOut.println("The balance on account " 
                     + mNumber
                     + " is " 
                     + mBalance);
    }

    public String getName() {
        return mName;
    }

    public int getNumber() {
        return mNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", mName='" + mName + '\'' +
                ", mNumber=" + mNumber +
                ", mBalance=" + mBalance +
                '}';
    }

    public double getBalance() {
        return mBalance;
    }

    public boolean equals (Object anotherObject) {
        if ( anotherObject instanceof  Account ) {
            Account otherAccount = (Account) anotherObject;
            return this.mNumber == otherAccount.mNumber;
        }
        return false;
    }
}
