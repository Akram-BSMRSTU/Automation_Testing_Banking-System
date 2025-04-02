package tests;

import org.testng.annotations.Test;

public class SeleniumPracticePageTest extends BaseTest{
    @Test(priority = 4)
    public void automationTestingClicked() throws InterruptedException{
        seleniumPracticePage.nevigatetoBankingHomaepage();
        Thread.sleep(5000);
    }


}
