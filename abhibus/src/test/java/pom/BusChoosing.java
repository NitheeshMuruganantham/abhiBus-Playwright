package pom;

import java.io.IOException;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BusChoosing extends BasePOM{

	public BusChoosing(Page page) throws IOException {
		super(page);
	}
	public void filtering1() throws InterruptedException {
		click("priceSort");
		click("busType");
	}
	public void filtering2() { 
		List <ElementHandle> seatsAvails= querySelectorAll("busSeatAvailCheck");
		for (ElementHandle seatsAvail : seatsAvails) {
		if(seatsAvail.innerText().contains("Seats Available"))
			{
			click("selectingBus");
			break;
		}	}}
	public void filtering3() { 
		if(isEnabled("seatChoosing")) {
			click("seatChoosing");
		}}
	public void boarding() {
		fillWithPlaceHolder("boardingSearch","Trichy");
		Locator board= locators("boardingList");
		selectingByForLoop(board, "Central");
	}
	public void dropping() {
		fillWithPlaceHolder("droppingSearch","Kilam");
		Locator board= locators("droppingList");
		selectingByForLoop(board, "Kilambakkam");
		click("nextStepContinue");
	}
	
	
	
	}
	

