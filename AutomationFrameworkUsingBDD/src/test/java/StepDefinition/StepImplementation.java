package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepImplementation {
	public static WebDriver driver;
	public static Properties Configprop;
	public static Properties Objectprop;
	@Given("Open browser and navigate")
	public void open_browser_and_navigate() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
			
		FileInputStream config_fis = new FileInputStream("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\MavenCICD\\AutomationFrameworkUsingBDD\\src\\test\\resources\\Configuration\\Config.properties");
		Configprop = new Properties();
		Configprop.load(config_fis);
		
		FileInputStream Object_fis = new FileInputStream("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\MavenCICD\\AutomationFrameworkUsingBDD\\src\\test\\resources\\Configuration\\ObjectRepo.properties");
		Objectprop = new Properties();
		Objectprop.load(Object_fis);
		
		String browserinfo = Configprop.getProperty("browserName");
		
		switch(browserinfo)
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.get(Configprop.getProperty("URL"));
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.get(Configprop.getProperty("URL"));
			driver.manage().window().maximize();
			break;
		case "edge":
			driver=new EdgeDriver();
			driver.get(Configprop.getProperty("URL"));
			driver.manage().window().maximize();
			break;
		}
				
		
	}
	@When("Enter username and password {string} {string}")
	public void enter_username_and_password(String Username, String Password) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_username']"));
		username.sendKeys(Username);
		WebElement password = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_password']"));
		password.sendKeys(Password);
	}
	@When("Click login button")
	public void click_login_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Login = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_login_button']"));
		Login.click();
		Thread.sleep(5000);
	}
	@Then("Verify login is successful")
	public void verify_login_is_successful() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Logout = driver.findElement(By.xpath("//*[@id='ctl00_logout']"));
		if (Logout.isDisplayed()) {
			System.out.println("Login is successful");
		}
		else
		{
			System.out.println("Login failed");
		}
	}
	
	@Then("Close the application")
	public void close_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}
	
	@When("Enter Product information {string} {string} {string} {string}")
	public void enter_product_information(String Productdata, String Quantitydata, String Priceperunitdata, String Discountdata) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Order = driver.findElement(By.xpath("//*[@id='ctl00_menu']/li[3]/a"));
		Order.click();
		WebElement Product = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
		Product.sendKeys(Productdata);
		WebElement Quantity = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
		Quantity.sendKeys(Quantitydata);
		WebElement Priceperunit = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']"));
		Priceperunit.sendKeys(Priceperunitdata);
		WebElement Discount = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtDiscount']"));
		Discount.sendKeys(Discountdata);
	}
	@When("Enter Address information {string} {string} {string} {string} {string}")
	public void enter_address_information(String Customer_namedata, String streetdata, String citydata, String statedata, String zipdata) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Customer_name = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtName']"));
		Customer_name.sendKeys(Customer_namedata);
		WebElement Street = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
		Street.sendKeys(streetdata);
		WebElement City = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
		City.sendKeys(citydata);
		WebElement State = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
		State.sendKeys(statedata);
		WebElement Zip = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
		Zip.sendKeys(zipdata);
	}
	@When("Enter Payment information")
	public void enter_payment_information() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("Click process button")
	public void click_process_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Process = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
		Process.click();
	}
	@Then("Verify the new order created successfully")
	public void verify_the_new_order_created_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Given("Verify title")
	public void verify_title() {
	    // Write code here that turns the phrase above into concrete actions
		String Expected = "Web Orders Login";
		String Actual = driver.getTitle();
		Assert.assertEquals(Expected, Actual);
	}
	
	@When("Extract the data from a Webtable")
	public void extract_the_data_from_a_webtable() {
	    // Write code here that turns the phrase above into concrete actions
		String Xpath_Start = "//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[";
		String Xpath_Mid = "]/td[";
		String Xpath_End = "]";
		for(int rows=2; rows<=9; rows++)
		{
			for(int cols=2; cols<=12; cols++)
			{
				String Table = driver.findElement(By.xpath(Xpath_Start + rows + Xpath_Mid + cols + Xpath_End)).getText();
				System.out.print(Table + "-----");
			}
			System.out.println();
		}
		
	}

	@Before
	public void preconditionsteps() throws IOException
	{
		FileInputStream config_fis = new FileInputStream("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\MavenCICD\\AutomationFrameworkUsingBDD\\src\\test\\resources\\Configuration\\Config.properties");
		Configprop = new Properties();
		Configprop.load(config_fis);
		
		FileInputStream Object_fis = new FileInputStream("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\MavenCICD\\AutomationFrameworkUsingBDD\\src\\test\\resources\\Configuration\\ObjectRepo.properties");
		Objectprop = new Properties();
		Objectprop.load(Object_fis);
		
		String browserinfo = Configprop.getProperty("browserName");
		
		switch(browserinfo)
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.get(Configprop.getProperty("URL"));
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.get(Configprop.getProperty("URL"));
			driver.manage().window().maximize();
			break;
		case "edge":
			driver=new EdgeDriver();
			driver.get(Configprop.getProperty("URL"));
			driver.manage().window().maximize();
			break;
		}
	}

	



}
