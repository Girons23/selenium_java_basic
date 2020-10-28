package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Sample9Task {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
        WebElement greenButton = driver.findElement(By.id("start_green"));
       // WebElement greenLoading = driver.findElement(By.id("loading_green"));

        greenButton.click();
        assertFalse(greenButton.isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
       // assertEquals("Loading green...",driver.findElement(By.id("loading_green")));
        Thread.sleep(5000);
assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();
        assertFalse(greenButton.isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"finish_green\"]/label"));
        assertFalse(greenButton.isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {

        WebElement greenButton = driver.findElement(By.id("start_green"));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));

        greenButton.click();
        assertFalse(greenButton.isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        Thread.sleep(5000);
        assertFalse(greenButton.isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());

//         TODO:
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
    }

    @Test
    public void loadGreenAndBlueBonus() {

        WebElement gnbButton = driver.findElement(By.id("start_green_and_blue"));
      //  Thread.sleep(10000);
        gnbButton.click();
assertFalse(gnbButton.isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
      //  Thread.wait(5000);
        //Thread.sleep(5000);
        assertFalse(gnbButton.isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        /* TODO:
         * 0) wait until button to load green and blue appears
         * 1) click on start loading green and blue button
         * 2) check that button does not appear, but loading text is seen instead for green
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
    }

}