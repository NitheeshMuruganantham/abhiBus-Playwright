package rough;

import java.io.IOException;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pom.BookBusPage;
import pom.BusChoosing;
import pom.PassengerDetails;

public class TestcaseWithoutTestng {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		
		page.navigate("https://www.abhibus.com/");
		BookBusPage bp= new BookBusPage(page);

	//	bp.fromPart();
		bp.toPart();
		bp.searchProcess();
		BusChoosing bs = new BusChoosing(page);
		bs.filtering1();
		bs.filtering2();
		bs.filtering3();
		bs.boarding();
		bs.dropping();
		PassengerDetails pd=new PassengerDetails(page);
		pd.detailsFillUp();
		
		
		
		
		}

}
