package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageLocators.SDETregistrationLocators;

public class SDETregistration {
	public static WebDriver driver = Base.getDriver();
	public WebDriverWait wait;
	
	SDETregistrationLocators reg = new SDETregistrationLocators(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@Given("that user is on the UltimateQA landing page")
	public void that_user_is_on_the_ultimate_qa_landing_page() {
	    wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(reg.SDETacademy_btn));
	    reg.SDETacademy_btn.isDisplayed();
		System.out.println("I'm on the landing page");
//		wait.until(ExpectedConditions.elementToBeClickable(reg.close_prompt));
//		reg.close_prompt.click();
	}

	@When("user clicks on java SDET Academy link")
	public void user_clicks_on_java_sdet_academy_link() {
		reg.SDETacademy_btn.click();
		js.executeScript("window.scrollBy(0, 500)");
	   
	}

	@And("types in first namane in the first name field")
	public void types_in_first_namane_in_the_first_name_field() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(reg.firstname));
	   reg.firstname.sendKeys("Testme");
	}

	@And("types in last name in the last name field")
	public void types_in_last_name_in_the_last_name_field() {
	    reg.lastname.sendKeys("Always");
	}

	@And("types in email address in the email address field")
	public void types_in_email_address_in_the_email_address_field() {
	   reg.email_address.sendKeys("test@testworld.com");
	}

	@And("types in phone number in the phone number field")
	public void types_in_phone_number_in_the_phone_number_field() {
	   reg.phone_number.sendKeys("2347123418628");
	}

	@And("click on the Get Early Access button")
	public void click_on_the_get_early_access_button() {
	   reg.Get_Early_Access_Submit.click();
	   
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		if(reg.captcha_checkbox.isDisplayed()) {
//			reg.captcha_checkbox.click();
//			reg.captcha_subsribe.click();
//		} else {
//			System.out.println("Captch not found");
//		}
//		
	}

	@Then("user should be successfully registered")
	public void user_should_be_successfully_registered() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(reg.text_confirmation));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    reg.text_confirmation.isDisplayed();
	}


}
