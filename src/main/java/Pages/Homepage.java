package Pages;

import com.microsoft.playwright.Page;

public class Homepage {
    Page page;
    public Homepage(Page page) {
        super();
        this.page = page;
    }


//    1.Locator
    private String pageheading = "//h1[normalize-space()='Welcome to Your Bank']";


//    3.Method
    public String headlineofPage(){
        String headerText = page.locator(pageheading).textContent();
        System.out.println("Page Header: " + headerText);
        return headerText;
    }



}
