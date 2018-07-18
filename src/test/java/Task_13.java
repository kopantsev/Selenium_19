import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task_13 extends Chrome {

    @Test
    public void execute() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.navigate().to("http://localhost/litecart/");
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.className("product")).click();
            if (isElementPresent(driver, tagName("select"))) {
                Select select = new Select(driver.findElement(tagName("select")));
                select.selectByIndex(1);
            }
            driver.findElement(cssSelector("[name='add_cart_product']")).click();
            wait.until(textToBe(cssSelector("span.quantity"), String.valueOf(i)));
            driver.navigate().to("http://localhost/litecart/");
        }
        driver.findElement(By.cssSelector("a.link[href='http://localhost/litecart/en/checkout']")).click();
        wait.until(visibilityOfElementLocated(cssSelector("#box-checkout-cart > ul > li:nth-child(1) > a > img"))).click();

        Integer numberOfRows = driver.findElements(By.cssSelector("td.item")).size();
        for (int i = 1; i <= numberOfRows; i++) {
            WebElement removeButton = driver.findElement(By.cssSelector("[name='remove_cart_item']"));
            removeButton.click();
            wait.until(stalenessOf(removeButton));
        }

        Assert.assertTrue(isElementPresent(driver, tagName("em")));
        driver.close();
    }
}
