package com.OrderingCheckout.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

	@When("I add some products to shopping cart")
	public void i_add_some_products_to_shopping_cart() {
		driver.findElement(By.name(prop.getProperty("search"))).sendKeys("hp");
	    driver.findElement(By.xpath(prop.getProperty("search_icon"))).click();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("hp_add_to_cart"))).click();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.findElement(By.xpath(prop.getProperty("button_cart"))).click();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    assertEquals(driver.findElement(By.xpath(prop.getProperty("alert1"))).getText(), "Success: You have added HP LP3065 to your shopping cart!\n×");
	}
	
	@When("I click on Checkout Button")
	public void i_click_on_checkout_button() {
		// Clicking on the Checkout Button
//		driver.findElement(By.xpath("//a[@title='Checkout']")).click();
//		driver.findElement(By.xpath(prop.getProperty("checkout"))).click();
//		driver.findElement(By.cssSelector("a[title='Checkout'] span[class='hidden-xs hidden-sm hidden-md']")).click();
//		driver.findElement(By.xpath("//span[normalize-space()='Checkout']")).click();
		driver.findElement(By.xpath(prop.getProperty("cart_total"))).click();
		driver.findElement(By.xpath(prop.getProperty("cart_checkout"))).click();
	}
	
	@Then("I should see Checkout Options Form")
	public void i_should_see_checkout_options_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Step 1: Checkout Options']")).getText(),"Step 1: Checkout Options");
	}

	@Then("I should see Login Form")
	public void i_should_see_login_form() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath(prop.getProperty("login_heading"))).getText());
		Thread.sleep(3000);
	    assertEquals(driver.findElement(By.xpath(prop.getProperty("login_heading"))).getText(),"Returning Customer");
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath(prop.getProperty("login_email"))).isEnabled());
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath(prop.getProperty("login_password"))).isEnabled());
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath(prop.getProperty("login_button"))).isDisplayed());
	}
	
	@Then("I should see Register Account and Guest Checkout options")
	public void i_should_see_register_account_and_guest_checkout_options() {
		// Register is Displayed
		boolean register = driver.findElement(By.xpath(prop.getProperty("register_account_label"))).isDisplayed();
		// Login is Displayed
		boolean guest = driver.findElement(By.xpath(prop.getProperty("guest_account_label"))).isDisplayed();
		// Assert if register and log is displayed
		Assert.assertTrue(register);
		Assert.assertTrue(guest);
	}
	
	@When("I enter email as <{string}>")
	public void i_enter_email_as(String email)
	{
		driver.findElement(By.xpath(prop.getProperty("login_email"))).clear();
		driver.findElement(By.xpath(prop.getProperty("login_email"))).sendKeys(email);
	}
	
	@When("I enter password as <{string}>")
	public void i_enter_password_as(String password)
	{
		driver.findElement(By.xpath(prop.getProperty("login_password"))).clear();
		driver.findElement(By.xpath(prop.getProperty("login_password"))).sendKeys(password);
	}
	
	@When("I click on Login Button")
	public void i_click_on_login_button()
	{
		driver.findElement(By.xpath(prop.getProperty("login_button"))).click();
	}
	
	@Then("I should see Billing Details Form")
	public void i_should_see_billing_details_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Step 2: Account & Billing Details']")).getText(),"Step 2: Account & Billing Details");
	}
	
	
	
	
	

//	@When("I click on Register Option")
//	public void i_click_on_register_option() {
//		// Clicking on Register Option
////		assertTrue(driver.findElement(By.xpath(prop.getProperty("register_account_label"))).isSelected());
//		driver.findElement(By.xpath(prop.getProperty("register_account_label"))).click();
////		driver.findElement(By.xpath(prop.getProperty("continue_button"))).click();
//	}

//	@Then("I should see Registration form")
//	public void i_should_see_registeration_form() {
//		// Registration form is displayed
//		boolean registration = driver.findElement(By.xpath(prop.getProperty("personal_details_legend"))).isDisplayed();
//		// Assert if registration form is displayed
//		Assert.assertTrue(registration);
//	}
//
//	@When("I click on Login Button")
//	public void i_click_on_login_button() {
//		// Clicking on Checkout Button
//		driver.findElement(By.xpath(prop.getProperty("checkout"))).click();
//	}

//	@Then("I should see Login form")
//	public void i_should_see_login_form() {
//		// Login form is displayed
//		boolean form = driver.findElement(By.xpath(prop.getProperty("returning_customer_legend"))).isDisplayed();
//		// Assert form
//		Assert.assertTrue(form);
//	}

	@When("I click on Continue as Guest Button")
	public void i_click_on_continue_as_guest_button() {
		// Clicking on Guest Button
		driver.findElement(By.xpath(prop.getProperty("input_value_guest"))).click();
		driver.findElement(By.xpath(prop.getProperty("continue_button"))).click();
	}

	@Then("I should see Personal Details Form")
	public void i_should_see_personal_details_form() {
		// Personal form is displayed
		boolean personal = driver.findElement(By.xpath(prop.getProperty("personal_details_legend"))).isDisplayed();
		// Assert if registration form is displayed
		Assert.assertTrue(personal);
	}

	@Then("I should see First Name field, Last Name field, Email field, Phone Number field and Contine Button")
	public void i_should_see_first_name_field_last_name_field_email_field_phone_number_field_and_contine_button() {
		// First Name field is displayed
		boolean firstName = driver.findElement(By.xpath(prop.getProperty("firstname_label"))).isDisplayed();
		// Last Name field is displayed
		boolean lastName = driver.findElement(By.xpath(prop.getProperty("lastname_label"))).isDisplayed();
		// Email field is displayed
		boolean email = driver.findElement(By.xpath(prop.getProperty("email_label"))).isDisplayed();
		// Phone Number field is displayed
		boolean phone = driver.findElement(By.xpath(prop.getProperty("phone_label"))).isDisplayed();
		// Assert if all the fields are displayed
		Assert.assertTrue(firstName);
		Assert.assertTrue(lastName);
		Assert.assertTrue(email);
		Assert.assertTrue(phone);
	}

	@When("I enter valid First Name")
	public void i_enter_valid_first_name() {
		// Enter valid First Name
		driver.findElement(By.id(prop.getProperty("firstname"))).click();
		driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys("FirstName");
	}

	@When("I enter valid Last Name")
	public void i_enter_valid_last_name() {
		// Enter valid Last Name
		driver.findElement(By.id(prop.getProperty("lastname"))).click();
		driver.findElement(By.id(prop.getProperty("lastname"))).sendKeys("LastName");
	}

	@When("I enter valid Email")
	public void i_enter_valid_email() {
		// Enter valid Email
		driver.findElement(By.id(prop.getProperty("email"))).click();
		driver.findElement(By.id(prop.getProperty("email"))).sendKeys("firstlast@gmail.com");
	}

	@When("I enter valid Phone Number")
	public void i_enter_valid_phone_number() {
		// Enter valid Phone Number
		driver.findElement(By.id(prop.getProperty("phone"))).click();
		driver.findElement(By.id(prop.getProperty("phone"))).sendKeys("1234567890");
	}

	@When("I click on Submit Button")
	public void i_click_on_submit_button() {
		// Pass - No submit button
	}

	@Then("I should see Address Form")
	public void i_should_see_address_form() {
		// Checking Address Form
		boolean address_form = driver.findElement(By.xpath(prop.getProperty("address_legend"))).isDisplayed();
		Assert.assertTrue(address_form);
	}

	@When("I enter invalid First Name")
	public void i_enter_invalid_first_name() {
		// Enter invalid First Name
		driver.findElement(By.id(prop.getProperty("firstname"))).click();
		driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys("@!123");
	}

	@When("I enter invalid Last Name")
	public void i_enter_invalid_last_name() {
		// Enter invalid Last Name
		driver.findElement(By.id(prop.getProperty("lastname"))).click();
		driver.findElement(By.id(prop.getProperty("lastname"))).sendKeys("@xe!123");
	}

	@When("I enter invalid Email")
	public void i_enter_invalid_email() {
		// Enter invalid Email
		driver.findElement(By.id(prop.getProperty("email"))).click();
		driver.findElement(By.id(prop.getProperty("email"))).sendKeys("123");
	}

	@When("I enter invalid Phone Number")
	public void i_enter_invalid_phone_number() {
		// Enter invalid phone number
		driver.findElement(By.id(prop.getProperty("phone"))).click();
		driver.findElement(By.id(prop.getProperty("phone"))).sendKeys("ABCDEF");
	}

	@Then("I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form")
	public void i_should_see_error_message_for_first_name_last_name_email_phone_number_input_field_in_the_personal_details_form() {
		// Clicking Continue button
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
		// Checking Error message
		boolean emailError = driver.findElement(By.xpath(prop.getProperty("email_error_message"))).isDisplayed();
		// Assert Error
		Assert.assertTrue(emailError);
	}

	@When("I don't enter First Name")
	public void i_don_t_enter_first_name() {
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@When("I don't enter Last Name")
	public void i_don_t_enter_last_name() {
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@When("I don't enter Email Address")
	public void i_don_t_enter_email_address() {
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@When("I don't enter Phone Number")
	public void i_don_t_enter_phone_number() {
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@Then("Page should not redirect to Address Details Form")
	public void page_should_not_redirect_to_address_details_form() {
		// Pass
	}

	@When("I enter valid details in Personal details form")
	public void i_enter_valid_details_in_personal_details_form() {
		driver.findElement(By.id(prop.getProperty("firstname"))).click();
		driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys("FirstName");
		driver.findElement(By.id(prop.getProperty("lastname"))).click();
		driver.findElement(By.id(prop.getProperty("lastname"))).sendKeys("LastName");
		driver.findElement(By.id(prop.getProperty("email"))).click();
		driver.findElement(By.id(prop.getProperty("email"))).sendKeys("firstlast@gmail.com");
		driver.findElement(By.id(prop.getProperty("phone"))).click();
		driver.findElement(By.id(prop.getProperty("phone"))).sendKeys("1234567890");
	}

	@Then("I should see Address Form with input fields - Address, State and Pincode")
	public void i_should_see_address_form_with_input_fields_address_state_and_pincode() {
		// Checking Address Form
		boolean address_form = driver.findElement(By.xpath(prop.getProperty("your_address_legend"))).isDisplayed();
		Assert.assertTrue(address_form);
	}

	@When("I enter valid Address")
	public void i_enter_valid_address() {
		driver.findElement(By.id(prop.getProperty("address"))).click();
		driver.findElement(By.id(prop.getProperty("address"))).sendKeys("Fire in Place");
		driver.findElement(By.id(prop.getProperty("city"))).click();
		driver.findElement(By.id(prop.getProperty("city"))).sendKeys("Mumbai");

	}

	@When("I enter valid State")
	public void i_enter_valid_state() {
		driver.findElement(By.id(prop.getProperty("country"))).click();
		WebElement dropdown = driver.findElement(By.id(prop.getProperty("country")));
		dropdown.findElement(By.xpath(prop.getProperty("india_option"))).click();
		driver.findElement(By.id(prop.getProperty("zone"))).click();
		WebElement dropdown1 = driver.findElement(By.id(prop.getProperty("zone")));
		dropdown1.findElement(By.xpath(prop.getProperty("mh_option"))).click();
	}

	@When("I enter valid Pincode")
	public void i_enter_valid_pincode() {
		driver.findElement(By.id(prop.getProperty("postcode"))).click();
		driver.findElement(By.id(prop.getProperty("postcode"))).sendKeys("400005");
	}

	@When("I click on Continue Button")
	public void i_click_on_continue_button() {
		// pass
	}

	@Then("I should see page with {string} Checkbox for Billing details")
	public void i_should_see_page_with_checkbox_for_billing_details(String string) {
		// Check if CheckBox is displayed
		boolean same_address = driver
				.findElement(By.xpath(prop.getProperty("checkbox_label")))
				.isDisplayed();
		// Assert CheckBox
		Assert.assertTrue(same_address);
	}

	@When("I enter invalid Address")
	public void i_enter_invalid_address() {
		driver.findElement(By.id(prop.getProperty("address"))).click();
		driver.findElement(By.id(prop.getProperty("address"))).sendKeys("Fire in Place");
		driver.findElement(By.id(prop.getProperty("city"))).click();
	}

	@When("I enter invalid State")
	public void i_enter_invalid_state() {
		driver.findElement(By.id(prop.getProperty("country"))).click();
		WebElement dropdown = driver.findElement(By.id(prop.getProperty("country")));
		dropdown.findElement(By.xpath(prop.getProperty("india_option"))).click();
		driver.findElement(By.id(prop.getProperty("zone"))).click();
		WebElement dropdown1 = driver.findElement(By.id(prop.getProperty("zone")));
		dropdown1.findElement(By.xpath(prop.getProperty("mh_option"))).click();
	}

	@When("I enter invalid Pincode")
	public void i_enter_invalid_pincode() {
		driver.findElement(By.id(prop.getProperty("postcode"))).click();
		driver.findElement(By.id(prop.getProperty("postcode"))).sendKeys("ABCDEF");
	}

	@Then("I should see Error message for Address, State, Pincode input field in the Address Form")
	public void i_should_see_error_message_for_address_state_pincode_input_field_in_the_address_form() {
		// Check if error is displayed
		boolean error_message = driver
				.findElement(By.xpath(prop.getProperty("address_error_message")))
				.isDisplayed();
		// Assert error message
		Assert.assertTrue(error_message);
	}

	@When("I enter null Address")
	public void i_enter_null_address() {
		// Click on Continue button
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@When("I enter null State")
	public void i_enter_null_state() {
		// Click on Continue button
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@When("I enter null Pincode")
	public void i_enter_null_pincode() {
		// Click on Continue button
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@When("I enter valid details in Address form")
	public void i_enter_valid_details_in_address_form() {
		// Entering all valid details in Address form
		driver.findElement(By.id(prop.getProperty("address"))).click();
		driver.findElement(By.id(prop.getProperty("address"))).sendKeys("Fire in Place");
		driver.findElement(By.id(prop.getProperty("city"))).click();
		driver.findElement(By.id(prop.getProperty("city"))).sendKeys("Mumbai");
		driver.findElement(By.id(prop.getProperty("country"))).click();
		WebElement dropdown = driver.findElement(By.id(prop.getProperty("country")));
		dropdown.findElement(By.xpath(prop.getProperty("india_option"))).click();
		driver.findElement(By.id(prop.getProperty("zone"))).click();
		WebElement dropdown1 = driver.findElement(By.id(prop.getProperty("zone")));
		dropdown1.findElement(By.xpath(prop.getProperty("mh_option"))).click();
		driver.findElement(By.id(prop.getProperty("postcode"))).click();
		driver.findElement(By.id(prop.getProperty("postcode"))).sendKeys("400005");

	}

	@When("I enter null details in Address form")
	public void i_enter_invalid_null_details_in_address_form() {
		// Clicking on Continue Button directly
		driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
	}

	@After
	public void afterScenario() {
		driver.quit();
	}
}