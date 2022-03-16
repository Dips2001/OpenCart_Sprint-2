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