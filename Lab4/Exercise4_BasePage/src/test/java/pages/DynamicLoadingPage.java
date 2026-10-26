package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class DynamicLoadingPage extends BasePage {
    private final By startButton = By.cssSelector("#start button");
    private final By finish = By.cssSelector("#finish h4");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage open(int example) {
        navigateTo(ConfigReader.get("baseUrl",
                "https://the-internet.herokuapp.com")
                + "/dynamic_loading/" + example);
        return this;
    }

    public String startAndGetResult() {
        click(startButton);
        return getText(finish);
    }
}