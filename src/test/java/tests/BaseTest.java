package tests;

import Factory.PlaywrightFactory;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.SeleniumPracticePage;
import Pages.WebAutomationPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected PlaywrightFactory pf;
    protected Page page;
    protected Homepage homePage;
    protected LoginPage loginPage;
    protected WebAutomationPage webautomationPage;
    protected SeleniumPracticePage seleniumPracticePage;
//    protected CommonPage commonPage;
//    protected LekhokPage lekhokPage;
//    protected CheckoutPage checkoutpage;


    @BeforeClass
    public void setup() {
        System.out.println("Setting up the tests...");
        pf = PlaywrightFactory.getInstance(); // Get Singleton instance
        page = pf.initBrowser("firefox");

        // Initialize page objects
        homePage = new Homepage(page);
        loginPage = new LoginPage(page);
        webautomationPage = new WebAutomationPage(page);
        seleniumPracticePage = new SeleniumPracticePage(page);
//        commonPage = new CommonPage(page);
//        lekhokPage = new LekhokPage(page);
//        checkoutpage = new CheckoutPage(page);

        System.out.println("Setup completed. Login initialized: " + (loginPage != null));
    }

    @AfterSuite
    public void teardown() {
        System.out.println("Tearing down the tests...");
        pf.closeBrowser();  // Close the browser after all tests
    }
}
