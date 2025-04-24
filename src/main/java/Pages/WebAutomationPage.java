package Pages;

import com.microsoft.playwright.Page;

public class WebAutomationPage {
    Page page;
//    1.Locator


    private String heading = "//h1[normalize-space()='WEB AUTOMATION']";
    private String seleniumProject_getStartedbtn = "//a[@href='/WebAutomation/contents/projects.html']";

//    2.Constructor
public WebAutomationPage(Page page){
    super();
    this.page = page;
}

//    3.Method
    public void navigateToPracticeSite(){
        page.locator(seleniumProject_getStartedbtn).click();
    }

}
