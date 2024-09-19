@Priduct
Feature: Product Details Page

  Scenario: Selecting Source Labs Bolt T-Shirt
    Given I open the browser and navigate to Saucelabs login page
    When I enter valid username "standard_user" and password "secret_sauce"
    And I click the login button
    And Sucesssfilly Login to the Application and navigated to the product pages
    And Select a product "Source Labs Bolt T-shirt"
    And I click on the add to cart button
    And I Navigated to the Cart page
    Then I should able to see added product in the cart with expected details
