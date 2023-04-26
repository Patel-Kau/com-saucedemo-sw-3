package testsuite;

import Utility.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDoem() {
        driver.close();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //  Verify the text “PRODUCTS”
        String expectedProductMessage = "Products";
        String actualProductMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        verifyTwoMessage(expectedProductMessage, actualProductMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        clickOnElement(By.xpath("//input[@id='login-button']"));
        List<WebElement> product = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualQuantity = product.size();
        int expectedQuantity = 6;
        Assert.assertEquals(expectedQuantity, actualQuantity);


        // Verify that six products are displayed on page


    }

}
