package logIn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import util.Driver;

public class stepsForLogIn {
    Driver driver = new Driver();
    DashboardPage dashboardPage = new DashboardPage(driver.getDriver());



    @Given("we navigated to the dashboard page.")
    public void weHaveAJiraUserRegistered() {

    }

    @When("we fill the username field with our valid username.")
    public void weFillTheUsernameFieldWithOurUsername() {

    }

    @And("we fill the password field with our username's password.")
    public void weFillThePasswordFieldWithOurUsernameSPassword() {

    }

    @And("we click on 'Log in' button.")
    public void weClickOnButton () {

    }

    @And("we navigate to our profile.")
    public void weCanClickOnOurAvatarOnTheTopRight() {
    }

    @Then("we can see our username under 'Summary'.")
    public void weAreNoLongerAbleToSeeTheButtonOnTheTopRight() {

    }
}
