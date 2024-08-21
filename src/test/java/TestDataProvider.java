import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {
//    @DataProvider(name="IncorrectLoginData")
    @DataProvider(name="NegativeLoginTestData")
    public static Object[][]getDataFromDataProviders() {
        return new Object[][] {
                {"invalid@testpro.io", "te$t$tudent"},
                {"demo@testpro.io", ""},
                {"demo@testproio", "te$t$tudent"},
                {"",""}
        };
    }
}
