package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageLocators.BlogValidationLocators;

public class BlogValidation {
	public static WebDriver driver = Base.getDriver();
	BlogValidationLocators blog = new BlogValidationLocators(driver);
	WebDriverWait wait;
	
	@When("user clicks on the Blog link")
	public void user_clicks_on_the_blog_link() {
	   blog.Blog_btn.click();
	}

	@And("clicks on a post")
	public void clicks_on_a_post() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(blog.AutoTestingPost));
	    blog.AutoTestingPost.click();
	}

	@Then("user should be able to open the post successfully")
	public void user_should_be_able_to_open_the_post_successfully() throws InterruptedException {
//		driver.wait(10000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(blog.blog1_content));
	    blog.blog1_content.isDisplayed();
	}

	@And("user goes back to the previous page")
	public void user_goes_back_to_the_previous_page() {
	   driver.navigate().back();
	}

	@And("clicks on another post")
	public void clicks_on_another_post() {
	   blog.DevJopVacancy.click();
	}

	@Then("user should be able to open it successfully")
	public void user_should_be_able_to_open_it_successfully() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(blog.blog2_content));
	   blog.blog2_content.isDisplayed();
	}



}
