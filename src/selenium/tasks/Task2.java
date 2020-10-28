package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
        WebElement name = driver.findElement(By.id("fb_name"));
        WebElement age = driver.findElement(By.id("fb_age"));
        WebElement english = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        WebElement french = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]"));
        WebElement spanish = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]"));
        WebElement chinese = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]"));
        WebElement male = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/label[1]"));
        WebElement female = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[2]"));
        WebElement commentBox = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[6]/textarea"));
        WebElement disable = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/label[3]"));
        WebElement button =driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button"));

        assertFalse(name.isSelected());
        assertFalse(english.isSelected());
        assertFalse(french.isSelected());
        assertFalse(spanish.isSelected());
        assertFalse(chinese.isSelected());
        assertFalse(male.isSelected());
        assertFalse(female.isSelected());
        assertEquals("",commentBox.getText());
        assertEquals("",name.getText());
        assertEquals("",age.getText());
       // assertTrue(disable.isSelected());
        driver.findElement(By.className("w3-select")).click();
        driver.findElement(By.xpath("//*[@id=\"like_us\"]/option[2]")).click();
        assertEquals("rgba(255, 255, 255, 1)", button.getCssValue("color"));
        assertEquals("rgba(33, 150, 243, 1)", button.getCssValue("background-color"));

//#2196f3
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
    }

    @Test
    public void emptyFeedbackPage() throws Exception {

        WebElement button =driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button"));

        button.click();
        WebElement name =driver.findElement(By.id("name"));
        WebElement age = driver.findElement(By.id("age"));
        WebElement language = driver.findElement(By.id("language"));
        WebElement gender = driver.findElement(By.id("gender"));
        WebElement option = driver.findElement(By.id("option"));
        WebElement comment = driver.findElement(By.id("comment"));

        assertEquals("", name.getAttribute("innerText"));
        assertEquals("", age.getAttribute("innerText"));
        assertEquals("", language.getAttribute("innerText"));
        assertEquals("null", gender.getAttribute("innerText"));
        assertEquals("null", option.getAttribute("innerText"));
        assertEquals("", comment.getAttribute("innerText"));

        WebElement yesButton =driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]"));
        WebElement noButton =driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]"));
        assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));



//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
        WebElement name = driver.findElement(By.id("fb_name"));
        WebElement age = driver.findElement(By.id("fb_age"));
        WebElement english = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        WebElement french = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]"));
        WebElement spanish = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]"));
        WebElement chinese = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]"));
        WebElement male = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]"));

        WebElement commentBox = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[6]/textarea"));
        WebElement button =driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button"));

        driver.findElement(By.className("w3-select")).click();
        driver.findElement(By.xpath("//*[@id=\"like_us\"]/option[2]")).click();
        name.sendKeys("Girts");
        age.sendKeys("24");
        commentBox.sendKeys("You are great!");
        english.click();
        french.click();
        spanish.click();
        chinese.click();
        male.click();
        button.click();
        WebElement name2 =driver.findElement(By.id("name"));
        WebElement age2 = driver.findElement(By.id("age"));
        WebElement language = driver.findElement(By.id("language"));
        WebElement gender = driver.findElement(By.id("gender"));
        WebElement option = driver.findElement(By.id("option"));
        WebElement comment = driver.findElement(By.id("comment"));

        assertEquals("Girts", name2.getAttribute("innerText"));
        assertEquals("24", age2.getAttribute("innerText"));
        assertEquals("English,French,Spanish,Chinese", language.getAttribute("innerText"));
        assertEquals("male", gender.getAttribute("innerText"));
        assertEquals("Good", option.getAttribute("innerText"));
        assertEquals("You are great!", comment.getAttribute("innerText"));

        WebElement yesButton =driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]"));
        WebElement noButton =driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]"));
        assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));





//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {

        WebElement name = driver.findElement(By.id("fb_name"));
        WebElement button =driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button"));

        ////*[@id="fb_thx"]/div/div[2]/button[1]
        name.sendKeys("Girts");
        button.click();
        Thread.sleep(1000);
        WebElement yesButton =driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]"));
        yesButton.click();
        WebElement messageBox = driver.findElement(By.id("message"));
        assertEquals("Thank you, Girts, for your feedback!", messageBox.getAttribute("innerText"));
        assertEquals("rgba(255, 255, 255, 1)", messageBox.getCssValue("color"));
        assertEquals("rgba(0, 0, 0, 0)", messageBox.getCssValue("background-color"));

//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
        WebElement button =driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button"));
        button.click();
        WebElement yesButton =driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]"));
        yesButton.click();
        WebElement messageBox = driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div"));
        assertEquals("Thank you for your feedback!", messageBox.getAttribute("innerText"));
        assertEquals("rgba(255, 255, 255, 1)", messageBox.getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)", messageBox.getCssValue("background-color"));

//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void noOnFeedbackPage() throws Exception {

        WebElement name = driver.findElement(By.id("fb_name"));
        WebElement age = driver.findElement(By.id("fb_age"));
        WebElement english = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        WebElement french = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]"));
        WebElement spanish = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]"));
        WebElement chinese = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]"));
        WebElement male = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]"));

        WebElement commentBox = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[6]/textarea"));
        WebElement button =driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button"));

        driver.findElement(By.className("w3-select")).click();
        driver.findElement(By.xpath("//*[@id=\"like_us\"]/option[2]")).click();
        name.sendKeys("Girts");
        age.sendKeys("24");
        commentBox.sendKeys("You are great!");
        english.click();
        french.click();
        spanish.click();
        chinese.click();
        male.click();
        button.click();
        WebElement noButton =driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]"));
        noButton.click();
        WebElement name2 = driver.findElement(By.id("fb_name"));
        WebElement age2 = driver.findElement(By.id("fb_age"));
        WebElement english2 = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        WebElement french2 = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]"));
        WebElement spanish2 = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]"));
        WebElement chinese2 = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]"));
        WebElement male2 = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]"));
        WebElement commentBox2 = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[6]/textarea"));
        //assertEquals("Girts", name2.getAttribute("innerText"));
        //assertTrue(name2.getText().contains("Girts"));
        //assertEquals("24", age2.getAttribute("innerText"));
        assertTrue(english2.isSelected());
        assertTrue(chinese2.isSelected());
        assertTrue(spanish2.isSelected());
        assertTrue(french2.isSelected());
        assertTrue(male2.isSelected());
        //assertEquals("You are great!", commentBox2.getAttribute("innerText"));

//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
    }
}
