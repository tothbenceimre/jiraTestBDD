Feature: Edit issue with summary is working

  Example: Edit issue with summary is working
    Given we have a registered user.
    And we navigated to our project's issue page.
    And we clicked on the 'Create issue' tab that is located on the bottom.
    And we filled the issuetype with the correct issutetype.
    And we filled the summary with the correct summary.
    When we click on 'Edit' that is located under the issue's picture and summary.
    And we filled the summary with a new value.
    And we click on 'Update'.
    Then we can see our issue's summary is updated with the new summary value.