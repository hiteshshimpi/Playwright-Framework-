package com.qa.tests;

import com.microsoft.playwright.Page;
import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase_VerifyCheckoutFlow extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    @Test
    @Parameters({"UserName", "Password"})
    public void verifyCompleteCheckout(String userName, String passWord) {
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        SoftAssert softAssert = new SoftAssert();

        try {
            softAssert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE, "Login page title mismatch");
            softAssert.assertTrue(loginPage.isLoginBtnVisible(), "Login button is not visible");

            loginPage.doLogin(userName, passWord);

            String title = homePage.getHomePageTitle();
            softAssert.assertEquals(title, AppConstants.HOME_PAGE_TITLE, "Home page title mismatch");

            String url = homePage.getHomePageURL();
            softAssert.assertEquals(url, AppConstants.HOME_PAGE_TITLE, "Home page URL mismatch");

            softAssert.assertTrue(homePage.checkInventoryPageIsDisplayed(), "Inventory page is not displayed");

            homePage.selectAndAddToCart("Sauce Labs Backpack");
            homePage.clickOnCart();
            softAssert.assertTrue(homePage.verifyItemAddedToCart("Sauce Labs Backpack"), "Item was not added to cart");



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            softAssert.assertAll(); // This ensures assertion errors are reported even after catch
        }
    }


















}



