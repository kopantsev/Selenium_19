import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTest extends Chrome {

    @Test
    public void ExecuteTest() throws IOException, InterruptedException {

        driver.navigate().to("http://www.google.com");
        Thread.sleep(5000);
        driver.close();

    }
}
