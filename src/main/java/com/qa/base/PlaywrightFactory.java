package com.qa.base;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.nio.file.Paths;
import java.util.Base64;

public class PlaywrightFactory {

    static Playwright playwright;
    protected static Page page;
    static BrowserContext browserContext;
    static Browser browser;


    public static Page getPage() {

        return page;
    }
    @Parameters({"AppUrl","browserType"})
    public static Page getPage(String url, String browserType)
    {
        playwright= Playwright.create();
        switch (browserType){
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);
        return page;
    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }
}
