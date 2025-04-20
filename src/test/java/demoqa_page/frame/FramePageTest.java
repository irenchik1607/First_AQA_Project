package demoqa_page.frame;

import demoqa_page.BasePageTest;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FramePageTest extends BasePageTest {
    private FramePage framePage;


    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/frames");
        framePage = new FramePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        framePage = null;
        super.tearDown();
    }

    @Test
    public void sampleHeaderTextTest() {
        String expected = "This is a sample page";
        // String actual = framePage.getFirstFrameHeaderText();
        FramePage.SamplePage firstFrame = framePage.getFirstFrame();
        String actual = firstFrame.getHeaderText();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void newTabTest() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://privatbank.ua/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://testng.org/#_testng_xml");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com/watch?v=iQIR2Zgb93k&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=35");

        Thread.sleep(3000);

        for (String windowHandle : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowHandle).getTitle();
            assert title != null;//саме запропонувало
            if (title.toLowerCase().contains("demoqa")) {
                break;
            }
        }
        Thread.sleep(3000);

    }
}