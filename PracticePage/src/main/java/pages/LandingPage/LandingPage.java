package pages.LandingPage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class LandingPage {
	 WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(className="title")
	private WebElement TitleName;
	
	@FindBy(xpath="//label[text()='Name:']")
	private WebElement NameText;
	
	@FindBy(id="name")
	private WebElement NameTextField;
	
	@FindBy(id="email")
	private WebElement EmailTextField;
	
	@FindBy(id="phone")
	private WebElement PhoneTextField;
	
	@FindBy(id="male")
	private WebElement MaleRadioButton;
	
	@FindBy(id="female")
	private WebElement FemaleRadioButton;
	
	@FindBy(xpath="(//div[@class=\"form-check form-check-inline\"])[position() > 2]")
	private List<WebElement> Days;
	
	@FindBy(id="country")
	private WebElement CountryName; 
	
	@FindBy(id = "datepicker")
	private WebElement DatePicker1;
	
	@FindBy(className="ui-datepicker-month")
	private WebElement MonthName;
	
	@FindBy(xpath = "//td[@data-handler=\"selectDay\"]")
	private List<WebElement> TotalDays;
 
	public String getTitleName() {
		
		return TitleName.getText();
		
	}
	
	public String getNameText() {
		return NameText.getText();
		
	}
	
	public void enterName(String Name) {
		
		NameTextField.sendKeys(Name);
		
	}
	
	public void enterEmail(String Email){
		EmailTextField.sendKeys(Email);
		
	}
	
	public void enterPhNumber(String PhNumber) {
		 PhoneTextField.sendKeys(PhNumber);
		
		
	}
	
	public int countPhNumber() {
		return PhoneTextField.getAttribute("value").length();
		
	}
	
	public void selectMaleRadioButton() {
		MaleRadioButton.click();
	}
	
	public void selectFemaleRadioButton() {
		FemaleRadioButton.click();
	}
	
	public void selectDays() {
		for(WebElement D:Days) {
			D.click();
			
		}
		
	}
	
	public void selectSpecificDay(String DayName) {
		for(WebElement D:Days) {
			String Day = D.getText();
			if(Day.equals(DayName)) {
				D.click();	
			}
			
		}	
	}
	
	public void SelectContry(String Country) {
		Select Cou = new Select(CountryName);
		List<WebElement> CountryList = Cou.getAllSelectedOptions();
		for(WebElement C:CountryList) {
			String contryText =C.getText();
			if(contryText.equalsIgnoreCase(Country)) {
				C.click();
				
			}
			
		}
		
	}
	
	public void Scroll(int Yaxis) {
		JavascriptExecutor scroll = (JavascriptExecutor)driver; 
		scroll.executeScript("window.scrollBy(0, arguments[0]);", Yaxis);
	}
	
	public void SelectDate1(String Month,int Day) {
		Actions A = new Actions(driver);
		A.moveToElement(DatePicker1).click().build().perform();
		for(int i=0;i<12;i++) {
		String month = MonthName.getText();
		if(month.equalsIgnoreCase(Month)) {
			for(WebElement D:TotalDays) {
				String day = D.getText();
				 int day1 =Integer.parseInt(day);
				 if(day1==Day) {
					 D.click();
				 }
				
			}
		}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
