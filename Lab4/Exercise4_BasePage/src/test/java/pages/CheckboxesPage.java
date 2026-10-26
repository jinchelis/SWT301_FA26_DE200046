package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class CheckboxesPage extends BasePage {
    private final By boxes =
            By.cssSelector("#checkboxes input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public CheckboxesPage open() {
        navigateTo(ConfigReader.get("baseUrl",
                "https://the-internet.herokuapp.com") + "/checkboxes");
        return this;
    }

    private WebElement box(int index) {
        waitForVisibility(boxes);
        return driver.findElements(boxes).get(index);
    }

    public void check(int index) {
        WebElement checkbox = box(index);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheck(int index) {
        WebElement checkbox = box(index);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isChecked(int index) {
        return box(index).isSelected();
    }
}