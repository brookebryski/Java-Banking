package com.company;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private static int count;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }
    @BeforeEach
    public void setup(){
        account = new BankAccount("Brooke", "Bryski", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }
    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(200.00, true);
        assertEquals(800, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_notBranch() {
        double balance = account.withdraw(200.00, false);
        assertEquals(800, balance, 0);
    }
    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
        // I tried it the way below first, and it did still pass
        // double balance = account.getBalance();
        // assertEquals(1000.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking());
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("This executes after my test cases. Count = " + count++);
    }
    @AfterAll
    public static void teardown() {
        System.out.println("Count = " + count++);
    }
}