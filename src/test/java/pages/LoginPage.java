package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class LoginPage {
    private WebDriver driver;

    // تحديد عناصر صفحة تسجيل الدخول باستخدام @FindBy
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".error-message-container")
    private WebElement errorMessage;

    // **المُنشئ (Constructor)**
    public LoginPage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    // **إدخال بيانات تسجيل الدخول**
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    // **إرجاع رسالة الخطأ**
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
