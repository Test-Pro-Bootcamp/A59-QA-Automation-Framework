import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {
    @DataProvider(name="IncorrectLoginData")
    public static Object[][]getDataFromDataProviders() {
        return new Object[][] {
                {"invalid@testpro.io", "invalidPassword"},
                {"demo@testpro.io", ""},
                {"",""}
        };
    }
}
