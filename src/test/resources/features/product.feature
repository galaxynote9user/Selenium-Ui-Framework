@Product
Feature: Product Details Page

Background: Pre-requesite
  Given I open the browser and navigate to Saucelabs login page
  When I enter valid username "standard_user" and password "secret_sauce"
  And I click the login button
  And Sucesssfilly Login to the Application and navigated to the product pages

  @Sinlge-Product
  Scenario: Selecting Sauce Labs Bolt T-Shirt  
    Given Select a product "Sauce Labs Bolt T-shirt"
    And I click on the add to cart button
    And I Navigated to the Cart page
    Then I should able to see added product in the cart with expected details

  @ProductSort
  Scenario: Verify Sorting functionality in product page
    When I click on filter option
    Then I should able to able to click on ascending name sort
    And I verify the product names are sorted in ascending order
    Then I click on filter option
    And I should able to click on descending name sort
    Then I verify the product names are sorted in descending order