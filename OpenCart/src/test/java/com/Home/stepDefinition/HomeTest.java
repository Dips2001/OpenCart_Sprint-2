package com.Home.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	Properties prop;
	
	
	@Before
	public void beforeScenario() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Capgemini\\Internship\\Module-4\\Drivers\\chromedriver_win32\\chromedriver.exe");
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

	@Then("OpenCart website should load with Header section in proper position")
	public void open_cart_website_should_load_with_header_section_in_proper_position() {
		String title=driver.getTitle();
		assertEquals(title, "Your Store");
		assertTrue(driver.findElement(By.id(prop.getProperty("navbar"))).isDisplayed());
	}
	
	@When("I check whether header section is visible in Contact page")
	public void i_check_whether_header_section_is_visible_in_contact_pages() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("phone_icon"))).click();
	}
	
	@When("I check whether header section is visible in Wish List \\({int}) page")
	public void i_check_whether_header_section_is_visible_in_wish_list_pages(Integer int1) {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(prop.getProperty("wishlist"))).click();
	}

	@When("I check whether header section is visible in Shopping Cart page")
	public void i_check_whether_header_section_is_visible_in_shopping_cart_pages() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("shopping_cart"))).click();
	}

	@When("I check whether header section is visible in Checkout page")
	public void i_check_whether_header_section_is_visible_in_checkout_pages() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("checkout"))).click();
	}

	@When("I check whether header section is visible in Register page")
	public void i_check_whether_header_section_is_visible_in_register_pages() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("account"))).click();
	    driver.findElement(By.xpath(prop.getProperty("register"))).click();
	}

	@When("I check whether header section is visible in Login page")
	public void i_check_whether_header_section_is_visible_in_login_pages() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("account"))).click();
	    driver.findElement(By.xpath(prop.getProperty("login"))).click();
	}
	
	@Then("Header Section should be visible in all pages")
	public void header_section_should_be_visible_in_all_pages() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.id(prop.getProperty("navbar"))).isDisplayed());
	}

	@When("I click on store logo")
	public void i_click_on_store_logo() {
	    driver.findElement(By.xpath(prop.getProperty("logo"))).click();
	}

	@Then("I should be redirected back to the home page")
	public void i_should_be_redirected_back_to_the_home_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String title=driver.getTitle();
		assertEquals(title, "Your Store");
	}

	@When("I click on currency block")
	public void i_click_on_currency_block() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("currency"))).click();
	}

	@Then("the currency dropdown containing Euro, Pound Sterling and US dollar should appear")
	public void the_currency_dropdown_containing_euro_pound_sterling_and_us_dollar_should_appear() {
		assertEquals(driver.findElement(By.name(prop.getProperty("euro"))).getText(),"€ Euro");
		assertEquals(driver.findElement(By.name(prop.getProperty("pound"))).getText(),"£ Pound Sterling");
		assertEquals(driver.findElement(By.name(prop.getProperty("dollar"))).getText(),"$ US Dollar");
	}
			
	@When("I select Euro currency")
	public void i_select_euro_currency() {
		driver.findElement(By.name(prop.getProperty("euro"))).click();
	}

	@Then("the price of all the products should convert to Euro currency")
	public void the_price_of_all_the_products_should_convert_to_euro_currency() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("euro_icon"))).getText(),"€");
	    assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price1"))).getText().contains("€"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price2"))).getText().contains("€"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price3"))).getText().contains("€"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price4"))).getText().contains("€"));
	}

	@When("I select Pound Sterling currency")
	public void i_select_pound_sterling_currency() {
		driver.findElement(By.name(prop.getProperty("pound"))).click();
	}

	@Then("the price of all the products should convert to Pound Sterling currency")
	public void the_price_of_all_the_products_should_convert_to_pound_sterling_currency() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("pound_icon"))).getText(),"£");
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price1"))).getText().contains("£"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price2"))).getText().contains("£"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price3"))).getText().contains("£"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price4"))).getText().contains("£"));
	}

	@When("I select US Dollar currency")
	public void i_select_us_dollar_currency() {
		if(!(driver.findElement(By.xpath(prop.getProperty("dollar_icon"))).getText().equals("$"))) {
			driver.findElement(By.name(prop.getProperty("dollar"))).click();
		}
	}

	@Then("the price of all the products should convert to US Dollar currency")
	public void the_price_of_all_the_products_should_convert_to_us_dollar_currency() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("dollar_icon"))).getText(),"$");
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price1"))).getText().contains("$"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price2"))).getText().contains("$"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price3"))).getText().contains("$"));
		assertTrue(driver.findElement(By.cssSelector(prop.getProperty("price4"))).getText().contains("$"));
	}
	
	@When("I click on shopping cart option")
	public void i_click_on_shopping_cart_option() {
		driver.findElement(By.xpath(prop.getProperty("cart"))).click();
	}
	
	@Then("it should display {string}")
	public void it_should_display(String string) {
	    assertEquals(driver.findElement(By.xpath(prop.getProperty("cart_text"))).getText(),string);
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

	@Then("shopping cart button should display number of items purchased and total cost of order")
	public void shopping_cart_button_should_display_number_of_items_purchased_and_total_cost_of_order() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("cart_total"))).getText(),"1 item(s) - $122.00");
	}

	@Then("it should display all product details added to the cart")
	public void it_should_display_all_product_details_added_to_the_cart() {
		//pass
	}

	@Then("it should display the options for View Cart and Checkout")
	public void it_should_display_all_the_options_for_view_cart_and_checkout() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("cart_view"))).getText(),"View Cart");
		assertEquals(driver.findElement(By.xpath(prop.getProperty("cart_checkout"))).getText(),"Checkout");
	}

	
	@When("I click on View Cart")
	public void i_click_on_view_cart() {
	    driver.findElement(By.xpath(prop.getProperty("cart_view"))).click();
	}

	@Then("the page should be redirected to the View Cart page")
	public void the_page_should_be_redirected_to_the_view_cart_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.getTitle(),"Shopping Cart");
	}

	@When("I click on Checkout")
	public void i_click_on_checkout() {
		driver.findElement(By.xpath(prop.getProperty("cart_checkout"))).click();
	}

	@Then("the page should be redirected to the Checkout page")
	public void the_page_should_be_redirected_to_the_checkout_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.getTitle(),"Checkout");
	}

	@When("I click on Search Box")
	public void i_click_on_search_box() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   driver.findElement(By.name(prop.getProperty("search"))).click();
	    
	}

	@When("I type some text in the search box")
	public void i_type_some_text_in_the_search_box() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name(prop.getProperty("search"))).sendKeys("iPhone");;
	}

	@When("I click on Search button")
	public void i_click_on_search_button() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("search_icon"))).click();
	}

	@Then("Search page should open")
	public void search_page_should_open() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  String expectedPageTitle = "Search - iPhone";
	  String actualPageTitle = driver.getTitle();
	  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@Then("search text should appear in the Search criteria box")
	public void search_text_should_appear_in_the_search_criteria_box() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.findElement(By.xpath(prop.getProperty("search_criteria")));
	    WebElement ActualSearchText = driver.findElement(By.xpath(prop.getProperty("search_criteria")));
	    String ExpectedSearchText = "iPhone";
	    
	    Assert.assertEquals(ExpectedSearchText,ActualSearchText.getText());
	    
	}

	@When("click on Search Box")
	public void click_on_search_box() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    WebElement s = driver.findElement(By.xpath(prop.getProperty("search")));
	    s.click();
	    s.clear();
	    
	}

	@When("click search button")
	public void click_search_button() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.findElement(By.xpath(prop.getProperty("search_icon"))).click();
	}

	@Then("OpenCart website should load Search page")
	public void open_cart_website_should_load_search_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String expectedPageTitle = "Search";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@Then("OpenCart website should load Header section with links for My Account, Wish List, Shopping Cart and Checkout are present in header section")
	public void open_cart_website_should_load_header_section_with_links_for_my_account_wish_list_shopping_cart_and_checkout_are_present_in_header_section() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		boolean myAcc = driver.findElement(By.xpath(prop.getProperty("account"))).isDisplayed();
		boolean wishList = driver.findElement(By.xpath(prop.getProperty("wish_list"))).isDisplayed();
		boolean ShopCart = driver.findElement(By.xpath(prop.getProperty("shopping_cart"))).isDisplayed();
		boolean checkout = driver.findElement(By.xpath(prop.getProperty("checkout"))).isDisplayed();
		
		

	}

	@When("click on My account in header section")
	public void click_on_my_account_in_header_section() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("account"))).click();
	}

	@Then("dropdown list should display options as Register and Login.")
	public void dropdown_list_should_display_options_as_register_and_login() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		boolean reg = driver.findElement(By.xpath(prop.getProperty("register"))).isDisplayed();
		boolean log = driver.findElement(By.xpath(prop.getProperty("login"))).isDisplayed();
	}

	@When("click on Wish List in header section")
	public void click_on_wish_list_in_header_section() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("wish_list"))).click();
	}

	@Then("Wish List button should redirect to Login page")
	public void wish_list_page_should_display_all_product_added_to_the_wish_list() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String expectedPageTitle = "Account Login";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on Shopping Cart in header section")
	public void click_on_shopping_cart_in_header_section() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("shopping_cart"))).click();
	}

	@Then("page should redirect to Shopping Cart page which will display all product added to the Shopping Cart.")
	public void page_should_redirect_to_shopping_cart_page_which_will_display_all_product_added_to_the_shopping_cart() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		String expectedPageTitle = "Shopping Cart";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on Checkout in header section")
	public void click_on_checkout_in_header_section() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("checkout"))).click();
	}

	@Then("page should redirect to Shopping Cart page which contains a link to checkout.")
	public void page_should_redirect_to_shopping_cart_page_which_contains_a_link_to_checkout() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String expectedPageTitle = "Shopping Cart";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@Then("The company telephone number should be visible at the header.")
	public void the_company_telephone_number_should_be_visible_at_the_header() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		boolean telNumber= driver.findElement(By.xpath(prop.getProperty("phone_number"))).isDisplayed();
	}

	@When("click on Phone icon")
	public void click_on_phone_icon() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("phone_icon"))).click();
	}

	@Then("the page should redirect to the Contact Us page.")
	public void the_page_should_redirect_to_the_contact_us_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String expectedPageTitle = "Contact Us";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on dropdown icon of My Account")
	public void click_on_dropdown_icon_of_my_account() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("account"))).click();
	}

	@When("click on Register")
	public void click_on_register() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("register"))).click();
	}

	@Then("the page should redirect to the Registration page.")
	public void the_page_should_redirect_to_the_registration_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String expectedPageTitle = "Register Account";
		  String actualPageTitle = driver.getTitle();
		  
		  Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}

	@When("click on Login")
	public void click_on_login() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(prop.getProperty("account"))).click();
		 driver.findElement(By.xpath(prop.getProperty("login"))).click();	 
	}

	@Then("the page should redirect to the Login page.")
	public void the_page_should_redirect_to_the_login_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String expectedPageTitle = "Account Login";
		 String actualPageTitle = driver.getTitle();	  
		 Assert.assertEquals(expectedPageTitle,actualPageTitle);
	}
	
	@After
	public void afterScenario() {
		driver.quit();
	}
}
