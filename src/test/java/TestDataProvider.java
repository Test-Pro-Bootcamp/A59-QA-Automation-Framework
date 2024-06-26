import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {

    @DataProvider(name = "NegativeLoginTestData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"alekseikoksharov@testpro.io","invalidPassword"},   //alekseikoksharov@testpro.io - invalid email
                {"aleksei.koksharov@testpro.io","invalidPassword"},
                {"alekseikoksharov@testpro.io","ak1234!@#$"},        //  ak1234!@#$ - valid password
                {"aleksei.koksharov@testpro.io",""},
                {"","ak1234!@#$"}

        };
    }

}
