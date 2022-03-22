package com.BrowseCart.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class BrowseCartTest {
	
	public static WebDriver driver;
	Properties prop;
	static int flag=0;
	
	@Before
	public void beforeScenario() throws IOException
	{
		while(flag == 0)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your preferred browser :- \n1) Google Chrome \n2) Mozilla Firefox \n3) Microsoft Edge\n");
			int choice = sc.nextInt();
			if(choice == 1)
			{
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
				flag=choice;
			}
			else if(choice == 2)
			{
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\geckodriver.exe");
		        flag=choice;
			}
			else if(choice == 3)
			{
				System.setProperty("webdriver.edge.driver", "src\\test\\resources\\Drivers\\msedgedriver.exe");
				flag=choice;
			}
			else
			{
				System.out.println("Invalid input\n");
				flag=0;
			}
		}
		if(flag == 1)
			driver = new ChromeDriver();
		else if(flag == 2)	
	        driver = new FirefoxDriver();
		else if(flag == 3)
			driver=new EdgeDriver();

		FileInputStream fs = new FileInputStream("src/test/resources/OpenCart.properties");
		prop = new Properties();
		prop.load(fs);
	}
	
	@Given("OpenCart website is ready")
	public void open_cart_website_is_ready() {
		System.out.println("OpenCart website is up and running");
	}

	@Given("I launch URL in chrome browser")
	public void i_launch_url_in_chrome_browser() {
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}

	@When("I browse products")
	public void i_browse_products() {
		driver.findElement(By.xpath(prop.getProperty("iPhone"))).click();
	}

	@Then("similar products should be available")
	public void similar_products_should_be_available() {
		assertEquals(driver.findElement(By.xpath(prop.getProperty("Apple_Cinema_30"))).getText(),"Apple Cinema 30\"");
	}

	@Then("same category products should be there")
	public void same_category_products_should_be_there() {
		assertEquals(driver.findElement(By.xpath(prop.getProperty("Apple_Cinema_30"))).getText(),"Apple Cinema 30\"");
	}

	@Given("Search option should be there")
	public void search_option_should_be_there() {
	    assertTrue(driver.findElement(By.name(prop.getProperty("search"))).isDisplayed());
	}

	@When("I search products")
	public void i_search_products() {
		driver.findElement(By.xpath(prop.getProperty("search_icon_single"))).click();
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
		driver.findElement(By.xpath(prop.getProperty("phones_pdas"))).click();
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
		assertTrue(driver.findElement(By.xpath(prop.getProperty("list_view"))).isDisplayed());
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
		assertTrue(driver.findElement(By.xpath(prop.getProperty("grid_view_display"))).isDisplayed());
	}

	@When("select the rating option")
	public void select_the_rating_option() throws InterruptedException {
		Thread.sleep(2000);
		Select sort=new Select(driver.findElement(By.xpath(prop.getProperty("input-sort"))));
		sort.selectByVisibleText("Rating (Highest)");
	}

	@Then("the products gets sorted according to rating")
	public void the_products_gets_sorted_according_to_rating() {
//	    System.out.println("Sorted according to rating");
		// pass
	}

	@When("select the name option")
	public void select_the_name_option() {
		Select sort=new Select(driver.findElement(By.xpath(prop.getProperty("input-sort"))));
		sort.selectByVisibleText("Name (A - Z)");
	}

	@Then("the products gets sorted according to name")
	public void the_products_gets_sorted_according_to_name() {
		String s1=driver.findElement(By.xpath(prop.getProperty("htc_touch_hd1"))).getText();
	    String s2=driver.findElement(By.xpath(prop.getProperty("iphone2"))).getText();
	    assertEquals(s1.compareTo(s2),-33);
	}

	@When("select the price option")
	public void select_the_price_option() {
		Select sort=new Select(driver.findElement(By.xpath(prop.getProperty("input-sort"))));
		sort.selectByVisibleText("Price (Low > High)");
	}

	@Then("the products gets sorted according to price")
	public void the_products_gets_sorted_according_to_price() {
		String s1=driver.findElement(By.xpath(prop.getProperty("span1"))).getText();
	    String s2=driver.findElement(By.xpath(prop.getProperty("span2"))).getText();
	    assertEquals(s1.compareTo(s2),-1);
	}

	@When("select the model option")
	public void select_the_model_option() {
		Select sort=new Select(driver.findElement(By.xpath(prop.getProperty("input-sort"))));
		sort.selectByVisibleText("Model (A - Z)");
	}

	@Then("the products gets sorted according to model")
	public void the_products_gets_sorted_according_to_model() {
		String s1=driver.findElement(By.xpath(prop.getProperty("htc_touch_hd1"))).getText();
	    String s2=driver.findElement(By.xpath(prop.getProperty("iphone2"))).getText();
	    assertEquals(s1.compareTo(s2),-33);
	}

	@When("after clicking on wishlist icon")
	public void after_clicking_on_wishlist_icon() {
	    // pass
	}

	@Then("the product get added to wishlist")
	public void the_product_get_added_to_wishlist() {
	    // pass
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
		assertEquals(driver.findElement(By.xpath(prop.getProperty("compareList"))).getText(),"Success: You have added MacBook to your product comparison!\n×");
	}

	@Then("shopping cart option should be visible.")
	public void shopping_cart_option_should_be_visible() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath(prop.getProperty("add_to_cart"))).isEnabled());
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

	@When("I click on shopping cart")
	public void i_click_on_shopping_cart() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("cart_total"))).click();
		driver.findElement(By.xpath(prop.getProperty("cart_view"))).click();
//	    driver.findElement(By.xpath(prop.getProperty("shopping_cart"))).click();
	}

	@Then("products added to cart should be present.")
	public void products_added_to_cart_should_be_present() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath(prop.getProperty("cart_total"))).getText(),"1 item(s) - $122.00");
	}
	
	@When("I click on coupon code")
	public void i_click_on_coupon_code() {
		driver.findElement(By.xpath(prop.getProperty("use"))).click();
	}

	@Then("coupon code option should be visible to customer.")
	public void coupon_code_option_should_be_visible_to_customer() {
		assertTrue(driver.findElement(By.name(prop.getProperty("coupon_code"))).isDisplayed());
	}

	@When("I insert coupon code while buying product")
	public void i_insert_coupon_code_while_buying_product() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name(prop.getProperty("coupon_code"))).click();
	    driver.findElement(By.name(prop.getProperty("coupon_code"))).sendKeys("2222");;
	    driver.findElement(By.id(prop.getProperty("coupon_button"))).click();
	}

	@Then("the warning message gets displayed in Coupon Code")
	public void the_warning_message_gets_displayed_in_coupon_code() {
	    assertEquals(driver.findElement(By.xpath(prop.getProperty("coupon_warning"))).getText(), "Warning: Coupon is either invalid, expired or reached its usage limit!\n×");
	    driver.findElement(By.xpath(prop.getProperty("use"))).click();
	}
	
	@When("I click on estimate shipping taxes")
	public void i_click_on_estimate_shipping_taxes() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(prop.getProperty("estimate_shipping_taxes"))).click();
		driver.findElement(By.cssSelector(prop.getProperty("estimate_shipping_taxes"))).click();
	}

	@Then("estimate shipping taxes option should be visible")
	public void estimate_shipping_taxes_option_should_be_visible() {
	    //pass
	}
	
    @When("I select valid Country")
    public void i_select_valid_country() {
        // Select valid Country
        driver.findElement(By.id("input-country")).click();
        WebElement dropdown = driver.findElement(By.id("input-country"));
        dropdown.findElement(By.xpath(prop.getProperty("india_option"))).click();
    }
    
    @When("I select valid Zone")
    public void i_select_valid_zone() {
        // Select valid Zone
        driver.findElement(By.id("input-zone")).click();
        Select dropdown1 = new Select(driver.findElement(By.id("input-zone")));
        dropdown1.selectByVisibleText("West Bengal");
    }
    
    @When("I enter valid Post Code")
    public void i_enter_valid_post_code() {
        // Enter valid Post Code
        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).sendKeys("400022");
    }
    
    @When("I click on add to estimate option")
	public void i_click_on_add_to_estimate_option() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		i_select_valid_country();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		i_select_valid_zone();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		i_enter_valid_post_code();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='button-quote']")).click();
	}

	@Then("total cost of product should be changed according to shipping and taxes")
	public void total_cost_of_product_should_be_changed_according_to_shipping_and_taxes() {
//		driver.switchTo().alert().accept();
	    driver.findElement(By.name("shipping_method")).click();
	    driver.findElement(By.id("button-shipping")).click();
	}

	@When("I click on add to gift certificate")
	public void i_click_on_add_to_gift_certificate() throws InterruptedException {
//		driver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[normalize-space()='Use Gift Certificate']")).click();
	}
	
	@Then("coupon code or gift voucher option should be visible to customer.")
	public void coupon_code_or_gift_voucher_option_should_be_visible_to_customer() {
	    // pass
	}

	@When("I add gift voucher")
	public void i_add_gift_voucher() {
	    driver.findElement(By.name("voucher")).click();
	    driver.findElement(By.name("voucher")).sendKeys("1234");
	    driver.findElement(By.id("button-voucher")).click();
	}

	@Then("the warning message gets displayed in Gift Voucher")
	public void the_warning_message_gets_displayed_in_gift_voucher() {
	    //pass
	}

	@When("I click on checkout button")
	public void i_click_on_checkout_button() {
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	}

	@Then("checkout option should be visible")
	public void checkout_option_should_be_visible() {
		assertEquals(driver.getTitle(),"Checkout");
	}

	@When("I click on continue to shopping button")
	public void i_click_on_continue_to_shopping_button() {
		driver.findElement(By.xpath("//a[@class='btn btn-default']")).click();
	}

	@Then("page should be redirected to home page")
	public void page_should_be_redirected_to_home_page() {
		String expectedPageTitle = "Your Store";
		String actualPageTitle = driver.getTitle();
		assertEquals(expectedPageTitle,actualPageTitle);
	    
	}


	@After
	public void afterScenario() {
		driver.quit();
	}
}