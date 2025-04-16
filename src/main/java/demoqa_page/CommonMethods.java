package demoqa_page;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import javax.swing.*;
import java.time.Duration;

public class CommonMethods {
    public static void clickButtonAfterScrolling(WebElement element, WebDriver driver) {
        FluentWait<WebElement> wait = new FluentWait<>(element)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(ElementClickInterceptedException.class);
        Actions actions = new Actions(driver);
        wait.until(webElement -> {
            actions.scrollByAmount(0, 50);
            actions.perform();
            element.click();
            return webElement;
        });
    }
}
