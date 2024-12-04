
public class TestReporter {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static void initializeReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent.attachReporter(spark);
    }

    public static void createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        testThreadLocal.set(test);
    }

    public static ExtentTest getCurrentTest() {
        return testThreadLocal.get();
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}