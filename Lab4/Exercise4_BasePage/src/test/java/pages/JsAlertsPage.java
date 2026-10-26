package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigReader;

public class JsAlertsPage extends BasePage {
    private final By alertButton =
            By.cssSelector("button[onclick='jsAlert()']");
    private final By confirmButton =
            By.cssSelector("button[onclick='jsConfirm()']");
    private final By promptButton =
            By.cssSelector("button[onclick='jsPrompt()']");
    private final By result = By.id("result");

    public JsAlertsPage(WebDriver driver) {
        super(driver);
    }

    public JsAlertsPage open() {
        navigateTo(ConfigReader.get("baseUrl",
                "https://the-internet.herokuapp.com")
                + "/javascript_alerts");
        return this;
    }

    private Alert waitAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        click(alertButton);
        waitAlert().accept();
    }

    public void dismissConfirm() {
        click(confirmButton);
        waitAlert().dismiss();
    }

    public void answerPrompt(String text) {
        click(promptButton);
        Alert alert = waitAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResult() {
        return getText(result);
    }
}