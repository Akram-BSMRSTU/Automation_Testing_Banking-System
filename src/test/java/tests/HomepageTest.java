package tests;

import Pages.Homepage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomepageTest extends BaseTest {

    @Test(priority = 1)
    public void headingtest(){
        String pageheading = homePage.headlineofPage();
        assertEquals(pageheading," Welcome to Your Bank");
    }

    @Test(priority = 2)
    public void testDeposit(){
        homePage.DepositMoney("1000");
        String balance = homePage.getBalance();
        Assert.assertTrue(balance.contains("1000.00"),"Deposit failed: balance was " + balance);
        System.out.println("Actual balance after deposit: '" + balance + "'");

    }
    //verify deposit successful notification
    @Test(priority = 3)
    public void testDepositEntryHisytory() throws InterruptedException {
        Assert.assertTrue(homePage.DepositmoneyEntryVisible(), "Deposit entry not found in history");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void testwithdraw(){
        homePage.withdrawMoney("200");
        String balance = homePage.getBalance();
        assertTrue(balance.contains("800"),"Withdrawal failed: balance was " + balance);
        System.out.println("Actual balance After withdrawals: '" + balance + "'");
    }
    //verify withdraw successful notification

    @Test(priority = 5)
    public void testwithdrawalHisytory(){
        Assert.assertTrue(homePage.WithdrawHistoryVisible(), "Withdrawal Amount not found in history");
    }
    @Test(priority = 6)
    public void testTransfer(){
        homePage.transferMoney("100","0987654321");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 7)
    public void testtransferHisytory(){
        Assert.assertTrue(homePage.isTransferSuccessful(), "Transfer is not successful ");
    }

    @Test(priority = 8)
    public void testaddinterest() throws InterruptedException {
        String beforeBalanceadded = homePage.getBalance();
        homePage.addinterest();
        String afterBalanceadded = homePage.getBalance();
        System.out.println("Before interest balance is "+beforeBalanceadded);
        System.out.println("Before interest balance is "+afterBalanceadded);
        Thread.sleep(3000);

    }

    @Test(priority = 9)
    public void testResetFunctionality() {
        homePage.resetAccount();
        String balance = homePage.getBalance();
        System.out.println("After reset balance is "+balance);
        Assert.assertEquals(balance, "$0.00", "Reset failed: Balance was not reset to $0.00");
    }

}
