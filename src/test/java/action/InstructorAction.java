package action;

import java.io.IOException;

import static utils.Data.data_reader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import common.CommonFunc;

/**
 *
 * @author piyusharora
 */
public class InstructorAction extends CommonFunc {

	static String url = "";
	 

	public InstructorAction(WebDriver driver) {
		super(driver, "InstructorLocators.txt");

	}

	public void login_instructor() throws IOException, InterruptedException {

		element("email").sendKeys(data_reader("user_ins"));
		element("pass").sendKeys(data_reader("pass_ins"));
		element("sign_in").click();
		hardWait(20);
	}

	public void create_course() throws IOException, InterruptedException {
		hardWait(5);
		element("create_course").click();
		element("next").click();
		element("next2").click();
		element("course_title").clear();
		element("course_title").sendKeys(data_reader("title"));
		element("school_name").clear();
		element("school_name").sendKeys(data_reader("school_name"));
		hardWait(2);
		element("create_course1").click();

	}

	public void activate_course() throws InterruptedException, IOException {
		hardWait(15);
		element("course").click();
		hardWait(5);
		element("enter_course").click();
		hardWait(5);
		element("activate_course").click();
		element("activation").click();
		hardWait(2);
		element("activate_done").click();
	}

	public void add_quiz() throws IOException, InterruptedException {
		hardWait(15);
		element("add_new").click();
		hardWait(5);
		element("quiz_box").click();
		hardWait(10);
		element("title").clear();
		element("title").sendKeys("Test");
		hardWait(2);
		element("save_button").click();
		hardWait(2);
		element("questions").click();

	}

	public void create_quiz() throws IOException, InterruptedException {
		hardWait(7);
		element("chapter").click();
		hardWait(5);
		element("quiz_create").click();
		hardWait(7);
		element("check_box0").click();
		hardWait(2);
		element("check_box1").click();
		hardWait(2);
		element("check_box2").click();
		hardWait(2);
		element("add_btn").click();
		hardWait(2);
		element("check_box3").click();
		hardWait(2);
		element("check_box4").click();
		hardWait(2);
		element("check_box5").click();
		hardWait(2);
		element("add_pool_drop").click();
		element("add_pool_btn").click();
		element("pool_title").sendKeys("Test");
		element("pool_ques").sendKeys("2");
		element("create_pool_btn").click();
		hardWait(5);
		// loc.element("create_btn").click();
		// loc.element("multiple_choice").click();
		// hardWait(10);
		// WebDriverInitiator.driver.switchTo().frame(1);
		// loc.element("question_multi").sendKeys("What is the capital of india
		// ?");
		// loc.element("question_multi").sendKeys(Keys.ENTER);
		// loc.element("question_multi").sendKeys("mumbai");
		// loc.element("question_multi").sendKeys(Keys.ENTER);
		// loc.element("question_multi").sendKeys("dehradun");
		// loc.element("question_multi").sendKeys(Keys.ENTER);
		// loc.element("question_multi").sendKeys("delhi");
		// loc.element("question_multi").sendKeys(Keys.ENTER);
		// loc.element("question_multi").sendKeys("kanpur");
		element("assignment").click();
		hardWait(10);
		element("due_date").sendKeys("09/15/2017");
		element("due_date").sendKeys(Keys.TAB);
		element("grades").sendKeys("100");
		element("assign_btn").click();
		/*
		 * code for number of attempt setting to be written
		 */
		hardWait(2);
		element("done_editing_btn").click();
		hardWait(2);
		element("home_btn").click();

	}

	public void load_base_url_and_logout_instructor() throws InterruptedException, IOException {
		hardWait(3);
		driver.get("http://www.lt.macmillan.cloud/launchpad/bps7e/");
		hardWait(10);
		WebElement elemnt = element("course");
		url = elemnt.getAttribute("href");
		System.out.println(url);
		element("logout").click();
		hardWait(1);
		element("logout_btn").click();
		hardWait(25);
	}

	public void already_existing_course() throws IOException, InterruptedException {
		Actions actions = new Actions(driver);
		WebElement existing_course = element("course");
		actions.moveToElement(existing_course).click();
		actions.perform();
		hardWait(7);
		element("enter_course").click();

	}

	public void already_existing_quiz() throws IOException, InterruptedException {
		hardWait(10);
		element("quiz_created_recent").click();
	}

}
