package com.BrowseCart.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.hello.Then;
import com.hello.When;
import com.hello.io;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class BrowseCartTest {
	public static WebDriver driver;
	Properties prop;
	
	@Before
	public void beforeScenario() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "E:\\Capgemini\\Internship\\Module-4\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fs = new FileInputStream("src/test/resources/OpenCart.properties");
		prop = new Properties();
		prop.load(fs);
	}
	
	@Given("Open cart website is ready")
	public void open_cart_website_is_ready() {
		System.out.println("Open cart website is ready");
	}

	@Given("URL should be working")
	public void url_should_be_working() {
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}

	@When("I browse products")
	public void i_browse_products() {
		driver.findElement(By.xpath("//img[@title='iPhone']")).click();
	}

	@Then("similar products should be available")
	public void similar_products_should_be_available() {
		assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Apple Cinema 30\"']")).getText(),"Apple Cinema 30\"");
	}

	@Then("same category products should be there")
	public void same_category_products_should_be_there() {
		assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Apple Cinema 30\"']")).getText(),"Apple Cinema 30\"");
	}

	@Given("Search option should be there")
	public void search_option_should_be_there() {
	    assertTrue(driver.findElement(By.name("search")).isDisplayed());
	}

	@When("I search products")
	public void i_search_products() {
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	}

	@Then("searching should be available based on categories")
	public void searching_should_be_available_based_on_categories() {
		assertTrue(driver.findElement(By.name("category_id")).isDisplayed());
	}

	@Then("searching should be available based on sub-categories")
	public void searching_should_be_available_based_on_sub_categories() {
		assertTrue(driver.findElement(By.name("sub_category")).isDisplayed());
	}

	@When("I go to products page")
	public void i_go_to_products_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Phones & PDAs')]")).click();
	}

	@Then("The list button should be visible there")
	public void the_list_button_should_be_visible_there() {
		assertTrue(driver.findElement(By.id("list-view")).isDisplayed());
	}

	@When("after clicking on list preference button")
	public void after_clicking_on_list_preference_button() {
		driver.findElement(By.id("list-view")).click();
	}

	@Then("the products should be displayed in list")
	public void the_products_should_be_displayed_in_list() {
		assertTrue(driver.findElement(By.xpath("//div[@id='content']//div[1]//div[1]//div[2]//div[1]")).isDisplayed());
	}

	@Then("The grid button should be visible there")
	public void the_grid_button_should_be_visible_there() {
		assertTrue(driver.findElement(By.id("grid-view")).isDisplayed());
	}

	@When("after clicking on grid preference button")
	public void after_clicking_on_grid_preference_button() {
		driver.findElement(By.id("grid-view")).click();
	}

	@Then("the products should be displayed in grid")
	public void the_products_should_be_displayed_in_grid() {
		assertTrue(driver.findElement(By.xpath("//body//div[@id='product-category']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[2]//div[1]//p[2]")).isDisplayed());
	}

	@When("select the rating option")
	public void select_the_rating_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the products gets sorted according to rating")
	public void the_products_gets_sorted_according_to_rating() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("select the name option")
	public void select_the_name_option() {
		Select sort=new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
		sort.selectByVisibleText("Name (A - Z)");
	}

	@Then("the products gets sorted according to name")
	public void the_products_gets_sorted_according_to_name() {
		String s1=driver.findElement(By.xpath("//a[normalize-space()='HTC Touch HD']")).getText();
	    String s2=driver.findElement(By.xpath("//a[normalize-space()='iPhone']")).getText();
	    assertEquals(s1.compareTo(s2),-33);
	}

	@When("select the price option")
	public void select_the_price_option() {
		Select sort=new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
		sort.selectByVisibleText("Price (Low > High)");
	}

	@Then("the products gets sorted according to price")
	public void the_products_gets_sorted_according_to_price() {
		String s1=driver.findElement(By.xpath("//span[normalize-space()='Ex Tax: $100.00']")).getText();
	    String s2=driver.findElement(By.xpath("//span[normalize-space()='Ex Tax: $101.00']")).getText();
	    assertEquals(s1.compareTo(s2),-1);
	}

	@When("select the model option")
	public void select_the_model_option() {
		Select sort=new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
		sort.selectByVisibleText("Model (A - Z)");
	}

	@Then("the products gets sorted according to model")
	public void the_products_gets_sorted_according_to_model() {
		String s1=driver.findElement(By.xpath("//a[normalize-space()='HTC Touch HD']")).getText();
	    String s2=driver.findElement(By.xpath("//a[normalize-space()='iPhone']")).getText();
	    assertEquals(s1.compareTo(s2),-33);
	}

	@When("after clicking on wishlist icon")
	public void after_clicking_on_wishlist_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the product get added to wishlist")
	public void the_product_get_added_to_wishlist() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I open product page")
	public void i_open_product_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("productPage"))).click();
	}

	@Then("Add to compare option should be visible.")
	public void add_to_compare_option_should_be_visible() {
		boolean addtoCompare = driver.findElement(By.xpath(prop.getProperty("compareButton"))).isDisplayed();
	}

	@When("I click on Add to compare option button")
	public void i_click_on_add_to_compare_option_button() {
		driver.findElement(By.xpath(prop.getProperty("compareButton"))).click();
	}

	@Then("product should be added to compare list.")
	public void product_should_be_added_to_compare_list() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("compareList"))).getText(),"HP LP3065");
	}

	@When("I open home page")
	public void i_open_home_page() {
		driver.findElement(By.xpath(prop.getProperty("homePage"))).click();
	}

	@Then("shopping cart option should be visible.")
	public void shopping_cart_option_should_be_visible() {
		boolean comparelist = driver.findElement(By.xpath(prop.getProperty("shopping_cart"))).isDisplayed();
	}

	@When("I click on shopping cart")
	public void i_click_on_shopping_cart() {
		driver.findElement(By.xpath(prop.getProperty("shopping_cart"))).click();
	}

	@Then("products added to cart should be present.")
	public void products_added_to_cart_should_be_present() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("cart_total"))).getText(),"1 item(s) - $122.00");
	}

	@When("I heading to checkout")
	public void i_heading_to_checkout() {
		driver.findElement(By.xpath(prop.getProperty("shopping_cart"))).click();
	}

	@Then("coupon code  option should be visible to customer.")
	public void coupon_code_option_should_be_visible_to_customer() {
		boolean comparelist = driver.findElement(By.xpath(prop.getProperty("couponCode"))).isDisplayed();
	}

	@When("I insert coupon code while buying product")
	public void i_insert_coupon_code_while_buying_product() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("total cost of product should be changed according to coupon discount")
	public void total_cost_of_product_should_be_changed_according_to_coupon_discount() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("estimate shipping taxes option should be visible")
	public void estimate_shipping_taxes_option_should_be_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on add to estimate option")
	public void i_click_on_add_to_estimate_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("total cost of product should be changed according to shipping and taxes")
	public void total_cost_of_product_should_be_changed_according_to_shipping_and_taxes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("coupon code or gift voucher option should be visible to customer.")
	public void coupon_code_or_gift_voucher_option_should_be_visible_to_customer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I  add gift voucher")
	public void i_add_gift_voucher() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("total cost of product should be changed according to gift voucher discount")
	public void total_cost_of_product_should_be_changed_according_to_gift_voucher_discount() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I completed the process of checkout")
	public void i_completed_the_process_of_checkout() {
		driver.findElement(By.xpath(prop.getProperty("checkout"))).click();
	}

	@Then("continue to shopping option should be visible")
	public void continue_to_shopping_option_should_be_visible() {
		driver.findElement(By.xpath(prop.getProperty("continueButton"))).isDisplayed();
	}

	@When("I click on continue to shopping button")
	public void i_click_on_continue_to_shopping_button() {
		driver.findElement(By.xpath(prop.getProperty("continueButton"))).click();
	}

	@Then("page should be redirected to home page")
	public void page_should_be_redirected_to_home_page() {
		String expectedPageTitle = "Your Store";
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(expectedPageTitle,actualPageTitle);
	    
	}


	@After
	public void afterScenario() {
		driver.quit();
	}
}
