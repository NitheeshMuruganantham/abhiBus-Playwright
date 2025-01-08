package testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import pom.BookBusPage;
import pom.BusChoosing;
import pom.PassengerDetails;
import utilities.MainDataProvider;

public class Test1 extends BaseTest{
	//Page page;
	@Test(dataProvider = "tripExcel",dataProviderClass = MainDataProvider.class)
	public void process(Hashtable <String, String> data) throws IOException, InterruptedException {
		
		page.navigate("https://www.abhibus.com/");
		BookBusPage bp= new BookBusPage(page);
System.out.println(data.get("FromStation"));
		bp.fromPart();
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
