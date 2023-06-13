@login

Feature: testapp1 - Login / Sign In page

  Background:
    Given I access the application Sign In page

  Scenario: Validate Successful Login - specific data
    When I enter an email farhanaRm@mail.com
    And I enter a password wolfoo@123
    And I click on Sign In button
    Then I should be displayed with home page

  Scenario: Validate Unsuccessful Login - specific data
    When I enter an email farhana@mail.com
    And I enter a password wolfoo@123
    And I click on Sign In button
    Then I should be presented with an unsuccessful login message

    Scenario Outline: Validate - Successful & Unsuccessful Login
      When I enter an email <email>
      And I enter a password <password>
      And I click on Sign In button
      Then I should be displayed with home page or unsuccessful login message <homePageOrLoginValidationMessage>

      Examples:
      |email|password|homePageOrLoginValidationMessage|
      |farhanaRm|wolfoo@123|https://testapp1.andresfloresv.com/index.php?controller=authentication?back=https%3A%2F%2Ftestapp1.andresfloresv.com%2Findex.php%3Fcontroller%3Dauthentication%3Fback%3Dhttps%253A%252F%252Ftestapp1.andresfloresv.com%252Findex.php|
