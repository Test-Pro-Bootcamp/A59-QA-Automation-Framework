import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = {"src/test/resources/features/Login.feature"},publish = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    // This method is executed before the class starts running and initializes the TestNGCucumberRunner.
    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    // This method overrides the scenarios() method from the AbstractTestNGCucumberTests class.
    // It provides the scenarios (feature files) to be executed by the TestNG framework.
//    @Override
    @DataProvider(parallel = true)
    public Object[][] scenario() {
        return super.scenarios();
    }
//    public Object[][] features() {
//        return testNGCucumberRunner.provideScenarios();
//    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
