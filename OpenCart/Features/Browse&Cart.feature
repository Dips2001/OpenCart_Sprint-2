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
Feature: Browse and Cart Verification
  Verfying the browse and cart appreance and functions

  @BrowsingProducts
  Scenario: To validate that able to browse products similar to other products 
    Given Open cart website is ready
    And URL should be working
    When I browse products
    Then similar products should be available

  @BrowsingProducts
  Scenario: To validate that able to browse products with same category
    Given Open cart website is ready
    And URL should be working
    When I browse products
    Then same category products should be there

	@SearchingProducts
	Scenario: To validate that able to search products based on categories
		Given Open cart website is ready
		And URL should be working
		And Search option should be there
		When I search products
		Then searching should be available based on categories
		
	@SearchProducts
	Scenario: To validate that able to search products based on sub-category
		Given Open cart website is ready
		And URL should be working
		And Search option should be there
		When I search products
		Then searching should be available based on sub-categories
	
	@ListButton
	Scenario: To validate the appreance of list button on the products page
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		Then The list button should be visible there
		
	@ListButton
	Scenario:  To validate the working of list preference button for displaying products
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		And after clicking on list preference button
		Then the products should be displayed in list
	
	@GridButton
	Scenario: To validate the appreance of grid button on the products page
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		Then The grid button should be visible there

	@GridButton
	Scenario: To validate the working of grid preference button for dislplaying products
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		And after clicking on grid preference button
		Then the products should be displayed in grid
	
	@SortingProducts
	Scenario: To validate the products sorting according to rating
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		And select the rating option 
		Then the products gets sorted according to rating
		
	@SortingProducts
	Scenario: To validate the products sorting according to name
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		And select the name option 
		Then the products gets sorted according to name
	
	@SortingProducts
	Scenario: To validate the products sorting according to price
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		And select the price option 
		Then the products gets sorted according to price
	
	@SortingProducts
	Scenario: To validate the products sorting according to model
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		And select the model option 
		Then the products gets sorted according to model

	@WishlistButton
	Scenario: To validate after clicking on add to product,  product is added in wishlist or not
		Given Open cart website is ready
		And URL should be working
		When I go to products page
		And after clicking on wishlist icon 
		Then the product get added to wishlist
		
	@ProductPage
  Scenario: To validate Add to compare option is visible on product page
	  Given Open cart website is ready
	  And URL should be working
	  When I open product page
	  Then Add to compare option should be visible.

 @ProductPage
	Scenario: To validate after clicking on add to compare, product is added to compare list
		Given Open cart website is ready
		And URL should be working
		When I click on Add to compare option button
		Then product should be added to compare list.
	
	@ShoppingCart
	Scenario: To validate shopping cart option is visible on page
		Given Open cart website is ready
		And URL should be working
		When I open home page
		Then shopping cart option should be visible.
	
	
	@ShoppingCart
	Scenario: To validate products are present in shopping cart, if previously added
		Given Open cart website is ready
		And URL should be working
		When I click on shopping cart
		Then products added to cart should be present.
	
	@ShoppingCart
	Scenario: 1. To validate coupon code option is visible to customer before heading to checkout
		Given Open cart website is ready
		And URL should be working
		When I heading to checkout
		Then coupon code  option should be visible to customer.
	
	
	@ShoppingCart
	Scenario: To validate changes in total cost after adding coupon code
		Given Open cart website is ready
		And URL should be working
		When I insert coupon code while buying product 
		Then total cost of product should be changed according to coupon discount
	
	@ShoppingCart
	Scenario: To validate estimate shipping taxes option is visible to customer before heading to checkout
		Given Open cart website is ready
		And URL should be working
		When I heading to checkout
		Then estimate shipping taxes option should be visible
	
	
	@ShoppingCart
	Scenario: To validate changes in total cost after adding estimate shipping taxes
		Given Open cart website is ready
		And URL should be working
		When I click on add to estimate option
		Then total cost of product should be changed according to shipping and taxes
	
	@ShoppingCart
	Scenario: To validate coupon code or gift voucher option is visible to customer before heading to checkout
		Given Open cart website is ready
		And URL should be working
		When I heading to checkout
		Then coupon code or gift voucher option should be visible to customer.
	
	@ShoppingCart
	Scenario: To validate changes in total cost after adding gift voucher
		Given Open cart website is ready
		And URL should be working
		When I  add gift voucher
		Then total cost of product should be changed according to gift voucher discount
	
	@Checkout
	Scenario: To validate continue to shopping button is visible on home page
		Given Open cart website is ready
		And URL should be working
		When I completed the process of checkout
		Then continue to shopping option should be visible
	
	@Checkout
	Scenario: To validate working of continue to shopping button
		Given Open cart website is ready
		And URL should be working
		When I click on continue to shopping button
		Then page should be redirected to home page
	