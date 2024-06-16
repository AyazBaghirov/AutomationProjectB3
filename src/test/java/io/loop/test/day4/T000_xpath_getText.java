package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T000_xpath_getText {
    /*
    1. open chrome
    2. go to docuport
    3. click on forgot password
    4. validate url contains: reset password
    5.validate - Enter the email address associated with your account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate send button is displayed
    8.validate cancel button is displayed
    9. click send button
    10. validate = We ve sent you an email with a link to reser your password. pleaase check your email

     */
    public static void main(String[] args) throws InterruptedException {

        //    1. open chrome
        //    2. go to docuport
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        //3. click on forgot password
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();
        //4. validate url contains: reset password
        String actualURL =driver.getCurrentUrl();
        if (actualURL.contains(DocuportConstants.RESET_PASSWORD)){
            System.out.println("Actual url matches expexted");
        }else {
            System.out.println("Actual url Does NOT match expexted");
        }
        //5.validate - Enter the email address associated with your account
        WebElement validateMessage =driver.findElement(By.xpath("//*[contains(text(),'Enter the email')]"));
        String actualValidateMessage =validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAIL");
        }
        //6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        // 7. validate send button is displayed
        // 8.validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if (cancelButton.isDisplayed()){
            System.out.println("TEST PASSED- cancel is displayed");
        }else {
            System.out.println("Test fail- cancel is not displayed");
        }
        if (sendButton.isDisplayed()){
            System.out.println("TEST PASSED- send is displayed");
        }else {
            System.out.println("Test fail- send is not displayed");
        }
        //9. click send button
        sendButton.click();

        Thread.sleep(3000);

        // 10. validate = We ve sent you an email with a link to reser your password. pleaase check your email
        WebElement succesMessage =driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(5000);
       // String actualMessage =succesMessage.getText();
       // System.out.println("actualMessage = " + actualMessage);

        try{
            System.out.println(succesMessage.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
        }

    }
}
