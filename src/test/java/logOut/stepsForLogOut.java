package logOut;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsForLogOut {
    @Given("that we are logged in.")
    public void thatWeAreLoggedIn() {

    }

    @And("we can see our avatar.")
    public void weCanSeeOurAvatar() {

    }

    @When("we click on our avatar.")
    public void weClickOnOurAvatar() {

    }

    @And("we click on {string}.")
    public void weClickOn(String button) {

    }

    @Then("we no longer able to see our avatar.")
    public void weNoLongerAbleToSeeOurAvatar() {

    }

    @And("we get back a message that says: {string}.")
    public void weGetBackAMessageThatSays(String message) {
    }
}
