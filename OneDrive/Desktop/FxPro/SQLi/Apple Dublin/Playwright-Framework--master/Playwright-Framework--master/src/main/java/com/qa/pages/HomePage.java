package com.qa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    // 1. String Locators -

    private  String startCollectingGoldBtn="#skeletonAd";
    private  String startCollectingGoldBtn_closed=".startCard";

    // 2. page constructor:
    public HomePage(Page page) {

        this.page = page;
    }

    // 3. page actions/methods:
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("page title: " + title);
        return title;
    }

    public String getHomePageURL() {
        String url = page.url();
        System.out.println("page url : " + url);
        return url;
    }

    public void clickOnStart() throws InterruptedException {
        System.out.println("Waiting for some time to load the page..");
        Thread.sleep(10000);
        page.locator(startCollectingGoldBtn).click();
        Thread.sleep(10000);
        System.out.println("Clicked on Start Collecting Gold..");

    }

    public boolean  verifyStartCollectingGoldBtnVisible()
    {
       return page.isVisible(startCollectingGoldBtn);
    }

    public Boolean  verifyStartCollectingGoldBtnClicked()
    {
        return page.isVisible(startCollectingGoldBtn_closed);

    }

}
