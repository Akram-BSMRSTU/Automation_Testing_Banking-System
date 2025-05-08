package Factory;

import com.microsoft.playwright.*;

import java.awt.*;

public class PlaywrightFactory {

    private static PlaywrightFactory instance;
    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    private PlaywrightFactory() {}

    // Singleton instance
    public static PlaywrightFactory getInstance() {
        if (instance == null) {
            instance = new PlaywrightFactory();
        }
        return instance;
    }

    // Initialize browser (only once)
    public Page initBrowser(String browserName) {


//        int width = (int)screensize.getWidth();
//        int height = (int)screensize.getHeight();
        if (playwright == null) {
            System.out.println("Starting " + browserName);
            playwright = Playwright.create();

            switch (browserName.toLowerCase()) {
                case "chromium":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;

                case "safari":
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "chrome":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                    break;

                default:
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;
            }

            if(!GraphicsEnvironment.isHeadless()){
                Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int)screensize.getWidth();
                int height = (int)screensize.getHeight();
                browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
            }
            else
                browserContext = browser.newContext();
            page = browserContext.newPage();
            page.navigate("https://testing-and-learning-hub.vercel.app/index.html");
        }
        return page;
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
            playwright.close();
        }
    }
}
