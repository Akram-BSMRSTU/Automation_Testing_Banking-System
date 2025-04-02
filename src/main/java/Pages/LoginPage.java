package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    //    1.Locator

    private String loginemail = "//input[@id='loginEmail']";
    private String loginpassword = "//input[@id='loginPassword']";
    private String loginButton = "//button[@id='signInBtn']";
    private String getStarted_Autmation = "//a[@href='../WebAutomation/selenium.html']";

//    2.Constructor
    public LoginPage(Page page){
    super();
    this.page = page;
}

//    3.Method
public void nevigateToHomePage(){
        page.locator(loginemail).fill("******");
        page.locator(loginpassword).fill("******");
    page.locator(loginButton).click(new Locator.ClickOptions().setForce(true));
//        page.locator(loginButton).click();
}
public void nevigatetoautomationTesting(){
        page.locator(getStarted_Autmation).click();
    }
    public String getLoginPagetitile(){
        return page.title();
    }
    public String headlineofPage(){
        String text = page.locator("//h2[normalize-space()='Testing and Learning Hub']").textContent();
        System.out.println("Element Text: " + text);
        return text;
    }


}
