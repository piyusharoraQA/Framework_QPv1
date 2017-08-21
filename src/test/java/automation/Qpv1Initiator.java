package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import action.GradeBookAction;
import action.InstructorAction;
import action.StudentAction;

public class Qpv1Initiator {
	public InstructorAction iact;
	public StudentAction sact;
	public GradeBookAction gact;
	public WebDriver driver;

	public Qpv1Initiator() {
		initialize_browser();
		initialize_page();

	}

	

	public void initialize_browser() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.lt.macmillan.cloud/launchpad/bps7e");

	}
	public void initialize_page() {

		iact = new InstructorAction(driver);
		sact = new StudentAction(driver);
		gact = new GradeBookAction(driver);

	}

}
