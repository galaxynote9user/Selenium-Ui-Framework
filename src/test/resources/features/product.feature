@Priduct
Feature: Product Details Page

  

  Scenario:  Selecting Source Labs Bolt T-Shirt
  
  Given I open the browser and navigate to Saucelabs login page
    When I enter valid username "standard_user" and password "secret_sauce"
    And I click the login button
 Given Sucesssfilly Login to the Application
    When Select a product "Source Labs Bolt T-shirt"
    Then Validating price of the product and Add to cart button
