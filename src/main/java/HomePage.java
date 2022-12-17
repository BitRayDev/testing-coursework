import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    protected WebDriver driver;

    public final String URL = "http://localhost:3000/";

    public String nickname = "test";
    public String password = "test123";

    public String wrongNickname = Util.generateRandomInput(6);
    public String wrongPassword = Util.generateRandomInput(6);

    public String xpathLoginButton = "//*[@class=\"header-desktop__additional-items\"]/a[1]";
    public String xpathNicknameInput = "//*[contains(@class, \"login-form__nickname-input\")]//input";
    public String xpathNicknameInputErrorMessage = "//*[contains(@class, \"login-form__nickname-input\")]//*[@class=\"text-field__error-message\"]";
    public String xpathPasswordInput = "//*[contains(@class, \"login-form__password-input\")]//input";
    public String xpathPasswordInputErrorMessage = "//*[contains(@class, \"login-form__password-input\")]//*[@class=\"text-field__error-message\"]";
    public String xpathLoginFormSubmitButton = "//*[@class=\"login-form\"]//button";
    public String xpathFormErrorMessage = "//*[@class=\"login-form__error-message\"]";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void inputNickname(String nickname){
        By by = By.xpath(xpathNicknameInput);
        WebElement inputElement = driver.findElement(by);
        inputElement.sendKeys(nickname);
    }

    public void inputPassword(String password){
        By by = By.xpath(xpathPasswordInput);
        WebElement inputElement = driver.findElement(by);
        inputElement.sendKeys(password);
    }

    public void loginButtonClick(){
        By by = By.xpath(xpathLoginButton);
        WebElement buttonElement = driver.findElement(by);
        buttonElement.click();
    }

    public void loginSubmitButtonClick(){
        By by = By.xpath(xpathLoginFormSubmitButton);
        WebElement buttonElement = driver.findElement(by);
        buttonElement.click();
    }

    public String getFormErrorMessage() {
        By by = By.xpath(xpathFormErrorMessage);
        String error = driver.findElement(by).getText();
        return error;
    }
    public String getNicknameInputErrorMessage() {
        By by = By.xpath(xpathNicknameInputErrorMessage);
        String error = driver.findElement(by).getText();
        return error;
    }
    public String getPasswordInputErrorMessage() {
        By by = By.xpath(xpathPasswordInputErrorMessage);
        String error = driver.findElement(by).getText();
        return error;
    }

    public void fillLoginForm(String nickname, String password) {
        Util.waiter(2);
        loginButtonClick();
        Util.waiter(1);
        inputNickname(nickname);
        inputPassword(password);
        Util.waiter(1);
        loginSubmitButtonClick();
        Util.waiter(5);
    }
}
