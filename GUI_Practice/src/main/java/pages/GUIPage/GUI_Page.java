package pages.GUIPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GUI_Page {
	
	WebDriver driver;
	public GUI_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="title")
	private WebElement PageTitle;
	
	@FindBy(id="name")
	private WebElement UserName;
	
	@FindBy(id="male")
	private WebElement MaleRadioButton;
	
	@FindBy(id="female")
	private WebElement FemaleRadioButton;
	
	@FindBy(xpath="(//div[@class=\"form-check form-check-inline\"])[position()>2]")
	private List<WebElement> Days;
	
	@FindBy(id="country")
	private WebElement CountriesDropDown;
	
	public String GetWebsiteName() {
		return driver.getCurrentUrl();
		
	}
	
	public String GetPageTitle() {
		
		return PageTitle.getText();
	}
	
	public void AddUserName(String Name) {
		UserName.sendKeys(Name);
	}
	
	public void SelectMaleGender() {
		
		if(!MaleRadioButton.isEnabled()) {
			MaleRadioButton.click();
		}
		
		else {
			FemaleRadioButton.click();	
		}
		
	}
	
	public void SelectFemaleGender() {
		
		if(!FemaleRadioButton.isEnabled()) {
			FemaleRadioButton.click();
		}
		
		else {
			MaleRadioButton.click();	
		}
		
	}
	
	public void SelectAllDays() {
		
		for(WebElement Day:Days) {
			Day.click();
			
		}
	}
	
	public void SelectSpecificDay(String Day) {
		for(WebElement day:Days) {
			String dayName=day.getText();
			if(dayName.equalsIgnoreCase(Day)) {
				day.click();
			}
			
		}
	}
	
	public void SelectContry(String countryName) {
		
		Select CountriesdropDown = new Select(CountriesDropDown);
		List<WebElement> AllContryNames = CountriesdropDown.getAllSelectedOptions();
		for(WebElement Contry:AllContryNames) {
			String CountroyName =Contry.getText();
			if(CountroyName.equalsIgnoreCase(countryName)) {
				Contry.click();
			}
		}
		
		
	}
	
	
	
	
	

}
