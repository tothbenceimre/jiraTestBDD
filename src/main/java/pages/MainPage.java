package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header-details-user-fullname\"]/span/span/img") WebElement avatar;
    @FindBy(id = "view_profile") WebElement viewProfileTab;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loadPage(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(avatar));
    }


    public void navigateToProfile () {
        avatar.click();
        viewProfileTab.click();
    }

}
