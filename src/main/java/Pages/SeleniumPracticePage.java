package Pages;

import com.microsoft.playwright.Page;

public class SeleniumPracticePage {
    Page page;
    private String BankingSystem_ViewBtn = "//div[@class='container mt-5']//div[2]//div[1]//div[1]//a[1]";

    public SeleniumPracticePage(Page page){
        super();
        this.page = page;
    }

    public void nevigatetoBankingHomaepage(){
        page.locator(BankingSystem_ViewBtn).click();
    }
}
