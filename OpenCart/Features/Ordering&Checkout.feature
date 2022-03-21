  @OrderingCheckout
  Feature: Ordering and Checkout Verification
	  Verfication of functionalities in Ordering and Checkout

#63
  @LoginAndRegister @Done
  Scenario: To validate Login form along with two options-Register and Guest Checkout are available
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    Then I should see Checkout Options Form
    And I should see Login Form 
    And I should see Register Account and Guest Checkout options
    
  @LoginExistingConfirm @Done
  Scenario: To validate Confirm Order via Login and using Existing Address
  	Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    Then I should see Login Form 
    When I enter email
    And I enter password
    #When I enter email as <"<email>">
    #And I enter password as <"<password>">
    And I click on Login Button
    #Examples: 
    #| email                  | password  |
    #|keshavopencart@gmail.com|Ironman@710|
    #|dipanwita.jash@gmail.com|Dipanwita  |
    Then I should see Billing Details Form
    When I click on Use an Existing Address in Billing Details Form
    Then I should see Delivery Details Form
    When I click on Use an Existing Address in Delivery Details Form
    Then I should see Delivery Method Form
    When I click on preferred Shipping Method
    Then I should see Payment Method Form
    When I click on preferred Payment Method
    And I click on Terms and Conditions
    Then I should see Confirm Order Form
    When I click on Confirm Order
    Then I should get confirmation about my order
    
    
  @LoginAndRegister @Done
  Scenario: To validate Confirm Order via Guest Checkout
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    Then I should see Personal Details Form


  @PersonalDetailsForm @Done
  Scenario: To validate all the input fields are available in personal details form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    Then I should see Personal Details Form
    And I should see First Name field, Last Name field, Email field, Phone Number field and Continue Button

  @PersonalDetailsForm @Done
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

  @PersonalDetailsForm @Done
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

  @PersonalDetailsForm @Done
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
  Scenario: To validate by providing null values for First Name, Last Name, Email, Phone Number input field in the Billing Details Form
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

  @BillingDetailsForm
  Scenario: To validate by providing invalid values for First Name, Last Name, Email, Phone Number input field in the Billing Details Form
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter all the valid details in Personal Details form
    And I uncheck the checkbox for same billing address
    And I click on Continue Button in Personal Details Form
    And I enter invalid First Name in Billing Details Form
    And I enter invalid Last Name in Billing Details Form
    And I enter invalid Address1 in Billing Details Form
    And I enter invalid Address2 in Billing Details Form
    And I enter invalid City in Billing Details Form
    And I enter invalid Post Code in Billing Details Form
    And I select valid Country in Billing Details Form
    And I select valid Zone in Billing Details Form
    And I click on Continue Button in Billing Details Form
    Then I should see Error message for First Name, Last Name, Address1, Address2, City, Post Code, Country, Zone input field in the Billing Details Form

	@SameAsCheckbox
  Scenario: To validate that redirection doesnot heppens to billing address form if checkbox is checked.
  	Given OpenCart website is ready
  	When I launch URL in chrome browser
 		And I click on Checkout button
 		And I click on Continue As Guest
 		And I enter valid data in Personal Details Form
 		And I click on Continue Button in Personal Details Form
 		And I enter valid data in Address Form
 		And I click on checkbox for same billing address
 		And I click on Continue Button in Billing Details Form 
  	Then I should see Delivery Method Form
    When I click on preferred Shipping Method
    Then I should see Payment Method Form
    When I click on preferred Payment Method
    And I click on Terms and Conditions
    Then I should see Confirm Order Form
    When I click on Confirm Order
    Then I should get confirmation about my order


	@SameAsCheckbox
  Scenario: To validate that redirection heppens to billing address form if checkbox is not checked.
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout button
 		And I click on Continue As Guest
 		And I enter valid data in Personal Details Form
 		And I click on Continue Button in Personal Details Form
 		And I enter valid data in Address Form
 		And I do not click the checkbox for same billing address
 		And I click on Continue Button in Billing Details Form 
    Then I should see the Delivery details Form
    And I click the continue button
    Then I should see Delivery Method Form
    When I click on preferred Shipping Method
    Then I should see Payment Method Form
    When I click on preferred Payment Method
    And I click on Terms and Conditions
    Then I should see Confirm Order Form
    When I click on Confirm Order
    Then I should get confirmation about my order
   

	@BillingDetailsForm
  Scenario: To validate all the input fields are available
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I click on Checkout Button
    And I Click on Continue As Guest
	  And I enter valid data in Personal Details Form
	 	And I click on Continue Button in Personal Details Form
		And i enter valid in Address Form
		And i Uncheck the checkbox "Same as Billing Address"
	  And I click on Continue Button in Billing Details Form 
    Then I should see the Delivery details Form
    And I enter address in delivery details
		And i enter state in delivery details
		And i enter pincode in delivery details
		And i enter country in delivery details
		And i enter region in delivery details
    And I click the continue button
    Then I should see Delivery Method Form
    When I click on preferred Shipping Method
    Then I should see Payment Method Form
    When I click on preferred Payment Method
    And I click on Terms and Conditions
    Then I should see Confirm Order Form
    When I click on Confirm Order
    Then I should get confirmation about my order
    



	@BillingDetailsForm
   Scenario: To validate by providing invalid values for Address, State, Pincode input field in the Billing Address Form
   	Given OpenCart website is ready
    When I launch URL in chrome browser
  	And I click on Checkout Button
  	And I Click on Continue As Guest
		And i enter valid data in Personal Details Form
		And I click on Continue Button in Personal Details Form
		And i enter valid in Address Form
		And i Uncheck the checkbox "Same as Billing Address"
		And I click on Continue Button in Billing Details Form  
		And I enter invalid address in delivery details
		And i enter invalid state in delivery details
		And i enter invalid pincode in delivery details
		And i enter invalid country in delivery details
		And i enter invalid Region in delivery details
    And I click on Continue Button
    Then I should see Error message for Address, State, Pincode input field in the Billing details Form


	@BillingDetailsForm
  Scenario: To validate by providing null values for Address, State, Pincode input field in the Billing Address Form
  	Given OpenCart website is ready
	  When I launch URL in chrome browser
	  And I click on Checkout Button
	  And I Click on Continue As Guest
		And i enter valid data in Personal Details Form
		And I click on Continue Button in Personal Details Form
		And i enter valid in Address Form
		And i Uncheck the checkbox "Same as Billing Address"
		And I click on Continue Button in Billing Details Form   
		And I enter null Address in delivery details
	  And I enter null State in delivery details
	  And I enter null Pincode in delivery details
	  And i enter null country in delivery details
		And i enter null Region in delivery details
	  And I click on Continue Button
	  Then I should see Error message for Address, State, Pincode input field in the Billing Address form

#
#	@BillingDetailsForm
  #Scenario: To validate that redirection occurs after clicking on the button if form is filled with valid values
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
    #Then I should see the Payemnt option Page



 #@BillingDetailsForm
  #Scenario: To validate that redirection doesnot occurs after clicking on the button if form is filled with invalid or null values
      #Given OpenCart website is ready
#	    When I launch URL in chrome browser
#	    And I click on Checkout Button
#	    And I Click on Continue As Guest
#		  And i enter valid data in Personal Details Form
#		  And i Click on Submit form
#		  And i enter valid in Address Form
#		  And i Click on Submit form
#		  And i Uncheck the checkbox "Same as Billing Address"
#		  And i Click on Submit Button  
#		  And i do not enter valid data in billing details form
#	    And i click on submit button
#	    Then I should see the error message 
#
#
#@PaymentPage
  #Scenario: To validate all the payment options are visible and selectable.
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i check the checkbox "Same as Billing Address" for same address
#	  And i uncheck the checkbox "Same as Billing Address"
#	  And i eneter valid data in billing address form
#	  And i Click on Submit Button  
    #Then I should see the Payment Options Page with selectable payment options
#
#
#@PaymentPage
  #Scenario: To validate that all payment options are redirecting to the their own payment page.
   #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i check the checkbox "Same as Billing Address" for same address
#	  And i uncheck the checkbox "Same as Billing Address"
#	  And i eneter valid data in billing address form
#	  And i Click on Submit Button  
    #Then I should see the payment form 
#
#@PaymentFunctionality
  #Scenario: To validate that all payment options work
   #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i check the checkbox "Same as Billing Address" for same address
#	  And i uncheck the checkbox "Same as Billing Address"
#	  And i eneter valid data in billing address form
#	  And i Click on Submit Button 
#	  And i click on one of the paymrnt option 
    #Then I should see the payment form  
#
#@PaymentFunctionality
  #Scenario: To validate that the correct payment amount is calculated and displayed.
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i check the Checkbox "Same as Billing Address" for same address
#	  And i uncheck the checkbox "Same as Billing Address"
#	  And i eneter valid data in billing address form
#	  And i Click on Submit Button 
#	  And i click on one of the Payment option 
#	  And i enter Payment Details 
#	  And i click on Submit Button
#	  Then I should see Correct payment amount of the order and i should be redirected to order overview page
  #
#
#
#@OrderOverviewPage
  #Scenario: To validate the order overview is being displayed and is accurate.
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i check the Checkbox "Same as Billing Address" for same address
#	  And i uncheck the checkbox "Same as Billing Address"
#	  And i eneter valid data in billing address form
#	  And i Click on Submit Button 
#	  And i click on one of the Payment option 
#	  And i enter Payment Details 
#	  And i click on Submit Button
    #Then I sould see An overview of the purchase which will include the product description, quantity, and price (including tax and shipping).
#
#
#@ConfirmOrderButton
  #Scenario: To validate Confirm Order button is visible and clickable.
  #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i check the Checkbox "Same as Billing Address" for same address
#	  And i uncheck the checkbox "Same as Billing Address"
#	  And i eneter valid data in billing address form
#	  And i Click on Submit Button 
#	  And i click on one of the Payment option 
#	  And i enter Payment Details 
#	  And i click on Submit Button
#	  And i click the confirm order Button 
#	  Then i see the order overview page 
#
#
#@ConfirmOrderButton
  #Scenario: To validate that redirection to homepage occurs after clicking the button with notification of "Order Confirmed".
    #Given OpenCart website is ready
    #When I launch URL in chrome browser
    #And I click on Checkout Button
    #And I Click on Continue As Guest
#	  And i enter valid data in Personal Details Form
#	  And i Click on Submit form
#	  And i enter valid in Address Form
#	  And i Click on Submit form
#	  And i check the Checkbox "Same as Billing Address" for same address
#	  And i uncheck the checkbox "Same as Billing Address"
#	  And i eneter valid data in billing address form
#	  And i Click on Submit Button 
#	  And i click on one of the Payment option 
#	  And i enter Payment Details 
#	  And i click on Submit Button
#	  And i click the confirm order Button 
#	  Then i should see the Home Page with a notification Order is confirmed.
