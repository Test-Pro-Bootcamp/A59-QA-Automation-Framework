import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name="NegativeLoginTestData")
    public static Object[][]getNegativeLoginTestData() {
        return new Object[][] {
                {"invalid@testpro.io", "invalidPassword"},
                {"demo@testpro.io", ""},
                {"",""}
        };
    }
}
