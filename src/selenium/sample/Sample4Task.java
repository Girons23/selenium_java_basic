package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number"
        WebElement number = driver.findElement(By.id("number"));
        number.sendKeys("23");

        WebElement actShowResult = driver.findElement(By.id("clear_result_button_number"));
        assertFalse(actShowResult.isEnabled());

        WebElement result_number = driver.findElement(By.id("result_number"));
        assertFalse(result_number.isDisplayed());

        WebElement resultButton = driver.findElement(By.id("result_button_number"));
        resultButton.click();

        assertTrue(result_number.isEnabled());

       // assertEquals("You entered number: \"523\"", result_number.getText());
        assertTrue(result_number.getText().contains("235"));

        assertTrue(actShowResult.isEnabled());
        actShowResult.click();
        assertEquals("",result_number.getText());
        assertFalse(result_number.isDisplayed());

//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed


    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage

        assertEquals(base_url, driver.getCurrentUrl());

        driver.findElement(By.id("homepage_link")).click();


        assertFalse(driver.getCurrentUrl().equals(base_url));

    }
}
