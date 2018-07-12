import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.openqa.selenium.By.cssSelector;

public class Task_11 extends Chrome {

    private void findAndFill(By locator, String input) {
        WebElement el = driver.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(Keys.HOME + input);
    }

    private void chooseCountry(By locator, String input) {
        Actions actions = new Actions(driver);
        WebElement el = driver.findElement(locator);
        actions.moveToElement(el);
        actions.click();
        actions.sendKeys(input + Keys.ENTER);
        actions.build().perform();
    }

    private String getRandomEmail() {
        return randomAlphanumeric(10) + "@" + randomAlphabetic(4) + "." + randomAlphabetic(2);
    }

    @Test
    public void execute() throws Exception {
        driver.navigate().to("http://localhost/litecart");
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/en/create_account']")).click();

        String myEmail = getRandomEmail();
        String myPassword = randomAlphanumeric(16);

        chooseCountry(cssSelector("span.selection"), "United States");
        findAndFill(cssSelector("[name='email']"), myEmail);
        findAndFill(cssSelector("[name='phone']"), "+1 800-275-8777");
        findAndFill(cssSelector("[name='password']"), myPassword);
        findAndFill(cssSelector("[name='confirmed_password']"), myPassword);
        findAndFill(cssSelector("[name='city']"), "Stanton");
        findAndFill(cssSelector("[name='postcode']"), "36790");
        findAndFill(cssSelector("[name='address1']"), "2230 Co Rd 45");
        findAndFill(cssSelector("[name='firstname']"), "John");
        findAndFill(cssSelector("[name='lastname']"), "Donne");
        driver.findElement(By.cssSelector("[name='newsletter']")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //logout
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/en/logout']")).click();
        Thread.sleep(1000);

        //login
        findAndFill(cssSelector("input[name='email']"), myEmail);
        findAndFill(cssSelector("input[name='password']"), myPassword);
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Thread.sleep(1000);

        //logout
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/en/logout']")).click();
        driver.close();
    }
}

