package com.qa.base;

import com.microsoft.playwright.Page;

import com.qa.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static Page page;
    protected HomePage homePage;

    PlaywrightFactory play;

    @BeforeClass
    @Parameters({ "appURL", "browserType" })
    public void setUp(String appURL, String browserType) {
        play = new PlaywrightFactory();
        page = play.getPage(appURL, browserType);
        homePage = new HomePage(page);
    }

    @AfterClass
    public void tearDown() {
        page.context().browser().close();
    }

}
