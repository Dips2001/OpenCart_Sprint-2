package com.OrderingCheckout.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderingCheckoutTest {
	public static WebDriver driver;
	Properties prop;
	File f=new File("src/test/resources/OpenCartData.xlsx");
	FileInputStream is;
	XSSFWorkbook w;
	
	@Before
	public void beforeScenario() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Capgemini\\Internship\\Module-4\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		FileInputStream fs = new FileInputStream("src/test/resources/OpenCart.properties");
		prop = new Properties();
		prop.load(fs);
		is=new FileInputStream(f);
		w=new XSSFWorkbook(is);
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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		// Register is Displayed
		boolean register = driver.findElement(By.xpath(prop.getProperty("register_account_label"))).isDisplayed();
		// Login is Displayed
		boolean guest = driver.findElement(By.xpath(prop.getProperty("guest_account_label"))).isDisplayed();
		// Assert if register and log is displayed
		Assert.assertTrue(register);
		Assert.assertTrue(guest);
	}
	
	@When("I enter email")
	public void i_enter_email()
	{
		XSSFSheet sheet=w.getSheetAt(0);
		String email=sheet.getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.xpath(prop.getProperty("login_email"))).clear();
		driver.findElement(By.xpath(prop.getProperty("login_email"))).sendKeys(email);
	}
	
	@When("I enter password")
	public void i_enter_password()
	{
		XSSFSheet sheet=w.getSheetAt(0);
		String password=sheet.getRow(2).getCell(1).getStringCellValue();
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
	
	@When("I click on Use an Existing Address in Billing Details Form")
	public void i_click_on_use_an_existing_address_in_billing_details_form() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("payment_address")).click();
		driver.findElement(By.id("button-payment-address")).click();
	}
	
	@Then("I should see Delivery Details Form")
	public void i_should_see_delivery_details_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Step 3: Delivery Details']")).getText(),"Step 3: Delivery Details");
	}
	
	@When("I click on Use an Existing Address in Delivery Details Form")
	public void i_click_on_use_an_existing_address_in_delivery_details_form() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("shipping_address")).click();
		driver.findElement(By.id("button-shipping-address")).click();
	}
	
//	@Then("I should see Delivery Method Form")
//	public void i_should_see_delivery_method_form() {
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Step 3: Delivery Details']")).getText(),"Step 3: Delivery Details");
//	}
	
	@When("I click on preferred Shipping Method")
	public void i_click_on_preferred_shipping_method() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("shipping_method")).click();
		driver.findElement(By.id("button-shipping-method")).click();
	}
	
	@Then("I should see Payment Method Form")
	public void i_should_see_payment_method_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Step 5: Payment Method']")).getText(),"Step 5: Payment Method");
	}
	
	@When("I click on preferred Payment Method")
	public void i_click_on_preferred_payment_method() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("payment_method")).click();
	}
	
	@When("I click on Terms and Conditions")
	public void i_click_on_terms_and_conditions() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.id("button-payment-method")).click();
	}

	@Then("I should see Confirm Order Form")
	public void i_should_see_confirm_order_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Step 6: Confirm Order']")).getText(),"Step 6: Confirm Order");
	}
	
	@When("I click on Confirm Order")
	public void i_click_on_confirm_order() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("button-confirm")).click();
	}
	
	@Then("I should get confirmation about my order")
	public void i_should_get_confirmation_about_my_order() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your order has been placed!']")).getText(), "Your order has been placed!");
	}
	
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

	@Then("I should see First Name field, Last Name field, Email field, Phone Number field and Continue Button")
	public void i_should_see_first_name_field_last_name_field_email_field_phone_number_field_and_continue_button() {
		// First Name field is displayed
        boolean firstName = driver.findElement(By.xpath(prop.getProperty("firstname_label"))).isDisplayed();
        // Last Name field is displayed
        boolean lastName = driver.findElement(By.xpath(prop.getProperty("lastname_label"))).isDisplayed();
        // Email field is displayed
        boolean email = driver.findElement(By.xpath(prop.getProperty("email_label"))).isDisplayed();
        // Telephone field is displayed
        boolean telephone = driver.findElement(By.xpath(prop.getProperty("phone_label"))).isDisplayed();
        // Company field is displayed
        boolean company = driver.findElement(By.xpath(prop.getProperty("company_label"))).isDisplayed();
        // Address 1 field is displayed
        boolean address1 = driver.findElement(By.xpath(prop.getProperty("address1_label"))).isDisplayed();
        // Address 2 field is displayed
        boolean address2 = driver.findElement(By.xpath(prop.getProperty("address2_label"))).isDisplayed();
        // City field is displayed
        boolean city = driver.findElement(By.xpath(prop.getProperty("city_label"))).isDisplayed();
        // Post Code field is displayed
        boolean postCode = driver.findElement(By.xpath(prop.getProperty("postcode_label"))).isDisplayed();
        // Country field is displayed
        boolean country = driver.findElement(By.xpath(prop.getProperty("country_label"))).isDisplayed();
        // Zone field is displayed
        boolean zone = driver.findElement(By.xpath(prop.getProperty("zone_label"))).isDisplayed();
        // Continue Button is displayed
        boolean continueButton = driver.findElement(By.xpath(prop.getProperty("continue_button_billing_details"))).isDisplayed();

        // Assert if all the fields are displayed
        Assert.assertTrue(firstName);
        Assert.assertTrue(lastName);
        Assert.assertTrue(email);
        Assert.assertTrue(telephone);
        Assert.assertTrue(company);
        Assert.assertTrue(address1);
        Assert.assertTrue(address2);
        Assert.assertTrue(city);
        Assert.assertTrue(postCode);
        Assert.assertTrue(country);
        Assert.assertTrue(zone);
        Assert.assertTrue(continueButton);
	}

    @When("I enter valid First Name")
    public void i_enter_valid_first_name() {
        // Enter valid First Name
        driver.findElement(By.id(prop.getProperty("firstname"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String firstName = sheet.getRow(1).getCell(0).getStringCellValue();
        driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys(firstName);
    }

    @When("I enter valid Last Name")
    public void i_enter_valid_last_name() {
        // Enter valid Last Name
        driver.findElement(By.id(prop.getProperty("lastname"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String lastName = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(By.id(prop.getProperty("lastname"))).sendKeys(lastName);
    }

    @When("I enter valid Email")
    public void i_enter_valid_email() {
        // Enter valid Email
        driver.findElement(By.id(prop.getProperty("email"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String email = sheet.getRow(1).getCell(2).getStringCellValue();
        driver.findElement(By.id(prop.getProperty("email"))).sendKeys(email);
    }

    @When("I enter valid Phone Number")
    public void i_enter_valid_phone_number() {
        // Enter valid Phone Number
        driver.findElement(By.id(prop.getProperty("telephone"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String telephone = Math.round(sheet.getRow(1).getCell(3).getNumericCellValue()) + "";
        driver.findElement(By.id(prop.getProperty("telephone"))).sendKeys(telephone);
    }

    @When("I enter valid Company")
    public void i_enter_valid_company() {
        // Enter valid Company
        driver.findElement(By.id(prop.getProperty("company"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String company = sheet.getRow(1).getCell(4).getStringCellValue();
        driver.findElement(By.id(prop.getProperty("company"))).sendKeys(company);
    }

    @When("I enter valid Address1")
    public void i_enter_valid_address1() {
        // Enter valid Address 1
        driver.findElement(By.id(prop.getProperty("address1"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String address1 = sheet.getRow(1).getCell(5).getStringCellValue();
        driver.findElement(By.id(prop.getProperty("address1"))).sendKeys(address1);
    }

    @When("I enter valid Address2")
    public void i_enter_valid_address2() {
        // Enter valid Address 2
        driver.findElement(By.id(prop.getProperty("address2"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String address2 = sheet.getRow(1).getCell(6).getStringCellValue();
        driver.findElement(By.id(prop.getProperty("address2"))).sendKeys(address2);
    }

    @When("I enter valid City")
    public void i_enter_valid_city() {
        // Enter valid City
        driver.findElement(By.id(prop.getProperty("city"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String city = sheet.getRow(1).getCell(7).getStringCellValue();
        driver.findElement(By.id(prop.getProperty("city"))).sendKeys(city);
    }

    @When("I enter valid Post Code")
    public void i_enter_valid_post_code() {
        // Enter valid Post Code
        driver.findElement(By.id(prop.getProperty("postcode"))).click();
        //Fetch from Excel sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String postcode = Math.round(sheet.getRow(1).getCell(8).getNumericCellValue()) + "";
        driver.findElement(By.id(prop.getProperty("postcode"))).sendKeys(postcode);
    }

    @When("I select valid Country")
    public void i_select_valid_country() {
        // Select valid Country
        driver.findElement(By.id(prop.getProperty("country"))).click();
        WebElement dropdown = driver.findElement(By.id(prop.getProperty("country")));
        dropdown.findElement(By.xpath(prop.getProperty("india_option"))).click();
    }

    @When("I select valid Zone")
    public void i_select_valid_zone() {
        // Select valid Zone
        driver.findElement(By.id(prop.getProperty("zone"))).click();
        WebElement dropdown1 = driver.findElement(By.id(prop.getProperty("zone")));
        dropdown1.findElement(By.xpath(prop.getProperty("mh_option"))).click();
    }

    @When("I enter all the valid details in Personal Details form")
    public void i_enter_all_the_valid_details_in_personal_details_form() throws InterruptedException {
        // Enter all the valid details in Personal Details form
    	Thread.sleep(3000);    	
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		i_enter_valid_first_name();
        i_enter_valid_last_name();
        i_enter_valid_email();
        i_enter_valid_phone_number();
        i_enter_valid_company();
        i_enter_valid_address1();
        i_enter_valid_address2();
        i_enter_valid_city();
        i_enter_valid_post_code();
        i_select_valid_country();
        i_select_valid_zone();
    }

    @When("I click on Continue Button in Personal Details Form")
    public void i_click_on_continue_button_in_personal_details_form() {
        driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
    }

    @Then("I should see Delivery Method Form")
    public void i_should_see_delivery_method_form() throws InterruptedException {
        Thread.sleep(2000);
//        WebElement flatRate = driver.findElement(By.xpath("//p[contains(text(),'Please select the preferred shipping method to use')]"));
//        Assert.assertTrue(flatRate.isDisplayed());
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Step 4: Delivery Method']")).getText(),"Step 4: Delivery Method");
    }


    @When("I enter invalid First Name")
    public void i_enter_invalid_first_name() {
        // Enter invalid First Name
        driver.findElement(By.id(prop.getProperty("firstname"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys("@!123");
    }

    @When("I enter invalid Last Name")
    public void i_enter_invalid_last_name() {
        // Enter invalid Last Name
        driver.findElement(By.id(prop.getProperty("lastname"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("lastname"))).sendKeys("@xe!123");
    }

    @When("I enter invalid Email")
    public void i_enter_invalid_email() {
        // Enter invalid Email
        driver.findElement(By.id(prop.getProperty("email"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("email"))).sendKeys("123");
    }

    @When("I enter invalid Phone Number")
    public void i_enter_invalid_phone_number() {
        // Enter invalid phone number
        driver.findElement(By.id(prop.getProperty("telephone"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("telephone"))).sendKeys("ABCDEF");
    }

    @When("I enter invalid Address1")
    public void i_enter_invalid_address1() {
        // Enter invalid Address1
        driver.findElement(By.id(prop.getProperty("address1"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("address1"))).sendKeys("123sdWrong");
    }

    @When("I enter invalid Address2")
    public void i_enter_invalid_address2() {
        // Enter invalid Address1
        driver.findElement(By.id(prop.getProperty("address2"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("address2"))).sendKeys("1456sdWrong");
    }

    @When("I enter invalid City")
    public void i_enter_invalid_city() {
        // Enter invalid City
        driver.findElement(By.id(prop.getProperty("city"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("city"))).sendKeys("@!123");
    }

    @When("I enter invalid Post Code")
    public void i_enter_invalid_post_code() {
        // Enter invalid Post Code
        driver.findElement(By.id(prop.getProperty("postcode"))).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("postcode"))).sendKeys("12345asda");
    }

    @When("I click on Submit Button")
    public void i_click_on_submit_button() {
        // Clicking Continue button
        driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();
    }

    @Then("I should see Error message for First Name, Last Name, Email, Phone Number input field in the Personal Details Form")
    public void iShouldSeeErrorMessageForFirstNameLastNameEmailPhoneNumberInputFieldInThePersonalDetailsForm() {
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

    @And("I uncheck the checkbox for same billing address")
    public void iUncheckCheckboxForSameBillingAddress() {
        WebElement checkbox = driver.findElement(By.xpath(prop.getProperty("checkbox")));
        checkbox.click();
    }

    @And("I check the checkbox for same billing address")
    public void iCheckTheCheckboxForSameBillingAddress() {
        WebElement checkbox = driver.findElement(By.xpath(prop.getProperty("checkbox")));
    }

    @Then("Billing Details Form should be displayed")
    public void billingDetailsFormShouldBeDisplayed() {
        // First Name field is displayed
        boolean firstName = driver.findElement(By.xpath(prop.getProperty("billing_firstname_label"))).isDisplayed();
        // Last Name field is displayed
        boolean lastName = driver.findElement(By.xpath(prop.getProperty("billing_lastname_label"))).isDisplayed();
        // Company field is displayed
        boolean company = driver.findElement(By.xpath(prop.getProperty("billing_company_label"))).isDisplayed();
        // Address 1 field is displayed
        boolean address1 = driver.findElement(By.xpath(prop.getProperty("billing_address1_label"))).isDisplayed();
        // Address 2 field is displayed
        boolean address2 = driver.findElement(By.xpath(prop.getProperty("billing_address2_label"))).isDisplayed();
        // City field is displayed
        boolean city = driver.findElement(By.xpath(prop.getProperty("billing_city_label"))).isDisplayed();
        // Post Code field is displayed
        boolean postCode = driver.findElement(By.xpath(prop.getProperty("billing_postcode_label"))).isDisplayed();
        // Country field is displayed
        boolean country = driver.findElement(By.xpath(prop.getProperty("billing_country_label"))).isDisplayed();
        // Zone field is displayed
        boolean zone = driver.findElement(By.xpath(prop.getProperty("billing_zone_label"))).isDisplayed();

        // Assert if all the fields are displayed
        Assert.assertTrue(firstName);
        Assert.assertTrue(lastName);
        Assert.assertTrue(company);
        Assert.assertTrue(address1);
        Assert.assertTrue(address2);
        Assert.assertTrue(city);
        Assert.assertTrue(postCode);
        Assert.assertTrue(country);
        Assert.assertTrue(zone);
    }

    @And("I enter valid First Name in Billing Details Form")
    public void iEnterValidFirstNameInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Fetches the First Name from the Excel Sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String firstName = sheet.getRow(1).getCell(0).getStringCellValue();
        // Enter First Name
        driver.findElement(By.id(prop.getProperty("firstname_billing_input"))).sendKeys(firstName);
    }

    @And("I enter valid Last Name in Billing Details Form")
    public void iEnterValidLastNameInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Fetches the Last Name from the Excel Sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String lastName = sheet.getRow(1).getCell(1).getStringCellValue();
        // Enter Last Name
        driver.findElement(By.id(prop.getProperty("lastname_billing_input"))).sendKeys(lastName);
    }

    @And("I enter valid Address1 in Billing Details Form")
    public void iEnterValidAddress1InBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Fetches the Address1 from the Excel Sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String address1 = sheet.getRow(1).getCell(5).getStringCellValue();
        // Enter Address1
        driver.findElement(By.id(prop.getProperty("address1_billing_input"))).sendKeys(address1);
    }

    @And("I enter valid Address2 in Billing Details Form")
    public void iEnterValidAddress2InBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Fetches the Address2 from the Excel Sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String address2 = sheet.getRow(1).getCell(6).getStringCellValue();
        // Enter Address2
        driver.findElement(By.id(prop.getProperty("address2_billing_input"))).sendKeys(address2);
    }

    @And("I enter valid City in Billing Details Form")
    public void iEnterValidCityInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Fetches the City from the Excel Sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String city = sheet.getRow(1).getCell(7).getStringCellValue();
        // Enter City
        driver.findElement(By.id(prop.getProperty("city_billing_input"))).sendKeys(city);
    }

    @And("I enter valid Post Code in Billing Details Form")
    public void iEnterValidPostCodeInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Fetches the Post Code from the Excel Sheet
        XSSFSheet sheet = w.getSheetAt(1);
        String postCode = Math.round(sheet.getRow(1).getCell(8).getNumericCellValue()) + "";
        // Enter Post Code
        driver.findElement(By.id(prop.getProperty("postcode_billing_input"))).sendKeys(postCode);
    }

    @And("I select valid Country in Billing Details Form")
    public void iSelectValidCountryInBillingDetailsForm() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='input-shipping-country']")));
        driver.findElement(By.id("input-shipping-country")).click();
        Select country = new Select(driver.findElement(By.id("input-shipping-country")));
        country.selectByIndex(10);
    }

    @And("I select valid Zone in Billing Details Form")
    public void iSelectValidZoneInBillingDetailsForm() throws InterruptedException {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='input-shipping-country']")));
        driver.findElement(By.id("input-shipping-zone")).click();
        Select zone = new Select(driver.findElement(By.id("input-shipping-zone")));
        zone.selectByIndex(2);
    }

    @And("I click on Continue Button in Billing Details Form")
    public void iClickOnContinueButtonInBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't enter First Name in Billing Details Form")
    public void iDonTEnterFirstNameInBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't enter Last Name in Billing Details Form")
    public void iDonTEnterLastNameInBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't enter Address1 in Billing Details Form")
    public void iDonTEnterAddress1InBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't enter Address2 in Billing Details Form")
    public void iDonTEnterAddress2InBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't enter City in Billing Details Form")
    public void iDonTEnterCityInBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't enter Post Code in Billing Details Form")
    public void iDonTEnterPostCodeInBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't select Country in Billing Details Form")
    public void iDonTSelectCountryInBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @And("I don't select Zone in Billing Details Form")
    public void iDonTSelectZoneInBillingDetailsForm() {
        driver.findElement(By.id(prop.getProperty("continue_button_shipping"))).click();
    }

    @Then("I should see Error message for First Name, Last Name, Address1, Address2, City, Post Code, Country, Zone input field in the Billing Details Form")
    public void iShouldSeeErrorMessageForFirstNameLastNameAddress1Address2CityPostCodeCountryZoneInputFieldInTheBillingDetailsForm() {
        // Checking Error message
        boolean error = driver.findElement(By.xpath(prop.getProperty("error_message_billing_form"))).isDisplayed();
        // Assert Error
        Assert.assertTrue(error);
    }

    @And("I enter invalid First Name in Billing Details Form")
    public void iEnterInvalidFirstNameInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Enter Invalid First Name which is more than 32 characters
        driver.findElement(By.id(prop.getProperty("firstname_billing_input"))).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @And("I enter invalid Last Name in Billing Details Form")
    public void iEnterInvalidLastNameInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Enter Invalid Last Name which is more than 32 characters
        driver.findElement(By.id(prop.getProperty("lastname_billing_input"))).sendKeys("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    }

    @And("I enter invalid Address1 in Billing Details Form")
    public void iEnterInvalidAddress1InBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Enter Invalid Address1
        driver.findElement(By.id(prop.getProperty("address1_billing_input"))).sendKeys("123 Nowhere");
    }

    @And("I enter invalid Address2 in Billing Details Form")
    public void iEnterInvalidAddress2InBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Enter Invalid Address2
        driver.findElement(By.id(prop.getProperty("address2_billing_input"))).sendKeys("465 Anywhere");
    }

    @And("I enter invalid City in Billing Details Form")
    public void iEnterInvalidCityInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Enter Invalid City
        driver.findElement(By.id(prop.getProperty("city_billing_input"))).sendKeys("12C123");
    }

    @And("I enter invalid Post Code in Billing Details Form")
    public void iEnterInvalidPostCodeInBillingDetailsForm() {
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        // Enter Invalid Post Code
        driver.findElement(By.id(prop.getProperty("postcode_billing_input"))).sendKeys("88Po9a");
    }
    
	@After
	public void afterScenario() {
		driver.quit();
	}
}