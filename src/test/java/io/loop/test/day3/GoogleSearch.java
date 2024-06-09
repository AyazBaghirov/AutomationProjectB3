package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the brower
 */
public class GoogleSearch {
    public static void main(String[] args) {
        // in selenium 3 we had to set up the driver, for that we need webdrivermanager libraries

        // create diriver object
        WebDriver driver = new ChromeDriver();

        //navigatei to google
        driver.get("https://www.google.com");

        //maximize
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Actual title is: " + actualTitle+", expected title is: " + expectedTitle+". => TEST PASS");
        }else {
            System.err.println("Actual title is: " + actualTitle+", DOES NOT expected title: " + expectedTitle+". => TEST FAIL");
        }

        String expectedUrl = "https://www.google.com";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl)){
            System.out.println("Actual url is: " + actualUrl+", matches expected url: " + expectedUrl+". => TEST PASS");
        }else {
            System.err.println("Actual url is: " + actualUrl+", DOES NOT matches expected url: " + expectedUrl+". => TEST FAIL");

        }
        driver.quit();

    }
}
