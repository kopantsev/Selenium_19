import javafx.scene.paint.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_10_Firefox {

    private static Double sizeInPxToDouble(String str) {
        return Double.valueOf(str.substring(0, str.length() - 2));
    }

    private boolean isGrey(Color color) {
        double r = color.getRed();
        double g = color.getGreen();
        double b = color.getBlue();
        return (r == g & g == b);
    }

    private boolean isRed(Color color) {
        double r = color.getRed();
        double g = color.getGreen();
        double b = color.getBlue();
        return (g == 0 & b == 0 & r != 0);
    }

    @Test
    public void execute() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://localhost/litecart");

        String name01 = driver.findElement(By.cssSelector("#box-campaigns a.link")).getAttribute("title");
        String regPrice01 = driver.findElement(By.cssSelector("#box-campaigns s.regular-price")).getText();
        String campPrice01 = driver.findElement(By.cssSelector("#box-campaigns strong.campaign-price")).getText();
        Color regPriceColor01 = Color.valueOf(driver.findElement(By.cssSelector("#box-campaigns s")).getCssValue("color"));
        Color campPriceColor01 = Color.valueOf(driver.findElement(By.cssSelector("#box-campaigns strong")).getCssValue("color"));
        Double campPriceFontSize01 = sizeInPxToDouble(driver.findElement(By.cssSelector("#box-campaigns strong")).getCssValue("font-size"));
        Double regPriceFontSize01 = sizeInPxToDouble(driver.findElement(By.cssSelector("#box-campaigns s")).getCssValue("font-size"));

        Assert.assertEquals(driver.findElement(By.cssSelector("#box-campaigns s")).getCssValue("text-decoration-line"), "line-through");
        Assert.assertTrue(isGrey(regPriceColor01));
        Assert.assertEquals(driver.findElement(By.cssSelector("#box-campaigns strong")).getCssValue("font-weight"), "900");
        Assert.assertTrue(isRed(campPriceColor01));
        Assert.assertTrue(campPriceFontSize01 > regPriceFontSize01);

        driver.findElement(By.cssSelector("#box-campaigns a.link")).click();

        String name02 = driver.findElement(By.cssSelector("h1.title")).getText();
        String regPrice02 = driver.findElement(By.cssSelector("s.regular-price")).getText();
        String campPrice02 = driver.findElement(By.cssSelector("strong.campaign-price")).getText();
        Color regPriceColor02 = Color.valueOf(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color"));
        Color campPriceColor02 = Color.valueOf(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color"));
        Double campPriceFontSize02 = sizeInPxToDouble(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size"));
        Double regPriceFontSize02 = sizeInPxToDouble(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size"));

        Assert.assertEquals(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line"), "line-through");
        Assert.assertTrue(isGrey(regPriceColor02));
        Assert.assertEquals(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight"), "700");
        Assert.assertTrue(isRed(campPriceColor02));
        Assert.assertTrue(campPriceFontSize02 > regPriceFontSize02);

        Assert.assertEquals(name02, name01);
        Assert.assertEquals(regPrice02, regPrice01);
        Assert.assertEquals(campPrice02, campPrice01);

        driver.close();
    }
}
