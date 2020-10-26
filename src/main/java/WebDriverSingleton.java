import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    public static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\tetianasnytko\\AppData\\Local\\Google\\Chrome\\Application\\84\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    private WebDriverSingleton() {}
}
