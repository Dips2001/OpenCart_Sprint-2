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
    And I add some products to shopping cart
    And I click on Checkout Button
    And I click on Continue as Guest Button
    And I enter all the valid details in Personal Details form
 		And I check the checkbox for same billing address
    And I click on Continue Button in Personal Details Form
    Then I should see Delivery Method Form
    When I click on preferred Shipping Method
    Then I should see Payment Method Form
    When I click on preferred Payment Method
    And I click on Terms and Conditions
    Then I should see Confirm Order Form
    When I click on Confirm Order
    Then I should get confirmation about my order

	@SameAsCheckbox @Do
  Scenario: To validate that redirection happens to billing address form if checkbox is not checked.
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
    When I click on preferred Shipping Method
    Then I should see Payment Method Form
    When I click on preferred Payment Method
    And I click on Terms and Conditions
    Then I should see Confirm Order Form
    When I click on Confirm Order
    Then I should get confirmation about my order

