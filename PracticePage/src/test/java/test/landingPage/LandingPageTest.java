package test.landingPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LandingPage.LandingPage;

public class LandingPageTest extends BaseTest {

	LandingPage landingpage;
	String Name = "Chethan";
	String Email = "123@123.com";
	String PhNumber = "12345678901";
	int MaxLength = 10;

	@BeforeMethod
	public void setUpTest() {
		landingpage = new LandingPage(driver);
	}

	@Test
	public void shouldMatchTitleName() {

		String TitleName = landingpage.getTitleName();
		String ExpectedTitleName = "Automation Testing Practice";
		Assert.assertEquals(TitleName, ExpectedTitleName);
	}

	@Test
	public void shouldMatchNameText() {
		String ActualNameText = landingpage.getNameText();
		String ExpectedNameText = "Name:";
		Assert.assertEquals(ActualNameText, ExpectedNameText);
	}

	@Test
	public void shouldEnterNameWIthoutAnyIssue() {
		landingpage.enterName(Name);

	}

	@Test
	public void shouldEnterEmailWIthoutAnyIssue() {
		landingpage.enterEmail(Email);

	}

	@Test
	public void shouldEnterPhNumberWithoutANyIssues() {
		landingpage.enterPhNumber(PhNumber);
		int ActualPhnumberCount = landingpage.countPhNumber();
		Assert.assertEquals(ActualPhnumberCount, MaxLength);

	}

	@Test
	public void shouldSelectMalewithoutanyIssues() {
		
			landingpage.selectMaleRadioButton();

		}

	 @Test 
	 public void shouldSelectFemalewithoutanyissues() {
	 landingpage.selectFemaleRadioButton(); }
	 
	 
	 
	 @Test
	 private void shouldSelectAllDays() {
		 landingpage.selectDays();
	 }
	 
	 @Test
	 private void shouldselectSpecificDay() {
		 
		 landingpage.selectSpecificDay("Tuesday");
	 }
	 
	 @Test
	 private void shouldSelectSpecificCountry() {
		 landingpage.SelectContry("france");
	 }
	 
	 @Test
	 private void DatePicker1() {
		 landingpage.Scroll(800);
		 landingpage.SelectDate1("June", 23);
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
