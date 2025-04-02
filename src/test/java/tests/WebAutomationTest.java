package tests;

import org.testng.annotations.Test;

public class WebAutomationTest extends BaseTest {
    @Test(priority = 1)
    public void loginbuttonclicked() throws InterruptedException{
       webautomationPage.navigatetopracticeSite();
        Thread.sleep(3000);
    }
}
