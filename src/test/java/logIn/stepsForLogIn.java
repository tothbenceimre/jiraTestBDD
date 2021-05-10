package logIn;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.MainPage;
import pages.ProfilePage;
import util.Driver;

public class stepsForLogIn {
    Driver driver = new Driver();
    DashboardPage dashboardPage = new DashboardPage(driver.getDriver());
    MainPage mainPage = new MainPage(driver.getDriver());
    ProfilePage profilePage = new ProfilePage(driver.getDriver());

    @Given("we navigated to the dashboard page.")
    public void weNavigatedToTheDashboardPage() {
        driver.navigation(driver.getBaseUrl());
    }

    @When("we fill the username field with our valid username.")
    public void weFillTheUsernameFieldWithOurUsername() {
        dashboardPage.fillUserForm(System.getenv("jirausername"));
    }

    @And("we fill the password field with our username's password.")
    public void weFillThePasswordFieldWithOurUsernameSPassword() {
        dashboardPage.fillPasswordForm(System.getenv("jirapassword"));
    }

    @And("we click on 'Log in' button.")
    public void weClickOnButton () {
        dashboardPage.clickOnLogIn();
    }

    @And("we navigate to our profile.")
    public void weCanClickOnOurAvatarOnTheTopRight() {
        mainPage.navigateToProfile();
    }

    @Then("we can see our username under 'Summary'.")
    public void weAreNoLongerAbleToSeeTheButtonOnTheTopRight() {
        profilePage.verifySuccessfulLogin(System.getenv("jirausername"));
    }

    @After
    public void tearDown () {
        driver.close();
    }
}
