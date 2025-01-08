package rough;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class base {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://www.abhibus.com/");
		page.click("#bus-link"); //buslink
		Thread.sleep(2000);
		page.fill("[placeholder='From Station']", "Trichy"); // from
		List <ElementHandle> formlists = page.querySelectorAll("//*[@id='search-from']/div/div[2]/ul/li/div/div[2]/div/div[1]");//selecting trichy from dropdown
		for (ElementHandle formList : formlists) {
			Thread.sleep(2000);
			if(formList.innerText().equalsIgnoreCase("Trichy"))
			{
				formList.click();
				break;
			}	}
		
		page.fill("[placeholder='To Station']", "Chennai");	//to
		List <ElementHandle> tolists = page.querySelectorAll("//div[@id='search-to']/div/div[2]/ul/li/div/div[2]/div/div[1]");//selecting Chennai from dropdown
		for (ElementHandle tolist : tolists) {
			Thread.sleep(2000);
			if(tolist.innerText().equalsIgnoreCase("Chennai"))
			{
				tolist.click();
				break;
			}	}
		
		page.click("[placeholder='Onward Journey Date']");	//calender click
		page.click("//div[@id='jaurney-date']/div/div[2]/div[2]/span[@class=' '][text()='25']"); //date seect
		//calender
//		while(true)
//		{			String curMonth= page.locator("//div[@id='jaurney-date']/div/div[2]/div/div[2]/span[1]").innerText();
//		
//			Thread.sleep(2000);
//			if(curMonth.equalsIgnoreCase("March")) 
//			{			System.out.println(curMonth);
//				page.click("//div[@id='jaurney-date']/div/div[2]/div[2]/span[@class=' '][text()='5']");
//				break;			}
//			else {
//			page.locator("//div[@id='jaurney-date']/div/div[2]/div/div[3]/span").click();}		}
		
		page.click("//button[text()='Search']"); //searchButton
		Thread.sleep(2000);
		page.click("//span[text()='Price']");	//pricesort
		page.click("(//a[@class='btn  outlined tertiary sm inactive button'])[3]"); // bus type

		List <ElementHandle> seatsAvails = page.querySelectorAll("//*[@id='service-cards-container']/div/div/div/div[2]/div/div[2]/div/div");  //all bus seats availability
			for (ElementHandle seatsAvail : seatsAvails) {
			if(seatsAvail.innerText().contains("Seats Available"))
				{
				page.click("//*[@id='service-cards-container']//div//button[text()='Select Seats']"); //select bus option
			//	System.out.println(page.locator("//*[@id='service-cards-container']/div/div/div/div/div/div[2]//h5").innerText()); // bus name
				break;
			}	}		
//		List <ElementHandle>  selectSeats = page.querySelectorAll("#seat-layout-details > tbody > tr:nth-child(1) > td > div > button > svg > path:nth-child(1)");
//		for (ElementHandle selectSeat : selectSeats) {
//			String val= selectSeat.getAttribute("fill");
//			if(val.contains("DEDEDE")){continue;}
//			else {selectSeat.click();
//				break;}}
		// specific seat selecting
		Locator seat=page.locator("#seat-layout-details > tbody > tr:nth-child(1) > td:nth-child(1)  > div > button > svg > path:nth-child(1)");
			if(seat.isEnabled()) {
				seat.click();
			}else
			{
				System.out.println("Choosen seat is already filled.Choose another");
			}
		page.getByPlaceholder("Search Boarding Point").fill("Trichy");//boarding search
		Locator boardList=page.locator("//div[@id='seating-place-selector']/div/div[2]/div");
		for(int i=0;i<boardList.count();i++) {
			if(boardList.nth(i).innerText().contains("Mannarpuram")) {
				boardList.nth(i).click();
			}}
		
		page.getByPlaceholder("Search Dropping Point").fill("Kilam");//dropping search
		Locator dropList=page.locator("//*[@id='place-select-container']/div[2]/div");
		for(int i=0;i<dropList.count();i++) {
			if(dropList.nth(i).innerText().contains("Kilambakkam")) {
				dropList.nth(i).click();
			}}
		page.click("//button[@class='btn  filled primary md inactive button']");//nextStep continue
		
		page.click("//div[@id='login-container']//div[@id='login-heading']/div/span");//login cancel
		page.getByPlaceholder("Name").fill("MNitheesh"); //passengerName
		page.getByPlaceholder("Age").fill("25");//passengerAge
		page.click("//button[text()='Male']");//passengerGender
		page.getByPlaceholder("Enter Mobile Number").fill("6365646362");//passengerMob
		page.getByPlaceholder("Enter Email Address").fill("6365646362@gmail.com");//passengerEmail
		
		page.click("//button[contains(text(),'Continue to Pay ₹')]");//continueToPay
		 
		 
		 
		Thread.sleep(10000);
		playwright.close();
		browser.close();
		page.close();
	}

}
