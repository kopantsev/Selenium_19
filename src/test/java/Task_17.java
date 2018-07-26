import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_17 extends Chrome {

    @Test
    public void execute() {

        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        login("admin", "1234");

        driver.findElement(By.linkText("Rubber Ducks")).click();
        int numberOfLinks = driver.findElements(By.partialLinkText("Duck")).size();
        for (int i = 1; i < numberOfLinks; i++) {
            driver.findElements(By.partialLinkText("Duck")).get(i).click();
            driver.manage().logs().get("browser").forEach(l -> {
                Assert.assertEquals(l.toString(), (""));
            });
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.history.go(-1)");
        }
        driver.quit();
    }
}
