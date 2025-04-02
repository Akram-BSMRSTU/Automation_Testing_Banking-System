package tests;

import Pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {

    @Test(priority = 1)
    public void headingtest(){
        String pageheading = homePage.headlineofPage();
        Assert.assertEquals(pageheading," Welcome to Your Bank");
    }
}
