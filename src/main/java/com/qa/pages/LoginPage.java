package com.qa.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    // 1. String Locators - OR
    private String username = "#user-name";
    private String password = "#password";
    private String loginBtn = "#login-button";

    private String products =".product_label";

    // 2. page constructor:
    public LoginPage(Page page) {

        this.page = page;
    }

    // 3. page actions/methods:
    public String getLoginPageTitle() {

        return page.title();
    }

    public boolean isLoginBtnVisible() {

        return page.isVisible(loginBtn);
    }

    public boolean doLogin(String appUserName, String appPassword) {
        System.out.println("Login creds: " + appUserName + ":" + appPassword);
        page.fill(username, appUserName);
        page.fill(password, appPassword);
        page.click(loginBtn);
        page.locator(products).waitFor();
        if(page.locator(products).isVisible()) {
            System.out.println("user is logged in successfully....");
            return true;
        }else {
            System.out.println("user is not logged in successfully....");
            return false;
        }
    }
}
