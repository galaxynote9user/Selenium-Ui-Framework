@Product
Feature: Product Details Page

Background: Login Page Navigation
  Given I open the browser and navigate to Saucelabs login page
  When I enter valid username "standard_user" and password "secret_sauce"
  And I click the login button
  And Successfully Login to the Application and navigated to the product pages

  @Single-Product
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


    @OrderProduct
    Scenario Outline: Verify Checkout end to end flow
      Given Select a product "Sauce Labs Bolt T-shirt"
      When I click on the add to cart button
      And I Navigated to the Cart page
      Then I should able to see added product in the cart with expected details
      Then I capture the product details
      And I click on checkout button
      And I enter the details "<firstname>" "<lastname>" "<zipcode>"
      And I click on continue button
      And I verify the product details in the checkout page
      And I click on finish button
      Then I should able to see the order confirmation page

      Examples:
        | firstname | lastname | zipcode |
        | John      | Doe      | 12345   |
        | John      | Wick     | 54321   |