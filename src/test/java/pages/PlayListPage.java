package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlayListPage extends BasePage {

    public static final String playlistNameEmpty = "";
    public static final String playlistNameWithOneCharacter = "J";
    public static final String playlistName = "Sounds-Great-01";
    public static final String playlistNameWith256Characters = "1234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678";
    public static final String songName = "grav";


    // Constructors
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    // Locators
//    @FindBy(xpath = "//i[@data-testid=\"sidebar-create-playlist-btn\"][@title=\"Create a new playlist\"][@class=\"fa fa-plus-circle create\"]")
    @FindBy(xpath = "//section[@id='playlists']//i[@role='button']")
    private WebElement getCreateNewPlaylistBtn;

    @FindBy(xpath = "//li[@data-testid=\"playlist-context-menu-create-simple\"][contains(text(), \"New Playlist\")]")
    private WebElement getNewPlaylistBtn;

    @FindBy(xpath = "//li[@data-testid=\"playlist-context-menu-create-smart\"][contains(text(), \"New Smart Playlist\")]")
    private WebElement getNewSmartPlaylistBtn;

//    @FindBy(xpath = "//input[@placeholder=\"↵ to save\"][@name=\"name\"][@required=\"required\"]")
//    @FindBy(xpath = "//input[@name=\"name\"][@required=\"required\"]")
    @FindBy(xpath = "//section[@id='playlists']//input[@name='name']")
    private WebElement getTitleNameField;

    @FindBy(xpath = "/html//div[@id='mainWrapper']//div[@class='smart-playlist-form']//form//input[@name='name']")
    private WebElement getTitleNameFieldForSmartPlaylist;

    @FindBy(xpath = "/html//div[@id='mainWrapper']//div[@class='smart-playlist-form']/div/form//div[@class='rule-group']/div")
    private WebElement getTest;

    @FindBy(xpath="/html//div[@id='mainWrapper']//div[@class='smart-playlist-form']/div/form//div[@class='rule-group']/div[@data-test='smart-playlist-rule-row']")
    private List<WebElement> getTestXPath2;

    //    @FindBy(xpath = "//*[contains(text(), 'Created playlist \""  + "TestPro Playlist" + ".\"')]")
//    @FindBy(xpath = "//*[contains(text(), 'Created playlist \"" + playlistName + ".\"')]")
    @FindBy(xpath = "/html/body/div[2]/div[.='Created playlist \"" + playlistName + ".\"']")
    private WebElement getCreatedVerificationMsg;

    @FindBy(css = "input[type='search']")
    private WebElement getSearchSongField;

//    @FindBy(css = "button[data-test='view-all-songs-btn']")
    @FindBy(xpath="/html//section[@id='searchExcerptsWrapper']//section[@class='songs']//button[1][contains(text(), 'View All')]")
    private WebElement getViewAllSongs;

    @FindBy(xpath = "//*[@id=\"songResultsWrapper\"]//table[@class=\"items\"]")
    private WebElement getFirstSong;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")
    private WebElement getAddSongToBtn;

    @FindBy(xpath = "/html//div[@class='alertify']/div/div")
    private WebElement getAlertBoxMsg;

    @FindBy(xpath = "/html//div[@id='mainWrapper']//div[@class='smart-playlist-form']/div/form")
    private WebElement getCreateNewSmartPlaylistForm;

    @FindBy(xpath = "//div[@id='mainWrapper']//div[@class='smart-playlist-form']/div/form//div[@class='rule-group']/div[@class='row']/select[@name='model[]']/option[j]")
    private WebElement getRuleSelectorColumnOneForSmartPlaylist;

//    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playlistName)]")
//    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), '" + playlistName + "')]")
    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class='playlist'][contains(text(), '" + playlistName + "')]")
//    @FindBy(xpath = "//section[@id='songResultsWrapper']//section[@class='existing-playlist'][contains(text(), '" + playlistName + "')]")
    private WebElement getPlaylist;

    //    @FindBy(xpath = "//*[contains(text(), 'Added 1 song into \"" + "TestPro Playlist" + ".\"')]")
    @FindBy(xpath = "/html/body/div[2]/div[.='Added 1 song into \"" + playlistName + ".\"']")
    private WebElement getAddedVerificationMsg;

//    @FindBy(xpath = "//a[contains(text(), 'TestPro Playlist')]")
//    @FindBy(xpath = "//a[contains(text(), '" + playlistName + "')]")
//    @FindBy(xpath = "//section[@id='playlists']/ul//a[contains(text(), '" + playlistName + "')]")
//    @FindBy(xpath = "//section[@id='playlists']/ul//a[contains(text(), 'Sounds-Great-01')]")
//    @FindBy(xpath = "//ul//a[contains(text(), 'Sounds-Great-01')]")
//    @FindBy(xpath="//section[@id='playlistWrapper']//div[@class='song-list-controls']//button[@title='Delete this playlist']")
//    @FindBy(xpath="//section[@id='playlists']/ul//a[@href='#!/playlist/97868']")
    @FindBy(xpath = "//a[contains(text(), '" + playlistName + "')]")
    private WebElement getPlaylistToDelete1;

    @FindBy(xpath="//section[@id='playlistWrapper']//div[@class='song-list-controls']//button[@title='Delete this playlist']")
    private WebElement getPlaylistToDelete2;

    // <button title="Delete this playlist" class="del btn-delete-playlist"> Playlist </button>
//    @FindBy(xpath = "//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]"
//    @FindBy(xpath = "//section[@id='playlists']//nav[@class='menu playlist-item-menu']/ul/li[.='Delete']")
    @FindBy(xpath= "//section[@id='playlistWrapper']//div[@class='song-list-controls']//button[@title='Delete this playlist']")
    private WebElement getPlaylistToDeleteBtn;

//    @FindBy(xpath = "//button[@class=\"ok\"][contains(text(), OK)]")
//    @FindBy(xpath = "//div[@class='dialog']/div/nav/button[@class='ok']")
    @FindBy(xpath = "/html//div[@class='alertify']//nav/button[@class='ok']")
    private WebElement getPlaylistToDeleteOkBtn1;

    @FindBy(xpath = "//button[@class=\"ok\"][contains(text(), Ok)]")
    private WebElement getPlaylistToDeleteOkBtn2;

//    @FindBy(xpath = "//*[contains(text(), 'Deleted playlist \""  + "TestPro Playlist" + ".\"')]")
    @FindBy(xpath = "/html/body/div[2]/div[.='Deleted playlist \"" + playlistName + ".\"']")
    private WebElement getDeletedVerificationMsg;

//    @FindBy(xpath = "//section[@id='songResultsWrapper']//section[@class='existing-playlists'][contains(text(), '" + playlistNameWith256Characters + "')]
    @FindBy(xpath = "//section[@id='songResultsWrapper']//section[@class='existing-playlists']//li[contains(text(), '" + playlistNameWith256Characters + "')]")
    private WebElement getPlaylistWith256Characters;

    @FindBy(xpath = "/html/body/div[2]/div[.='Created playlist \"" + playlistNameWith256Characters + ".\"']")
    private WebElement getCreatedVerificationMsgFor256Characters;

//    @FindBy(xpath = "//section[@id='playlists']/ul//a[contains(text(), '" + playlistNameWith256Characters + "')]")
    @FindBy(xpath = "//a[contains(text(), '" + playlistNameWith256Characters + "')]")
    private WebElement getPlaylistToDeleteWith256Characters;

    @FindBy(xpath = "/html/body/div[2]/div[.='Deleted playlist \"" + playlistNameWith256Characters + ".\"']")
    private WebElement getDeletedVerificationMsgFor256Characters;

    @FindBy(xpath="//section[@id='songResultsWrapper']//div[@class='add-to']/section[@class='existing-playlists']/p[.='Add 1 song to']")
    private WebElement getPlaylistToAddSongTo;


    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), '" + playlistNameWithOneCharacter + "')]")
    private WebElement getPlaylistWithOneCharacter;

    @FindBy(xpath = "//*[contains(text(), 'Created playlist \"" + playlistNameWithOneCharacter + ".\"')]")
    private WebElement getCreatedVerificationMsgForOneCharacter;

//    @FindBy(xpath = "//section[@id='playlist']/ul//a[contains(text(), '" + playlistNameWithOneCharacter + "')]")
    @FindBy(xpath = "//a[contains(text(), '" + playlistNameWithOneCharacter + "')]")
    private WebElement getPlaylistToDeleteWithOneCharacter;

//    @FindBy(xpath = "//*[contains(text(), 'Deleted playlist \"" + playlistNameWithOneCharacter + ".\"')]")
    @FindBy(xpath = "/html/body/div[2]/div[.='Deleted playlist \"" + playlistNameWithOneCharacter + ".\"']")
    private WebElement getDeletedVerificationMsgForOneCharacter;


    @FindBy(xpath = "//div[@id='validationMessage' and contains(text(), 'Please fill out this field.')]")
    private WebElement getInvalidmessage;

//  Not Used
    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playlistName)]")
    private WebElement getPlayListField;

    @FindBy(css = "div.success.show")
    private WebElement getVerificationNoticeMsg;


    // Page Methods
    // Very basic methods



    // Use the method to find an element by the dynamic XPath
//    @FindBy(xpath = "driver.findElement(By.xpath(xpath))")

//    private WebElement dynamicElement;

    private String getModelXPath(int i) {
        return String.format("//div[@id='mainWrapper']" +
                "//div[@class='smart-playlist-form']" +
                "/div/form//div[@class='rule-group']" +
                "/div[@class='row']/select[@name='model[]']" +
                "/option[%d]", i);
    }

    // Method to find and interact with an option based on index 'i'
    private void getModelElement(int i) {
        String xpath = getModelXPath(i);
        driver.findElement(By.xpath(xpath)).click();
    }

    private String getOperatorXPath(int j) {
        return String.format("//div[@id='mainWrapper']" +
                "//div[@class='smart-playlist-form']" +
                "/div/form//div[@class='rule-group']" +
                "/div[@class='row']/select[@name='operator[]']" +
                "/option[%d]", j);
    }

    // Method to find and interact with an option based on index 'j'
    private void getOperatorElement(int j) {
        String xpath = getOperatorXPath(j);
        driver.findElement(By.xpath(xpath)).click();
    }

    private String getValueXPathForText() {

        return "//input[@name='value[]'][@required='required'][@type='text']";
    }

    private String getValueXPathForNumber(int j) {

//        return "//input[@name='value[]'][@required='required'][@type='number']";
        return String.format("//div[@id='mainWrapper']" +
                "//div[@class='smart-playlist-form']" +
                "/div/form//div[@class='rule-group']" +
                "/div[@class='row']/span[@class='value-wrapper']" +
                "/input[%d]",j);
    }

    private String getValueXPathForDate(int j) {

        return String.format("//div[@id='mainWrapper']" +
                "//div[@class='smart-playlist-form']" +
                "/div/form//div[@class='rule-group']" +
                "/div[@class='row']/span[@class='value-wrapper']" +
                "/input[%d]",j);
    }

    private String getRuleBtnXPath() {

        return  "/html//div[@id='mainWrapper']" +
                "//div[@class='smart-playlist-form']" +
                "/div/form//div[@class='rule-group']" +
                "/button[@class='btn-add-rule']";
    }
    private void getRuleBtnElement() {
        String xpath = getRuleBtnXPath();
        driver.findElement(By.xpath(xpath)).click();
    }


    private String getGroupBtnXPath() {

        return  "/html//div[@id='mainWrapper']" +
                "//div[@class='smart-playlist-form']" +
                "//form//button[@class='btn-add-group']";
    }

    private String getTestXPath() {

        return  "/html//div[@id='mainWrapper']" +
                "//div[@class='smart-playlist-form']" +
                "/div/form//div[@class='rule-group']/div";
    }

    private void getSmartPlaylistInventory() {

        int numberOfNameFields      = 0;
        int numberOfSmartRuleFields = 0;
        int numberOfRuleBtns        = 0;
        int numberOfGroupBtns       = 0;
        int numberOfSaveBtns        = 0;
        int numberofCancelBtns      = 0;

        String filePath = "C:\\temp\\koel-output.txt";
        String xpath;

        getRuleBtnElement();
        getRuleBtnElement();
        getRuleBtnElement();
        getRuleBtnElement();
        getRuleBtnElement();
        getRuleBtnElement();

        try {
            // Convert a WebElement to a list
//            List<WebElement> elementList = new ArrayList<>();
//            elementList.add(getTestXPath2);
            System.out.println("Number of Name Fields:  " + getTestXPath2.size());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Write the message to the file
                writer.write("Number of Name Fields:  " + getTestXPath2.size());
                System.out.println("Message written to file successfully.");
            } catch (IOException e) {
                // Handle potential IOExceptions
                System.err.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }

        } catch (NoSuchElementException e) {
            System.out.println("No such element found");
        }

    }

    private void getValueElement(String choiceValue) throws InterruptedException {

        String xpath = "";
//        String xpath = "";
        int j = 1;
        String sendDate1 = "10-01-2020";
        String sendDate2 = "10-31-2023";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now();

        if (choiceValue == "text") {
            xpath = getValueXPathForText();
            WebElement valueInput = driver.findElement(By.xpath(xpath));

            valueInput.click();
            valueInput.clear();
            valueInput.sendKeys("Test");
        }

        if (choiceValue == "number") {
            xpath = getValueXPathForNumber(j);
            WebElement valueInput = driver.findElement(By.xpath(xpath));

            valueInput.click();
            valueInput.clear();
            valueInput.sendKeys("10");

            try {
               j = 2;
                xpath = getValueXPathForNumber(j);
                WebElement valueInputTwo = driver.findElement(By.xpath(xpath));

                System.out.println("Element Found:  " + valueInput.getText());

                valueInput.click();
                valueInput.clear();
                valueInput.sendKeys("20");

            } catch (NoSuchElementException e) {
                System.out.println("No such element found");
            }
        }

        if (choiceValue == "date") {
            j = 1;
            xpath = getValueXPathForDate(j);
            WebElement valueInput = driver.findElement(By.xpath(xpath));

            valueInput.click();
            valueInput.clear();
            actions.sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).perform();
            valueInput.sendKeys(sendDate2);
//            Thread.sleep(2000);
//            valueInput.sendKeys(dtf.format(localDate));

            try {
                j = 2;

                xpath = getValueXPathForNumber(j);
                valueInput = driver.findElement(By.xpath(xpath));

                System.out.println("Element Found:  " + valueInput.getText());

                valueInput.click();
                valueInput.clear();
                actions.sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).perform();
                actions.sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).perform();
                valueInput.sendKeys(sendDate2);
//                Thread.sleep(5000);

            } catch (NoSuchElementException e) {
                System.out.println("No such element found");
            }
        }
    }

    public void selectCycleThrough() throws InterruptedException {

        for (int i = 1; i < 9; i++ ) {
            getModelElement(i);

            if(i < 4){
                int x = 7;
                for (int j = 1; j < x; j++) {
                    getOperatorElement(j);
                    getValueElement("text");
                    Thread.sleep(2000);
                }
            } else {
                int x = 6;
                for (int j = 1; j < x; j++) {
                    getOperatorElement(j);
                    switch (i) {
                        case 4:     getValueElement("number"); break;

                        case 5:     if (j == 1 || j == 2 || j == 5 ) {
                                        getValueElement("date");
                                        break;
                                    } else {
                                        getValueElement("number");
                                        break;
                                    }

                        case 6:     getValueElement("number"); break;

                        case 7:     if (j == 1 || j == 2 || j == 5) {
                                        getValueElement("date");
                                        break;
                                    } else {
                                        getValueElement("number");
                                        break;
                                    }

                        case 8:     if (j == 1 || j == 2 || j == 5) {
                                        getValueElement("date");
                                        break;
                                    } else {
                                        getValueElement("number");
                                        break;
                                    }

                        default:    getValueElement("text");   break;
                    }

//                    Thread.sleep(2000);
                }
            }

        }
    }

//    private String selectStringToLookFor(String lookForThis) {
//        return String.format("//div[@id='mainWrapper']//div[@class='smart-playlist-form']/div/form//div[@class='rule-group']/div[@class='row']/select[@name='model[]']/option[%d]", j);
//    }

//    public void selectNumberOfElementsFound() {
//        @FindBy(xpath = "//div[@id='mainWrapper']//div[@class='smart-playlist-form']/div/form//div[@class='form-row rules']/div[2]/div[@class='row']/button[@class='remove-rule']")
//        List<WebElement> elements = driver.findElements(locator);
//        int numberOfElements = elements.size();
//    }


    public void selectTitleNameFieldForSmartPlaylist(String playlistName) {

        waitForVisibility(getTitleNameFieldForSmartPlaylist).clear();
        waitForVisibility(getTitleNameFieldForSmartPlaylist).sendKeys(playlistName);
//        getSmartPlaylistInventory();  // Just a test
//        (getRuleSelectorColumnOneForSmartPlaylist).click();
    }

    public String selectTextEmailValidationMessage() {

        return getTitleNameField.getAttribute("validationMessage");
    }

    public void selectCreateNewPlaylistBtn () {

        waitForVisibility(getCreateNewPlaylistBtn);
        mouseOverAndClick(getCreateNewPlaylistBtn);
    }

    public void selectNewPlaylistBtn () {

        getNewPlaylistBtn.click();
    }

    public void selectNewSmartPlaylistBtn () {

        getNewSmartPlaylistBtn.click();
    }

    public void selectTitleNameField(String playlistName) {

        waitForVisibility(getTitleNameField).clear();
        waitForVisibility(getTitleNameField).sendKeys(playlistName + "\n");
    }

    public String selectVerificationNoticeMsg() {

        return getVerificationNoticeMsg.getText();
    }

    public String selectDeletedVerifyNotificationMsg() {

        System.out.println("Message Received: " + getDeletedVerificationMsg.getText());
        return waitForVisibility(getDeletedVerificationMsg).getText();
    }

    public String selectDeletedVerifyNotificationMsgForOneCharacter() {

        System.out.println("Message Received: " + getDeletedVerificationMsgForOneCharacter.getText());
        return waitForVisibility(getDeletedVerificationMsgForOneCharacter).getText();
    }

    public String selectDeletedVerifyNotificationMsgFor256Characters() {

        System.out.println("Message Received: " + getDeletedVerificationMsgFor256Characters.getText());
        return waitForVisibility(getDeletedVerificationMsgFor256Characters).getText();
    }

    public String selectAddedVerifyNotificationMsg() {

        return getAddedVerificationMsg.getText();
    }

    public String selectCreatedVerifyNotificationMsg() {

        return getCreatedVerificationMsg.getText();
    }

    public void selectPlaylistToDelete(String playlistName) {

        driver.navigate().refresh();
//        System.out.println("Output of playlistName: " + playlistName);


            waitForVisibility(getPlaylistToDelete1).click();
            actions.contextClick(getPlaylistToDelete1).perform();
            waitForVisibility(getPlaylistToDeleteBtn).click();

//            waitForVisibility(getPlaylistToDelete2).click();
//            actions.contextClick(getPlaylistToDelete2).perform();
//            waitForVisibility(getPlaylistToDeleteBtn).click();

//  Need to set it up later to look up playlistName --> playlistID

        if (waitForVisibility(getAlertBoxMsg).isDisplayed()) {
            waitForClickableAndClick(getPlaylistToDeleteOkBtn1);
        }

//        waitForClickableAndClick(getPlaylistToDeleteOkBtn1);
//        waitForClickableAndClick(getPlaylistToDeleteOkBtn2);

//        waitForClickable(getPlaylistToDeleteOkBtn1).click();
//        waitForClickable(getPlaylistToDeleteOkBtn2).click();

//        findElement(getPlayListToDelete).click();
//        findElement(getPlayListToDeleteBtn).click();
//        waitForPresence(getPlayListToDeleteOkBtn).click();

//        mouseOverAndContextClick(getPlayListToDelete);
//        mouseOverAndClick(getPlayListToDeleteBtn);
//        mouseOverAndClick(getPlayListToDeleteOkBtn);

    }

    public void selectPlaylistWithOneCharacterToDelete(String playlistName) {

        driver.navigate().refresh();
        System.out.println("Output of playlistName: " + playlistName);
        actions.contextClick(getPlaylistToDeleteWithOneCharacter).perform();
        waitForVisibility(getPlaylistToDeleteBtn).click();

        if(waitForVisibility(getAlertBoxMsg).isDisplayed()){
            waitForVisibility(getPlaylistToDeleteOkBtn1).click();
        }
    }

    public void selectPlaylistWith256CharactersToDelete(String playlistName) {

        driver.navigate().refresh();
        System.out.println("Output of playlistName: " + playlistName);
        actions.contextClick(getPlaylistToDeleteWith256Characters).perform();
        waitForClickableAndClick(getPlaylistToDeleteBtn);

        if (waitForVisibility(getPlaylistToDeleteOkBtn1).isDisplayed()) {
            waitForClickableAndClick(getPlaylistToDeleteOkBtn1);
        }
    }

    public void selectPlaylistToDeleteBtn () {

        getPlaylistToDeleteBtn.click();
    }

    public void selectSearchSongField (String songName) {

        getSearchSongField.sendKeys(songName + "\n");
    }

    public void selectViewAllSongs () {

        getViewAllSongs.click();
    }

    public void selectFirstSong () {

        getFirstSong.click();
    }

    public void selectAddSongToBtn () {

        getAddSongToBtn.click();
    }

    public void selectPlaylist (String playlistName) {

        waitForClickable(getPlaylist).click();
//        System.out.println("Output of playlistName: " + playlistName);
    }

    public void selectPlaylistWithOneCharacter (String playlistNameWithOneCharacter) {

        waitForClickable(getPlaylistWithOneCharacter).click();
       System.out.println("Output of playlistName: " + playlistNameWithOneCharacter);
    }

    public void selectPlaylistWith256Characters (String playlistNameWith256Characters) {

        waitForVisibility(getPlaylistToAddSongTo);
        waitForClickableAndClick(getPlaylistWith256Characters);
        waitForClickable(getPlaylistWith256Characters).click();
//        System.out.println("Output of playlistName: " + playlistNameWith256Characters);
    }

}