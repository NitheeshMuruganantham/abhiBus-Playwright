package pom;

import java.io.IOException;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class BookBusPage extends BasePOM{
	public BookBusPage(Page page) throws IOException 
	{
		super(page);
	}
	public void fromPart() throws InterruptedException {
		click("busLink");
		fill("fromBus", "Trichy");
		List <ElementHandle>  formlists=querySelectorAll("fromBusDropdown");
		elementHandle(formlists, "Trichy");
	}
	
	public void toPart() throws InterruptedException {
		fill("toBus", "Chennai");
		List <ElementHandle>  tolists=	querySelectorAll("toBusDropdown");
		elementHandle(tolists, "Chennai");
	}
	public void searchProcess() throws InterruptedException {
		click("calenderClick");
		click("dateSelect");
		click("tripSearchButtom");
		Thread.sleep(3000);
	}

}
