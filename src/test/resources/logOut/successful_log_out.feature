Feature: Jira's log out feature

  Example: Logout is working
    Given that we are logged in.
    And we can see our avatar.
    When we click on our avatar.
    And we click on "Log out".
    Then we no longer able to see our avatar.
    And we get back a message that says: "You're now logged out.".