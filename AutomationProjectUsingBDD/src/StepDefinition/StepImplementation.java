package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepImplementation {
	
	@Given("^Open browser$")
	public void open_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Opening browser");
		  
	}

	@Given("^Launch application$")
	public void launch_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Navigate to the URL to launch application");
		
	}

	@When("^Enter username and password$")
	public void enter_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter username and password to the portal");
	}
	
	@When("^Click login button$")
	public void click_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Navigate to the login button");
	}

	@Then("^Verify login is successful$")
	public void verify_login_is_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
			System.out.println("Login is successful");
	}

	@Given("^Login to the application$")
	public void login_to_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login to the app");
	}
 
	@When("^Enter Product information$")
	public void enter_Product_information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter prod info");
	}

	@When("^Enter Address information$")
	public void enter_Address_information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter address info");
	}

	@When("^Enter Payment information$")
	public void enter_Payment_information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter payment info");
	}

	@When("^Click process button$")
	public void click_process_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Process application");
	}

	@Then("^Verify the new order created successfully$")
	public void verify_the_new_order_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Order created successfully");
	}



}
