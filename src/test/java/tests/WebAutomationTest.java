package tests;

import org.testng.annotations.Test;

public class WebAutomationTest extends BaseTest {
    @Test(priority = 1)
    public void loginButtonClicked() throws InterruptedException{
       webautomationPage.navigateToPracticeSite();
        Thread.sleep(3000);
    }
}
