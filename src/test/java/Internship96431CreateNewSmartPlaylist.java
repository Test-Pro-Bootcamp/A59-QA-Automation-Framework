import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import static org.testng.Assert.assertTrue;

public class Internship96431CreateNewSmartPlaylist extends BaseTest {
    String newSmartPlaylistName = "Kristina's smart playlist";

    @Test(priority = 1)
    public void createNewSmartPlaylistWithOneRule() {
        String expectedCreatedSmartPlaylistMessage = "Created playlist \"Kristina's smart playlist.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Actions actions = new Actions(driver);

        loginPage.login();
        clickPlaylists();
        clickNewSmartPlaylist();
        inputNewSmartPlaylistName();
        clickAddGroupBtn();
        clickFirstCriteriaField();
        selectFirstCriteriaValue();
        clickSecondCriteriaField();
        selectSecondCriteriaValue();
        inputThirdCriteriaField();
        clickSaveBtn();
        Assert.assertEquals(getCreatedSmartPlaylistMessage(), expectedCreatedSmartPlaylistMessage);
    }

    public void clickPlaylists() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylist.click();
    }

    public void clickNewSmartPlaylist() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[2]")));
        clickNewPlaylistBtn.click();
    }

    public void inputNewSmartPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[1]/input")));
        newPlaylistName.sendKeys("Kristina's smart playlist");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public void clickAddGroupBtn() {
        WebElement clickAddGroupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/button")));
        clickAddGroupBtn.click();
    }

    public void clickFirstCriteriaField() {
        WebElement clickFirstCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]")));
        clickFirstCriteriaField.click();
    }

    public void selectFirstCriteriaValue() {
        WebElement selectFirstCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[2]")));
        selectFirstCriteriaValue.click();
    }

    public void clickSecondCriteriaField() {
        WebElement clickSecondCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]")));
        clickSecondCriteriaField.click();
    }

    public void selectSecondCriteriaValue() {
        WebElement selectSecondCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[3]")));
        selectSecondCriteriaValue.click();
    }

    public void inputThirdCriteriaField() {
        WebElement inputThirdCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/span/input")));
        inputThirdCriteriaField.sendKeys("A");
        inputThirdCriteriaField.click();
    }

    public void clickSaveBtn() {
        WebElement clickSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/footer/button[1]")));
        clickSaveBtn.click();
    }

    public String getCreatedSmartPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    @Test(priority = 2)
    public void createNewSmartPlaylistWithMultipleRule()  {
        String expectedCreatedPlaylistMessage = "Created playlist \"New smart playlist.\"";

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login();
        clickPlaylist();
        createNewSmartPlaylist();
        inputNewPlaylistName();
        clickGroupBtn();
        clickFirstCriteria();
        selectFirstCriteria();
        clickSecondCriteria();
        selectSecondCriteria();
        inputThirdCriteria();
        addMoreRules();
        clickSecondRuleFirstCriteria();
        selectSecondRuleFirstCriteria();
        clickSecondRuleSecondCriteria();
        selectSecondRuleSecondCriteria();
        inputSecondRuleThirdCriteria();
        addMoreGroup();
        clickThirdRuleFirstCriteria();
        selectThirdRuleFirstCriteria();
        clickThirdRuleSecondCriteria();
        selectThirdRuleSecondCriteria();
        inputThirdRuleThirdCriteria();
        enterSaveBtn();
        Assert.assertEquals(getCreatedPlaylistMessage(), expectedCreatedPlaylistMessage);


    }

    public void clickPlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylist.click();
    }

    public void createNewSmartPlaylist() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[2]")));
        clickNewPlaylistBtn.click();
    }

    public void inputNewPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[1]/input")));
        newPlaylistName.sendKeys("New smart playlist");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public void clickGroupBtn() {
        WebElement clickGroupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/button")));
        clickGroupBtn.click();
    }

    public void clickFirstCriteria() {
        WebElement clickFirstCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]")));
        clickFirstCriteriaField.click();
    }

    public void selectFirstCriteria() {
        WebElement selectFirstCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[2]")));
        selectFirstCriteriaValue.click();
    }

    public void clickSecondCriteria() {
        WebElement clickSecondCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]")));
        clickSecondCriteriaField.click();
    }

    public void selectSecondCriteria() {
        WebElement selectSecondCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[3]")));
        selectSecondCriteriaValue.click();
    }

    public void inputThirdCriteria() {
        WebElement inputThirdCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/span/input")));
        inputThirdCriteriaField.sendKeys("A");
        inputThirdCriteriaField.click();
    }

    public void addMoreRules() {
        WebElement clickAddMoreRuleBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/button")));
        clickAddMoreRuleBtn.click();
    }

    public void clickSecondRuleFirstCriteria() {
        WebElement clickSecondRuleFirstCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[3]/select[1]")));
        clickSecondRuleFirstCriteriaField.click();
    }

    public void selectSecondRuleFirstCriteria() {
        WebElement selectSecondRuleFirstCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[3]/select[1]/option[1]")));
        selectSecondRuleFirstCriteriaValue.click();
    }

    public void clickSecondRuleSecondCriteria() {
        WebElement clickSecondRuleSecondCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[3]/select[2]")));
        clickSecondRuleSecondCriteriaField.click();
    }

    public void selectSecondRuleSecondCriteria() {
        WebElement selectSecondRuleSecondCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[3]/select[2]/option[5]")));
        selectSecondRuleSecondCriteriaValue.click();
    }

    public void inputSecondRuleThirdCriteria() {
        WebElement inputThirdCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[3]/span/input")));
        inputThirdCriteriaField.sendKeys("H");
        inputThirdCriteriaField.click();
    }

    public void addMoreGroup() {
        WebElement clickAddMoreGroupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/button")));
        clickAddMoreGroupBtn.click();
    }

    public void clickThirdRuleFirstCriteria() {
        WebElement clickThirdRuleFirstCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[1]")));
        clickThirdRuleFirstCriteriaField.click();
    }

    public void selectThirdRuleFirstCriteria() {
        WebElement selectThirdRuleFirstCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[1]/option[3]")));
        selectThirdRuleFirstCriteriaValue.click();
    }

    public void clickThirdRuleSecondCriteria() {
        WebElement clickThirdRuleSecondCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[2]")));
        clickThirdRuleSecondCriteriaField.click();
    }

    public void selectThirdRuleSecondCriteria() {
        WebElement selectThirdRuleSecondCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[2]/option[4]")));
        selectThirdRuleSecondCriteriaValue.click();
    }

    public void inputThirdRuleThirdCriteria() {
        WebElement inputThirdRuleCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/span/input")));
        inputThirdRuleCriteriaField.sendKeys("B");
        inputThirdRuleCriteriaField.click();
    }

    public void enterSaveBtn() {
        WebElement enterSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/footer/button[1]")));
        enterSaveBtn.click();
    }

    public String getCreatedPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


    @Test(priority = 3)
    public void ifRuleDoesNotExist() {

        String expectedCreatedPlaylistMsg = "Created playlist \"Smart playlist.\"";
        String actualNoSongsMessage = "No songs match the playlist's criteria.";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        clickSmartPlaylist();
        createSmartPlaylist();
        inputPlaylistName();
        clickGroupButton();
        click1StCriteria();
        select1StCriteria();
        click2NdCriteria();
        select2NdCriteria();
        input3RdCriteria();
        enterSaveButton();
        Assert.assertEquals(getCreatedPlaylistMsg(), expectedCreatedPlaylistMsg);
        Assert.assertEquals(getNoSongsMatchMsg(), actualNoSongsMessage);


    }

    public void clickSmartPlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylist.click();
    }

    public void createSmartPlaylist() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[2]")));
        clickNewPlaylistBtn.click();
    }

    public void inputPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[1]/input")));
        newPlaylistName.sendKeys("Smart playlist");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public void clickGroupButton() {
        WebElement clickGroupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/button")));
        clickGroupBtn.click();
    }

    public void click1StCriteria() {
        WebElement clickFirstCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]")));
        clickFirstCriteriaField.click();
    }

    public void select1StCriteria() {
        WebElement selectFirstCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[7]")));
        selectFirstCriteriaValue.click();
    }

    public void click2NdCriteria() {
        WebElement clickSecondCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]")));
        clickSecondCriteriaField.click();
    }

    public void select2NdCriteria() {
        WebElement selectSecondCriteriaValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[1]")));
        selectSecondCriteriaValue.click();
    }

    public void input3RdCriteria() {
        WebElement inputThirdCriteriaField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/span/input")));
        inputThirdCriteriaField.sendKeys("07/31/2024");
        inputThirdCriteriaField.click();
    }

    public void enterSaveButton() {
        WebElement enterSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/footer/button[1]")));
        enterSaveBtn.click();
    }

    public String getCreatedPlaylistMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public String getNoSongsMatchMsg() {
        WebElement noSongsMatchMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div")));
        return noSongsMatchMsg.getText();
    }

@Test(priority = 4)
    public void smartPlaylistNameShouldHaveSameRuleAsRegular() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login();
        clickPlaylistsBtn();
        createSmartPlaylists();
        inputSmartPlaylistName(longPlaylistName);
        clickSaveButton();
        validatePlaylistName(longPlaylistName);

    }
    public void clickPlaylistsBtn() {
        WebElement clickPlaylistsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylistsBtn.click();
    }

    public void createSmartPlaylists() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[2]")));
        clickNewPlaylistBtn.click();
    }

    public void inputSmartPlaylistName(String longPlaylistName) {
        WebElement newPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[1]/input")));

    }
}



