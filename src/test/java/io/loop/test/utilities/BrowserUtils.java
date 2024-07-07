package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author ayaz
     * implements assertion
     */

    public static void  switchWindowValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle =expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        Set<String> windowhandles = driver.getWindowHandles();
        for(String each : windowhandles  ){
            driver.switchTo().window(each);

            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle));{
                return;
            }
        }
    }
}
