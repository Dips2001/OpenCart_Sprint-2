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
  Feature: Ordering and Checkout Verification
	  Verfication of functionalities in Ordering and Checkout

#63
  @LoginAndRegister
  Scenario: To validate Login form along with two options-Register and Guest Checkout are available
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    Then I should see Checkout Options Form
    And I should see Login Form 
    And I should see Register Account and Guest Checkout options
    
  @LoginAndRegister
  Scenario: To validate Confirm Order via Login 
  	Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    Then I should see Login Form 
    When I enter email as <"dipanwita.jash@gmail.com">
    And I enter password as <"Dipanwita">
    And I click on Login Button
    Then I should see Billing Details Form
    
    
    

#64
  #@LoginAndRegister
  #Scenario: To validate Checkout as New User
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I click on Register Option
    #Then I should see Registeration form

#65
  #@LoginAndRegister
  #Scenario: To validate Checkout as Existing User
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I click on Login Button
    #Then I should see Login form

#66
  #@LoginAndRegister
  #Scenario: To validate Checkout as a Guest User
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I click on Continue as Guest Button
    #Then I should see Personal Details Form

#67
	@PersonalDetailsForm
  Scenario: To validate all the input fields are available
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    Then I should see Personal Details Form
    And I should see First Name field, Last Name field, Email field, Phone Number field and Contine Button

#68
	@PersonalDetailsForm
  Scenario:To validate by providing valid values for First Name, Last Name, Email, Phone Number input field in the Personal Details Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid First Name
    And I enter valid Last Name
    And I enter valid Email
    And I enter valid Phone Number
    And I click on Submit Button
    Then I should see Address Form

#69
	@PersonalDetailsForm
  Scenario:To validate by providing invalid values for First Name, Last Name, Email, Phone Number input field in the Personal Details Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter invalid First Name
    And I enter invalid Last Name
    And I enter invalid Email
    And I enter invalid Phone Number
    And I click on Submit Button
    Then I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form

#70
	@PersonalDetailsForm
  Scenario:To validate by providing null values for First Name, Last Name, Email, Phone Number input field in the Personal Details Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I don't enter First Name
    And I don't enter Last Name
    And I don't enter Email Address
    And I don't enter Phone Number
    And I click on Submit Button
    Then I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form

#71
  @PersonalDetailsForm
  Scenario: To validate that redirection to Address Details form occurs after clicking on the Button if form is filled with valid values
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid First Name
    And I enter valid Last Name
    And I enter valid Email
    And I enter valid Phone Number
    And I click on Submit Button
    Then I should see Address Form

#72
  @PersonalDetailsForm
  Scenario: To validate that redirection to Address Details form does not occurs after clicking on the Button if form is filled with invalid or null values
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid First Name
    And I enter valid Last Name
    And I enter valid Email
    And I enter valid Phone Number
    And I click on Submit Button
    Then I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form
    And Page should not redirect to Address Form


#73
	@AddressDetailsForm
  Scenario: To validate all the input fields are available 
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid details in Personal details form
    And I click on Submit Button
    Then I should see Address Form with input fields - Address, State and Pincode

#74
	@AddressDetailsForm
  Scenario: To validate by providing valid values for Address, State, Pincode input field in the Address Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid details in Personal details form
    And I click on Submit Button
    And I enter valid Address
    And I enter valid State
    And I enter valid Pincode
    And I click on Continue Button
    Then I should see page with 'Same as' Checkbox for Billing details

#75
  @AddressDetailsForm
  Scenario: To validate by providing invalid values for Address, State, Pincode input field in the Address Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid details in Personal details form
    And I click on Submit Button
    And I enter invalid Address
    And I enter invalid State
    And I enter invalid Pincode
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Address Form

#76
@AddressDetailsForm
  Scenario: To validate by providing null values for Address, State, Pincode input field in the Address Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid details in Personal details form
    And I click on Submit Button
    And I enter null Address
    And I enter null State
    And I enter null Pincode
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Address Form

#77
@AddressDetailsForm
  Scenario: To validate that redirection occurs after clicking on the Button if form is filled with valid values
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid details in Personal details form
    And I click on Submit Button
    And I enter valid details in Address form
    And I click on Continue Button
    Then I should see page with 'Same as' Checkbox for Billing details

#78
@AddressDetailsForm
  Scenario: To validate that redirection does not occur after clicking on the Button if form is filled with invalid or null values
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid details in Personal details form
    And I click on Submit Button
    And I enter null details in Address form
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Address Form




#79
@SameAsCheckbox
    Scenario: To validate that redirection doesnot heppens to billing address form if checkbox is checked.
  Given OpenCart website is ready
  When I launch URL in chrome browser
 	And I click on Checkout button
 	And I click on Continue As Guest
 	And I enter valid data in Personal Details Form
 	And I Click on Submit button
 	And I enter valid data in Address Form
 	And I click on submit button
 	And I click on checkbox for same billing address
 	And I click the submit button
  Then I should see Error message for Address, State, Pincode input field in the billing details Form

#80
@SameAsCheckbox
  Scenario: To validate that redirection heppens to billing address form if checkbox is not checked.
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout button
 		And I click on Continue As Guest
 		And I enter valid data in Personal Details Form
 		And I Click on Submit button
 		And I enter valid data in Address Form
 		And I click on submit button
 		And I do not click the checkbox for same billing address
 		And I click the submit button
   Then I should see the billing details Form
   


#81
@BillingDetailsForm
  Scenario: To validate all the input fields are available
    Given OpenCart website is ready
    when I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And I enter valid data in Personal Details Form
	 	And i Click on Submit form
		And i enter valid in Address Form
		And i Click on Submit form
		And i Uncheck the checkbox "Same as Billing Address"
		And i Click on Submit Button  
    Then I should see the billing details Form

#82
@BillingDetailsForm
  Scenario: To validate by providing valid values for Address, State, Pincode input field in the Billing Address Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
    And i enter valid data in Personal Details Form
		And i Click on Submit form
		And i enter valid in Address Form
		And i Click on Submit form
		And i Uncheck the checkbox "Same as Billing Address"
		And i Click on Submit Button  
		And I enter address
		And i enter state
		And i enter pincode
    And I click on Continue Button
    Then I should see the billing details Form

#83
@BillingDetailsForm
   Scenario: To validate by providing invalid values for Address, State, Pincode input field in the Billing Address Form
   Given OpenCart website is ready
    When I launch URL in chrome browser
  And I click on Checkout Button
  And I Click on Continue As Guest
	And i enter valid data in Personal Details Form
	And i Click on Submit form
	And i enter valid in Address Form
	And i Click on Submit form
	And i Uncheck the checkbox "Same as Billing Address"
	And i Click on Submit Button  
	And I enter address
	And i enter state
	And i enter pincode
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Billing details Form

#84
@BillingDetailsForm
  Scenario: To validate by providing null values for Address, State, Pincode input field in the Billing Address Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
  And I Click on Continue As Guest
	And i enter valid data in Personal Details Form
	And i Click on Submit form
	And i enter valid in Address Form
	And i Click on Submit form
	And i Uncheck the checkbox "Same as Billing Address"
	And i Click on Submit Button  
	And I enter null Address
  And I enter null State
  And I enter null Pincode
  And I click on Continue Button
   Then I should see Null values for Address, State, Pincode input field in the Billing Address form

#85
@BillingDetailsForm
  Scenario: To validate that redirection occurs after clicking on the button if form is filled with valid values
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i Uncheck the checkbox "Same as Billing Address"
    And I click on submit Button
    And i enter valid data in billing details form
    And i click on submit button
    Then I should see the Payemnt option Page

#86
@BillingDetailsForm
  Scenario: To validate that redirection doesnot occurs after clicking on the button if form is filled with invalid or null values
  Given OpenCart website is ready
  When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i Uncheck the checkbox "Same as Billing Address"
	  And i Click on Submit Button  
	  And i do not enter valid data in billing details form
    And i click on submit button
    Then I should see the error message 

#87
@PaymentPage
  Scenario: To validate all the payment options are visible and selectable.
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i check the checkbox "Same as Billing Address" for same address
	  And i uncheck the checkbox "Same as Billing Address"
	  And i eneter valid data in billing address form
	  And i Click on Submit Button  
    Then I should see the Payment Options Page with selectable payment options

#88
@PaymentPage
  Scenario: To validate that all payment options are redirecting to the their own payment page.
   Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i check the checkbox "Same as Billing Address" for same address
	  And i uncheck the checkbox "Same as Billing Address"
	  And i eneter valid data in billing address form
	  And i Click on Submit Button  
    Then I should see the payment form 

#89
@PaymentFunctionality
  Scenario: To validate that all payment options work
   Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i check the checkbox "Same as Billing Address" for same address
	  And i uncheck the checkbox "Same as Billing Address"
	  And i eneter valid data in billing address form
	  And i Click on Submit Button 
	  And i click on one of the paymrnt option 
    Then I should see the payment form  
#90
@PaymentFunctionality
  Scenario: To validate that the correct payment amount is calculated and displayed.
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i check the Checkbox "Same as Billing Address" for same address
	  And i uncheck the checkbox "Same as Billing Address"
	  And i eneter valid data in billing address form
	  And i Click on Submit Button 
	  And i click on one of the Payment option 
	  And i enter Payment Details 
	  And i click on Submit Button
	  Then I should see Correct payment amount of the order and i should be redirected to order overview page
  

#91
@OrderOverviewPage
  Scenario: To validate the order overview is being displayed and is accurate.
     Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i check the Checkbox "Same as Billing Address" for same address
	  And i uncheck the checkbox "Same as Billing Address"
	  And i eneter valid data in billing address form
	  And i Click on Submit Button 
	  And i click on one of the Payment option 
	  And i enter Payment Details 
	  And i click on Submit Button
    Then I sould see An overview of the purchase which will include
     the product description, quantity, and price (including tax and shipping).

#92
@ConfirmOrderButton
  Scenario: To validate Confirm Order button is visible and clickable.
  Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i check the Checkbox "Same as Billing Address" for same address
	  And i uncheck the checkbox "Same as Billing Address"
	  And i eneter valid data in billing address form
	  And i Click on Submit Button 
	  And i click on one of the Payment option 
	  And i enter Payment Details 
	  And i click on Submit Button
	  And i click the confirm order Button 
	  Then i see the order overview page 

#93
@ConfirmOrderButton
  Scenario: To validate that redirection to homepage occurs after clicking the button with notification of "Order Confirmed".
  Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And i enter valid data in Personal Details Form
	  And i Click on Submit form
	  And i enter valid in Address Form
	  And i Click on Submit form
	  And i check the Checkbox "Same as Billing Address" for same address
	  And i uncheck the checkbox "Same as Billing Address"
	  And i eneter valid data in billing address form
	  And i Click on Submit Button 
	  And i click on one of the Payment option 
	  And i enter Payment Details 
	  And i click on Submit Button
	  And i click the confirm order Button 
	  Then i should see the Home Page with a notification Order is confirmed.

