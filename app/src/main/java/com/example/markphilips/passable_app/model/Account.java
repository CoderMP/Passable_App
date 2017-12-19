package com.example.markphilips.passable_app.model;

import java.util.ArrayList;

/**
 * Created by Mark on 12/11/2017.
 */

public class Account {
    //Declare required private field variables
    private String acctName;
    private String acctUserName;
    private int acctPassword;

    /**
     * Constructor method for the Account Class.
     * Responsible for defining a new Account with an Account name, username, and password
     *
     * @param acctName The name of the Account (e.g.Facebook)
     * @param acctUserName The username/userID on the account
     * @param acctPassword The account password
     */
    public Account(String acctName, String acctUserName, int acctPassword){
        this.acctName = acctName;
        this.acctUserName = acctUserName;
        this.acctPassword = acctPassword;
    }

    //region Setter Methods
    public void setAcctName(String acctName){ this.acctName = acctName; }
    public void setAcctUserName(String acctUserName){ this.acctUserName = acctUserName; }
    public void setAcctPassword(int acctPassword){ this.acctPassword = acctPassword; }
    //endregion


    //region Getter Methods
    public String getAcctName(){ return this.acctName; }
    public String getAcctUserName(){ return this.acctUserName; }
    public int getAcctPassword(){ return this.acctPassword; }
    public static ArrayList<Account> getAccounts(){
        //Declare and initialize a new ArrayList object that will hold the Account objects
        ArrayList<Account> accounts = new ArrayList<>();

        //Populate the ArrayList
        //TODO: Determine how to populate the ArrayList with stored Account data via SQLite
        //TODO: REMOVE THIS TEST DATA
        accounts.add(new Account("Facebook", "Rahool", 12345));
        accounts.add(new Account("LinkedIn", "Zavala", 24689));
        accounts.add(new Account("Twitter", "Cayde", 23456));
        accounts.add(new Account("Twitch", "Ikora", 13579));

        //Return the populated ArrayList object
        return accounts;
    }
    //endregion


    /**
     * Overridden toString method. Responsible for correctly displaying the requested data in a
     * readable format.
     *
     * @return
     */
    @Override
    public String toString() { return super.toString(); }
}

