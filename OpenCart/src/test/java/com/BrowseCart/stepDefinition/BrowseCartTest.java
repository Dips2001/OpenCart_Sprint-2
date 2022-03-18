package com.BrowseCart.stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		driver = new ChromeDriver();
		FileInputStream fs = new FileInputStream("src/test/resources/OpenCart.properties");
		prop = new Properties();
		prop.load(fs);
	}
	
	@Given("Open cart website is ready")
	public void open_cart_website_is_ready() {
	    
	}

	@Given("URL should be working")
	public void url_should_be_working() {
	    
	}

	@When("I browse products")
	public void i_browse_products() {
	    
	}

	@Then("similar products should be available")
	public void similar_products_should_be_available() {
	    
	}

	@Then("same category products should be there")
	public void same_category_products_should_be_there() {
	    
	}

	@Given("Search option should be there")
	public void search_option_should_be_there() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I search products")
	public void i_search_products() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("searching should be available based on categories")
	public void searching_should_be_available_based_on_categories() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("searching should be available based on sub-categories")
	public void searching_should_be_available_based_on_sub_categories() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I go to products page")
	public void i_go_to_products_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The list button should be visible there")
	public void the_list_button_should_be_visible_there() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("after clicking on list preference button")
	public void after_clicking_on_list_preference_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the products should be displayed in list")
	public void the_products_should_be_displayed_in_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The grid button should be visible there")
	public void the_grid_button_should_be_visible_there() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("after clicking on grid preference button")
	public void after_clicking_on_grid_preference_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the products should be displayed in grid")
	public void the_products_should_be_displayed_in_grid() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the products gets sorted according to name")
	public void the_products_gets_sorted_according_to_name() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("select the price option")
	public void select_the_price_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the products gets sorted according to price")
	public void the_products_gets_sorted_according_to_price() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("select the model option")
	public void select_the_model_option() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the products gets sorted according to model")
	public void the_products_gets_sorted_according_to_model() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Add to compare option should be visible.")
	public void add_to_compare_option_should_be_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on Add to compare option button")
	public void i_click_on_add_to_compare_option_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("product should be added to compare list.")
	public void product_should_be_added_to_compare_list() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I open home page")
	public void i_open_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("shopping cart option should be visible.")
	public void shopping_cart_option_should_be_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on shopping cart")
	public void i_click_on_shopping_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("products added to cart should be present.")
	public void products_added_to_cart_should_be_present() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I heading to checkout")
	public void i_heading_to_checkout() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("coupon code  option should be visible to customer.")
	public void coupon_code_option_should_be_visible_to_customer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("continue to shopping option should be visible")
	public void continue_to_shopping_option_should_be_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on continue to shopping button")
	public void i_click_on_continue_to_shopping_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page should be redirected to home page")
	public void page_should_be_redirected_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
