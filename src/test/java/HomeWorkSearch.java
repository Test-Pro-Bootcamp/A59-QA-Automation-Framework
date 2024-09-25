import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkSearch extends BaseTest{

@Test
    public  void homeWorkSearch() throws InterruptedException {
    enterEmail("shikhabidovarusana@gmail.com");
    enterPassword("te$t$tudent");
    clickSubmit();
    Assert.assertTrue(searchField());


}
public  boolean  searchField () throws InterruptedException {
    WebElement clickSearchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
    Thread.sleep(1000);
    return clickSearchField.isDisplayed();
    }

}


