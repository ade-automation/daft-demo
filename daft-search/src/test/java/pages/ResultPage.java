package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultPage {

    private final WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[contains(text(),'Properties for Sale')]")
    public WebElement searchResultsHeader;

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div[3]/div[1]/ul/li[1]")
    public List<WebElement> filteredResultList;


}