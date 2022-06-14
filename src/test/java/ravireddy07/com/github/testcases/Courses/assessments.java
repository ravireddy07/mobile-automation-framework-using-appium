package ravireddy07.com.github.testcases.Courses;

import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.pages.LoginPage;
import ravireddy07.com.github.utils.JsonParser;
import ravireddy07.com.github.utils.TestUtils;
import org.json.JSONObject;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@SuppressWarnings({"WeakerAccess"})
public class assessments extends BaseTest {
    JSONObject loginData = JsonParser.getLoginData();
    JSONObject testData = JsonParser.getTestData();

    /*
    - 80743
    - 80746
    - 80747
     */

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to click on Take assessment button")
    public void takeAnyAssessment(String platformName) throws Exception {
        /*
        Requirements:
            Requirements:
            Name: Course 80738
            lessons: 2
            certificate: yes
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner3").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80738");
            loginPage.viewSpecificCourse("Course 80738");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("a");
            loginPage.clickCompleteAssessment();
            loginPage.clickAssessmentSummary();
            loginPage.navigateBack();
            loginPage.clickProceed();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                //loginPage.downloadCertificateImage();
                //loginPage.downloadCertificateImage();/* Close the Popup */
                //loginPage.downloadCertificatePDF();
                //loginPage.downloadCertificatePDF(); /* Close the Popup */
                loginPage.pressBackButtonFromMobile();
                loginPage.navigateBack();
            } else {
                launchApp();
                iOSPermissions();
                loginPage.clickSkipButton();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner3").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scrollDown();
                loginPage.viewSpecificCourse("Course 80738");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80738");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80738
            TestUtils.updateTestRailResult(true, "takeAnyAssessment", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "takeAnyAssessment", "");
            Assert.fail(e.getMessage());
        }
    }// 80738

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to skip the assessment and complete the course")
    public void skipAssessment(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80739
            lessons: 2
            certificate: no
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80739");
            loginPage.viewSpecificCourse("Course 80739");
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickSkipAssessment();
            loginPage.clickBackButton();
            loginPage.clickSkipAssessment();
            loginPage.clickSkipButton();
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80739");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80739
            TestUtils.updateTestRailResult(true, "skipAssessment", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "skipAssessment", "");
            Assert.fail(e.getMessage());
        }
    }// 80739

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to click on Cancel from skip assessment warning screen")
    public void validateCancelButtonOnSkipAssessment(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80740
            lessons: 2
            certificate: no
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80740");
            loginPage.viewSpecificCourse("Course 80740");
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickSkipAssessment();
            loginPage.clickBackButton();
            loginPage.clickSkipAssessment();
            loginPage.clickSkipButton();
            loginPage.clickBackToCoursesButton();
            loginPage.scrollDown();
            loginPage.viewSpecificCourse("Course 80740");
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80740");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80740
            TestUtils.updateTestRailResult(true, "validateCancelButtonOnSkipAssessment", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "validateCancelButtonOnSkipAssessment", "");
            Assert.fail(e.getMessage());
        }
    }// 80740

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to perform Attend later")
    public void attendLater(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80741
            lessons: 2
            certificate: no
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80741");
            loginPage.viewSpecificCourse("Course 80741");
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickSkipAssessment();
            loginPage.clickBackButton();
            loginPage.clickTakeAssessment();
            loginPage.clickAttendLater();
            loginPage.clickNoButton();
            loginPage.clickAttendLater();
            loginPage.clickYesButton();
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80741");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80741
            TestUtils.updateTestRailResult(true, "attendLater", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "attendLater", "");
            Assert.fail(e.getMessage());
        }
    }// 80741

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to click on NO from Attend later warning screen")
    public void noAttendLater(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80742
            lessons: 2
            certificate: no
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80742");
            loginPage.viewSpecificCourse("Course 80742");
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickSkipAssessment();
            loginPage.clickBackButton();
            loginPage.clickTakeAssessment();
            loginPage.clickAttendLater();
            loginPage.clickNoButton();
            loginPage.clickAttendLater();
            loginPage.clickYesButton();
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80742");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80742
            TestUtils.updateTestRailResult(true, "noAttendLater", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "noAttendLater", "");
            Assert.fail(e.getMessage());
        }
    }// 80742

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to take single choice assessment with assessment options")
    public void takeSingleChoice(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80744
            lessons: 2
            certificate: no
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80744");
            loginPage.viewSpecificCourse("Course 80744");
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("a");
            loginPage.clickCompleteAssessment();
            loginPage.clickAssessmentSummary();
            loginPage.navigateBack();
            loginPage.clickProceed();
            loginPage.scrollDown();
            loginPage.viewSpecificCourse("Course 80744");
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80744");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80744
            TestUtils.updateTestRailResult(true, "takeSingleChoice", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "takeSingleChoice", "");
            Assert.fail(e.getMessage());
        }
    }// 80744

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to take Multiple choice assessment with assessment options")
    public void takeMultipleChoice(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80745
            lessons: 2
            certificate: no
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80745");
            loginPage.viewSpecificCourse("Course 80745");
            Assert.assertFalse(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("a");
            loginPage.selectOption("b");
            loginPage.clickCompleteAssessment();
            loginPage.clickAssessmentSummary();
            loginPage.navigateBack();
            loginPage.clickProceed();
            loginPage.scrollDown();
            loginPage.viewSpecificCourse("Course 80745");
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80745");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80745
            TestUtils.updateTestRailResult(true, "takeMultipleChoice", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "takeMultipleChoice", "");
            Assert.fail(e.getMessage());
        }
    }// 80745
}
