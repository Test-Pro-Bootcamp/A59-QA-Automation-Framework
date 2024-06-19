import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {


    @DataProvider(name = "NegativeLoginTestData")
    public static  Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"invalid@testpro.io", "invalidPassword"},
                {"christina.taylor@testpro.io", "invalidPassword"},
                {"invalid@testpro.io", "jKV0uSX6z1dv"},
                {"christina.taylor@testpro.io", ""},
                {"", "jKV0uSX6z1dv"},
        };
    }
}

