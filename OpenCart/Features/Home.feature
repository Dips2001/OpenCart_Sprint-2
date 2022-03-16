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
  Feature: Verification of Home Page
	  Appearances and Functionalities of Home Page are being verified

  @HeaderSection
  Scenario: To validate the header section is in proper position
    Given OpenCart website is ready
    When I launch URL in chrome browser
    Then OpenCart website should load with Header section in proper position

  @HeaderSection
  Scenario: To validate header section is visible in all pages
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I check whether header section is visible in all pages
    Then OpenCart website should load with Header section
    And Header Section should be visible in all pages

  @StoreLogo
  Scenario: To validate that redirection to Home page occurs after clicking on the logo
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on store logo
    Then I should be redirected back to the home page

  @CurrencyBlock
  Scenario: To validate the customer can select among various currency icons
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    Then the currency dropdown containing Euro, Pound Sterling and US dollar should appear

	@CurrencyBlock
  Scenario: To validate the complete functionality of the website by selecting 'Euro' currency
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    And I select 'Euro' currency
    Then the price of all the products should convert to Euro currency

	@CurrencyBlock
  Scenario: To validate the complete functionality of the website by selecting 'Sterling Pound' currency
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    And I select 'Pound Sterling' currency
    Then the price of all the products should convert to Pound Sterling currency

	@CurrencyBlock
  Scenario: To validate the complete functionality of the website by selecting 'US Dollar' currency
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on currency block
    And I select 'US Dollar' currency
    Then the price of all the products should convert to US Dollar currency

  @ShoppingCart
  Scenario: To validate that Shopping Cart displays total number of items purchased and total price of orders
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    Then shopping cart button should display number of items purchased and total cost of order

  @ShoppingCart
  Scenario: To validate the functionality of shopping cart option when empty
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on shopping cart
    Then it should display "Your shopping cart is empty!"
    
  @ShoppingCart
  Scenario: To validate shopping cart option is functioning properly with products added
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on shopping cart
    Then it should display all product details added to the cart 

	@ShoppingCart
  Scenario: To validate that clicking on Shopping Cart button will have both "View Cart" and "Checkout" option 
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on shopping cart
    Then the price of all the products should convert to Euro currency

	@ShoppingCart
  Scenario: To validate that page is redirected to the shopping cart page after clicking View Cart or Checkout
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on shopping cart option
    And I click on "View Cart" or "Checkout"
    Then the page should be redirected to the shopping cart page

  @SearchBox
  Scenario: To validate that search page opens with pre-filled search criteria when text is given by customer in Search Box and click on Search button
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Search Box
    And I type some text in the search box
    And I click on Search button
    Then Search page should open 
    And search text should appear in the Search criteria box
    
    

@SearchBox
  Scenario: To validate that search page is opened after nothing provided in search box and search button is pressed
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on Search Box
    But leaving the serch box empty 
    And click search button
    Then OpenCart website should load Search page 


@Links
  Scenario: To validate links for My Account, Wish List, Shopping Cart and Checkout are present in header section
    Given OpenCart website is ready
    When I launch URL in chrome browser
    Then OpenCart website should load Header section with links for My Account, Wish List, Shopping Cart and Checkout are present in header section


@MyAccount
  Scenario: To validate that dropdown list containing Register and Login appears on clicking on the "My Account" link
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on My account in header section
    Then dropdown list should display options as Register and Login.

@WishList
  Scenario: To validate that redirection occurs to the Wish List page on clicking on the "Wish List" link
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on Wish List in header section
    Then Wish List page should display all product added to the Wish List.

@ShoppingCart
  Scenario:To validate that redirection occurs to the Shopping Cart page on clicking the "Shopping Cart" link
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on Shopping Cart in header section
    Then page should redirect to Shopping Cart page which will display all product added to the Shopping Cart.

@Checkout
  Scenario:To validate that redirection occurs to the Shopping Cart page which contains a link to checkout on clicking the "Checkout" link
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on Checkout in header section
    Then page should redirect to Shopping Cart page which contains a link to checkout.



@Telephone
  Scenario:To validate that Company Telephone Number is given is header section
    Given OpenCart website is ready
    When I launch URL in chrome browser
    Then The company telephone number should be visible at the header.




@Telephone
  Scenario:To validate that redirection to Contact Us page happens after clicking on 'Phone' icon
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on Phone icon
    Then  the page should redirect to the Contact Us page.



@RegisterPage
  Scenario:To validate that redirection to the Register page after clicking Register
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on dropdown icon of My Account
    And click on Register
    Then  the page should redirect to the Registration page.

@LoginPage
  Scenario:To validate that redirection to the Login page after clicking Login
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And click on dropdown icon of My Account
    And click on Login
    Then  the page should redirect to the Login page.









    










    


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
      
