import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Chrome {
    WebDriver driver = new ChromeDriver();

    public void fillField(By locator, String input) {
        WebElement el = driver.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(Keys.HOME + input);
    }


    public void login(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop() {
        //driver.close();
        //driver = null;
    }
}