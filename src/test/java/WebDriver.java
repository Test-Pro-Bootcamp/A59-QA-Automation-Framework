/*

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

// driver = pickBrowser(System.getProperty("browser"));

public static WebDriver pickBrowser(String browser) throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    String gridURL = "http://192.168.55.103:4444";  //replace with your gird url,  localhost:4444

    switch(browser) {
        case "firefox":  // gradle clean test -Dbrowser=firefox
             WebDriverManager.firefoxdriver().setup();
             return driver = new FirefoxDriver();

        case "MicrosoftEdge":
             WebDriverManager.edgedriver().setup();
             EdgeOptions edgeOptions = new EdgeOptions();
             edgeOptions.addArguments("--remote-allow-origins=*");
             return driver = new EdgeDriver(edgeOptions);

        case "grid-edge": // gradle clean test -Dbrowser=grid-edge
             caps.setCapability("browserName", "MicrosoftEdge");
             return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

        case "grid-firefox": // gradle clean test - Dbrowser=grid-firefox
             caps.setCapability("browserName", "firefox");
             return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

         case "grid-chrom":  // gradle clean test - Dbrowser=grid-chrome
              caps.setCapability("browserName", "chrome");
              return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

         default:
              WebDriverManager.chromedriver().setup();
              ChromeOptions chromeOptions = new ChromeOptions();
              chromeOptions.addArguments("--Remote-allow-origins=*");
        }
}
*/