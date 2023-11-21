package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilterPage {

    private final WebDriver driver;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(id = "keywordtermsModal")
    public WebElement keywordField;

    @FindBy(xpath = "//button[@data-testid='filters-modal-show-results-button']")
    public WebElement filterModalResultsButton;



}