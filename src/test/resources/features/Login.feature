@login @regression

Feature: WebDriver University - Login page

  Background:
    Given I access the webdriver university login page
@login1
  Scenario: Validate Successful Login - specific data
    When I enter a specific username "webdriver"
    And I enter a specific password webdriver123
    And I click on Login button
    Then I should be presented with a successful login message

  Scenario: Validate Unsuccessful Login - unique data
    When I enter a unique username
    And I enter a unique password
    And I click on Login button
    Then I should be presented with an unsuccessful login message

  Scenario: Validate Unsuccessful Login - specific data
    When I enter a specific username "webdriver"
    And I enter a specific password password123
    And I click on Login button
    Then I should be presented with an unsuccessful login message

  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on Login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username   | password     | loginValidationMessage |
      | webdriver  | webdriver123 | validation succeeded   |
      | farhana123 | password123  | validation failed      |
      | farhanaRm  | sample123    | validation failed      |