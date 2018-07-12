import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.cssSelector;

public class Task_12 extends Chrome {
    @Test
    public void execute() throws Exception {
        driver.navigate().to("http://localhost/litecart/admin/");
        login("admin", "1234");
        driver.findElement(By.xpath("//*[@id='box-apps-menu']/li[2]")).click();
        Thread.sleep(500);
        driver.findElement(cssSelector("#content > div:nth-child(2) > a:nth-child(2)")).click();

        //заполняем данные продукта на вкладке General
        driver.findElement(By.cssSelector("input[type='radio'][value='1']")).click();
        fillField(cssSelector("input[name='name[en]']"), "Spiderman");
        fillField(cssSelector("input[name='code']"), "SPDR001");
        driver.findElement(By.cssSelector("input[value='1-3']")).click();
        fillField(cssSelector("input[name='quantity']"), "9000");
        Select soldOutStatus = new Select(driver.findElement(By.cssSelector("select[name='sold_out_status_id']")));
        soldOutStatus.selectByValue("2");
        String filePath = System.getProperty("user.dir") + "/src/res/spiderman.jpg";
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(filePath);
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("01012018");
        driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("01012028");

        //заполняем данные продукта на вкладке Information
        driver.findElement(By.cssSelector("a[href='#tab-information']")).click();
        Thread.sleep(500);
        Select manufacturer = new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
        manufacturer.selectByValue("1");
        fillField(cssSelector("input[name='keywords']"), "Spiderman");
        fillField(cssSelector("input[name='short_description[en]']"), "Your Friendly Neighborhood Spiderman");
        fillField(cssSelector("div.trumbowyg-editor"), "Does whatever a spider can.");
        fillField(cssSelector("input[name='head_title[en]']"), "Spiderman");
        fillField(cssSelector("input[name='meta_description[en]']"), "Spiderman");

        //заполняем данные продукта на вкладке Prices
        driver.findElement(By.cssSelector("a[href='#tab-prices']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("10");
        Select currency = new Select(driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")));
        currency.selectByValue("USD");
        driver.findElement(By.cssSelector("button[name='save']")).click();
        driver.close();

    }
}
