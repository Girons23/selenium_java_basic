package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
        long expected = 5;
        long real = driver.findElements(By.className("test")).size();
        assertEquals(expected, real);
//         check that value of second button is "This is also a button"
        String expected2 = "This is also a button";
        String real2 = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expected2, real2);
        assertEquals(expected2, real2);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
        String expected = "This is also a button";
        String actual = (driver.findElement(By.name("randomButton2")).getAttribute("value"));
        assertTrue(actual.equalsIgnoreCase(expected));
        // pass:
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
    }

    @Test
    public void assertFalseExample() throws Exception {
        String exp = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(exp.equals("This is a button"));
        assertFalse(exp.equals("wrong text"));
        assertFalse(exp.contains("wrong text"));
        assertFalse(false);

//        check that it is False that value of second button is "This is a button"
    }

    @Test
    public void failTask() throws Exception {
//        TODO:

        List <WebElement> allElementsWithClass = driver.findElements(By.className("test"));

            assertFalse(allElementsWithClass.contains("190"));
        }
            }


