#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

  @tag
  Feature: Verification of Header Section
	  Different aspects of Header Section is being verified

  @tag1
  Scenario: To validate the header section is in proper position
    Given OpenCart website is ready
    When I launch URL in chrome browser
    Then OpenCart website should load with Header section in proper position

  @tag2
  Scenario: To validate header section is visible in all pages
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I check whether header section is visible in all pages
    Then OpenCart website should load with Header section
    And Header Section should be visible in all pages

  @tag
  Feature: Verification of Store Logo functionality
    Store Logo functionality is being verified

  @tag1
  Scenario: To validate that redirection to Home page occurs after clicking on the logo
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on store logo
    Then I should be redirected back to the home page

  @tag
  Feature: Verification of Currency Block
    Currency Block functionality is being verified

  @tag1
  Scenario: To validate the customer can select among various currency icons
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    Then the currency dropdown containing Euro, Pound Sterling and US dollar should appear

	@tag2
  Scenario: To validate the complete functionality of the website by selecting 'Euro' currency
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    And I select 'Euro' currency
    Then the price of all the products should convert to Euro currency

	@tag3
  Scenario: To validate the complete functionality of the website by selecting 'Sterling Pound' currency
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    And I select 'Pound Sterling' currency
    Then the price of all the products should convert to Pound Sterling currency

	@tag4
  Scenario: To validate the complete functionality of the website by selecting 'US Dollar' currency
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    And I select 'US Dollar' currency
    Then the price of all the products should convert to US Dollar currency

  @tag
  Feature: Verification of Shopping Cart Appearance
    Shopping Cart appearance is being verified

  @tag1
  Scenario: To validate that Shopping Cart displays total number of items purchased and total price of orders
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    Then shopping cart button should display number of items purchased and total cost of order
    
  @tag
  Feature: Verification of Shopping Cart Functionality
    Shopping Cart functionality is being verified

  @tag1
  Scenario: To validate the functionality of shopping cart option when empty
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on shopping cart
    Then it should display "Your shopping cart is empty!"
    
  @tag2
  Scenario: To validate shopping cart option is functioning properly with products added
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on shopping cart
    Then it should display all product details added to the cart 

	@tag3
  Scenario: To validate that clicking on Shopping Cart button will have both "View Cart" and "Checkout" option 
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on shopping cart
    Then the price of all the products should convert to Euro currency

	@tag4
  Scenario: To validate that page is redirected to the shopping cart page after clicking View Cart or Checkout
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on shopping cart option
    And I click on "View Cart" or "Checkout"
    Then the page should be redirected to the shopping cart page

  @tag
  Feature: Verification of Search Box functionality
    Search Box functionality is being verified

  @tag1
  Scenario: To validate that search page opens with pre-filled search criteria when text is given by customer in Search Box and click on Search button
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Search Box
    And I type some text in the search box
    And I click on Search button
    Then Search page should open 
    And search text should appear in the Search criteria box


  #@tag2
  #Scenario Outline: 
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
      
