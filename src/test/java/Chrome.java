import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
    WebDriver driver = new ChromeDriver();

    void fillField(By locator, String input) {
        WebElement el = driver.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(Keys.HOME + input);
    }

    void login(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @After
    public void terminate() {
        driver.quit();
    }
}