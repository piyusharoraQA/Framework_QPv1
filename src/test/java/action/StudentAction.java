package action;


//import static utils.Data.data_reader;
import static utils.Data.data_reader;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.CommonFunc;

public class StudentAction extends CommonFunc {

	
	public StudentAction(WebDriver driver) {
		super(driver,"StudentLocators.txt");
	}

	public void login_Student() throws IOException, InterruptedException {
		element("email").sendKeys(data_reader("user_stud"));
		element("pass").sendKeys(data_reader("pass_stud"));
		element("sign_in").click();
		hardWait(20);

	}

	public void navigate_to_created_course() throws InterruptedException, IOException {
		driver.get(InstructorAction.url);
		hardWait(10);

	}

	public void opening_quiz() throws InterruptedException, IOException {
		hardWait(5);
		element("enter_course").click();
		element("opening_quiz").click();
		hardWait(5);
		element("starting_quiz").click();
	}

	public void attempting_quiz() throws InterruptedException, IOException {

		hardWait(10);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		hardWait(5);
		driver.switchTo().frame(iframeElements.get(1));
		WebElement frame2 = element("frame2");
		driver.switchTo().frame(frame2);
		WebElement frame3 = element("frame3");
		driver.switchTo().frame(frame3);
		element("q1").click();
		element("q2").click();
		element("q3").click();
		element("q4").click();
		element("q5").click();
		hardWait(5);
		element("submit_btn").click();
		hardWait(5);
		element("done_quiz").click();

	}

	public void logout_student() throws InterruptedException, IOException {
		hardWait(10);
		element("logout").click();
		hardWait(2);
		element("logout_btn").click();
		hardWait(25);
	}

}
