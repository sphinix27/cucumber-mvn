Feature: Login using UI

  Just a simple demo to login Trello with UI

  Scenario: Simple Login
    Given user is in login page
    When user enter username
    And user deletes username
    Then password should be visible