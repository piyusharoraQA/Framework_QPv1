package action;

//import static utils.Data.data_reader;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import common.CommonFunc;
import static utils.Data.data_reader;

/**
 *
 * @author piyusharora
 */
public class GradeBookAction extends CommonFunc {
	Screen skl = new Screen();
	String user_dir = System.getProperty("user.dir");

	public GradeBookAction(WebDriver driver) {
		super(driver, "GradebookLocators.txt");

	}

	public void action_logging_instructor() throws IOException, InterruptedException {
		driver.get("http://www.lt.macmillan.cloud/launchpad/bps7e");
		hardWait(10);
		element("email").sendKeys(data_reader("user_ins"));
		element("pass").sendKeys(data_reader("pass_ins"));
		element("sign_in").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void action_navigate_to_course() throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		WebElement element = element("course");
		actions.moveToElement(element).perform();
		hardWait(5);
		element.click();
		hardWait(9);

	}

	public void action_enter_course() throws InterruptedException, IOException {

		element("enter_course").click();
		hardWait(9);
		element("gradebook").click();
		hardWait(9);

	}

	public void action_importing_and_exporting_score() throws InterruptedException, FindFailed, IOException {
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(iframeElements.get(1));
		element("export_score").click();
		element("file_name").sendKeys(data_reader("filename"));
		hardWait(2);
		skl.click(user_dir + "\\src\\test\\resources\\Images\\export_btn.PNG");
		hardWait(2);
		skl.click(user_dir + "\\src\\test\\resources\\Images\\close_box_btn.PNG");
		skl.click(user_dir + "\\src\\test\\resources\\Images\\import_score_btn.PNG");
		skl.click(user_dir + "\\src\\test\\resources\\Images\\browse_btn.PNG");
		skl.click(user_dir + "\\src\\test\\resources\\Images\\download_btn.PNG");
		skl.click(user_dir + "\\src\\test\\resources\\Images\\grade_file.PNG");
		skl.click(user_dir + "\\src\\test\\resources\\Images\\open_btn.PNG");
		hardWait(5);
		skl.click(user_dir + "\\src\\test\\resources\\Images\\continue_btn.PNG");
		hardWait(5);
		skl.click(user_dir + "\\src\\test\\resources\\Images\\import_btn.PNG");

	}

	public void verify_user_is_on_login_page() throws InterruptedException {
		System.out.println(driver.getTitle());
		hardWait(10);
		Assert.assertEquals("Macmillan Launchpad: Login", driver.getTitle());

	}

	public void verify_user_is_logged_in() {

		WebElement element = driver.findElement(By.xpath("//a[@id='createcourseoption']"));
		System.out.println(element.getAttribute("class"));
		Assert.assertEquals("createcourseoption", element.getAttribute("class"));

	}

	public void verify_user_is_on_enter_your_course_page() {
		WebElement element = driver.findElement(By.xpath("//div[@title='Testing Purpose Course']"));
		System.out.println(element.getAttribute("title"));
		Assert.assertEquals("Testing Purpose Course", element.getAttribute("title"));

	}
}
