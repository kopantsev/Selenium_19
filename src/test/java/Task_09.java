import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task_09 extends Chrome {

    @Test
    public void executePartOne() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        login("admin", "1234");

        List<WebElement> Countries = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[5]/a"));
        List<String> listOfCountryNames = new ArrayList<String>();

        for (int i = 0; i < Countries.size(); i++) {
            listOfCountryNames.add(Countries.get(i).getText());
        }
        List<String> listSorted_01 = new ArrayList<String>(listOfCountryNames);
        Collections.sort(listSorted_01);
        Assert.assertEquals(listSorted_01, listOfCountryNames);

        for (int i = 2; i <= Countries.size() + 1; i++) {
            if (!driver.findElement(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[" + i + "]/td[6]")).getText().equals("0")) {
                driver.findElement(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[" + i + "]/td[5]/a")).click();

                List<WebElement> Zones = driver.findElements(By.xpath("//*[@type='hidden'][contains(@name, 'name')]"));
                List<String> listOfZoneNames = new ArrayList<String>();

                for (int j = 0; j < Zones.size(); j++) {
                    listOfZoneNames.add(Zones.get(j).getAttribute("value"));
                }
                List<String> listSorted_02 = new ArrayList<String>(listOfZoneNames);
                Collections.sort(listSorted_02);
                Assert.assertEquals(listSorted_02, listOfZoneNames);
                driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    @Test
    public void executePartTwo() {
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        //login("admin", "1234");

        List<WebElement> Countries_02 = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[3]/a"));

        for (int i = 2; i <= Countries_02.size() + 1; i++) {
            driver.findElement(By.xpath("//*[@id='content']/form/table/tbody/tr[" + i + "]/td[3]/a")).click();

            List<WebElement> Zones = driver.findElements(By.xpath("//*[@id='table-zones']/tbody/tr/td[3]/select/option[@selected]"));
            if (Zones.size() != 0) {
                List<String> listOfZoneNames = new ArrayList<String>();

                for (int j = 0; j < Zones.size(); j++) {
                    listOfZoneNames.add(Zones.get(j).getText());
                }
                List<String> listSorted_02 = new ArrayList<String>(listOfZoneNames);
                Collections.sort(listSorted_02);
                Assert.assertEquals(listSorted_02, listOfZoneNames);
                driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            } else {
                driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            }
        }
    }
}


