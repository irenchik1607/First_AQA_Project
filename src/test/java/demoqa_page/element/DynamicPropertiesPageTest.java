package demoqa_page.element;

import demoqa_page.BasePageTest;
import demoqa_page.elements.DynamicPropertiesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicPropertiesPageTest extends BasePageTest {

    private DynamicPropertiesPage page;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/dynamic-properties");
        page = new DynamicPropertiesPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        page=null;
        super.tearDown();
    }

@Test
    public void enableAfterButtonBackgroundColorTest(){

    page.waitElementToBeClickable();

    String beforeHover = page.getBackgroundColorEnableAfterButton();
    page.moveToEnableAfterButton();
    String afterHover = page.getBackgroundColorEnableAfterButton();

    Assert.assertNotEquals(afterHover, beforeHover);
}

}