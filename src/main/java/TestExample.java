import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.URLEncoder;
import java.util.Random;

public class TestExample {

    WebDriver driver;

    @DataProvider(name = "queries-provider")
    public Object[][] queriesProvider() {
        return new Object[][] {{ "TestNG" }, { "Maven" }, { "Hello World!" }};
    }

    @BeforeSuite
    public void setup() {
        driver = WebDriverSingleton.getInstance();
    }

    @AfterSuite
    public void exit() {
        driver.close();
    }

    @Test()
    public void googleTitleTest() {
        driver.get("https://google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(dataProvider = "queries-provider")
    public void googleQueryTest(String query) {
        String encodedQuery = URLEncoder.encode(query);
        driver.get("https://google.com/search?q=" + encodedQuery);
        Assert.assertEquals(driver.getTitle(), query + " - Поиск в Google");
    }

    @Test()
    public void rangeTest() {
        Random rand = new Random();
        int res = rand.nextInt(10);
        Assert.assertTrue(res < 10);
        Assert.assertTrue(res > 0);
    }

}
