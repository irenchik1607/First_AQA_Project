package page.element;

import demoqa_page.elements.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxPageTest {

    private TextBoxPage textBoxPage;
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize(); // розгорнули сторінку до макс розміру
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        textBoxPage = null;// щоб попередня сторінка не потрапила в наступний тест (зануляємо)
        driver.quit();
    }

    @Test
    public void fullNameFieldTest() {
        String input = "Ira";
        String expected = "Ira";

        textBoxPage.fillFullNameInput(input);
        textBoxPage.clickSubmitButton();

        String actual = textBoxPage.getOutputText();

        Assert.assertTrue(actual.contains(expected));

    }


}
