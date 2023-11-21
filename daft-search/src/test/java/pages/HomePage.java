package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "didomi-notice-agree-button")
    public WebElement acceptAllButton;

    @FindBy(id = "search-box-input")
    public WebElement homepageSearchBox;

    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    public WebElement filtersButton;

}