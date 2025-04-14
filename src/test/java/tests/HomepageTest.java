package tests;

import Pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Test(priority = 3)
    public void testwithdraw(){
        homePage.withdrawMoney("200");
        String balance = homePage.getBalance();
        assertTrue(balance.contains("800"),"Withdrawal failed: balance was " + balance);
        System.out.println("Actual balance After withdrawals: '" + balance + "'");
    }
}
