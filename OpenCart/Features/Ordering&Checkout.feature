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
    When I enter email
    And I enter password
    And I click on Login Button
    Then I should see Billing Details Form
    
  @LoginAndRegister
  Scenario: To validate Confirm Order via Guest Checkout
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    Then I should see Personal Details Form

  @PersonalDetailsForm
  Scenario: To validate all the input fields are available in personal details form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    Then I should see Personal Details Form
    And I should see First Name field, Last Name field, Email field, Phone Number field and Continue Button

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
    And I enter valid Address1
    And I enter valid Address2
    And I enter valid City
    And I enter valid Post Code
    And I select valid Country
    And I select valid Zone
    And I click on Continue Button in Personal Details Form
    #Same step in Login Scenario
    Then I should see Delivery Method Form

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
    And I enter invalid Address1
    And I enter invalid Address2
    And I enter invalid City
    And I enter invalid Post Code
    And I click on Submit Button
    Then I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form

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

  @SameAsCheckbox
  Scenario: To validate the redirection of "Same As" Checkbox when unchecked in the Delivery Method Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter all the valid details in Personal Details form
    And I uncheck the checkbox for same billing address
    And I click on Continue Button in Personal Details Form
    Then Billing Details Form should be displayed

  @SameAsCheckbox
  Scenario: To validate the redirection of "Same As" Checkbox when checked in the Delivery Method Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter all the valid details in Personal Details form
    And I check the checkbox for same billing address
    And I click on Continue Button in Personal Details Form
    Then I should see Delivery Method Form

    @BillingDetailsForm
    Scenario: To validate by providing valid values for First Name, Last Name, Email, Phone Number input field in the Billing Details Form
      Given OpenCart website is ready
      When I launch URL in chrome browser
      And I add some products to shopping cart
      And I click on Checkout Button
      And I click on Continue as Guest Button
      And I enter all the valid details in Personal Details form
      And I uncheck the checkbox for same billing address
      And I click on Continue Button in Personal Details Form
      And I enter valid First Name in Billing Details Form
      And I enter valid Last Name in Billing Details Form
      And I enter valid Address1 in Billing Details Form
      And I enter valid Address2 in Billing Details Form
      And I enter valid City in Billing Details Form
      And I enter valid Post Code in Billing Details Form
      And I select valid Country in Billing Details Form
      And I select valid Zone in Billing Details Form
      And I click on Continue Button in Billing Details Form
      Then I should see Delivery Method Form

  @BillingDetailsForm
  Scenario: To validate by providing null/invalid values for First Name, Last Name, Email, Phone Number input field in the Billing Details Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter all the valid details in Personal Details form
    And I uncheck the checkbox for same billing address
    And I click on Continue Button in Personal Details Form
    And I don't enter First Name in Billing Details Form
    And I don't enter Last Name in Billing Details Form
    And I don't enter Address1 in Billing Details Form
    And I don't enter Address2 in Billing Details Form
    And I don't enter City in Billing Details Form
    And I don't enter Post Code in Billing Details Form
    And I don't select Country in Billing Details Form
    And I don't select Zone in Billing Details Form
    And I click on Continue Button in Billing Details Form
    Then I should see Error message for First Name, Last Name, Address1, Address2, City, Post Code, Country, Zone input field in the Billing Details Form


#
#79
#@SameAsCheckbox
    #Scenario: Verification of "Same as" Checkbox of Billing details
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
 #	and I click on Checkout button
 #	and I click on Continue As Guest
 #	and I enter valid data in Personal Details Form
 #	and I Click on Submit button
 #	and I enter valid data in Address Form
 #	and I click on submit button
 #	and I click on checkbox for same billing address
 #	and I click the submit button
    #Then I should see Error message for Address, State, Pincode input field in the billing details Form
#
#80
#@SameAsCheckbox
  #Scenario: Verification of "Same as" Checkbox of Billing details
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #and I click on Checkout button
 #	and I click on Continue As Guest
 #	and I enter valid data in Personal Details Form
 #	and I Click on Submit button
 #	and I enter valid data in Address Form
 #	and I click on submit button
 #	and I do not click the checkbox for same billing address
 #	and I click the submit button
   #Then I should the billing details Form
   #
#
#
#81
#@BillingDetailsForm
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #when I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	and i enter valid data in Personal Details Form
#	and i Click on Submit form
#	and i enter valid in Address Form
#	and i Click on Submit form
#	and i Uncheck the checkbox "Same as Billing Address"
#	and i Click on Submit Button  
    #Then I should see the billing details Form
#
#82
#@BillingDetailsForm
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	and i enter valid data in Personal Details Form
#	and i Click on Submit form
#	and i enter valid in Address Form
#	and i Click on Submit form
#	and i Uncheck the checkbox "Same as Billing Address"
#	and i Click on Submit Button  
#	and I enter address
#	And i enter state
#	and i enter pincode
    #And I click on Continue Button
    #Then I should see the billing details Form
#
#83
#@BillingDetailsForm
   #Scenario: Verification of Billing Address Form Appearance
   #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	and i enter valid data in Personal Details Form
#	and i Click on Submit form
#	and i enter valid in Address Form
#	and i Click on Submit form
#	and i Uncheck the checkbox "Same as Billing Address"
#	and i Click on Submit Button  
#	and I enter address
#	And i enter state
#	and i enter pincode
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Billing details Form
#
#84
#@BillingDetailsForm
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	and i enter valid data in Personal Details Form
#	and i Click on Submit form
#	and i enter valid in Address Form
#	and i Click on Submit form
#	and i Uncheck the checkbox "Same as Billing Address"
#	and i Click on Submit Button  
#	#doubt
#	and I  address
#	And i enter state
#	and i enter pincode
    #And I click on Continue Button
    #Then I should see Error message for Address, State, Pincode input field in the Address Form
#
#85
#@BillingDetailsForm
  #Scenario: Verification of Billing Address Form Appearance
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i Uncheck the checkbox "Same as Billing Address"
    #And I click on submit Button
    #And i enter valid data in billing details form
    #And i click on submit button
    #Then I should see the Billing details Form
#
#86
#@BillingDetailsForm
  #Scenario: Verification of Billing Address Form Appearance
   #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i Uncheck the checkbox "Same as Billing Address"
#	  And i Click on Submit Button  
#	  And i do not enter valid data in billing details form
    #And i click on submit button
    #Then I should see the Billing details Form
#todo
#87
#@PaymentPage
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
