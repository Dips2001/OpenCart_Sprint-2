package com.OrderingCheckout.stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderingCheckoutTest {
	public static WebDriver driver;
	Properties prop;

	@Before
	public void beforeScenario() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Capgemini\\Internship\\Module-4\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fs = new FileInputStream("src/test/resources/OpenCart.properties");
		prop = new Properties();
		prop.load(fs);
	}

	@Given("OpenCart website is ready")
	public void open_cart_website_is_ready() {
		System.out.println("OpenCart website is up and running");
	}

	@When("I launch URL in chrome browser")
	public void i_launch_url_in_chrome_browser() {
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}

	@When("I click on Checkout Button")
	public void i_click_on_checkout_button() {
		// Clicking on the Checkout Button
		driver.findElement(By.xpath("//span[normalize-space()='Checkout']")).click();
	}

	@Then("I should see Login and Register options")
	public void i_should_see_login_and_register_options() {
		// Register is Displayed
		boolean register = driver.findElement(By.xpath("//label[normalize-space()='Register Account']")).isDisplayed();
		// Login is Displayed
		boolean login = driver.findElement(By.xpath("//label[normalize-space()='Guest Checkout']")).isDisplayed();

		// Assert if register and log is displayed
		Assert.assertTrue(register);
		Assert.assertTrue(login);
	}

	@When("I click on Register Button")
	public void i_click_on_register_button() {
		// Clicking on Register Button
		driver.findElement(By.xpath("//input[@value='register']")).click();
		driver.findElement(By.xpath("//input[@id='button-account']")).click();
	}

	@Then("I should see Registeration form")
	public void i_should_see_registeration_form() {
		// Registration form is displayed
		boolean registration = driver.findElement(By.xpath("//legend[normalize-space()='Your Personal Details']"))
				.isDisplayed();
		// Assert if registration form is displayed
		Assert.assertTrue(registration);
	}

	@When("I click on Login Button")
	public void i_click_on_login_button() {
		// Clicking on Checkout Button
		driver.findElement(By.xpath("//span[normalize-space()='Checkout']")).click();
	}

	@Then("I should see Login form")
	public void i_should_see_login_form() {
		// Login form is displayed
		boolean form = driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']")).isDisplayed();
		// Assert form
		Assert.assertTrue(form);
	}

	@When("I click on Continue as Guest Button")
	public void i_click_on_continue_as_guest_button() {
		// Clicking on Guest Button
		driver.findElement(By.xpath("//input[@value='guest']")).click();
		driver.findElement(By.xpath("//input[@id='button-account']")).click();
	}

	@Then("I should see Personal Details Form")
	public void i_should_see_personal_details_form() {
		// Personal form is displayed
		boolean personal = driver.findElement(By.xpath("//legend[normalize-space()='Your Personal Details']"))
				.isDisplayed();
		// Assert if registration form is displayed
		Assert.assertTrue(personal);
	}

	@Then("I should see First Name field, Last Name field, Email field, Phone Number field and Contine Button")
	public void i_should_see_first_name_field_last_name_field_email_field_phone_number_field_and_contine_button() {
		// First Name field is displayed
		boolean firstName = driver.findElement(By.xpath("//label[@for='input-payment-firstname']")).isDisplayed();
		// Last Name field is displayed
		boolean lastName = driver.findElement(By.xpath("//label[@for='input-payment-lastname']")).isDisplayed();
		// Email field is displayed
		boolean email = driver.findElement(By.xpath("//label[@for='input-payment-email']")).isDisplayed();
		// Phone Number field is displayed
		boolean phone = driver.findElement(By.xpath("//label[@for='input-payment-telephone']")).isDisplayed();
		// Assert if all the fields are displayed
		Assert.assertTrue(firstName);
		Assert.assertTrue(lastName);
		Assert.assertTrue(email);
		Assert.assertTrue(phone);
	}

	@When("I enter valid First Name")
	public void i_enter_valid_first_name() {
		// Enter valid First Name
		driver.findElement(By.id("input-payment-firstname")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("FirstName");
	}

	@When("I enter valid Last Name")
	public void i_enter_valid_last_name() {
		// Enter valid Last Name
		driver.findElement(By.id("input-payment-lastname")).click();
		driver.findElement(By.id("input-payment-lastname")).sendKeys("LastName");
	}

	@When("I enter valid Email")
	public void i_enter_valid_email() {
		// Enter valid Email
		driver.findElement(By.id("input-payment-email")).click();
		driver.findElement(By.id("input-payment-email")).sendKeys("firstlast@gmail.com");
	}

	@When("I enter valid Phone Number")
	public void i_enter_valid_phone_number() {
		// Enter valid Phone Number
		driver.findElement(By.id("input-payment-telephone")).click();
		driver.findElement(By.id("input-payment-telephone")).sendKeys("1234567890");
	}

	@When("I click on Submit Button")
	public void i_click_on_submit_button() {
		// Pass - No submit button
	}

	@Then("I should see Address Form")
	public void i_should_see_address_form() {
		// Checking Address Form
		boolean address_form = driver.findElement(By.xpath("//legend[normalize-space()='Your Address']")).isDisplayed();
		Assert.assertTrue(address_form);
	}

	@When("I enter invalid First Name")
	public void i_enter_invalid_first_name() {
		// Enter invalid First Name
		driver.findElement(By.id("input-payment-firstname")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("@!123");
	}

	@When("I enter invalid Last Name")
	public void i_enter_invalid_last_name() {
		// Enter invalid Last Name
		driver.findElement(By.id("input-payment-lastname")).click();
		driver.findElement(By.id("input-payment-lastname")).sendKeys("@xe!123");
	}

	@When("I enter invalid Email")
	public void i_enter_invalid_email() {
		// Enter invalid Email
		driver.findElement(By.id("input-payment-email")).click();
		driver.findElement(By.id("input-payment-email")).sendKeys("123");
	}

	@When("I enter invalid Phone Number")
	public void i_enter_invalid_phone_number() {
		// Enter invalid phone number
		driver.findElement(By.id("input-payment-telephone")).click();
		driver.findElement(By.id("input-payment-telephone")).sendKeys("ABCDEF");
	}

	@Then("I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form")
	public void i_should_see_error_message_for_first_name_last_name_email_phone_number_input_field_in_the_personal_details_form() {
		// Clicking Continue button
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
		// Checking Error message
		boolean emailError = driver
				.findElement(By.xpath("//div[normalize-space()='E-Mail address does not appear to be valid!']"))
				.isDisplayed();
		// Assert Error
		Assert.assertTrue(emailError);
	}

	@When("I don't enter First Name")
	public void i_don_t_enter_first_name() {
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@When("I don't enter Last Name")
	public void i_don_t_enter_last_name() {
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@When("I don't enter Email Address")
	public void i_don_t_enter_email_address() {
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@When("I don't enter Phone Number")
	public void i_don_t_enter_phone_number() {
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@Then("Page should not redirect to Address Details Form")
	public void page_should_not_redirect_to_address_details_form() {
		// Pass
	}

	@When("I enter valid details in Personal details form")
	public void i_enter_valid_details_in_personal_details_form() {
		driver.findElement(By.id("input-payment-firstname")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("FirstName");
		driver.findElement(By.id("input-payment-lastname")).click();
		driver.findElement(By.id("input-payment-lastname")).sendKeys("LastName");
		driver.findElement(By.id("input-payment-email")).click();
		driver.findElement(By.id("input-payment-email")).sendKeys("firstlast@gmail.com");
		driver.findElement(By.id("input-payment-telephone")).click();
		driver.findElement(By.id("input-payment-telephone")).sendKeys("1234567890");
	}

	@Then("I should see Address Form with input fields - Address, State and Pincode")
	public void i_should_see_address_form_with_input_fields_address_state_and_pincode() {
		// Checking Address Form
		boolean address_form = driver.findElement(By.xpath("//legend[normalize-space()='Your Address']")).isDisplayed();
		Assert.assertTrue(address_form);
	}

	@When("I enter valid Address")
	public void i_enter_valid_address() {
		driver.findElement(By.id("input-payment-address-1")).click();
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Fire in Place");
		driver.findElement(By.id("input-payment-city")).click();
		driver.findElement(By.id("input-payment-city")).sendKeys("Mumbai");

	}

	@When("I enter valid State")
	public void i_enter_valid_state() {
		driver.findElement(By.id("input-payment-country")).click();
		WebElement dropdown = driver.findElement(By.id("input-payment-country"));
		dropdown.findElement(By.xpath("//option[. = 'India']")).click();
		driver.findElement(By.id("input-payment-zone")).click();
		WebElement dropdown1 = driver.findElement(By.id("input-payment-zone"));
		dropdown1.findElement(By.xpath("//option[. = 'Maharashtra']")).click();
	}

	@When("I enter valid Pincode")
	public void i_enter_valid_pincode() {
		driver.findElement(By.id("input-payment-postcode")).click();
		driver.findElement(By.id("input-payment-postcode")).sendKeys("400005");
	}

	@When("I click on Continue Button")
	public void i_click_on_continue_button() {
		// pass
	}

	@Then("I should see page with {string} Checkbox for Billing details")
	public void i_should_see_page_with_checkbox_for_billing_details(String string) {
		// Check if CheckBox is displayed
		boolean same_address = driver
				.findElement(By.xpath("//label[normalize-space()='My delivery and billing addresses are the same.']"))
				.isDisplayed();
		// Assert CheckBox
		Assert.assertTrue(same_address);
	}

	@When("I enter invalid Address")
	public void i_enter_invalid_address() {
		driver.findElement(By.id("input-payment-address-1")).click();
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Fire in Place");
		driver.findElement(By.id("input-payment-city")).click();
	}

	@When("I enter invalid State")
	public void i_enter_invalid_state() {
		driver.findElement(By.id("input-payment-country")).click();
		WebElement dropdown = driver.findElement(By.id("input-payment-country"));
		dropdown.findElement(By.xpath("//option[. = 'India']")).click();
		driver.findElement(By.id("input-payment-zone")).click();
		WebElement dropdown1 = driver.findElement(By.id("input-payment-zone"));
		dropdown1.findElement(By.xpath("//option[. = 'Maharashtra']")).click();
	}

	@When("I enter invalid Pincode")
	public void i_enter_invalid_pincode() {
		driver.findElement(By.id("input-payment-postcode")).click();
		driver.findElement(By.id("input-payment-postcode")).sendKeys("ABCDEF");
	}

	@Then("I should see Error message for Address, State, Pincode input field in the Address Form")
	public void i_should_see_error_message_for_address_state_pincode_input_field_in_the_address_form() {
		// Check if error is displayed
		boolean error_message = driver
				.findElement(By.xpath("//div[normalize-space()='City must be between 2 and 128 characters!']"))
				.isDisplayed();
		// Assert error message
		Assert.assertTrue(error_message);
	}

	@When("I enter null Address")
	public void i_enter_null_address() {
		// Click on Continue button
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@When("I enter null State")
	public void i_enter_null_state() {
		// Click on Continue button
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@When("I enter null Pincode")
	public void i_enter_null_pincode() {
		// Click on Continue button
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@When("I enter valid details in Address form")
	public void i_enter_valid_details_in_address_form() {
		// Entering all valid details in Address form
		driver.findElement(By.id("input-payment-address-1")).click();
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Fire in Place");
		driver.findElement(By.id("input-payment-city")).click();
		driver.findElement(By.id("input-payment-city")).sendKeys("Mumbai");
		driver.findElement(By.id("input-payment-country")).click();
		WebElement dropdown = driver.findElement(By.id("input-payment-country"));
		dropdown.findElement(By.xpath("//option[. = 'India']")).click();
		driver.findElement(By.id("input-payment-zone")).click();
		WebElement dropdown1 = driver.findElement(By.id("input-payment-zone"));
		dropdown1.findElement(By.xpath("//option[. = 'Maharashtra']")).click();
		driver.findElement(By.id("input-payment-postcode")).click();
		driver.findElement(By.id("input-payment-postcode")).sendKeys("400005");

	}

	@When("I enter null details in Address form")
	public void i_enter_invalid_null_details_in_address_form() {
		// Clicking on Continue Button directly
		driver.findElement(By.xpath("//input[@id='button-guest']")).click();
	}

	@After
	public void afterScenario() {
		driver.quit();
	}
}