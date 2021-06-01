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
    @FindBy(id = "type-val") WebElement issueType;
    @FindBy(id = "project-name-val") WebElement projectName;
    @FindBy(id = "summary-val") WebElement summary;
    @FindBy(id = "opsbar-operations_more") WebElement moreButton;
    @FindBy(id = "delete-issue-submit") WebElement deleteButton;
    @FindBy(xpath = "//span[normalize-space()='Delete']") WebElement deleteTab;

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

    public String getRecentlyCreatedIssuePage () {
        return "https://jira-auto.codecool.metastage.net/projects/PP/issues/?filter=addedrecently";
    }

    public void selectIssueType (String issue) {
        clickOnIssueTypeField();
        this.waiter.waitForElementToAppear(getIssueType(issue));
        getIssueType(issue).click();
    }

    public void createIssue (String issue, String summary) {
        clickOnCreateButton();
        selectIssueType(issue);
        fillAndSubmitSummaryField(summary);
    }

    public void clickOnEditButton () {
        this.waiter.waitCertainAmountOfTime(100000);
        editIssueButton.click();
    }

    public boolean isIssueCreated (String projectName, String issueType, String summary){
        if (!projectName.contains(this.projectName.getText())){
            return false;
        }
        if (!this.issueType.getText().contains(issueType)|| !issueType.contains(this.issueType.getText())){
            return false;
        }
        if (!this.summary.getText().equals(summary)){
            return false;
        }
        return true;
    }

    public void clickOnMoreButton () {
        this.moreButton.click();
    }

    public void clickOnDeleteTab () {
        this.deleteTab.click();
    }

    public void deleteCurrentIssue () {
        clickOnMoreButton();
        clickOnDeleteTab();
        clickOnDeleteButton();
    }

    public void clickOnDeleteButton () {
        this.deleteButton.click();
    }
}
