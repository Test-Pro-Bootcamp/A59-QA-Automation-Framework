package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ActionsPage extends BasePage {

    public static final String playlistName = "TestPro Playlist";
    public static final String lookForPage = "";

    //Constructor
    public ActionsPage(WebDriver givenDriver){
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    //Locators
//    @FindBy(xpath = "//a[contains(text(), 'A')]")
    @FindBy(xpath = "//a[contains(text(), 'TestPro Playlist')]")
//    @FindBy(xpath = "//a[contains(text(), playlistName)]")
    private WebElement getPlaylistByName;

    @FindBy(xpath="//a[contains(@href, '#!/albums')]")
    private WebElement getAlbumsFromMenu;

    @FindBy(css = "section#playlistWrapper td.title")
    private List<WebElement> songList;

    @FindBy(xpath = "//li[contains(@class, 'playlist') and not(descendant::a[contains(text(), 'Favorites') or contains(text(), 'Recently Played')])]//a")
    private List<WebElement> playlists;

    @FindBy(css = "section#playlistWrapper td.title")
    private List<WebElement> countSongs;

//    @FindBy(xpath = "//a[contains(@href, '#!/')]")
    @FindBy(xpath = "//a[contains(@href, '#!/') and not(contains(@href, '#!/artist/')) and not(contains(@href, '#!/album/'))]")
    private List<WebElement> getStandardHyperlinks;

    @FindBy(xpath = "//a[contains(@href, '#!/album/')]")
    private List<WebElement> getAlbums;

    @FindBy(xpath = "//a[contains(@href, '#!/artist/')]")
    private List<WebElement> getArtists;

    @FindBy(xpath = "//a[contains(@href, '#!/songs')]")
    private List<WebElement> getSongs;

    @FindBy(xpath = "//a") // Example: finding all <a> tags
    private List<WebElement> getAllAElements;


    // @FindBy(xpath = "//*[contains(text(), 'Created playlist \"" + playlistNameWithOneCharacter + ".\"')]")

//    @FindBy(xpath= "//a[contains(@href, '#!/ %s')]", lookForPage)
//    @FindBy(xpath = "//a[contains(text(), '" + lookForPage + "')]")
//    private WebElement getPage;



    //Page Methods

    public int selectSongCount() {

         System.out.println("Number of Songs: " + songList.size());
         return songList.size();
    }

    public void selectPlaylistByName() {

        waitForVisibility(getPlaylistByName).click();
    }


    public List<WebElement> getElementsWithDynamicHref(String keyword) {

        // Construct dynamic XPath using the keyword
        String xpath = String.format("//a[contains(@href, '#!/ %s')]", keyword);
        return driver.findElements(By.xpath(xpath));
    }


    public void displayAllSongs() {

        //count and display song names
        String filePath = "C:\\temp\\koel-output.txt";

        try {
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);

            myWriter.write("Number of Songs in the playlist " + "\"" + playlistName + "\"" + ": " + songList.size() + "\n" + "\n");

            int i = 1;
            for ( WebElement e : songList) {
                myWriter.write(i+".");

                if (i < 10) {
                    myWriter.write("  ");
                } else if (i < 100 ){
                    myWriter.write(" ");
                }

                myWriter.write(e.getText() + "\n");
                i = i + 1;
            }
            myWriter.write("\n" + "\n");

            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

    public void displayAllPlaylists() {

        //count and display playlist names
        String filePath = "C:\\temp\\koel-output.txt";

        try {
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            myWriter.write("Number of custom playlists: " + playlists.size() + "\n" + "\n");

            int i = 1;

            for ( WebElement e : playlists) {
                myWriter.write(i+".");

                if (i < 10) {
                    myWriter.write("  ");
                } else if (i < 100 ){
                    myWriter.write(" ");
                }

                String href = e.getAttribute("href");
                String playlistName = e.getText();
                String songID = href.replaceAll(".*playlist/(\\d+).*", "$1");
                myWriter.write(songID + " ");
                myWriter.write(playlistName + "\n");

                i = i + 1;
            }
            myWriter.write("\n" + "\n");

            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

    public void selectStandardHyperLinks() {

        //count and display all hyperlinks
        String filePath = "C:\\temp\\koel-output.txt";

        try {
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            myWriter.write("Number of hyper links: " + getStandardHyperlinks.size() + "\n" + "\n");

            int i = 1;
            int j = getLengthOfLargestString(getStandardHyperlinks);
            for ( WebElement e : getStandardHyperlinks) {
                if (!Objects.equals(e.getText(), "")) {
                   myWriter.write(i+".");

                   if (i < 10) {
                      myWriter.write("  ");
                   } else if (i < 100 ){
                      myWriter.write(" ");
                   }
                }
//                String href = e.getAttribute("href");
                //Gets the Target word
                String href = e.getText();

                // Example input string
                String expectedURL = e.getAttribute("href");

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word
                String lastWord = extractLastWord(expectedURL, delimiter);
                myWriter.write("Input:  " + expectedURL + " ");

                String targetURL = ("Target:  " + href + " ");
//                myWriter.write(targetURL);

                //a[contains(@href, '#!/playlist/98078')]
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

                myWriter.write("findByThis: " + findByThis + "\n");

//                myWriter.write("Target URL:  " + inputString + "\n");
                LoginPage loginPage = new LoginPage(driver);
                loginPage.selectCurrentPage();
                driver.findElement(By.xpath(findByThis)).click();
                String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");

                Assert.assertEquals(expectedURL, actualURL);

                i = i + 1;
            }
            myWriter.write("\n" + "\n");
            myWriter.write("Length of Largest String is:  " + j + "\n");

            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

    public void selectAlbumHyperLinks() {

        //count and display all hyperlinks
        String filePath = "C:\\temp\\koel-output.txt";

        try {
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            myWriter.write("Number of hyper links: " + getAlbums.size() + "\n" + "\n");

            int i = 1;
            int j = getLengthOfLargestString(getAlbums);
            for ( WebElement e : getAlbums) {
                if (!Objects.equals(e.getText(), "")) {
                    myWriter.write(i+".");

                    if (i < 10) {
                        myWriter.write("  ");
                    } else if (i < 100 ){
                        myWriter.write(" ");
                    }
                }
//                String href = e.getAttribute("href");
                //Gets the Target word
                String href = e.getText();

                // Example input string
                String expectedURL = e.getAttribute("href");

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word
                String lastWord = extractLastWord(expectedURL, delimiter);
                myWriter.write("Input:  " + expectedURL + " ");

                String targetURL = ("Target:  " + href + " ");
//                myWriter.write(targetURL);

                //a[contains(@href, '#!/playlist/98078')]
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

                myWriter.write("findByThis: " + findByThis + "\n");

//                myWriter.write("Target URL:  " + inputString + "\n");
                LoginPage loginPage = new LoginPage(driver);
                loginPage.selectCurrentPage();
                driver.findElement(By.xpath(findByThis)).click();
                String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");

//                Assert.assertEquals(expectedURL, actualURL);

                i = i + 1;
            }

            myWriter.write("\n" + "\n");
            myWriter.write("Length of Largest String is:  " + j + "\n");

            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void selectCheckPageAccessibility() {

        try {
        //count and display all hyperlinks
//        List<WebElement> examineTheseElements = uniqueWebElements(getStandardHyperlinks);
//        for ( WebElement e : examineTheseElements) {
            for ( WebElement e : getStandardHyperlinks) {

                //Gets the Target word
                String href = e.getText();

                // Example input string
                String expectedURL = e.getAttribute("href");

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word -  myWriter.write("Input:  " + expectedURL + " ");
                String lastWord = extractLastWord(expectedURL, delimiter);

                //a[contains(@href, '#!/playlist/98078')] - myWriter.write("@FindBy: " + findByThis + "\n");
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

                LoginPage loginPage = new LoginPage(driver);
                String actualURL = loginPage.selectCurrentPage();
                writeOutToFile(e);
//            Thread.sleep(2000);
                driver.findElement(By.xpath(findByThis)).click();

//
                Assert.assertEquals(expectedURL, actualURL);
            }
        } catch (NoSuchElementException x) {
            System.out.println("An error occurred.");

        }
    }

    public void writeOutToFile(WebElement inputStream) {

        try {
//            List<WebElement> examineTheseElements = uniqueWebElements(getStandardHyperlinks);
//            List<WebElement> examineTheseElements = uniqueWebElements(inputStream);

            String filePath = "C:\\temp\\koel-output.txt";
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);

//            myWriter.write("Input: " + inputStream + "\n" + "\n");

                //Gets the Target word
//                String href = e.getText();

//                String targetURL = ("Target:  " + href + " ");
//                myWriter.write(targetURL);

                // Example input string
                String expectedURL = inputStream.getAttribute("href");

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word
                String lastWord = extractLastWord(expectedURL, delimiter);
                myWriter.write("Input:  " + expectedURL + " ");

                //a[contains(@href, '#!/playlist/98078')]
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

                myWriter.write("@FindBy: " + findByThis + "\n");

//                myWriter.write("Target URL:  " + inputString + "\n");

//                myWriter.write(e.getAttribute("href") + "    ");
//                myWriter.write(e.getText() + "\n");

//                LoginPage loginPage = new LoginPage(driver);
//                String actualURL = loginPage.selectCurrentPage();

//                driver.findElement(By.xpath(findByThis)).click();
//                String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");

//                Assert.assertEquals(expectedURL, actualURL)


//            myWriter.write("\n" + "\n");
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void writeOutToFileIfList(List<WebElement> inputStream) {

        try {
//            List<WebElement> examineTheseElements = uniqueWebElements(getStandardHyperlinks);
            List<WebElement> examineTheseElements = uniqueWebElements(inputStream);

            String filePath = "C:\\temp\\koel-output.txt";
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);

            myWriter.write("Number of hyper links: " + examineTheseElements.size() + "\n" + "\n");

            int i = 1;
            int j = getLengthOfLargestString(examineTheseElements);
            for ( WebElement e : examineTheseElements) {
                if (!Objects.equals(e.getText(), "")) {
                    myWriter.write(i+".");

                    if (i < 10) {
                        myWriter.write("  ");
                    } else if (i < 100 ){
                        myWriter.write(" ");
                    }
                }

                //Gets the Target word
//                String href = e.getText();

//                String targetURL = ("Target:  " + href + " ");
//                myWriter.write(targetURL);


                // Example input string
                String expectedURL = e.getAttribute("href");

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word
                String lastWord = extractLastWord(expectedURL, delimiter);
                myWriter.write("Input:  " + expectedURL + " ");

                //a[contains(@href, '#!/playlist/98078')]
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

                myWriter.write("@FindBy: " + findByThis + "\n");

//                myWriter.write("Target URL:  " + inputString + "\n");

//                myWriter.write(e.getAttribute("href") + "    ");
//                myWriter.write(e.getText() + "\n");

//                LoginPage loginPage = new LoginPage(driver);
//                String actualURL = loginPage.selectCurrentPage();

//                driver.findElement(By.xpath(findByThis)).click();
//                String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");

//                Assert.assertEquals(expectedURL, actualURL);

                i = i + 1;
            }

            myWriter.write("\n" + "\n");
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public List<WebElement> uniqueWebElements(List<WebElement> getTheseElements) {

        // Create a Set to store unique WebElements
        Set<WebElement> tempElementsSet = new HashSet<>(getTheseElements);

//        List<String> list = new ArrayList<>();

//        Collections.sort(list);
//        List<WebElement> uniqueElements = new ArrayList<>(tempElementsSet);
        List<WebElement> uniqueElements = new ArrayList<>(tempElementsSet);

//        uniqueElements.sort(Comparator.comparing(WebElement::getText));
//        writeOutToFile(uniqueElements);

//            uniqueElements.sort(new Comparator<WebElement>() {
//                @Override
//                public int compare(WebElement e1, WebElement e2) {
//                    int i = e1.getText().compareTo(e2.getText());
//                    return i;
//                }
//            });
//        uniqueElements.sort(Comparator.comparing(WebElement::getText));


        // Convert the Set back to a List

 /*  // Section only intended for debugging purposes

        String filePath = "C:\\temp\\koel-output.txt";

        try {
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            myWriter.write("Number of unique elements: " + uniqueElementsList.size() + "\n" + "\n");

            // Print out the unique elements
            for (WebElement e : uniqueElementsList) {

                myWriter.write(e.getAttribute("href") + "   ");
                myWriter.write(e.getText() + "\n");
            }

            myWriter.write("\n" + "\n");
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

      // End of Debugging section  */

        return uniqueElements;
    }

    public static int countDigits(int number) {

        if (number == 0) {

            return 1; // Special case for zero
        }

        int count = 0;
        int num = Math.abs(number); // Handle negative numbers

        while (num > 0) {

            num = num / 10;
            count = count + 1;
        }

        return count;
    }

    // Method to extract the keyword from the XPath statement
    public static String extractKeyword(String xpathStatement) {
        // Define the start and end markers for extraction
        String startMarker = "#!/";
        String endMarker = " ";
//        String endMarker = "')]";

        // Find the start and end indices of the keyword
        int startIndex = xpathStatement.indexOf(startMarker) + startMarker.length();
        int endIndex = xpathStatement.indexOf(endMarker, startIndex);

        // Extract the keyword
        if (startIndex > -1 && endIndex > -1) {
            return xpathStatement.substring(startIndex, endIndex);
        }

        // Return null if keyword not found
        return null;
    }

    private static String extractLastWord(String input, String delimiter) {
        // Split the string by the delimiter
        String[] parts = input.split(delimiter);

        // Check if we have at least one part
        if (parts.length > 0) {
            // Return the last part
            return parts[parts.length - 1];
        }

        // Return an empty string if no parts are found
        return "";
    }

    private static int getLengthOfLargestString(List<WebElement> elements) {
        int maxLength = 0;

        if (elements == null) {
            throw new IllegalArgumentException("List of WebElements cannot be null");
        }
        int i = 1;
        int j = 1; // Position of largest string found
        for (WebElement element : elements) {
            if (element != null) {
                String text = element.getText();
                if (text != null) {
                    int length = text.length();
                    if (length > maxLength) {
                        maxLength = length;
                        j = i;
                    }
                }
            }
            i++;
        }

        return maxLength;
    }
}
