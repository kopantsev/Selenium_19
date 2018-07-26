package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Page {
    @FindBy(name = "remove_cart_item")
    public WebElement removeButton;
    @FindBy(tagName = "emX")
    public WebElement noItemsInCartMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
