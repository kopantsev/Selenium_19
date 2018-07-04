import org.testng.annotations.Test;

public class Task_01 extends Chrome {

    @Test
    public void ExecuteTest() throws InterruptedException {

        driver.navigate().to("http://www.google.com");
        Thread.sleep(5000);
        driver.close();
    }
}
