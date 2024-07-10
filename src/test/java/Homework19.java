import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    @Parameters({"BaseURL"})
    public void deletePlaylist(String baseURL) throws InterruptedException {
        // navigate to login page for Koel app
        navigateToPage(baseURL);
        // Step 1 - Login
        enterEmail("leon.poyau@testpro.io");;
        enterPassword("jTRCkwNf");
        submit();
    }
}
