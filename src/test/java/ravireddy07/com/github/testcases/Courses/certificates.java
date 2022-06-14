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
public class certificates extends BaseTest {
    JSONObject loginData = JsonParser.getLoginData();
    JSONObject testData = JsonParser.getTestData();

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to complete the course without assessment and with certificate")
    public void completeCourseWithCertificateWithoutAssessment(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80760
            lessons: 3
            certificate: yes
            assessment: no
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            //if(platformName.equals("iOS")) {
            //  loginPage.iOSPermissions();
            //}
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner3").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80760");
            loginPage.viewSpecificCourse("Course 80760");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickNextLesson();
            loginPage.clickCompleteLessonButton();
            if(!platformName.equals("iOS")) {
                loginPage.clickViewCertificate();
                loginPage.pressBackButtonFromMobile();
            }
            loginPage.navigateBack();
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80760");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80760
            TestUtils.updateTestRailResult(true, "completeCourseWithCertificateWithoutAssessment", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "completeCourseWithCertificateWithoutAssessment", "");
            Assert.fail(e.getMessage());
        }
    }// 80760

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to complete the course without assessment and with certificate and download the certificate")
    public void completeCourseWithCertificateAndDownload(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 81218
            lessons: 3
            certificate: yes
            assessment: no
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
            loginPage.searchCourse(platformName, "Course 81218");
            loginPage.viewSpecificCourse("Course 81218");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickNextLesson();
            loginPage.clickCompleteLessonButton();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.navigateBack();
            } else {
                launchApp();
                iOSPermissions();
                loginPage.clickSkipButton();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scrollDown();
                loginPage.viewSpecificCourse("Course 81218");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 81218");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/81218
            TestUtils.updateTestRailResult(true, "completeCourseWithCertificateAndDownload", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "completeCourseWithCertificateAndDownload", "");
            Assert.fail(e.getMessage());
        }
    }// 81218

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see Certificate in Course details screen ")
    public void validateCertificateInCourseDetails(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80770
            lessons: 2
            certificate: yes
            assessment: no
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
            loginPage.searchCourse(platformName, "Course 80770");
            loginPage.viewSpecificCourse("Course 80770");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickCompleteLessonButton();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.navigateBack();
            } else {
                launchApp();
                iOSPermissions();
                loginPage.clickSkipButton();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scrollDown();
                loginPage.viewSpecificCourse("Course 80770");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80770");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80770
            TestUtils.updateTestRailResult(true, "validateCertificateInCourseDetails", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "validateCertificateInCourseDetails", "");
            Assert.fail(e.getMessage());
        }
    }// 80770

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see Certificate Tab in Course details screen during enrollment")
    public void validateCertificateTabWhileEnrolling(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80771
            lessons: 1
            certificate: yes
            assessment: no
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
            loginPage.searchCourse(platformName, "Course 80771");
            loginPage.viewSpecificCourse("Course 80771");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80771");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80771
            TestUtils.updateTestRailResult(true, "validateCertificateTabWhileEnrolling", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "validateCertificateTabWhileEnrolling", "");
            Assert.fail(e.getMessage());
        }
    }// 80771

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the information in the certificate as per admin's configuration")
    public void validateInformationOnCertificate(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80772
            lessons: 1
            certificate: yes
            assessment: no
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
            loginPage.searchCourse(platformName, "Course 80772");
            loginPage.viewSpecificCourse("Course 80772");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickCompleteLessonButton();
            if(!platformName.equals("iOS")) {
                loginPage.clickViewCertificate();
                /****/ // validate data on certificate
                loginPage.pressBackButtonFromMobile();
            }
            loginPage.navigateBack();
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80772");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80772
            TestUtils.updateTestRailResult(true, "validateInformationOnCertificate", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "validateInformationOnCertificate", "");
            Assert.fail(e.getMessage());
        }
    }// 80772

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to complete the course with mandatory assessment and with certificate")
    public void completeCourseWithCertificateAndAssessment(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80773
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80773");
            loginPage.viewSpecificCourse("Course 80773");
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
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.navigateBack();
            } else {
                launchApp();
                iOSPermissions();
                loginPage.clickSkipButton();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scrollDown();
                loginPage.viewSpecificCourse("Course 80773");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80773");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80773
            TestUtils.updateTestRailResult(true, "completeCourseWithCertificateAndAssessment", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "completeCourseWithCertificateAndAssessment", "");
            Assert.fail(e.getMessage());
        }
    }// 80773

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to Fail in the course with mandatory assessment and with certificate")
    public void failMandatoryAssessmentWithCertificate(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80777
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80777");
            loginPage.viewSpecificCourse("Course 80777");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("b");
            loginPage.clickCompleteAssessment();
            Assert.assertFalse(loginPage.validateAssessmentStatus());
            loginPage.clickAssessmentSummary();
            loginPage.navigateBack();
            loginPage.clickProceed();
            loginPage.viewSpecificCourse("Course 80777");
            loginPage.clickResumeButton();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("a");
            loginPage.clickCompleteAssessment();
            Assert.assertTrue(loginPage.validateAssessmentStatus());
            loginPage.clickAssessmentSummary();
            loginPage.navigateBack();
            loginPage.clickProceed();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.navigateBack();
            } else {
                launchApp();
                iOSPermissions();
                loginPage.clickSkipButton();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scrollDown();
                loginPage.viewSpecificCourse("Course 80777");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80777");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80777
            TestUtils.updateTestRailResult(true, "failMandatoryAssessmentWithCertificate", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "failMandatoryAssessmentWithCertificate", "");
            Assert.fail(e.getMessage());
        }
    }// 80777

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to complete the course with optional assessment and with certificate")
    public void optionalAssessmentWithCertificate(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80778
            lessons: 2
            certificate: yes
            assessment: yes(optional)
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
            loginPage.searchCourse(platformName, "Course 80778");
            loginPage.viewSpecificCourse("Course 80778");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
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
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.navigateBack();
            } else {
                launchApp();
                iOSPermissions();
                loginPage.clickSkipButton();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scrollDown();
                loginPage.viewSpecificCourse("Course 80778");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80778");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80778
            TestUtils.updateTestRailResult(true, "optionalAssessmentWithCertificate", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "optionalAssessmentWithCertificate", "");
            Assert.fail(e.getMessage());
        }
    }// 80778

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to Fail in the course with optional assessment and with certificate")
    public void failOptionalAssessmentWithCertificate(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80779
            lessons: 2
            certificate: yes
            assessment: yes(optional)
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
            loginPage.searchCourse(platformName, "Course 80779");
            loginPage.viewSpecificCourse("Course 80779");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("b");
            loginPage.clickCompleteAssessment();
            Assert.assertFalse(loginPage.validateAssessmentStatus());
            loginPage.clickAssessmentSummary();
            loginPage.navigateBack();
            loginPage.clickProceed();
            loginPage.scrollDown();
            loginPage.viewSpecificCourse("Course 80779");
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80779");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80779
            TestUtils.updateTestRailResult(true, "failOptionalAssessmentWithCertificate", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "failOptionalAssessmentWithCertificate", "");
            Assert.fail(e.getMessage());
        }
    }// 80779

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to skip the assessment and get certificate")
    public void skipAssessmentWithCertificate(String platformName) throws Exception {
        /*
        Requirements:
            Name: Course 80780
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80780");
            loginPage.viewSpecificCourse("Course 80780");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
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
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.navigateBack();
            } else {
                launchApp();
                iOSPermissions();
                loginPage.clickSkipButton();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scrollDown();
                loginPage.viewSpecificCourse("Course 80780");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 80780");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80780
            TestUtils.updateTestRailResult(true, "skipAssessmentWithCertificate", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "skipAssessmentWithCertificate", "");
            Assert.fail(e.getMessage());
        }
    }// 80780

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the information in the certificate under My certificate")
    public void validateInfoInMyCertificates(String platformName) throws Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
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
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80783
            TestUtils.updateTestRailResult(true, "validateInfoInMyCertificates", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "validateInfoInMyCertificates", "");
            Assert.fail(e.getMessage());
        }
    }// 80783

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the Certificate in My certificate and download it")
    public void downloadFromMyCertificates(String platformName) throws Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
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
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/80784
            TestUtils.updateTestRailResult(true, "downloadFromMyCertificates", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "downloadFromMyCertificates", "");
            Assert.fail(e.getMessage());
        }
    }// 80784

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the Certificate under My certificate in sorted order")
    public void myCertificatesInSortedOrder(String platformName) throws Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
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
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/82525
            TestUtils.updateTestRailResult(true, "myCertificatesInSortedOrder", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "myCertificatesInSortedOrder", "");
            Assert.fail(e.getMessage());
        }
    }// 82525

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see the certificate even the user kills the application in the certificate screen ")
    public void killTheAppAfterCourseCompletion(String platformName) throws Exception {
        /*
        Requirements:
            Requirements:
            Name: Course 81217
            lessons: 1
            certificate: yes
            assessment: no
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                loginPage.iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 81217");
            loginPage.viewSpecificCourse("Course 81217");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertFalse(loginPage.isCertificateAvailable(platformName));
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickCompleteLessonButton();
            loginPage.terminateApp(platformName);
            launchApp();
            if(platformName.equals("iOS")) {
                loginPage.iOSPermissions();
            }
            loginPage.clickSkipButton();
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.scrollDown();
            loginPage.viewSpecificCourse("Course 81217");
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            loginPage.scrollDown();
            Assert.assertTrue(loginPage.isCertificateAvailable(platformName));
            loginPage.scrollUp();
            loginPage.navigateBack();
            loginPage.clickSearchTab();
            loginPage.searchCourse(platformName, "Course 81217");
            Assert.assertTrue(loginPage.isNoResultFound());
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/81217
            TestUtils.updateTestRailResult(true, "killTheAppAfterCourseCompletion", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "killTheAppAfterCourseCompletion", "");
            Assert.fail(e.getMessage());
        }
    }// 81217

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the preview information under My certificate ")
    public void previewMyCertificates(String platformName) throws Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
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
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/81213
            TestUtils.updateTestRailResult(true, "previewMyCertificates", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "previewMyCertificates", "");
            Assert.fail(e.getMessage());
        }
    }// 81213

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to view the certificate gained from Web/Mobile browser")
    public void validateCertificateGainedOnBrowser(String platformName) throws Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
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
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            updateTestcaseStatus(true);
            // https://auzmorhr.testrail.io/index.php?/cases/view/82966
            TestUtils.updateTestRailResult(true, "validateCertificateGainedOnBrowser", "");
        } catch(Exception e) {
            e.printStackTrace();
            updateTestcaseStatus(false);
            TestUtils.updateTestRailResult(false, "validateCertificateGainedOnBrowser", "");
            Assert.fail(e.getMessage());
        }
    }// 82966
}
