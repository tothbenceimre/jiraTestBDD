package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsIssuePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='inline-issue-create-container']//button[contains(., 'Create issue')]") WebElement createButton;
    @FindBy(xpath = "//form[@class='iic-widget__form aui']//textarea") WebElement summaryField;


    public ProjectsIssuePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
