package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import util.Waiter;

public class DashboardPage {
    WebDriver driver;
    Waiter waiter;

    @FindBy(id = "login-form-username") WebElement usernameForm;
    @FindBy(id = "login-form-password") WebElement passwordForm;
    @FindBy(id = "login") WebElement loginButton;
    @FindBy(xpath = "//p[@class='title']") WebElement logoutMessage;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
        this.driver = driver;
        this.waiter = new Waiter(this.driver);
    }

    public void fillUserForm (String username) {
        usernameForm.sendKeys(username);
    }

    public void fillPasswordForm (String password) {
        passwordForm.sendKeys(password);
    }

    public void login (String username, String password) {
        fillUserForm(username);
        fillPasswordForm(password);
        loginButton.click();
    }

    public void clickOnLogIn () {
        loginButton.click();
    }

    public boolean verifySuccessfulLogOut () {
        return this.logoutMessage.getText().equals("You are now logged out. Any automatic login has also been stopped.");
    }
}
