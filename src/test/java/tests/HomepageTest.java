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
    public void testDepositEntryHisytory(){
        Assert.assertTrue(homePage.DepositmoneyEntryVisible(), "Deposit entry not found in history");
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


}
