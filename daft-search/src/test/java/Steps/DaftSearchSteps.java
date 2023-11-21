package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.FilterPage;
import pages.HomePage;
import pages.ResultPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DaftSearchSteps {


    private static WebDriver driver;
    private static HomePage homePage;
    private static FilterPage filterPage;
    private static ResultPage resultPage;
    private static BasePage basePage;
    private static int initialCount;
    static boolean prevScenarioFailed = false;


    @Before
    public void setUp() {
        if (prevScenarioFailed) {
            throw new IllegalStateException("Previous scenario failed!");
        }

    }

    /**
     * Open web app and initialize pages
     *
     * @param url Daft application
     */
    @Given("^I have navigated to Daft web application at (.*)$")
    public void navigateToUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
        filterPage = PageFactory.initElements(driver, FilterPage.class);
        resultPage = PageFactory.initElements(driver, ResultPage.class);

        basePage.waitForElementToBeClickable(homePage.acceptAllButton).click();
    }

    /**
     * This method searches for a property in a specified location
     *
     * @param location - property location
     */
    @When("^I search the term (.*) using the homepage search tool$")
    public void searchProperties(String location) {
        homePage.homepageSearchBox.sendKeys(location);
        basePage.waitForSeconds(2);
        homePage.homepageSearchBox.sendKeys(Keys.ENTER);
        basePage.waitForElementToBeClickable(homePage.homepageSearchBox).sendKeys(Keys.ENTER);
    }

    /**
     * This method verifies search result
     *
     * @param searchResultText -
     */
    @Then("^(.*) should be displayed in the search result$")
    public void verifySearchResult(String searchResultText) {
        basePage.waitForSeconds(2);
        assertThat(resultPage.searchResultsHeader.getText())
                .as("The expected search result text is not contained in the result header")
                .contains(searchResultText);
    }

    /**
     * This method applies filter to a search result
     *
     */
    @Then("^I apply the keyword filter, (.*) to the search result$")
    public void applyFilters(String keywordFilter) {
        homePage.filtersButton.click();
        basePage.waitForSeconds(2);

        initialCount = BasePage.extractNumber(filterPage.filterModalResultsButton.getText());
        filterPage.keywordField.sendKeys(keywordFilter, Keys.TAB);
        basePage.waitForSeconds(2);
    }

    /**
     * Compares that the number of filtered records is less to total records
     */
    @Then("^the number of filtered results should be less than total number of results before the filtering$")
    public void verifyFilterIsApplied() {
        int finalCount = BasePage.extractNumber(filterPage.filterModalResultsButton.getText());
        filterPage.filterModalResultsButton.click();
        basePage.waitForSeconds(2);

        assertThat(finalCount).as("Number of filtered results is not less than before").isLessThan(initialCount);
    }

    /**
     * Verify that searched keyword correctly reflects in the ad
     *
     */
    @Then("^the URL of the result page should contain the search query: (.*)$")
    public void verifyFilterResult(String searchQuery) {
        Assertions.assertThat(driver.getCurrentUrl())
                .as("The URL does not contain the expected search query")
                .contains(searchQuery);
    }

    /**
     * Open the first ad from the list and verify it has the expected keyword filter
     *
     */
    @And("^the term, (.*) should be contained in any of the results, when opened$")
    public void verifyKeywordInContainedInAFilterResult(String searchQuery) {
        if (resultPage.filteredResultList.isEmpty()) {
            throw new NoSuchElementException("No elements found in the filter list");
        }

        resultPage.filteredResultList.get(0).click();
        basePage.waitForSeconds(2);

        Assertions.assertThat(driver.getPageSource())
                .as("The expected search result text is not contained in the result header")
                .containsIgnoringCase(searchQuery);
    }

    @After()
    public void stopExecutionAfterFailure(Scenario scenario) {
        prevScenarioFailed = scenario.isFailed();
    }

    @Then("^the browser should close$")
    public void quitBrowser() {
        driver.quit();

    }
}
