import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Task_08 extends Chrome {

    @Test
    public void Execute() {
        driver.navigate().to("http://localhost/litecart/");

        List<WebElement> products = driver.findElements(By.className("product"));
        for (int i = 0; i < products.size(); i++) {
            Assert.assertNotNull(products.get(i).findElement(By.xpath("./a/div/div[contains (@class, 'sticker')]")));
        }
        driver.close();
    }
}

