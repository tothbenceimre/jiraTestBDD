package editIssue;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.EditIssueForm;
import pages.MainPage;
import pages.ProjectsIssuePage;
import util.Driver;
import static org.junit.Assert.*;

public class stepsForEditIssue {
    Driver driver = new Driver();
    DashboardPage dashboardPage = new DashboardPage(driver.getDriver());
    MainPage mainPage = new MainPage(driver.getDriver());
    ProjectsIssuePage projectsIssuePage = new ProjectsIssuePage(driver.getDriver());
    EditIssueForm editIssueForm = new EditIssueForm(driver.getDriver());

    @Given("we have a logged in.")
    public void weHaveLoggedIn () {
        driver.navigation(driver.getBaseUrl());
        dashboardPage.login(System.getenv("jirausername"), System.getenv("jirapassword"));
    }

    @And("we navigated to our project's issue page.")
    public void weNavigatedToOurProjectSIssuePage() throws Exception {
        if (mainPage.avatarIsVisible()) {
            driver.navigation(driver.getProjectURL("PP"));
        }
        else {
            throw new Exception("Avatar is not visible");
        }
    }

    @And("we clicked on the 'Create issue' tab that is located on the bottom.")
    public void weClickedOnTheCreateIssueTabThatIsLocatedOnTheBottom () {
        projectsIssuePage.clickOnCreateButton();
    }

    @And("we filled the issuetype with the correct issutetype.")
    public void weFilledTheIssuetypeWithTheCorrectIssutetype () {
        projectsIssuePage.selectIssueType("Task");
    }

    @And("we filled the summary with the correct summary.")
    public void weFilledTheSummaryWithTheCorrectSummary () {
        projectsIssuePage.fillAndSubmitSummaryField("test_for_edit_issue_from_project");
    }

    @When("we click on 'Edit' that is located under the issue's picture and summary.")
    public void weClickOnEditThatIsLocatedUnderTheIssueSPictureAndSummary () {
        driver.navigation(projectsIssuePage.getRecentlyCreatedIssuePage());
        driver.acceptAlert();
        projectsIssuePage.clickOnEditButton();
    }

    @And("we filled the summary with a new value.")
    public void weFilledTheSummaryWithANewValue () {
        editIssueForm.clearSummaryField();
        editIssueForm.fillSummaryField("edit_issue_is_working");
    }

    @And("we click on 'Update'.")
    public void weClickOnUpdate () {
        editIssueForm.clickOnUpdateButton();
    }

    @Then("we can see our issue's summary is updated with the new summary value.")
    public void weCanSeeOurIssueSSummaryIsUpdatedWithTheNewSummaryValue () {
        boolean expected = projectsIssuePage.isIssueCreated("Private Project 1", "Task", "edit_issue_is_working");
        assertTrue(expected);
    }

    @After
    public void tearDown () {
        projectsIssuePage.deleteCurrentIssue();
        driver.close();
    }
}
