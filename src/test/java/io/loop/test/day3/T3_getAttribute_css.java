package io.loop.test.day3;
/*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"
     */

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_getAttribute_css {
    public static void main(String[] args) {


    // go to url

    WebDriver driver = WebDriverUtil.getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://beta.docuport.app");

    //identify docuport with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));
        String docuport = logo.getAttribute("alt");
        System.out.println("docuport = "+docuport);

        if (DocuportConstants.LOGO_DOCUPORT.equals(docuport)){
            System.out.println("Expected matches with actual");
            System.out.println("TEST PASS");
        }else{
            System.err.println("Expected does NOT match the actual");
            System.out.println("TEST FAIL");
        }
    }

}