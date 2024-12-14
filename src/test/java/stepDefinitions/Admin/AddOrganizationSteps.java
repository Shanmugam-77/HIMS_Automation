package stepDefinitions.Admin;

import factory.BaseClass;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.Homepage;
import pageObjects.AdminModule.TC_002_AddOrganization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AddOrganizationSteps {

	WebDriver driver;
	Homepage hp;
	TC_002_AddOrganization addOrg;

	 @Given("I open the application")
	    public void i_open_the_application() throws IOException {
		 if (driver == null) { // Avoid re-initialization
		        driver = BaseClass.initilizeBrowser();
		    }
	        hp = new Homepage(driver);
	        addOrg = new TC_002_AddOrganization(driver); // Initialize addOrg object
	        BaseClass.getLogger().info("Application opened successfully.");
	    }

	 @When("I navigate to the admin category")
	    public void i_navigate_to_the_admin_category() {
	        hp.clkMenuopen(); 
	        hp.clkAdmincategory();
	        BaseClass.getLogger().info("Navigated to Admin category.");
	    }
	 
	  @When("I click on the Add Organization button")
	    public void i_click_on_the_add_organization_button() {
	        addOrg.setAddOrgbtn(); // This should now work without issues
	        BaseClass.getLogger().info("Clicked on the Add Organization button.");
	    }
	  
	  @When("I fill in the organization details")
	    public void i_fill_in_the_organization_details(io.cucumber.datatable.DataTable dataTable) {
	        Map<String, String> data = dataTable.asMap(String.class, String.class);
	        
	        addOrg.setOrgName(BaseClass.randomString().toUpperCase());
	        addOrg.setOrgEmail(BaseClass.randomAlphaNumeric());
	        addOrg.setOrgContact(BaseClass.randomNumber());
	        addOrg.setOrgAddress(BaseClass.randomAlphaNumeric1());
	        addOrg.setCountry();
	        addOrg.setcountryRegion();
	        addOrg.setCityName();
	        addOrg.setPostalCode();
	    }
	  @When("I submit the form")
	    public void i_submit_the_form() {
	        addOrg.setSubmit();
	        BaseClass.getLogger().info("Submitted the Add Organization form.");
	    }
	  @Then("the add organization should be added successfully")
	  public void the_add_organization_should_be_added_successfully() {
	      // Verify if the organization has been added successfully.
	      // You can verify this using an assertion or by checking some UI element or message.

	      // Example: Check for a success message on the UI
	      String successMessage = driver.findElement(By.xpath("//div[@class='go2072408551']")).getText();
	      Assert.assertEquals(successMessage, "Organization added successfully");
	      
	      BaseClass.getLogger().info("Verified that the organization was added successfully.");
	  }
	  
}
