import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Chrome {
    WebDriver driver = new ChromeDriver();

    @After
    public void stop() {
        //driver.close();
        //driver = null;
    }
}