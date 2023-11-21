# README #


### Project ###
This project is an automation framework for testing the property search and filter functionality of the Daft web application.
It utilizes Java, Selenium WebDriver, Cucumber, and AssertJ for testing


### Table of Contents ###
Table of Contents
Project Structure
Dependencies
How to Run
Cucumber Feature Files
Step Definitions
Base Page
WebDriver Configuration
Test Execution
Test Reports

### Project Structure ###
The project is organized as follows:

* src/test/java: Contains the test automation code.
* DaftSearchSteps: Step definitions for Cucumber scenarios.
* BasePage: Utility functions for WebDriver interactions.
* src/main/resources: Contains feature files with Cucumber scenarios.
* pom.xml: Maven Project Object Model file with dependencies and build configurations.


### Dependencies ###
* Selenium WebDriver: Used for browser automation.
* Cucumber: Enables behavior-driven development (BDD) testing.
* AssertJ: Provides fluent assertions for better test readability.
* WebDriverManager: Simplifies the management of WebDriver binaries.


### How to Run ###
* Ensure you have Java and Maven installed on your system. Testing was executed using Java 17
* Clone the repository to your local machine.
* Open a terminal and navigate to the project directory.
* Run the tests using the following command: mvn clean install
* Test can also be run using the Cucumber Test Runner - DevTest



### Cucumber Feature Files ###
Property search and filter.feature: Contains Gherkin syntax feature scenarios for testing property search and filter functionality.

### Step Definitions ###
* DaftSearchSteps: Contains step definitions corresponding to the Gherkin scenarios. Defines actions to perform during test execution.

### BasePage ###
* BasePage: Provides common utility functions for WebDriver interactions, such as waiting for elements and extracting numbers from strings.

### WebDriver Configuration ###
* WebDriver is configured to use ChromeDriver for automated testing.
* WebDriverManager is used to manage the WebDriver binaries automatically.

### Test Reports ###
Test reports are generated in the target/cucumber-reports directory after test execution.