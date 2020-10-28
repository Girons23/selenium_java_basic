package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        WebElement option1 = driver.findElement(By.id("vfb-6-1"));
        WebElement option2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/span[2]/label"));
        WebElement option3 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/span[3]/label"));
        WebElement result = driver.findElement(By.id("result_button_checkbox"));
        WebElement result_checkbox = driver.findElement(By.id("result_checkbox"));
        ///html/body/div[3]/div[3]/div/div/span[3]/label
        //result_button_checkbox
        //result_checkbox
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }
        option2.click();

        //assertFalse(option1.isSelected()); // checkboxes are NOT selected

        assertFalse(option3.isSelected());// checkboxes are NOT selected

        //assertTrue(option2.isSelected());// checkbox is selected

        option3.click();
        result.click();
        assertTrue(result_checkbox.isDisplayed());
        assertEquals("You selected value(s): Option 2, Option 3", result_checkbox.getText());
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"result_checkbox\"]")).getText());
//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
    }


    @Test
    public void selectRadioButton() throws Exception {

        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected()); // radio are NOT selected
        }
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio']"));
        WebElement resultButton = driver.findElement(By.id("result_button_ratio"));
        WebElement result = driver.findElement(By.id("result_radio"));
        //result_radio
        option3.click();
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());

        option1.click();

        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option1.isSelected());

        resultButton.click();

        assertTrue(result.isDisplayed());

//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
    }

    @Test
    public void selectOption() throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Option 3");
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        ////*[@id="ui-datepicker-div"]/div/a[1]
//    select date 15
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();


        assertEquals(result, dateBox.getAttribute("value"));

//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.click();
        String dateToEnter = "05/02/1959";
        dateBox.sendKeys(dateToEnter);

        assertEquals(dateToEnter, dateBox.getAttribute("value"));
//05/02/1959
        System.out.println("Date printed out is " +
                dateBox.getAttribute("value") + "'");

//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
