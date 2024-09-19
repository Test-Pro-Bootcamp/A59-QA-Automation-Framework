import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {

    @DataProvider(name = "NegativeLoginTestData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"alekseikoksharovtestpro.io","invalidPassword"},   //alekseikoksharov@testpro.io - invalid email
                {"aleksei.koksharov@testpro.io","invalidPassword"},
                {"aleksei.koksharovtestpro.io","ak1234!@#$"},        //  ak1234!@#$ - valid password
                {"aleksei.koksharov@testpro.io",""},
                {"","ak1234!@#$"}

        };
    }
    @DataProvider(name = "incorrectCredentials")
    public static Object[][] provideIncorrectCredentials(){
        return new Object[][] {
                {" "}, //empty password
                {"Ak12!"}, //less than 10 characters
                {"Ak123456!@#$%^"}, //more than 15 characters
                {"AKSD123!@#$"}, //with uppercase letters
                {"ahjdj12!@!"}, //with lowercase letters
                {"hsdkafHSAIFD"}, //just letters
                {"1234567890123"}, //just numbers
                {"Ak12341234"}, //without special characters
        };
    }
    @DataProvider(name = "emailRegistrationCredentials")
    public static Object[][] provideEmailRegistrationCredentials(){
        return new Object[][] {
                {" "}, //empty email
                {"aleksei.koksharovtestpro.io"}, //without '@' symbol
                {"alekseikoksharov@testproio"}, //without '.' dot
                {"aleksei.koksharov"}, //without '@testpro.io' domain
        };
    }

}
