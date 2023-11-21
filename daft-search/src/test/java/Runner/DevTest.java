package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"Steps"},
        tags = "@search",
        features = {"src/test/resources/"})


/**
 This class is used to run the regression test suite.
 Execute by running:
 mvn test -Dtest="DevTest"
 */
public class DevTest {
}
