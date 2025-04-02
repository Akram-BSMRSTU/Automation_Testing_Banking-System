package tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginPageTest extends BaseTest {


    @Test(priority = 1)
    public void titletestofloginpage(){
        String actualoginPageTitile = loginPage.getLoginPagetitile();
        System.out.println("Page Actual Title : "+actualoginPageTitile);
        Assert.assertEquals(actualoginPageTitile,"Login with Enhanced Features");
    }
    @Test(priority = 2)
    public void headingtest(){
        String pageheading = loginPage.headlineofPage();
        Assert.assertEquals(pageheading,"Testing and Learning Hub");
    }
    @Test(priority = 3)
    public void loginbuttonclicked() throws InterruptedException{
        loginPage.nevigateToHomePage();
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void automationTestingClicked() throws InterruptedException{
        loginPage.nevigatetoautomationTesting();
        Thread.sleep(3000);
    }



}
