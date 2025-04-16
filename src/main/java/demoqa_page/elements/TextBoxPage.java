package demoqa_page.elements;

import demoqa_page.BasePage;
import demoqa_page.CommonMethods;
import demoqa_page.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TextBoxPage extends BasePage {
    private WebElement fullNameInput;
    private WebElement emailInput;
    private WebElement currentAddressTextArea;
    private WebElement permanentAddressTextArea;
    private WebElement submitButton;
    private WebElement output;

    private WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.fullNameInput = driver.findElement(By.cssSelector(Selectors.TEXT_BOX_FULL_NAME));
        this.emailInput = driver.findElement(By.cssSelector(Selectors.TEXT_BOX_EMAIL));
        this.currentAddressTextArea = driver.findElement(By.cssSelector(Selectors.TEXT_BOX_CURRENT_ADDRESS));
        this.permanentAddressTextArea = driver.findElement(By.cssSelector(Selectors.TEXT_BOX_PERMANENT_ADDRESS));
        this.submitButton = driver.findElement(By.cssSelector(Selectors.TEXT_BOX_SUBMIT_BUTTON));
        this.output = driver.findElement(By.cssSelector(Selectors.TEXT_BOX_OUTPUT));
        this.driver = driver;
    }

    public void fillFullNameInput(String value) {
        fullNameInput.clear();
        fullNameInput.sendKeys(value);
    }

    public void fillEmailInput(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickSubmitButton() {
       CommonMethods.clickButtonAfterScrolling(submitButton,driver);

    }




    public String getOutputText() {
        List<WebElement> outputs = output.findElements(By.cssSelector(".mb-1"));
        StringBuilder stringBuilder = new StringBuilder();
        for (WebElement output:outputs){
          stringBuilder.append(output.getText());
          stringBuilder.append("\n"); //перенос рядка
        }return  stringBuilder.toString();
    }

}


