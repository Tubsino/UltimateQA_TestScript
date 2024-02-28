package pageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogValidationLocators {
	
	WebDriver driver;
	
	@FindBy(linkText = "Blog")
	public WebElement Blog_btn;
	
	@FindBy(xpath =  "//a[@href = 'https://ultimateqa.com/automation-patterns-antipatterns/']")
	public WebElement AutoTestingPost;
	
	@FindBy(xpath = "//h1[contains(text(), 'Top 17 Automated Testing Best Practices (Supported By Data)')]")
	public WebElement blog1_content;
	
	@FindBy(xpath =  "//a[@href = 'https://ultimateqa.com/full-time-position-senior-devops-engineer-with-java/']")
	public WebElement DevJopVacancy;
	
	@FindBy(xpath = "//h1[contains(text(), 'Full-time Position: Senior DevOps Engineer with Java')]")
	public WebElement blog2_content;
	
	
	public BlogValidationLocators(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	


}
