package pages.GUIPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@FindBy(id="colors")
	private WebElement ColorsTable;
	
	@FindBy(id="animals")
	private WebElement Animals;
	
	@FindBy(id="datepicker")
	private WebElement DatePicker1;
	
	@FindBy(className="ui-datepicker-month")
	private WebElement MonthName;
	
	@FindBy(xpath="//table/tbody/tr/td[@data-handler=\"selectDay\"]")
	private List<WebElement> Dates;
	
	@FindBy(className="ui-icon")
	private WebElement NextMonthButton;
	
	
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
	
	public void SelectColors() {
		Select colors = new Select(ColorsTable);
		List<WebElement> Colors = colors.getAllSelectedOptions();
		for(WebElement Color:Colors) {
			Color.click();
			
		}
		
	}
	
	
	 public void SelectSpecificColor(String Color) { 
		 Select colors = new Select(ColorsTable);
			List<WebElement> Colors = colors.getAllSelectedOptions();
			for(WebElement Color1:Colors) {
				String ColorName =Color1.getText();
				if(ColorName.equalsIgnoreCase(Color)) {
					Color1.click();
				}
			}
	 }
	 
	
	public List<List<String>> CheckAnimalsinSortOrder() {
		Select animals = new Select(Animals);
		List<WebElement> AnimalNames = animals.getAllSelectedOptions();
		List<String> ActualAnimalNames =AnimalNames.stream().map(WebElement::getText).collect(Collectors.toList());
		List<String> SortedAnimalNames = AnimalNames.stream().map(WebElement::getText).sorted().collect(Collectors.toList());
	  return Arrays.asList(ActualAnimalNames,SortedAnimalNames);
	}
	
	public boolean SelectDate1(String month, int date) {

	    DatePicker1.click();

	    for (int i = 0; i < 12; i++) {

	        if (MonthName.getText().toLowerCase().contains(month.toLowerCase())) {

	            for (WebElement d : Dates) {

	                String text = d.getText().trim();
	                if (text.isEmpty()) continue;

	                if (Integer.parseInt(text) == date) {
	                    d.click();
	                    return true; // ✅ success
	                }
	            }
	        } else {
	            NextMonthButton.click();
	        }
	    }
	    return false; // ❌ date not found
	}

	
	
	

}
