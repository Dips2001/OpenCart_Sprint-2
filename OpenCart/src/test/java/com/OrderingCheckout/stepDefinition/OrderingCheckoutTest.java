package com.OrderingCheckout.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderingCheckoutTest {
	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Capgemini\\Internship\\Module-4\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("OpenCart website is ready")
	public void open_cart_website_is_ready() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I launch URL in chrome browser")
	public void i_launch_url_in_chrome_browser() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on Checkout Button")
	public void i_click_on_checkout_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Login and Register options")
	public void i_should_see_login_and_register_options() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on Register Button")
	public void i_click_on_register_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Registeration form")
	public void i_should_see_registeration_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on Login Button")
	public void i_click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Login form")
	public void i_should_see_login_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on Continue as Guest Button")
	public void i_click_on_continue_as_guest_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Personal Details Form")
	public void i_should_see_personal_details_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see First Name field, Last Name field, Email field, Phone Number field and Contine Button")
	public void i_should_see_first_name_field_last_name_field_email_field_phone_number_field_and_contine_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid First Name")
	public void i_enter_valid_first_name() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid Last Name")
	public void i_enter_valid_last_name() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid Email")
	public void i_enter_valid_email() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid Phone Number")
	public void i_enter_valid_phone_number() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on Submit Button")
	public void i_click_on_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Address Form")
	public void i_should_see_address_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid First Name")
	public void i_enter_invalid_first_name() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid Last Name")
	public void i_enter_invalid_last_name() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid Email")
	public void i_enter_invalid_email() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid Phone Number")
	public void i_enter_invalid_phone_number() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form")
	public void i_should_see_error_message_for_first_name_last_name_email_phone_number_input_field_in_the_personal_details_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I don't enter First Name")
	public void i_don_t_enter_first_name() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I don't enter Last Name")
	public void i_don_t_enter_last_name() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I don't enter Email Address")
	public void i_don_t_enter_email_address() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I don't enter Phone Number")
	public void i_don_t_enter_phone_number() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid Email Address")
	public void i_enter_valid_email_address() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Address Details Form")
	public void i_should_see_address_details_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid\\/null in First Name field")
	public void i_enter_invalid_null_in_first_name_field() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid\\/null in Last Name field")
	public void i_enter_invalid_null_in_last_name_field() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid\\/null in Email field")
	public void i_enter_invalid_null_in_email_field() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid\\/null in Phone Number field")
	public void i_enter_invalid_null_in_phone_number_field() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Page should not redirect to Address Details Form")
	public void page_should_not_redirect_to_address_details_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid details in Personal details form")
	public void i_enter_valid_details_in_personal_details_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Address Form with input fields - Address, State and Pincode")
	public void i_should_see_address_form_with_input_fields_address_state_and_pincode() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid Address")
	public void i_enter_valid_address() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid State")
	public void i_enter_valid_state() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid Pincode")
	public void i_enter_valid_pincode() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on Continue Button")
	public void i_click_on_continue_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see page with {string} Checkbox for Billing details")
	public void i_should_see_page_with_checkbox_for_billing_details(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid Address")
	public void i_enter_invalid_address() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid State")
	public void i_enter_invalid_state() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid Pincode")
	public void i_enter_invalid_pincode() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see Error message for Address, State, Pincode input field in the Address Form")
	public void i_should_see_error_message_for_address_state_pincode_input_field_in_the_address_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter null Address")
	public void i_enter_null_address() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter null State")
	public void i_enter_null_state() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter null Pincode")
	public void i_enter_null_pincode() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid details in Address form")
	public void i_enter_valid_details_in_address_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid\\/null details in Address form")
	public void i_enter_invalid_null_details_in_address_form() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}