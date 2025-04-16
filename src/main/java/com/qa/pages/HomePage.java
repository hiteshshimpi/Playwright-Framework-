package com.qa.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.List;

public class HomePage {
    private Page page;

    // 1. String Locators - OR
    private String shoppingCart = ".shopping_cart_link";

    private String btn_OpenMenu = "//button[text()='Open Menu']";

    private String lnk_Logout = "//a[text()='Logout']";

    private String appLogo = "//div[@class='app_logo']";

    private String addProducts = "//button[text()='Add to cart']";

    private String productPrice = "//div[@class='inventory_item_price']";

    private String productName = "//div[@class='inventory_item_name ']";

    private String sortProductDropdown = "//select[@class='product_sort_container']";


    private String item = "//div[@class='inventory_item']";

    private String item_Name = ".inventory_item_name";
    private String addToCart = "button.btn_primary.btn_inventory";


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

    public void selectAndAddToCart(String targetProductName) {
        // Find all product containers
        List<ElementHandle> products = page.querySelectorAll(item);

        for (ElementHandle product : products) {
            // Get the product name from within this product block
            ElementHandle nameElement = product.querySelector(item_Name);
            if (nameElement == null) continue;

            String name = nameElement.innerText().trim();

            if (name.equalsIgnoreCase(targetProductName)) {
                // Found the matching product – now click its "Add to Cart" button
                ElementHandle addToCartButton = product.querySelector(addToCart);

                if (addToCartButton != null) {
                    addToCartButton.click();
                    System.out.println("Clicked 'Add to Cart' for product: " + name);
                } else {
                    System.out.println("Add to Cart button not found for product: " + name);
                }

                return; // Exit after finding the match
            }
        }
    }

    public boolean checkInventoryPageIsDisplayed() {
        try {
            return (page.isVisible(appLogo));
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click on shopping cart
    public void clickOnCart() {
        page.click(shoppingCart);
        System.out.println("Clicked on Cart icon on HomePage");
    }

    public boolean verifyItemAddedToCart(String targetProductName) {
        List<ElementHandle> products = page.querySelectorAll(item);

        for (ElementHandle product : products) {
            // Get the product name from within this product block
            ElementHandle nameElement = product.querySelector(item_Name);
            if (nameElement == null) continue;

            String name = nameElement.innerText().trim();

            if (name.equalsIgnoreCase(targetProductName)) {
                // Found the matching product – now click its "Add to Cart" button
                ElementHandle addedToCart = product.querySelector("btn_secondary btn_inventory");
                if (addedToCart.isChecked()) {
                    System.out.println("Item is added to the cart " + targetProductName);
                    return true;
                } else {
                    System.out.println("Item is not added to the cart " + targetProductName);
                    return false;
                }
            }
        }
        return false;
    }
}
