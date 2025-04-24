package tests;

import Pages.Homepage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HomepageTest extends BaseTest {

    @Test(priority = 1)
    public void testHomePageHeading(){
        String pageheading = homePage.headlineOfHomePage();
        assertEquals(pageheading," Welcome to Your Bank");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void testDeposit(){
        homePage.depositMoney("1000");
        String balance = homePage.getBalance();
        Assert.assertTrue(balance.contains("1000.00"),"Deposit failed: balance was " + balance);
        System.out.println("Actual balance after deposit: '" + balance + "'");

    }
    //verify deposit successful notification
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    public void testDepositEntryHisytory() throws InterruptedException {
        Assert.assertTrue(homePage.depositMoneyEntryVisible(), "Deposit entry not found in history");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    public void testwithdraw(){
        homePage.withdrawMoney("200");
        String balance = homePage.getBalance();
        assertTrue(balance.contains("800"),"Withdrawal failed: balance was " + balance);
        System.out.println("Actual balance After withdrawals: '" + balance + "'");
    }
    //verify withdraw successful notification

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    public void testWithdrawalHisytory(){
        Assert.assertTrue(homePage.withdrawHistoryVisible(), "Withdrawal Amount not found in history");
    }
    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    public void testTransfer(){
        homePage.transferMoney("100","0987654321");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 7)
    public void testTransferHisytory(){
        Assert.assertTrue(homePage.isTransferSuccessful(), "Transfer is not successful ");
    }

    @Test(priority = 8)
    public void testAddInterest() throws InterruptedException {
        String beforeBalanceadded = homePage.getBalance();
        homePage.addInterest();
        String afterBalanceadded = homePage.getBalance();
        System.out.println("Before interest balance is "+beforeBalanceadded);
        System.out.println("Before interest balance is "+afterBalanceadded);
        Thread.sleep(3000);

    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    public void testResetFunctionality() {
        homePage.resetAccount();
        String balance = homePage.getBalance();
        System.out.println("After reset balance is "+balance);
        Assert.assertEquals(balance, "$0.00", "Reset failed: Balance was not reset to $0.00");
    }

}
