import javafx.scene.paint.Color;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_10_Chrome extends Chrome {

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
        driver.navigate().to("http://localhost/litecart");

        String name01 = driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.name")).getText();
        String regPrice01 = driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getText();
        String campPrice01 = driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getText();
        Color regPriceColor01 = Color.valueOf(driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getCssValue("color"));
        Color campPriceColor01 = Color.valueOf(driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getCssValue("color"));
        Double campPriceFontSize01 = sizeInPxToDouble(driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getCssValue("font-size"));
        Double regPriceFontSize01 = sizeInPxToDouble(driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getCssValue("font-size"));

        Assert.assertEquals(driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getCssValue("text-decoration-line"), "line-through");
        Assert.assertTrue(isGrey(regPriceColor01));
        Assert.assertEquals(driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getCssValue("font-weight"), "700");
        Assert.assertTrue(isRed(campPriceColor01));
        Assert.assertTrue(campPriceFontSize01 > regPriceFontSize01);

        driver.findElement(By.cssSelector("#box-campaigns > div > ul > li")).click();

        String name02 = driver.findElement(By.cssSelector("#box-product > div:nth-child(1) > h1")).getText();
        String regPrice02 = driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > s")).getText();
        String campPrice02 = driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > strong")).getText();
        Color regPriceColor02 = Color.valueOf(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > s")).getCssValue("color"));
        Color campPriceColor02 = Color.valueOf(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > strong")).getCssValue("color"));
        Double campPriceFontSize02 = sizeInPxToDouble(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > strong")).getCssValue("font-size"));
        Double regPriceFontSize02 = sizeInPxToDouble(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > s")).getCssValue("font-size"));

        Assert.assertEquals(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > s")).getCssValue("text-decoration-line"), "line-through");
        Assert.assertTrue(isGrey(regPriceColor02));
        Assert.assertEquals(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > strong")).getCssValue("font-weight"), "700");
        Assert.assertTrue(isRed(campPriceColor02));
        Assert.assertTrue(campPriceFontSize02 > regPriceFontSize02);

        Assert.assertEquals(name02, name01);
        Assert.assertEquals(regPrice02, regPrice01);
        Assert.assertEquals(campPrice02, campPrice01);

        driver.close();
    }
}
