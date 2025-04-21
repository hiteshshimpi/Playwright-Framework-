package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;
import com.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_001_StartCollectingButtonClickable extends BaseTest {
   public static HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    @Test(priority= 4)
    public void TC_Click_StartCollectingGold_Button() throws InterruptedException {
        homePage = new HomePage(page);
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnStart();
        homePage.verifyStartCollectingGoldBtnVisible();
    }


    @Test(priority = 1)
    public void homePageTitleTest() {
        homePage = new HomePage(page);
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void homePageURLTest() {
        homePage = new HomePage(page);
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL,"https://adjoe-qa-tasks.s3.eu-central-1.amazonaws.com/release/ver2.html");
    }
    @Test(priority =3)
    public void startCollectingBtnVisible() {
        homePage = new HomePage(page);
        boolean actualValue = homePage.verifyStartCollectingGoldBtnVisible();
        Assert.assertEquals(actualValue,Boolean.TRUE);
    }
    @Test(priority =5)
    public void startCollectingBtnclicked() {
        homePage = new HomePage(page);
        Assert.assertNotEquals(homePage.verifyStartCollectingGoldBtnClicked(),Boolean.TRUE);
    }
}





