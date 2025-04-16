package com.qa.pages;

import com.microsoft.playwright.Page;

public class CartPage {

    private String subHeader=".subheader";
    private  Page page;

    public CartPage(Page page){
        this.page=page;
    }

    public String getCartPageTitle() {

        return page.title();
    }

    public boolean verifySubHeader()
    {
       return page.isVisible(subHeader);
    }

    public static void verifyProductsInCart(String productName)
    {


    }
}
