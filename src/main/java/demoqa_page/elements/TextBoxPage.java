package demoqa_page.elements;

import demoqa_page.BasePage;
import demoqa_page.CommonMethods;
import demoqa_page.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class TextBoxPage extends BasePage {

    @FindBy(css=Selectors.TEXT_BOX_FULL_NAME)
    private WebElement fullNameInput;

    @FindBy(css=Selectors.TEXT_BOX_EMAIL)
    private WebElement emailInput;

    @FindBy(css=Selectors.TEXT_BOX_CURRENT_ADDRESS)
    private WebElement currentAddressTextArea;

    @FindBy(css=Selectors.TEXT_BOX_PERMANENT_ADDRESS)
    private WebElement permanentAddressTextArea;

    @FindBy(css=Selectors.TEXT_BOX_SUBMIT_BUTTON)
    private WebElement submitButton;

    @FindBy(css=Selectors.TEXT_BOX_OUTPUT)
    private WebElement output;


    public TextBoxPage(WebDriver driver) {
        super(driver);
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


