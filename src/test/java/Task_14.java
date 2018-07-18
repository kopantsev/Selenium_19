import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;


public class Task_14 extends Chrome {

    public ExpectedCondition<String> anyWindowOtherThan(final Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    @Test
    public void execute() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        login("admin", "1234");
        driver.findElement(By.cssSelector("a.button")).click();

        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();

        List<WebElement> links = driver.findElements(By.cssSelector("i.fa-external-link"));

        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            driver.close();
            driver.switchTo().window(mainWindow);
        }
        terminate();
    }
}
