package StepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is on Login Page");
	}

	@And("user enters valid login details")
	public void user_enters_valid_login_details() {
		System.out.println("User Enters valid details");
	}

	@When("clicks login button")
	public void clicks_login_button() {
		System.out.println("User Clicked on Login button");
	}

	@Then("user navigated to home page")
	public void user_navigated_to_login_page() {
		System.out.println("User is navigated to home Page");
	}
	
	
}
