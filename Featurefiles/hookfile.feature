
Feature: As a normal user, I should be able to login

  Scenario Outline: Login with valid credentials
    Given I am on the login page
    When I enter valid username "<username>" and password "<password>"
    And I click the login button
    Then I should be logged in successfully
    And I print a message

    Examples:
      | username                  | password  |
      | eslamgamal19933@gmail.com | Bud2710ee |
