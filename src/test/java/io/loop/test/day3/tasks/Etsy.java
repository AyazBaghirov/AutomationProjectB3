package io.loop.test.day3.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.loop.test.utilities.TItleConstants.EXPECTED_TITLE_FOR_ETSY_WOODEN_SPOON;

public class Etsy {
    public static void main(String[] args) {

        //Open Chrome browser
        WebDriver driver =new ChromeDriver();

        driver.get("https://www.etsy.com");

        //Search for “wooden spoon”
        WebElement searchForElement = driver.findElement(By.id("global-enhancements-search-query"));
        searchForElement.sendKeys("wooden spoon");

        //Verify title:
        //Expected: “Wooden spoon | Etsy”
        String actualTitleForEtsy = driver.getTitle();
        if (actualTitleForEtsy.contains("Wooden spoon | Etsy")){
            System.out.println("Expected Title: "+ EXPECTED_TITLE_FOR_ETSY_WOODEN_SPOON+" matches actual "+ actualTitleForEtsy+ "test passed");
        }else {
            System.out.println("Expected Title: "+ EXPECTED_TITLE_FOR_ETSY_WOODEN_SPOON+" matches actual "+ actualTitleForEtsy+ "test failed");
        }
    }
}
