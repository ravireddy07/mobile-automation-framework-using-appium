package ravireddy07.com.github.testcases;

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
    LoginPage loginPage = new LoginPage();

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to click on Take assessment button")
    public void takeAnyAssessment(String platformName) throws Exception {
        try {
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
            TestUtils.updateTestRailResult(true, "takeAnyAssessment", "");
        } catch(Exception e) {
            e.printStackTrace();
            TestUtils.updateTestRailResult(false, "takeAnyAssessment", "");
            Assert.fail(e.getMessage());
        }
    }

    @Parameters({"platformName"})
    @Test(enabled = true)
    @Description("Learner - Able to skip the assessment and complete the course")
    public void skipAssessment(String platformName) throws Exception {
        try {
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
            TestUtils.updateTestRailResult(true, "skipAssessment", "");
        } catch(Exception e) {
            e.printStackTrace();
            TestUtils.updateTestRailResult(false, "skipAssessment", "");
            Assert.fail(e.getMessage());
        }
    }
}
