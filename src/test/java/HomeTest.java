import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
    static WebDriver driver;
    static HomePage page;

    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new HomePage(driver);
        driver.get(page.URL);
        driver.manage().window().maximize();
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void testOpen() {
        String xpathTitle = "//*[@class=\"index-page\"]";
        By byId = By.xpath(xpathTitle);
        try {
            Util.waiter(3);
            WebElement element = driver.findElement(byId);
        } catch (Exception e) {
            Assert.fail("No such element");
        }
    }

    @Test
    public void testLogin() {
        page.fillLoginForm(page.nickname, page.password);
        Util.waiter(1);
    }

    @Test
    public void testLoginIncorrect() {
        page.fillLoginForm(page.wrongNickname, page.wrongPassword);
        String error = page.getFormErrorMessage();
        Assert.assertEquals("Неверный логин или пароль", error);
    }

    @Test
    public void testLoginEmptyEmailAndPassword() {
        page.fillLoginForm("", "");
        String nicknameError = page.getNicknameInputErrorMessage();
        Assert.assertEquals("Никнейм обязателен", nicknameError);
        String passwordError = page.getPasswordInputErrorMessage();
        Assert.assertEquals("Пароль обязателен", passwordError);
    }
}
