package common;

import utils.Locator;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunc {
	protected  WebDriver driver;
	
	String pagename;
	String filepathstring = "";
	String filepath = "src/test/resources/Locator/";
	Locator loc;
	
	
	public CommonFunc(WebDriver driver, String pagename) {
		this.driver = driver;
		this.pagename = pagename;
		filepathstring = filepath + pagename;
		loc = new Locator(filepathstring);

	}

	public WebElement element(String elementName) throws IOException {

		return driver.findElement(loc.Locator_type(elementName));
	}

	public void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
