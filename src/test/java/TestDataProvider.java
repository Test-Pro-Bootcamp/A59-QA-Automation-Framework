import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {
//    @DataProvider(name="IncorrectLoginData")
    @DataProvider(name="NegativeLoginTestData")
    public static Object[][]getDataFromDataProviders() {
        return new Object[][] {
                {"invalid@testpro.io", "te$t$tudent1"},
                {"james.mar@testpro.io", ""},
                {"james.mar@testproio", "te$t$tudent1"},
                {"",""}
        };
    }
}
