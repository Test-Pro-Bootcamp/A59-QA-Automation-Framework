import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {
//    @DataProvider(name="IncorrectLoginData")
    @DataProvider(name="NegativeLoginTestData")
    public static Object[][]getDataFromDataProviders() {
        return new Object[][] {
                {"invalid@testpro.io", "invalidPassword"},
                {"demo@testpro.io", ""},
                {"",""}
        };
    }
}
