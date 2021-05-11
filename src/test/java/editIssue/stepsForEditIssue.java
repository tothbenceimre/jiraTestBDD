package editIssue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.MainPage;
import util.Driver;

public class stepsForEditIssue {
    Driver driver = new Driver();
    DashboardPage dashboardPage = new DashboardPage(driver.getDriver());
    MainPage mainPage = new MainPage(driver.getDriver());

    @Given("we have a logged in.")
    public void weHaveLoggedIn () {
    }

    @And("we navigated to our project's issue page.")
    public void weNavigatedToOurProjectSIssuePage() {

    }

    @And("we clicked on the 'Create issue' tab that is located on the bottom.")
    public void weClickedOnTheCreateIssueTabThatIsLocatedOnTheBottom () {

    }

    @And("we filled the issuetype with the correct issutetype.")
    public void weFilledTheIssuetypeWithTheCorrectIssutetype () {

    }

    @And("we filled the summary with the correct summary.")
    public void weFilledTheSummaryWithTheCorrectSummary () {

    }

    @When("we click on 'Edit' that is located under the issue's picture and summary.")
    public void weClickOnEditThatIsLocatedUnderTheIssueSPictureAndSummary () {

    }

    @And("we filled the summary with a new value.")
    public void weFilledTheSummaryWithANewValue () {

    }

    @And("we click on 'Update'.")
    public void weClickOnUpdate () {

    }

    @Then("we can see our issue's summary is updated with the new summary value.")
    public void weCanSeeOurIssueSSummaryIsUpdatedWithTheNewSummaryValue () {
    }
}
