import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Task_08 extends Chrome {

    private boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Test
    public void Execute() {
        driver.navigate().to("http://localhost/litecart/");

        int numberOfItems = driver.findElements(By.xpath("//*[@class='product column shadow hover-light']")).size();
        for (int i = 1; i <= numberOfItems; i++) {
            Assert.assertTrue(isElementPresent(driver, By.xpath("(//*[@class='product column shadow hover-light'])[" + i + "]/a/div/div[contains (@class, 'sticker')]")));
        }
        driver.close();
    }
}

