@Login @sanity @regression
Feature: Login to SauceLabs

  @Validlogin
  Scenario: Successful login
    Given I open the browser and navigate to Saucelabs login page
    When I enter valid username "Name" and password "Password"
    And I click the login button
    
  @Invalidlogin
  Scenario: Invalid login
    Given I open the browser and navigate to Saucelabs login page
    When I enter valid username "standard_user" and invalidpassword "secret_sauce1"
    And I click the login button
    Then I should see the error message

    