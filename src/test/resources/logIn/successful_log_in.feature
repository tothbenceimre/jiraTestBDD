Feature: Jira's log in feature

  Example: Successful log in from log in page
    Given we have a Jira user registered.
    And we navigated to the dashboard page.
    And we click on "Log in" button on the top right corner.
    When we fill the username field with our username.
    And we fill the password field with our username's password.
    And we click on "Log in" button.
    Then we are no longer able to see the "Log in" button on the top right.
    And we can click on our avatar on the top right.