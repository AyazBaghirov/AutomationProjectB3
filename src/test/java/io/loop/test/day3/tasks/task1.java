package io.loop.test.day3.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.loop.test.utilities.TItleConstants.EXPECTED_TITLE_FOR_GMAIL;
import static io.loop.test.utilities.TItleConstants.EXPECTED_TITLE_FOR_GOOGLE;


public class task1 {
    public static void main(String[] args) {
        //Open a chrome browse
        WebDriver driver =new ChromeDriver();

        // Go to: https://google.com
        driver.get("https://google.com");

        //Click to Gmail from top right.
        WebElement searchBoxWithClassName = driver.findElement(By.className("gb_I"));
        searchBoxWithClassName.click();

        //Verify title contains:
        //Expected: Gmail
        String actualTitleForGmail = driver.getTitle();
        if (actualTitleForGmail.contains(EXPECTED_TITLE_FOR_GMAIL)){
            System.out.println("Expected Title: "+EXPECTED_TITLE_FOR_GMAIL +" matches actual "+ actualTitleForGmail+ "test passed");
        }else {
            System.out.println("Expected Title: "+EXPECTED_TITLE_FOR_GMAIL +" does not match actual "+ actualTitleForGmail+ "test failed");
        }
        //Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google

        String actualTitleForGoogle = driver.getTitle();
        if (actualTitleForGoogle.contains(EXPECTED_TITLE_FOR_GOOGLE)){
            System.out.println("Expected Title: "+EXPECTED_TITLE_FOR_GOOGLE +" matches actual "+ actualTitleForGoogle+ "test passed");
        }else {
            System.out.println("Expected Title: "+EXPECTED_TITLE_FOR_GOOGLE +" does not match actual "+ actualTitleForGoogle+ "test passed");
        }




    }
}
