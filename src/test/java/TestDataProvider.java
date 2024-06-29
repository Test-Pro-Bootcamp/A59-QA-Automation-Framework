import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest{

    @DataProvider(name="NegativeLoginTestData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@testpro.io","invalidPassword"},
                {"demo@testpro.io","invalidPassword"},
                {"invalid@testpro.io","te$t$tudent"},
                {"demo@testpro.io",""},
                {"","te$t$tudent"}
        };
    }

}