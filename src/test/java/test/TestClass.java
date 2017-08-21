package test;

import automation.Qpv1Initiator;
import java.io.IOException;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {


    Qpv1Initiator test;
    
    @BeforeTest
    public void initialize() {
        
    	test=new Qpv1Initiator();
    }

    @Test
    public void test_case_a() throws IOException, InterruptedException {
        test.iact.login_instructor();
    }
    
//    @Test
//    public void test_case_b()throws IOException, InterruptedException  {
//        iact.create_course();
//    	  iact.activate_course();
//    }
    
//    @Test
//    public void test_case_c() throws InterruptedException, IOException{
//      
//    	iact.already_existing_course();
//    	iact.already_existing_quiz();
//        
//    }
//    @Test
//    public void test_case_d()throws InterruptedException, IOException{
//        iact.add_quiz();
//    }
//    
//    @Test
//    public void test_case_e()throws InterruptedException, IOException{
//        iact.create_quiz();
//    }
    @Test
    public void test_case_f() throws InterruptedException, IOException{
        test.iact.load_base_url_and_logout_instructor();
    }
    
    @Test
    public void test_case_g() throws IOException, InterruptedException{
        test.sact.login_Student();
        test.sact.navigate_to_created_course();
    }
    
    @Test
    public void test_case_h() throws InterruptedException, IOException{
        test.sact.opening_quiz();
    }
    @Test
    public void test_case_i() throws InterruptedException, IOException{
        test.sact.attempting_quiz();
        test.sact.logout_student();
    }
   
    @Test
    public void test_case_j() throws IOException, InterruptedException {
//        gact.verify_user_is_on_login_page();
    	 test.gact.action_logging_instructor();
      

    }

    @Test
    public void test_case_k() throws InterruptedException, IOException {
//        gact.verify_user_is_logged_in();
    	 test.gact.action_navigate_to_course();
    }

    @Test
    public void test_case_l() throws InterruptedException, IOException {
//        gact.verify_user_is_on_enter_your_course_page();
    	 test.gact.action_enter_course();
    }

    @Test
    public void test_case_m() throws InterruptedException, FindFailed, IOException {
    	 test.gact.action_importing_and_exporting_score();
    }

}
