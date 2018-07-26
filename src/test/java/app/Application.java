package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import pages.MainPage;
import pages.ProductPage;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Application {

    private WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private MainPage mainPage = new MainPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private CheckoutPage checkoutPage = new CheckoutPage(driver);

    public void quit() {
        driver.quit();
    }

    public void addProductToCart() {
        mainPage.open();
        mainPage.product.click();
        productPage.manageSelectIfNeeded();
        productPage.addAndWaitForCartToUpdate();
    }

    public void checkout() {
        mainPage.cart.click();
    }

    public void removeItemsFromCart() {
        wait.until(visibilityOfElementLocated(cssSelector("#box-checkout-cart > ul > li:nth-child(1) > a > img"))).click();
        int numberOfRows = driver.findElements(cssSelector("td.item")).size();
        for (int i = 1; i <= numberOfRows; i++) {
            WebElement removeButton = driver.findElement(cssSelector("[name='remove_cart_item']"));
            removeButton.click();
            wait.until(stalenessOf(removeButton));
        }

    }
}
