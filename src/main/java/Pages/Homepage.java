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
    private String depositEntry = "//ul[@id='history1']/li[span[contains(text(), 'Deposit of $1000.00')]]";
    private String withdrawHistory = "//ul[@id='history1']/li[span[contains(text(), 'Withdrawal of $200.00')]]";
    private String transferButton ="//button[@id='transfer1']";
    private String transferhistory="//span[contains(text(),'Transfer of $100.00 to Account 0987654321')]";
    private String transferhistoryuser2="//span[contains(text(),'Transferred $100.00 to Account 1234567890')]";
    private String addinterestButton="//button[@id='interest1']";
    private String resetButton="//button[@id='reset1']";



//    3.Method

    public String getBalance(){
        return page.locator(balance).textContent();
    }
    public String headlineOfHomePage(){
        String headerText = page.locator(pageheading).textContent();
        System.out.println("Page Header: " + headerText);
        return headerText;
    }

    public void depositMoney(String amount){
        page.locator(amountInput).fill(amount);
        page.locator(depositButton).click();
    }

    public boolean depositMoneyEntryVisible(){
        return  page.locator(depositEntry).isVisible();

    }

//    withdraw
    public void withdrawMoney(String amount){
        page.locator(amountInput).fill(amount);
        page.locator(withdrawButton).click();
    }
    public boolean  withdrawHistoryVisible(){
        return page.locator(withdrawHistory).isVisible();

    }

//    transfer
    public void transferMoney(String amount, String accountNumber) {
        page.onceDialog(dialog -> {
            dialog.accept(accountNumber);
        });
        page.locator(amountInput).fill(amount);
        page.locator(transferButton).click();
    }
    public boolean isTransferSuccessful() {
        return page.locator(transferhistoryuser2).isVisible() && page.locator(transferhistory).isVisible();
    }

//    interest

    public void addInterest(){
        page.locator(addinterestButton).click();
    }

//    ResetAccount
public void resetAccount() {
    // Step 1: Handle the confirmation dialog
    page.onceDialog(dialog -> dialog.accept());
    page.locator(resetButton).click();
    };

}


