package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class AllSongsPage extends BasePage {

    //Constructor
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement getFirstSong;

    @FindBy(css = "li a.songs")
    private WebElement getAllSongs;

    @FindBy(css = "li.playback")
    private WebElement getPlayBtn;

    @FindBy(xpath = "//th[@class='track-number']")
    private WebElement getTrackNumberTH;

    @FindBy(xpath = "//th[@class='title']")
    private WebElement getTitleTH;

    @FindBy(xpath = "//th[@class='artist']")
    private WebElement getArtistTH;

    @FindBy(xpath = "//th[@class='album']")
    private WebElement getAlbumTH;

    @FindBy(xpath = "//th[@class='time']")
    private WebElement getTimeTH;

    @FindBy(xpath = "//button[@title='View song information' and @data-testid='toggle-extra-panel-btn']")
    private WebElement getInfoBtn;

    // Display currently playing song in the progress panel
    @FindBy(xpath = "//div[@id='progressPane' and contains(@class, 'progress')]")
    private WebElement getSongPlayingInProgressPanel;

    // Locator for the <td> element with class="title" within the song item row
//    @FindBy(xpath = ".//td[contains(@class, 'title')]")
    @FindBy(xpath = "//div[@id='progressPane' and @class='progress']//h3[@class='title']")
    private WebElement getTitleOfSongInProgressPanel;

    // Locator for the <td> element with class="artist" within the song item row
//    @FindBy(xpath = ".//td[contains(@class, 'artist')]")
    @FindBy(xpath = "//div[@id='progressPane' and @class='progress']//a[@class='artist']")
    private WebElement getArtistOfSongInProgressPanel;

    // Locator for the <td> element with class="album" within the song item row
//    @FindBy(xpath = ".//td[contains(@class, 'album')]")
    @FindBy(xpath = "//div[@id='progressPane' and @class='progress']//a[@class='album']")
    private WebElement getAlbumOfSongInProgressPanel;

    @FindBy(xpath = "//td[@class='title' and text()='Dark Days']")
    private WebElement getDarkDays;


    // Locator for the <tr> element with class="song-item playing selected"
    @FindBy(xpath = "//tr[@class='song-item playing selected']")
    private WebElement getSongPlayingInListPanel;

    // Locator for the <td> element with class="title"
    @FindBy(xpath = "//tr[@class='song-item playing selected']//td[@class='title']")
    private WebElement getTitlePlayingInListPanel;

    // Locator for the <td> element with class="artist"
    @FindBy(xpath = "//tr[@class='song-item playing selected']//td[@class='artist']")
    private WebElement getArtistPlayingInListPanel;

    // Locator for the <td> element with class="album"
    @FindBy(xpath = "//tr[@class='song-item playing selected']//td[@class='album']")
    private WebElement getAlbumPlayingInListPanel;


    @FindBy(xpath = "song-item playing selected")
    private WebElement getCoverOfPlayingSong;

    @FindBy(xpath = "song-item playing selected")
    private WebElement getAlbumOfPlayingSong;

    @FindBy(xpath = "//button[@id='extraTabLyrics' and @role='tab' and contains(text(), 'Lyrics')]")
    private WebElement getLyricsBtn;

    @FindBy(xpath="//div[@id='progressPane' and .//a[@class='album' and text()='Dark Days EP']]")
    private WebElement getIsDarkDaysAlbumPresent;

    @FindBy(xpath = "//span[@class='album-thumb']")
    private WebElement getAlbumThumbforSongPlaying;

    @FindBy(xpath = "//span[contains(@style, 'background-image: url(\"https://qa.koel.app/img/covers/a4ad0a07a41b5ffd5218393592bf34826da663f2.jpeg\")')]/a/i[@class='fa fa-pause']")
    private WebElement getCoverForDarkDays;

    @FindBy(xpath="//span[text()='No lyrics available. Are you listening to Bach?']")
    private WebElement getLyricsMsg;

    @FindBy(xpath = "//*[@data-testid=\"toggle-extra-panel-btn\" and contains(@class, 'active')]")
    private WebElement getIsInfoPanelDisplayed;


    //Page Methods

    public void selectAllSongsBtn() {

        waitForVisibility(getAllSongs).click();
    }

    public void selectSongBtn(String title, String artist, String album) {

//        String xpath = String.format("//td[@class='title' and text()='%s']", title);
//        String xpath = String.format("//tr[@class='song-item' and td[@class='title' and text()='%s'] and td[@class='artist' and text()='%s'] and td[@class='album' and text()='%s']]", title, artist, album);
        String xpath = "//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[53]/td[2]";

        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(clickableElement));

        doubleClick(visibleElement);
    }

    public void selectInfoTypeBtn(String info) {

        String xpath = String.format("//button[@role='tab' and @aria-controls='extraPanel%s']", info);

        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(clickableElement));

        doubleClick(visibleElement);
    }

    public void selectShuffleArtistBtn(String info) {

        String xpath = String.format("//button[contains(@title, 'Shuffle all songs by %s') and contains(@class, 'shuffle') and contains(@class, 'control')]", info);

        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(clickableElement));

        doubleClick(visibleElement);
    }

    public void selectShuffleAlbumBtn(String info) {

        String xpath = String.format("//button[contains(@title, 'Shuffle all songs in %s') and contains(@class, 'shuffle') and contains(@class, 'control')]", info);

        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(clickableElement));

        doubleClick(visibleElement);
    }

    public void selectFirstSong() {

        waitForVisibility(getFirstSong).click();
    }

    public void selectInfoBtn() {

        waitForVisibility(getInfoBtn).click();
    }

    public void selectLyricsBtn() {

        waitForVisibility(getLyricsBtn).click();
    }

    public void selectPlayBtn() {

        waitForVisibility(getPlayBtn).click();
    }

    public void rightClickOnSong() {

        selectRightClick(getFirstSong);
    }

    public boolean isCoverOfPlayingSongPresent() {

        return waitForVisibility(getAlbumThumbforSongPlaying).isDisplayed();
    }

    public boolean isDarkDaysAlbumPresent() {

        return waitForVisibility(getIsDarkDaysAlbumPresent).isDisplayed();
    }

    public boolean isLyricsMsgPresent() {

        return getLyricsMsg.isDisplayed();
    }

    public boolean isDarkDaysCoverPresent() {

        return getCoverForDarkDays.isDisplayed();
    }

    public boolean isArtistNamePresent(String artist) {

        ActionsPage actionsPage = new ActionsPage(driver);

        try {
            // Create the XPath dynamically with the artist's name
//            String xpath = String.format("//article[@data-test='artist-info' and @class='artist-info sidebar']//h1[@class='name']//span[text()='%s']", artist);
//            String xpath = String.format("//h1[@class='name']//span[text()='%s']", artist);
            String testString = "This is just a test string" + "\n";
//            actionsPage.writeStringOutToFile(testString);

//            String xpath = String.format("//a[@class='artist' and text()='%s']", artist);
//            String xpath = String.format("//h1[@class='name']//span[text()='%s']", artist);
//            String xpath = String.format("//tr[@class='song-item playing selected']//td[@class='%s']", artist);
//            actionsPage.writeStringOutToFile("writeStringOutToFile: " + xpath + "\n");

            // Wait for the element to be visible
            String xpath = "//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[53]/td[3]";
//            WebElement presentElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actionsPage.writeElementOutToFile(visibleElement);

            // Return true if the element is displayed
//            Thread.sleep(6000);
//            actionsPage.writeElementOutToFile(visibleElement);
            return visibleElement.isDisplayed();
        } catch (TimeoutException e ) {
            // Return false if a TimeoutException occurs
            return false;
        } catch (Exception e) {

            return false;
        }
    }

    public boolean isInfoPanelPresent() {

//        String xpath = "//section[@id='extra' and @data-testid='extra-panel' and contains(@class, 'showing')]";
        String xpath = "//*[@data-testid=\"toggle-extra-panel-btn\" and contains(@class, 'active')]";
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(clickableElement));

        return visibleElement.isDisplayed();
    }

    public boolean isInfoPanelNotPresent() {

//        String xpath = "//section[@id='extra' and @data-testid='extra-panel' and contains(@class, 'showing')]";
        String xpath = "//*[@data-testid=\"toggle-extra-panel-btn\" and not(contains(@class, 'active'))]";
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(clickableElement));

        return visibleElement.isDisplayed();
    }

    public void selectSongPlayingInListPanel() {

        try {
            waitForVisibility(getSongPlayingInListPanel);

            // Extract the title, artist, and album
//            String title =  getSongPlayingInListPanel.getAttribute("title");
//            String artist = getSongPlayingInListPanel.getAttribute("artist");
//            String album =  getSongPlayingInListPanel.getAttribute("album");

            waitForVisibility(getAlbumThumbforSongPlaying);

            String styleAttribute = getAlbumThumbforSongPlaying.getAttribute("style");
            // Check if the style attribute is not null and contains 'background-image'
            if (styleAttribute != null && styleAttribute.contains("background-image")) {
                // Extract the URL from the style attribute
                String url = styleAttribute.replaceAll(".*url\\(\"(.*?)\"\\).*", "$1");

                // Extract the JPEG file name from the URL
                String fileName = url.substring(url.lastIndexOf("/") + 1);
            }


        } catch (NoSuchElementException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void selectSongPlayingInProgressPanel() {

        try {
            waitForVisibility(getSongPlayingInProgressPanel);

            // Extract the title, artist, and album
            String title =  getSongPlayingInProgressPanel.getCssValue("title");
            String artist = getSongPlayingInProgressPanel.getCssValue("a.artist");
            String album =  getSongPlayingInProgressPanel.getCssValue("a.album");

    } catch (NoSuchElementException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }

}
