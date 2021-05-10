package logOut;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.MainPage;
import util.Driver;

public class stepsForLogOut {
    Driver driver = new Driver();
    DashboardPage dashboardPage = new DashboardPage(driver.getDriver());
    MainPage mainPage = new MainPage(driver.getDriver());

    @Given("that we are logged in.")
    public void thatWeAreLoggedIn() {
        driver.navigation(driver.getBaseUrl());
        dashboardPage.login(System.getenv("jirausername"), System.getenv("jirapassword"));
    }

    @And("we can see our avatar.")
    public void weCanSeeOurAvatar() {
        mainPage.avatarIsVisible();
    }

    @When("we click on our avatar.")
    public void weClickOnOurAvatar() {
        mainPage.clickOnAvatar();
    }

    @And("we click on Log out.")
    public void weClickOnLogOut() {
        mainPage.clickOnLogOutTab();
    }

    @Then("we get back a message that says: You're now logged out..")
    public void weGetBackAMessageThatSaysYouReNowLoggedOut() {
        dashboardPage.verifySuccessfulLogOut();
    }

    @After
    public void tearDown () {
        driver.close();
    }
}
