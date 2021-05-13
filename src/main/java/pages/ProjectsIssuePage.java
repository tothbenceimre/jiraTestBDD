package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waiter;

public class ProjectsIssuePage {
    WebDriver driver;
    Waiter waiter;

    @FindBy(xpath = "//*[@class='inline-issue-create-container']//button[contains(., 'Create issue')]") WebElement createButton;
    @FindBy(xpath = "//form[@class='iic-widget__form aui']//textarea") WebElement summaryField;
    @FindBy(xpath = "//*[@class='iic-widget__issue-type-selector']//button") WebElement issueTypeField;
    @FindBy(id = "edit-issue") WebElement editIssueButton;


    public ProjectsIssuePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(this.driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCreateButton () { createButton.click(); }

    public void fillSummaryField (String summary) { summaryField.sendKeys(summary); }

    public void submitSummaryField () {summaryField.sendKeys(Keys.ENTER);}

    public void fillAndSubmitSummaryField (String summary) {
        fillSummaryField(summary);
        submitSummaryField();
    }

    public void clickOnIssueTypeField () { issueTypeField.click();}

    public WebElement getIssueType (String issue) {
        return driver.findElement(By.xpath("//form[@class='iic-widget__form aui']//a[text()= '" + issue + "']"));
    }
}
