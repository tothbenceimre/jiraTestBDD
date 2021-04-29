Feature: Jira's log in feature

  Example: Successful log in from dashboard
    Given  we navigated to the dashboard page.
    When we fill the username field with our valid username.
    And we fill the password field with our username's password.
    And we click on 'Log in' button.
    And we navigate to our profile.
    Then we can see our username under 'Summary'.
