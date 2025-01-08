package pom;

import java.io.IOException;

import com.microsoft.playwright.Page;

public class PassengerDetails extends BasePOM {

	public  PassengerDetails(Page page) throws IOException {
		super(page);
	}
	
	public void detailsFillUp() {
		click("loginAlertCancel");
		fillWithPlaceHolder("passengerName", "MNitheesh");
		fillWithPlaceHolder("passengerAge", "25");
		click("passengerMale");
		fillWithPlaceHolder("passengerMobile", "6365646362");
		fillWithPlaceHolder("passengerEmail", "6365646362@gmail.com");
		click("continueForPay");
	}

	
}
