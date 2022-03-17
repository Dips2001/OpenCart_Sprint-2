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
  Scenario: To validate, two options-Login and Register-are available
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    Then I should see Login and Register options

#64
  @LoginAndRegister
  Scenario: To validate Checkout as New User
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I click on Register Button
    Then I should see Registeration form

#65
  @LoginAndRegister
  Scenario: To validate Checkout as Existing User
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I click on Login Button
    Then I should see Login form

#66
  @LoginAndRegister
  Scenario: To validate Checkout as a Guest User
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I click on Continue as Guest Button
    Then I should see Personal Details Form

#67
	@PersonalDetailsForm
  Scenario: To validate all the input fields are available
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I click on Continue as Guest Button
    Then I should see Personal Details Form
    And I should see First Name field, Last Name field, Email field, Phone Number field and Contine Button

#68
	@PersonalDetailsForm
  Scenario:To validate by providing valid values for First Name, Last Name, Email, Phone Number input field in the Personal Details Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
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
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid First Name
    And I enter valid Last Name
    And I enter valid Email Address
    And I enter valid Phone Number
    And I click on Submit Button
    Then I should see Address Details Form

#72
  @PersonalDetailsForm
  Scenario: To validate that redirection to Address Details form does not occurs after clicking on the Button if form is filled with invalid or null values
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter invalid/null in First Name field
    And I enter invalid/null in Last Name field
    And I enter invalid/null in Email field
    And I enter invalid/null in Phone Number field
    And I click on Submit Button
    Then I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form
    And Page should not redirect to Address Details Form


#73
	@AddressDetailsForm
  Scenario: To validate all the input fields are available 
    Given OpenCart website is ready
    When I launch URL in chrome browser
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
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter valid details in Personal details form
    And I click on Submit Button
    And I enter invalid/null details in Address form
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Address Form




#79
@SameAsCheckbox
    Scenario: Verification of "Same as" Checkbox of Billing details
    Given OpenCart website is ready
    When I launch URL in chrome browser
 	and I click on Checkout button
 	and I click on Continue As Guest
 	and I enter valid data in Personal Details Form
 	and I Click on Submit button
 	and I enter valid data in Address Form
 	and I click on submit button
 	and I click on checkbox for same billing address
 	and I click the submit button
    Then I should see Error message for Address, State, Pincode input field in the billing details Form

#80
@SameAsCheckbox
  Scenario: Verification of "Same as" Checkbox of Billing details
    Given OpenCart website is ready
    When I launch URL in chrome browser
    and I click on Checkout button
 	and I click on Continue As Guest
 	and I enter valid data in Personal Details Form
 	and I Click on Submit button
 	and I enter valid data in Address Form
 	and I click on submit button
 	and I do not click the checkbox for same billing address
 	and I click the submit button
   Then I should the billing details Form
   


#81
@BillingDetailsForm
  Scenario: Verification of Billing Address Form Appearance
    Given OpenCart website is ready
    when I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	and i enter valid data in Personal Details Form
	and i Click on Submit form
	and i enter valid in Address Form
	and i Click on Submit form
	and i Uncheck the checkbox "Same as Billing Address"
	and i Click on Submit Button  
    Then I should see the billing details Form

#82
@BillingDetailsForm
  Scenario: Verification of Billing Address Form Appearance
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	and i enter valid data in Personal Details Form
	and i Click on Submit form
	and i enter valid in Address Form
	and i Click on Submit form
	and i Uncheck the checkbox "Same as Billing Address"
	and i Click on Submit Button  
	and I enter address
	And i enter state
	and i enter pincode
    And I click on Continue Button
    Then I should see the billing details Form

#83
@BillingDetailsForm
   Scenario: Verification of Billing Address Form Appearance
   Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	and i enter valid data in Personal Details Form
	and i Click on Submit form
	and i enter valid in Address Form
	and i Click on Submit form
	and i Uncheck the checkbox "Same as Billing Address"
	and i Click on Submit Button  
	and I enter address
	And i enter state
	and i enter pincode
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Billing details Form

#84
@BillingDetailsForm
  Scenario: Verification of Billing Address Form Appearance
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	and i enter valid data in Personal Details Form
	and i Click on Submit form
	and i enter valid in Address Form
	and i Click on Submit form
	and i Uncheck the checkbox "Same as Billing Address"
	and i Click on Submit Button  
	#doubt
	and I  address
	And i enter state
	and i enter pincode
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Address Form

#85
@BillingDetailsForm
  Scenario: Verification of Billing Address Form Appearance
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	and i enter valid data in Personal Details Form
	and i Click on Submit form
	and i enter valid in Address Form
	and i Click on Submit form
	and i Uncheck the checkbox "Same as Billing Address"
    And I click on submit Button
    and i enter valid data in billing details form
    and i click on submit button
    Then I should see the Billing details Form

#86
@BillingDetailsForm
  Scenario: Verification of Billing Address Form Appearance
   Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	and i enter valid data in Personal Details Form
	and i Click on Submit form
	and i enter valid in Address Form
	and i Click on Submit form
	and i Uncheck the checkbox "Same as Billing Address"
	and i Click on Submit Button  
	and i do not enter valid data in billing details form
    and i click on submit button
    Then I should see the Billing details Form
#todo
#87
@PaymentPage
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#
#88
#@PaymentPage
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#
#89
#@PaymentFunctionality
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#
#90
#@PaymentFunctionality
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#
#
#91
#@OrderOverviewPage
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#
#
#92
#@ConfirmOrderButton
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#
#93
#@ConfirmOrderButton
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#94
#@
