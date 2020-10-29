import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverSingleton.getInstance();
    }

    @Test()
    public void loginTest() {
        driver.get("https://aqa-courses.bujapp.com/");
        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));

        emailInput.sendKeys("tetiana.snytko@ctdev.io");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));

        passwordInput.sendKeys("Kitsune07");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        By userProfileButtonSelector = By.cssSelector("button[class^='ownUserProfile_showProfileBtn']");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(userProfileButtonSelector));

        driver.findElement(userProfileButtonSelector).click();

        driver.findElement(By.cssSelector("button[class^='ownUserProfile_showEditForm']")).click();

    }

}
