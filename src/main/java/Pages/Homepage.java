package Pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class Homepage {
    Page page;
    public Homepage(Page page) {
        super();
        this.page = page;
    }


//    1.Locator
    private String pageheading = "//h1[normalize-space()='Welcome to Your Bank']";
    private String amountInput ="//input[@id='amount1']";
    private String depositButton ="//button[@id='deposit1']";
    private String balance = "//p[@id='balance1']";
    private String withdrawButton = "//button[@id='withdraw1']";


//    3.Method

    public String getBalance(){
        return page.locator(balance).textContent();
    }
    public String headlineofPage(){
        String headerText = page.locator(pageheading).textContent();
        System.out.println("Page Header: " + headerText);
        return headerText;
    }

    public void DepositMoney(String amount){
        page.locator(amountInput).fill(amount);
        page.locator(depositButton).click();
    }

    public void withdrawMoney(String amount){
        page.locator(amountInput).fill(amount);
        page.locator(withdrawButton).click();
    }


}
