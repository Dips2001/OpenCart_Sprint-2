package com.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class HomeTest 
{
	public static WebDriver driver;
	
	@Before
	public void beforeScenario()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Capgemini\\Internship\\Module-4\\Drivers\\chromedriver_win32\\chromedriver.exe");
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

	@Then("OpenCart website should load with Header section in proper position")
	public void open_cart_website_should_load_with_header_section_in_proper_position() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I check whether header section is visible in all pages")
	public void i_check_whether_header_section_is_visible_in_all_pages() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("OpenCart website should load with Header section")
	public void open_cart_website_should_load_with_header_section() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Header Section should be visible in all pages")
	public void header_section_should_be_visible_in_all_pages() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on store logo")
	public void i_click_on_store_logo() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should be redirected back to the home page")
	public void i_should_be_redirected_back_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on currency block")
	public void i_click_on_currency_block() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the currency dropdown containing Euro, Pound Sterling and US dollar should appear")
	public void the_currency_dropdown_containing_euro_pound_sterling_and_us_dollar_should_appear() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I select {string} currency")
	public void i_select_currency(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the price of all the products should convert to Euro currency")
	public void the_price_of_all_the_products_should_convert_to_euro_currency() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the price of all the products should convert to Pound Sterling currency")
	public void the_price_of_all_the_products_should_convert_to_pound_sterling_currency() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the price of all the products should convert to US Dollar currency")
	public void the_price_of_all_the_products_should_convert_to_us_dollar_currency() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I add some products to shopping cart")
	public void i_add_some_products_to_shopping_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("shopping cart button should display number of items purchased and total cost of order")
	public void shopping_cart_button_should_display_number_of_items_purchased_and_total_cost_of_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on shopping cart")
	public void i_click_on_shopping_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("it should display {string}")
	public void it_should_display(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("it should display all product details added to the cart")
	public void it_should_display_all_product_details_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on shopping cart option")
	public void i_click_on_shopping_cart_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on {string} or {string}")
	public void i_click_on_or(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the page should be redirected to the shopping cart page")
	public void the_page_should_be_redirected_to_the_shopping_cart_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on Search Box")
	public void i_click_on_search_box() {
	   driver.findElement(By.name("search")).click();
	    
	}

	@When("I type some text in the search box")
	public void i_type_some_text_in_the_search_box() {
		driver.findElement(By.name("search")).sendKeys("iPhone");;
	  
	    
	}

	@When("I click on Search button")
	public void i_click_on_search_button() {
		 driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	   
	}

	@Then("Search page should open")
	public void search_page_should_open() {
	  String expectedPageTitle = "Search - iPhone";
	  String actualPageTitle = driver.getTitle();
	  
	  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@Then("search text should appear in the Search criteria box")
	public void search_text_should_appear_in_the_search_criteria_box() {
	    driver.findElement(By.xpath("//input[@id='input-search']"));
	    WebElement ActualSearchText = driver.findElement(By.xpath("//input[@id='input-search']"));
	    String ExpectedSearchText = "iPhone";
	    
	    Assert.assertEquals(ExpectedSearchText,ActualSearchText.getText());
	    
	}

	@When("click on Search Box")
	public void click_on_search_box() {
	    WebElement s = driver.findElement(By.xpath("//input[@placeholder='Search']"));
	    s.click();
	    s.clear();
	    
	}

	@When("click search button")
	public void click_search_button() {
	    driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	}

	@Then("OpenCart website should load Search page")
	public void open_cart_website_should_load_search_page() {
		 String expectedPageTitle = "Search";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@Then("OpenCart website should load Header section with links for My Account, Wish List, Shopping Cart and Checkout are present in header section")
	public void open_cart_website_should_load_header_section_with_links_for_my_account_wish_list_shopping_cart_and_checkout_are_present_in_header_section() {
		boolean myAcc = driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isDisplayed();
		boolean wishList = driver.findElement(By.xpath("//span[normalize-space()='Wish List (0)']")).isDisplayed();
		boolean ShopCart = driver.findElement(By.xpath("//span[normalize-space()='Shopping Cart']")).isDisplayed();
		boolean checkout = driver.findElement(By.xpath("//span[normalize-space()='Checkout']")).isDisplayed();
		
		

	}

	@When("click on My account in header section")
	public void click_on_my_account_in_header_section() {
		 driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	}

	@Then("dropdown list should display options as Register and Login.")
	public void dropdown_list_should_display_options_as_register_and_login() {
		boolean reg = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).isDisplayed();
		boolean log = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).isDisplayed();
	}

	@When("click on Wish List in header section")
	public void click_on_wish_list_in_header_section() {
		 driver.findElement(By.xpath("//span[normalize-space()='Wish List (1)']")).click();
	}

	@Then("Wish List button should redirect to Login page")
	public void wish_list_page_should_display_all_product_added_to_the_wish_list() {
		 String expectedPageTitle = "Account Login";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on Shopping Cart in header section")
	public void click_on_shopping_cart_in_header_section() {
		 driver.findElement(By.xpath("//span[normalize-space()='Shopping Cart']")).click();
	}

	@Then("page should redirect to Shopping Cart page which will display all product added to the Shopping Cart.")
	public void page_should_redirect_to_shopping_cart_page_which_will_display_all_product_added_to_the_shopping_cart() {
		 String expectedPageTitle = "Shopping Cart";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on Checkout in header section")
	public void click_on_checkout_in_header_section() {
		 driver.findElement(By.xpath("//span[normalize-space()='Checkout']")).click();
	}

	@Then("page should redirect to Shopping Cart page which contains a link to checkout.")
	public void page_should_redirect_to_shopping_cart_page_which_contains_a_link_to_checkout() {
		 String expectedPageTitle = "Shopping Cart";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@Then("The company telephone number should be visible at the header.")
	public void the_company_telephone_number_should_be_visible_at_the_header() {
		boolean telNumber= driver.findElement(By.xpath("//span[normalize-space()='123456789']")).isDisplayed();
	}

	@When("click on Phone icon")
	public void click_on_phone_icon() {
		 driver.findElement(By.xpath("//i[@class='fa fa-phone']")).click();
	}

	@Then("the page should redirect to the Contact Us page.")
	public void the_page_should_redirect_to_the_contact_us_page() {
		 String expectedPageTitle = "Contact Us";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on dropdown icon of My Account")
	public void click_on_dropdown_icon_of_my_account() {
		 driver.findElement(By.xpath("//span[@class='caret']")).click();
	}

	@When("click on Register")
	public void click_on_register() {
		 driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
	}

	@Then("the page should redirect to the Registration page.")
	public void the_page_should_redirect_to_the_registration_page() {
		 String expectedPageTitle = "Register Account";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on Login")
	public void click_on_login() {
		 driver.findElement(By.xpath("//span[@class='caret']")).click();
		 driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
		 
	}

	@Then("the page should redirect to the Login page.")
	public void the_page_should_redirect_to_the_login_page() {
		 String expectedPageTitle = "Account Login";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);

	}
}
