package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
    public void titleTestOfLoginPage(){
        String actualoginPageTitile = loginPage.getLoginPagetitile();
        System.out.println("Page Actual Title : "+actualoginPageTitile);
        Assert.assertEquals(actualoginPageTitile,"Login with Enhanced Features");
    }
    @Test(priority = 2)
    public void headingTestOfLoginPage(){
        String pageheading = loginPage.headLineOfPage();
        Assert.assertEquals(pageheading,"Testing and Learning Hub");
    }
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    public void loginButtonClicked() throws InterruptedException{
        loginPage.nevigateToHomePage();
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void automationTestingClicked() throws InterruptedException{
        loginPage.nevigateToAutomationTesting();
        Thread.sleep(3000);
    }



}
