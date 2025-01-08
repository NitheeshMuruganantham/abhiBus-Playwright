package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

	public Playwright playwright;
	public Browser browser;
	public Page page;
	
	
	@BeforeClass
	public void launch() {
	playwright=Playwright.create();
	browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	page =browser.newPage();
	}
	
	
	
	
	
	@AfterClass
	public void lauch() throws InterruptedException {
		Thread.sleep(5000);
		page.close();
		browser.close();
		playwright.close();
	}
}
