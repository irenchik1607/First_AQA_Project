package demoqa_page.frame;

import demoqa_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#frame1")
    private WebElement firstFrame;

    public String getFirstFrameHeaderText() {
        driver.switchTo().frame(firstFrame);
//        WebElement header = driver.findElement(By.cssSelector("#sampleHeading")); робота без Іннер класу
//        return header.getText();
        SamplePage firstFrame = new SamplePage();

        String headerText =firstFrame.getHeaderText();
        driver.switchTo().parentFrame();
        return headerText;
    }


    //робота з фреймом напряму через Іннер клас
    public SamplePage getFirstFrame() {
        driver.switchTo().frame(firstFrame);
        return new SamplePage();
    }


    public class SamplePage {
        @FindBy(css = "#sampleHeading")
        private WebElement header;


        public SamplePage() {
            PageFactory.initElements(driver, this);
        }

        public String getHeaderText() {
            return header.getText();
        }

        public FramePage returnToParentFrame(){
            driver.switchTo().parentFrame();
            return new FramePage(driver);
        }

    }


}
