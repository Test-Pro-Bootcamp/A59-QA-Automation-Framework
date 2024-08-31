package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.lang.Math.abs;

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

//    @FindBy(xpath = "//a[contains(@href, '#!/')] and (contains(@href, '#!/playlist/'))]")
//    @FindBy(xpath = "//a[contains(@href, '#!/') and (contains(@href, '#!/playlist/'))]")
    @FindBy(xpath = "//a[contains(@href, '#!/')]")
//    @FindBy(xpath = "//a[contains(@href, '#!/') and not(contains(@href, '#!/artist/')) and not(contains(@href, '#!/album/'))]")
//    @FindBy(css = "a[href*='#!']:not([href*='#!/artist/']):not([href*='#!/album/'])")
//    @FindBy(xpath = "//a[@href='/#!/profile' or @href='#!/home' or @href='#!/queue' or @href='#!/albums' or @href='#!/artists' or @href='#!/favorites' or @href='#!/recently-played' or @href='#!/playlist/99055' or @href='#!/playlist/99056']\n")
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

    public void selectCheckHyperLinks() {

        waitUntilAllElementsLocatedByAreVisible(getStandardHyperlinks);

        // Debugging Purposes Only
        writeOutToFileIfList(getStandardHyperlinks);

//        selectHyperLinksToCheck(getStandardHyperlinks);
    }

    public void selectHyperLinksToCheck(List<WebElement> elements) {

        //count and display all hyperlinks

        try {
            waitUntilAllElementsLocatedByAreVisible(elements);

            for ( WebElement e : elements) {

                //Gets the Target word
                String href = e.getText();

                // Example input string
                String expectedURL = e.getAttribute("href");

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word
                String lastWord = extractLastWord(expectedURL, delimiter);

                //a[contains(@href, '#!/playlist/98078')]
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

//                driver.findElement(By.xpath(findByThis)).click();
//                waitForClickableAndClick((WebElement By.xpath(findByThis));
                WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(findByThis)));
                clickableElement.click();
//                Thread.sleep(1000);
                String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");

                Assert.assertEquals(expectedURL, actualURL);
            }

        } catch (java.util.NoSuchElementException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void selectAlbumHyperLinks(List<WebElement> elements) {

        //count and display all hyperlinks

        try {

            for ( WebElement e : getAlbums) {

                //Gets the Target word
                String href = e.getText();

                // Example input string
                String expectedURL = e.getAttribute("href");

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word
                String lastWord = extractLastWord(expectedURL, delimiter);

                //a[contains(@href, '#!/playlist/98078')]
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

                driver.findElement(By.xpath(findByThis)).click();
                String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");

                Assert.assertEquals(expectedURL, actualURL);
            }

        } catch (java.util.NoSuchElementException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void selectCheckPageAccessibility(List<WebElement> elements) {

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

    public void writeStringOutToFile(String inputStream) {

        try {

            String filePath = "C:\\temp\\koel-output.txt";
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            myWriter.write("Contents of String:  " + inputStream);

//            myWriter.write("\n" + "\n");
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void writeElementOutToFile(WebElement inputStream) {

        try {
//            List<WebElement> examineTheseElements = uniqueWebElements(getStandardHyperlinks);
//            List<WebElement> examineTheseElements = uniqueWebElements(inputStream);

            String filePath = "C:\\temp\\koel-output.txt";
            FileWriter myWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            myWriter.write("Contents of Element:  " + inputStream);
//            myWriter.write("Input: " + inputStream + "\n" + "\n");

            //Gets the Target word
//                String href = e.getText();

//                String targetURL = ("Target:  " + href + " ");
//                myWriter.write(targetURL);



//            // Example input string
//            String expectedURL = inputStream.getAttribute("href");
//
//            // Define the delimiter
//            String delimiter = "/#!/";
//
//            // Extract the last word
//            String lastWord = extractLastWord(expectedURL, delimiter);
//            myWriter.write("Input:  " + expectedURL + " ");
//
//            //a[contains(@href, '#!/playlist/98078')]
//            String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";
//
//            myWriter.write("@FindBy: " + findByThis + "\n");

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

    public void writeOutToFile(WebElement inputStream) {

        try {
//            List<WebElement> examineTheseElements = uniqueWebElements(getStandardHyperlinks);
//            List<WebElement> examineTheseElements = uniqueWebElements(inputStream);

            String filePath = "C:\\temp\\koel-output.txt";
            FileWriter myWriter = new FileWriter(filePath, false);
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
//            driver.navigate().refresh();
//            List<WebElement> examineTheseElements = uniqueWebElements(inputStream);
//            List<WebElement> examineTheseElements = inputStream;

            String filePath = "C:\\temp\\koel-output.txt";
            FileWriter myWriter = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            ArrayList<String> expectedURLArray = new ArrayList<>();
            ArrayList<String> findByThisArray = new ArrayList<>();
            ArrayList<String> actualURLArray = new ArrayList<>();

            int i = 0;
            int j = 0;
            int k = 2;   // Buffer
            int longestStringExpectedURL = 0;                   // Number of characters in the longest string
            int shortestStringExpectedURL = Integer.MAX_VALUE;  // Number of characters in the shortest string
            int longestStringFindBy = 0;                        // Number of characters in the longest string
            int shortestStringFindBy = Integer.MAX_VALUE;       // Number of characters in the shortest string
            int longestStringActualURL = 0;                     // Number of characters in the longest string
            int shortestStringActualURL = Integer.MAX_VALUE;    // Number of characters in the shortest string

            myWriter.write("Number of hyper links: " + inputStream.size() + "\n" + "\n");

            for (WebElement e : inputStream) {

                String expectedURL = e.getAttribute("href");
                expectedURLArray.add("ExpectedURL: " + expectedURL);

                // Define the delimiter
                String delimiter = "/#!/";

                // Extract the last word
                String lastWord = extractLastWord(expectedURL, delimiter);

                //a[contains(@href, '#!/playlist/98078')]
                String findByThis = "//a[contains(@href,'#!/" + lastWord + "')]";

                findByThisArray.add("FindBy: " + findByThis);

                // Comment out for testing
                WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(findByThis)));
                clickableElement.click();

                String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");

                actualURLArray.add("ActualURL: " + actualURL);

                Assert.assertEquals(expectedURL, actualURL);
            }

            int numberOfElements;

            numberOfElements = expectedURLArray.size();
            myWriter.write("ExpectedURLArray: " + numberOfElements + "\n");

            numberOfElements = findByThisArray.size();
            myWriter.write("FindByThisArray: " + numberOfElements + "\n");

            numberOfElements = actualURLArray.size();
            myWriter.write("ActualURLArray: " + numberOfElements + "\n");

            for (String myString : expectedURLArray) {

                int length = myString.length();

                if (length > longestStringExpectedURL) {
                    longestStringExpectedURL = length;
                    myWriter.write("myString: " + myString + " ");
                    myWriter.write("longestStringExpectedUR: " + longestStringExpectedURL + "\n");
                }

                if (length < shortestStringExpectedURL) {
                    shortestStringExpectedURL = length;
                }
            }

            for (String myString : findByThisArray) {

                int length = myString.length();

                if (length > longestStringFindBy) {
                    longestStringFindBy = length;
                    myWriter.write("myString: " + myString + " ");
                    myWriter.write("longestStringFindBy: " + longestStringFindBy + "\n");
                }

                if (length < shortestStringFindBy) {
                    shortestStringFindBy = length;
                }
            }

            for (String myString : actualURLArray) {

                int length = myString.length();

                if (length > longestStringActualURL) {
                    longestStringActualURL = length;
                    myWriter.write("myString: " + myString + " ");
                    myWriter.write("longestStringActualURL: " + longestStringActualURL + "\n");
                }

                if (length < shortestStringActualURL) {
                    shortestStringActualURL = length;
                }
            }

            myWriter.write("\n" + "\n");

            int space = 0;
            i = 0;
            int counterLimit = expectedURLArray.size();
            for (String m : expectedURLArray) {

                myWriter.write(expectedURLArray.get(i));

                space = abs(longestStringExpectedURL - expectedURLArray.get(i).length() + 2);

                myWriter.write(" ".repeat(space));

                myWriter.write(findByThisArray.get(i));

                space = abs(longestStringFindBy - findByThisArray.get(i).length() + 2);

                myWriter.write(" ".repeat(space));

                myWriter.write(actualURLArray.get(i));

                space = abs(longestStringActualURL - actualURLArray.get(i).length() + 2);

                myWriter.write(" ".repeat(space));

                myWriter.write("\n");

                i++;
            }

            myWriter.write("\n" + "\n");
            myWriter.write("Length of the longest Element in ExpectedURL is: " + longestStringExpectedURL);

            myWriter.write("\n" + "\n");
            myWriter.write("Length of the shortest Element in ExpectedURL is: " + shortestStringExpectedURL);

            myWriter.write("\n" + "\n");
            myWriter.write("Length of the longest Element in FindBy is: " + longestStringFindBy);

            myWriter.write("\n" + "\n");
            myWriter.write("Length of the shortest Element in FindBy is: " + shortestStringFindBy);

            myWriter.write("\n" + "\n");
            myWriter.write("Length of the longest Element in ActualURL is: " + longestStringActualURL);

            myWriter.write("\n" + "\n");
            myWriter.write("Length of the shortest Element in ActualURL is: " + shortestStringActualURL);

            myWriter.write("\n" + "\n");

            bufferedWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeOutToFileIfPlaylist(WebElement inputStream) {

        try {

            String filePath = "C:\\temp\\koel-output.txt";
            FileWriter myWriter = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);

            String id =        inputStream.getAttribute("id");
            String className = inputStream.getAttribute("class");
            String title =     inputStream.findElement(By.className("title")).getText();
            String artist =    inputStream.findElement(By.cssSelector("a.artist")).getText();
            String album =     inputStream.findElement(By.cssSelector("a.album")).getText();

            myWriter.write("Info about song playing from list: " + "\n" + "\n");

            myWriter.write("ID is:    " + id + "\n");
            myWriter.write("Class is: " + className + "\n");
            myWriter.write("Title is: " + title + "\n");
            myWriter.write("Artist:   " + artist + "\n");
            myWriter.write("Album is: " + album + "\n");

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
        int num = abs(number); // Handle negative numbers

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
