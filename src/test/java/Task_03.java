import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Task_03 extends Chrome {

    @Test
    public void ExecuteTest() throws InterruptedException {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
