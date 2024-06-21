import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class P1 extends BaseTest {
    @Test
    public void openAlbums () {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        login("india.messam@testpro.io", "slcTalgy");


    }
    //select albums tab
    public void selectAlbumTab()  {
        By.cssSelector("[href='#!/albums']");

    }

}
