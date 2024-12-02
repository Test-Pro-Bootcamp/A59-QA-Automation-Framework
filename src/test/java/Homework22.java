import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SalesDashboardPage {
    @FindBy(id = "total-revenue") private WebElement totalRevenueElement;
    @FindBy(id = "total-cost") private WebElement totalCostElement;
    @FindBy(id = "total-margin") private WebElement totalMarginElement;
    @FindBy(id = "margin-percentage") private WebElement marginPercentageElement;
    @FindBy(id = "best-month") private WebElement bestMonthElement;
    @FindBy(id = "worst-month") private WebElement worstMonthElement;

    public SalesDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private double parseMetric(WebElement element) {
        return Double.parseDouble(element.getText().replace("%", "").trim());
    }

    public double getTotalRevenue() { return parseMetric(totalRevenueElement); }
    public double getTotalCost() { return parseMetric(totalCostElement); }
    public double getTotalMargin() { return parseMetric(totalMarginElement); }
    public double getMarginPercentage() { return parseMetric(marginPercentageElement); }
    public String getBestMonth() { return bestMonthElement.getText(); }
    public String getWorstMonth() { return worstMonthElement.getText(); }
}

public class SalesDashboardTest {
    @Test
    public void testSalesDashboardMetrics() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://example.com/sales-dashboard");
            SalesDashboardPage dashboard = new SalesDashboardPage(driver);

            assertTrue(dashboard.getTotalRevenue() > 0, "Invalid total revenue");
            assertTrue(dashboard.getTotalMargin() > 0, "Invalid total margin");
            assertTrue(dashboard.getMarginPercentage() <= 100, "Invalid margin percentage");
        } finally {
            driver.quit();
        }
    }
}
