import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_07 extends Chrome {

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Test
    public void Execute() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.name("login")).click();

        int submenusNumber = driver.findElements(By.id("app-")).size();
        for (int j = 1; j <= submenusNumber; j++) {
            driver.findElement(By.xpath("//*[@id='box-apps-menu']/li[" + j + "]/a")).click();
            Assert.assertTrue(isElementPresent(driver, By.tagName("h1")));

            int itemsNumber = driver.findElements(By.xpath("//*[@id='box-apps-menu']/li[" + j + "]/ul/li")).size();
            if (itemsNumber != 0) {
                for (int k = 1; k <= itemsNumber; k++) {
                    driver.findElement(By.xpath("//*[@id='box-apps-menu']/li[" + j + "]/ul/li[" + k + "]")).click();
                    Assert.assertTrue(isElementPresent(driver, By.tagName("h1")));
                }
            }
        }
        driver.close();
    }
}








