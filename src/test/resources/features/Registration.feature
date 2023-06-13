@registration

Feature: testapp1 - Registration page

  Background:
    Given I access the application registration page

  Scenario: Validate Successful Creation of Customer Account with inputs in all fields- Specific data
    When I click on Mrs check box for social title
    And I enter a specific first name Farhana
    And I enter a specific last name Rahman
    And I enter a specific email address farhanaRm123@mail.com
    And I enter a specific password cherryBlossom2023
    And i enter a specific birthdate 06/11/1952
    And I click on all the checkboxes
    And I  click on the save button
    Then I should be presented with the customer account name on home page

  Scenario: Validate Unsuccessful Creation of Customer Account with unfilled mandatory fields- Specific data
    When I click on Mr check box for social title
    And I enter a specific first name Joe
    And I enter a specific last name Harold
    And I enter a specific email address joeH123@mail.com
    And i enter a specific birthdate 06/11/1971
    And I click on all the checkboxes
    And I  click on the save button
    Then I should be presented with an error message in the unfilled mandatory field

  Scenario: Validate Unsuccessful Creation of Customer Account with unchecked Terms and Conditions- Specific data
    When I click on Mr check box for social title
    And I enter a specific first name John
    And I enter a specific last name Smith
    And I enter a specific email address johnS123@mail.com
    And I enter a specific password hello123
    And i enter a specific birthdate 06/08/1999
    And I click on the checkbox for Offers
    And I click on the checkbox for Newsletter
    And I click on the checkbox for Data Privacy
    And I  click on the save button
    Then I should be presented with an error message in the Terms and Conditions checkbox

