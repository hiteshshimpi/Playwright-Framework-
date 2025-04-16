package com.qa.base;

import com.microsoft.playwright.Page;

import com.qa.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    public static Page page;
    protected LoginPage loginPage;

    PlaywrightFactory play;

    @BeforeClass
    @Parameters({ "appURL", "browserType" })
    public void setUp(String appURL, String browserType) {
        play = new PlaywrightFactory();
        page = play.getPage(appURL, browserType);
        loginPage = new LoginPage(page);
    }

    @AfterClass
    public void tearDown() {
        page.context().browser().close();
    }

}
