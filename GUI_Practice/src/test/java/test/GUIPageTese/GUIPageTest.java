package test.GUIPageTese;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.GUIPage.GUI_Page;

public class GUIPageTest extends BaseTest {
	
	GUI_Page GuiPage;
	
	@BeforeMethod
	public void SetUp() {
		GuiPage = new GUI_Page(driver);
	}
	
	@Test
	public void shouldOpenRightWebsite() {
		String ActualWebSiteName = GuiPage.GetWebsiteName();
		String ExpectedWebsiteName = "https://testautomationpractice.blogspot.com/";
		Assert.assertEquals(ActualWebSiteName, ExpectedWebsiteName);
	}
	
	@Test
	public void shouldmatchPageTitle() {
		String ActualTitle = GuiPage.GetPageTitle();
		String ExpectedTitle ="Automation Testing Practice";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test
	public void shouldAddUserNameWithoutAnyIssues() {
		GuiPage.AddUserName("Chethan");	
	}
	
	@Test
	public void shouldSelectMaleGender() {
		GuiPage.SelectMaleGender();
	}
	
	@Test
	public void shouldSelectFemaleGender() {
		GuiPage.SelectFemaleGender();
	}
	
	@Test
	public void ShouldSelectAlltheDays() {
		GuiPage.SelectAllDays();
	}
	
	@Test
	public void ShouldSelectSpecificDay() {
		GuiPage.SelectSpecificDay("friday");;
	}
	
	@Test
	public void ShouldSelectContryWithoutAnyissues() {
		GuiPage.SelectContry("india");
	}
	
	@Test
	public void shouldSelectAllColors() {
		GuiPage.SelectColors();
	}	
	
	@Test 
	 public void shouldSelectSpecificColors() {
	 GuiPage.SelectSpecificColor("Green"); 
	 }
	 
	@Test
	 public void validatingSortOrder() {
		 List<List<String>> ANimalNames = GuiPage.CheckAnimalsinSortOrder();
		 List<String> ActualAnimalName =ANimalNames.get(0);
		 List<String> SortedAnimalName =ANimalNames.get(1);
		 Assert.assertEquals(ActualAnimalName, SortedAnimalName);
		 
	 }
	
	@Test
	public void shouldSelectDatefromDatepicker1() {
		Assert.assertTrue(
			    GuiPage.SelectDate1("june", 23),
			    "Failed to select date from datepicker"
			);

	}
	 	
	
}
