package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
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
    public void findElementByXPath() throws Exception {
        System.out.println("Find element by id using xPath:");
////*[@id="heading_2"]
        System.out.println("\t text of element with xpath '//*[@id=\"heading_2\"]' is '" +
                driver.findElement(By.xpath("//*[@id=\"heading_2\"]")).getText() + "'");

        System.out.println("\t text of element with xpath '//*[@id=\"test1\"]/p[1]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test1\"]/p[1]")).getText() + "'");

        System.out.println("\t text of element with xpath '//*[@id=\"test1\"]/p[2]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test1\"]/p[2]")).getText() + "'");

        System.out.println("\t text of element with xpath '//*[@id=\"test3\"]/p[1]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test3\"]/p[1]")).getText() + "'");

        System.out.println("\t text of element with xpath '//*[@id=\"test3\"]/p[2]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test3\"]/p[2]")).getText() + "'");

        System.out.println("\t text of element with xpath '//*[@id=\"test2\"]/p[1]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test2\"]/p[1]")).getText() + "'");

        System.out.println("\t text of element with xpath '//*[@id=\"buttonId\"]' is '" +
                driver.findElement(By.xpath("//*[@id=\"buttonId\"]")).getAttribute("value") + "'");




                //*[@id="heading_1"]   (By.xpath("//*[@id='heading_1']"))
//         TODO:
//        2 ways to find text: "Heading 2 text":
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"
    }

    @Test
    public void findElementByCssName() throws Exception {

        System.out.println("Find element by id using class:");
        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.className("test")).getText() + "'");

        System.out.println("\t text of element with class 'twoTest' is '" +
                driver.findElement(By.className("twoTest")).getText() + "'");

        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.className("test")).getText() + "'");

        System.out.println("\t text of element with name 'randomButton1' is '" +
                driver.findElement(By.name("randomButton1")).getAttribute("value") + "'");
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"
    }
}
