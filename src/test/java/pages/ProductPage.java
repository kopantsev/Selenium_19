package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class ProductPage extends Page {
    @FindBy(name = "add_cart_product")
    public WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void manageSelectIfNeeded() {
        if (isElementPresent(driver, tagName("select"))) {
            Select select = new Select(driver.findElement(tagName("select")));
            select.selectByIndex(1);
        }
    }

    public void addAndWaitForCartToUpdate() {
        int currentNumberOfItems = Integer.valueOf(NumberOfItems.getText());
        String currentNumberOfItemsPlusOne = String.valueOf(currentNumberOfItems + 1);
        addToCartButton.click();
        wait.until(textToBe(cssSelector("span.quantity"), currentNumberOfItemsPlusOne));
    }
}
