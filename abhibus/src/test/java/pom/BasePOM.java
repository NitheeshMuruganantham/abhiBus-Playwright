package pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePOM {

	public  Page page;
	public static Properties pr=new Properties();
	public static FileInputStream fis;
	
	
	public  BasePOM(Page page) throws IOException {
		this.page = page;
		fis = new FileInputStream("src\\test\\resources\\Locators.properties");
		pr.load(fis);
	}
	public void click(String Locator) {
		page.click(pr.getProperty(Locator));
	}
	public void fill(String Locator, String value){
		page.fill(pr.getProperty(Locator), value);
	}
	public void fillWithPlaceHolder(String Locator, String value){
		page.getByPlaceholder(pr.getProperty(Locator)).fill(value);;
	}
	public Locator locators(String Locator) {
		return page.locator(pr.getProperty(Locator));
		
	}
	public boolean isEnabled(String Locator) {
		try{
			  page.isEnabled(pr.getProperty(Locator));
			  return true;
		}
		catch(Throwable t) {
			System.out.println(t.getMessage()+ Locator +"is not available");
			return false;
		}
	}
	
	 public List <ElementHandle> querySelectorAll(String Locator) {
		 return page.querySelectorAll(pr.getProperty(Locator));
	 }
	
	 public void elementHandle (List <ElementHandle> lists, String value) throws InterruptedException {
		 for (ElementHandle list : lists) {
			 Thread.sleep(2000);
			if(list.innerText().equalsIgnoreCase(value))
			{
				list.click();
				break;
			}}
	 }
	 public void selectingByForLoop(Locator loc, String value) {
		 for(int i=0;i<loc.count();i++) {
				if(loc.nth(i).innerText().contains(value)) {
					loc.nth(i).click();
				}}
	 }

}
