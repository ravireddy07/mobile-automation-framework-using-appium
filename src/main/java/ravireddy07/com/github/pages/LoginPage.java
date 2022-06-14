package ravireddy07.com.github.pages;

import com.aventstack.extentreports.Status;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.reports.ExtentReport;
import ravireddy07.com.github.utils.JsonParser;
import ravireddy07.com.github.utils.TestUtils;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage extends BaseTest {
    TestUtils utils = new TestUtils();
    WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
    Actions actionsObject;
    int heightOfScreen = getDriver().manage().window().getSize().getHeight();
    int widthOfScreen = getDriver().manage().window().getSize().getWidth();
    int middleHeightOfScreen = heightOfScreen/2; //50% of width/Width
    double x = widthOfScreen*0.5;
    double y = heightOfScreen*0.5;

    /* Sign in */
    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private MobileElement textBox;
    @AndroidFindBy(accessibility = "Continue")
    @iOSXCUITFindBy(accessibility = "Continue")
    private MobileElement continueBtn;

    @AndroidFindBy(accessibility = "Sign In")
    @iOSXCUITFindBy(accessibility = "Sign In")
    private MobileElement signInButton;
    @AndroidFindBy(accessibility = "Sign In with SSO")
    @iOSXCUITFindBy(accessibility = "Sign In with SSO")
    private MobileElement signInSSOButton;

    @AndroidFindBy(accessibility = "back")
    @iOSXCUITFindBy(accessibility = "back")
    private MobileElement backButton;
    /* Tabs */
    @AndroidFindBy(accessibility = "home-tab")
    @iOSXCUITFindBy(accessibility = "home-tab")
    private MobileElement homeTab;
    @AndroidFindBy(accessibility = "search-tab")
    @iOSXCUITFindBy(accessibility = "search-tab")
    private MobileElement searchTab;
    @AndroidFindBy(accessibility = "notifications-tab")
    @iOSXCUITFindBy(accessibility = "notifications-tab")
    private MobileElement notificationTab;
    @AndroidFindBy(accessibility = "profile-tab")
    @iOSXCUITFindBy(accessibility = "profile-tab")
    private MobileElement profileTab;
    /* Profile */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"SM\"]")
    private MobileElement editProfile;

    @AndroidFindBy(accessibility = "Save")
    @iOSXCUITFindBy(accessibility = "Save")
    private MobileElement saveButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    @iOSXCUITFindBy(className = "XCUIElementTypeImage")
    private MobileElement myCertificatesTab;
    @AndroidFindBy(className = "XCUIElementTypeOther")
    @iOSXCUITFindBy(className = "XCUIElementTypeOther")
    private MobileElement firstCertificate;
    @AndroidFindBy(accessibility = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private MobileElement logout;
    @AndroidFindBy(accessibility = "Sign Out")
    @iOSXCUITFindBy(accessibility = "Sign Out")
    private MobileElement signout;
    @AndroidFindBy(accessibility = "Cancel")
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement cancel;
    @AndroidFindBy(accessibility = "Enroll Now")
    @iOSXCUITFindBy(accessibility = "Enroll Now")
    private MobileElement enrollNowButton;
    @AndroidFindBy(accessibility = "Completed")
    @iOSXCUITFindBy(accessibility = "Completed")
    private MobileElement completedButton;
    @AndroidFindBy(accessibility = "Start Course")
    @iOSXCUITFindBy(accessibility = "Start Course")
    private MobileElement startCourseButton;
    @AndroidFindBy(accessibility = "Resume")
    @iOSXCUITFindBy(accessibility = "Resume")
    private MobileElement resumeButton;
    @AndroidFindBy(accessibility = "Next lesson")
    @iOSXCUITFindBy(accessibility = "Next lesson")
    private MobileElement nextLessonButton;
    @AndroidFindBy(accessibility = "Exit course")
    @iOSXCUITFindBy(accessibility = "Exit course")
    private MobileElement exitCourse;
    @AndroidFindBy(accessibility = "Take Assessment")
    @iOSXCUITFindBy(accessibility = "Take Assessment")
    private MobileElement takeAssessmentButton;
    @AndroidFindBy(accessibility = "Skip Assessment")
    @iOSXCUITFindBy(accessibility = "Skip Assessment")
    private MobileElement skipAssessmentButton;
    @AndroidFindBy(accessibility = "Skip")
    @iOSXCUITFindBy(accessibility = "Skip")
    private MobileElement skipButton;
    @AndroidFindBy(accessibility = "Attend later")
    @iOSXCUITFindBy(accessibility = "Attend later")
    private MobileElement attendLaterButton;
    @AndroidFindBy(accessibility = "Yes")
    @iOSXCUITFindBy(accessibility = "Yes")
    private MobileElement yesButton;
    @AndroidFindBy(accessibility = "No")
    @iOSXCUITFindBy(accessibility = "No")
    private MobileElement noButton;
    @AndroidFindBy(accessibility = "Complete Assessment")
    @iOSXCUITFindBy(accessibility = "Complete Assessment")
    private MobileElement completeAssessmentButton;
    @AndroidFindBy(accessibility = "Edit Answers")
    @iOSXCUITFindBy(accessibility = "Edit Answers")
    private MobileElement editAnswers;
    @AndroidFindBy(accessibility = "Submit")
    @iOSXCUITFindBy(accessibility = "Submit")
    private MobileElement submitButton;
    @AndroidFindBy(accessibility = "Complete")
    @iOSXCUITFindBy(accessibility = "Complete")
    private MobileElement completeButton;
    @AndroidFindBy(accessibility = "Complete Lesson")
    @iOSXCUITFindBy(accessibility = "Complete Lesson")
    private MobileElement completeLessonButton;
    @AndroidFindBy(accessibility = "Assessment summary")
    @iOSXCUITFindBy(accessibility = "Assessment summary")
    private MobileElement assessmentSummaryButton;
    @AndroidFindBy(accessibility = "Proceed")
    @iOSXCUITFindBy(accessibility = "Proceed")
    private MobileElement proceedButton;
    @AndroidFindBy(accessibility = "View Certificate")
    @iOSXCUITFindBy(accessibility = "View Certificate")
    private MobileElement viewCertificateButton;
    @AndroidFindBy(accessibility = "Download")
    @iOSXCUITFindBy(accessibility = "Download")
    private MobileElement downloadButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image")
    @iOSXCUITFindBy(accessibility = "Export as Image")
    private MobileElement downloadCertificateButton;
    @AndroidFindBy(accessibility = "Export as PDF")
    @iOSXCUITFindBy(xpath = "Export as PDF")
    private MobileElement certificateExportAsPDF;
    @AndroidFindBy(accessibility = "Export as Image")
    @iOSXCUITFindBy(accessibility = "Export as Image")
    private MobileElement certificateExportAsImage;
    @AndroidFindBy(id = "com.android.chrome:id/button_primary")
    private MobileElement downloadButtonChrome; // In-App browser
    @AndroidFindBy(accessibility = "Back to Course")
    @iOSXCUITFindBy(accessibility = "Back to Course")
    private MobileElement backToCourseButton;
    @AndroidFindBy(accessibility = "Back to courses")
    @iOSXCUITFindBy(accessibility = "Back to courses")
    private MobileElement backToCoursesButton;
    @AndroidFindBy(accessibility = "Go Back")
    @iOSXCUITFindBy(accessibility = "Go Back")
    private MobileElement goBackButton;

    public LoginPage clickSignInBtn() throws Exception {
        try {
            Thread.sleep(1000);
            wait.until(visibilityOfElementLocated(MobileBy.AccessibilityId("Sign In")));
            wait.until(elementToBeClickable(MobileBy.AccessibilityId("Sign In"))).click();
            utils.log().info("Clicked SignIn Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked SignIn Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click SignIn Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click SignIn Button");
            throw new Exception("Error: Unable to Click SignIn Button");
        }
        return this;
    }

    public LoginPage enterLoginEmail(String platformName, String username) throws Exception {
        By inputField;
        try {
            if(platformName.equals("iOS")) {
                inputField = By.className("XCUIElementTypeTextField");
            } else {
                inputField = By.className("android.widget.EditText");
            }
            getDriver().findElement(inputField).click();
            getDriver().findElement(inputField).clear();
            getDriver().getKeyboard().sendKeys(username);
            utils.log().info("Entered userName/Email: '" + username + "'");
            ExtentReport.getTest().log(Status.INFO, "Entered userName/Email: " + username + "'");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to enter login email");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to enter login email");
            throw new Exception("Error: Unable to enter login email");
        }
        return this;
    }

    public LoginPage enterLoginPassword(String platformName, String password) throws Exception {
        try {
            actionsObject = new Actions(getDriver());
            actionsObject.sendKeys(password);
            actionsObject.perform();
            utils.log().info("Entered Password: " + password + "'");
            ExtentReport.getTest().log(Status.INFO, "Entered Password: " + password + "'");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to enter login password");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to enter login password");
            throw new Exception("Error: Unable to enter login password");
        }
        return this;
    }

    public LoginPage clickShowPasswordButton() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("show").click();
            utils.log().info("Clicked Show Password Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked Show Password Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Show Password Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Show Password Button");
            throw new Exception("Error: Unable to Click on Show Password Button");
        }
        return this;
    }

    public LoginPage clickHidePasswordButton() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("hide").click();
            utils.log().info("Clicked Hide Password Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked Hide Password Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Hide Password Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Hide Password Button");
            throw new Exception("Error: Unable to Click on Hide Password Button");
        }
        return this;
    }

    public LoginPage clickForgotPassword() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Forgot Password?").click();
            utils.log().info("Clicked Forgot Password Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked Forgot Password Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Forgot Password Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Forgot Password Button");
            throw new Exception("Error: Unable to Click on Forgot Password Button");
        }
        return this;
    }

    public LoginPage clickContinue() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Continue").click();
            utils.log().info("Clicked Continue Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked Continue Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Continue Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Continue Button");
            throw new Exception("Error: Unable to Click on Continue Button");
        }
        return this;
    }

    public LoginPage navigateBack() throws Exception {
        try {
            click(backButton);
            utils.log().info("Clicked on Back Button Arrow");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Back Button Arrow");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Back Button Arrow");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Back Button Arrow");
            throw new Exception("Error: Unable to Click on Back Button Arrow");
        }
        return this;
    }

    public LoginPage clickBackButton() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Back").click();
            utils.log().info("Clicked on Back Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Back Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Back Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Back Button");
            throw new Exception("Error: Unable to Click on Back Button");
        }
        return this;
    }

    public LoginPage clickHomeTab() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("home-tab").click();
            utils.log().info("Clicked on Home Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Home Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Home Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Home Tab");
            throw new Exception("Error: Unable to Click on Home Tab");
        }
        return this;
    }

    public LoginPage clickSearchTab() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("search-tab").click();
            utils.log().info("Clicked on Search/Explore Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Search/Explore Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click Search/Explore Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click Search/Explore Tab");
            throw new Exception("Error: Unable to Click Search/Explore Tab");
        }
        return this;
    }

    public LoginPage clickNotificationTab() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("notifications-tab").click();
            utils.log().info("Clicked on Notification Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Notification Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click Notification Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click Notification Tab");
            throw new Exception("Error: Unable to Click Notification Tab");
        }
        return this;
    }

    public LoginPage clickMarkAllReadNotifications() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Mark all as read").click();
            utils.log().info("Clicked on \"Mark all Read\" Button in Notifications");
            ExtentReport.getTest().log(Status.INFO, "Clicked on \"Mark all Read\" Button in Notifications");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on \"Mark all Read\" Button in Notifications");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on \"Mark all Read\" Button in Notifications");
            throw new Exception("Error: Unable to Click on \"Mark all Read\" Button in Notifications");
        }
        return this;
    }

    public LoginPage clickProfileTab() throws Exception {
        try {
            /****/
            click(profileTab);
            utils.log().info("Switched to Profile Tab");
            ExtentReport.getTest().log(Status.INFO, "Switched to Profile Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Switch to Profile Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Switch to Profile Tab");
            throw new Exception("Error: Error: Unable to Switch to Profile Tab");
        }
        return this;
    }

    public LoginPage viewMyCertificates() throws Exception {
        try {
            click(myCertificatesTab);
            utils.log().info("Clicked on View My Certificates Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on View My Certificates Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click My Certificates Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click My Certificates Button");
            throw new Exception("Error: Unable to Click My Certificates Button");
        }
        return this;
    }

    public LoginPage clickOnFirstCertificate() throws Exception {
        try {
            click(firstCertificate);
            utils.log().info("Clicked on First Certificate");
            ExtentReport.getTest().log(Status.INFO, "Clicked on First Certificate");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on First Certificate");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on First Certificate");
            throw new Exception("Error: Unable to Click on First Certificate");
        }
        return this;
    }

    public LoginPage searchCourse(String platformName, String courseName) throws Exception {
        Thread.sleep(1000);
        By searchTextBox;
        try {
            if(platformName.equals("iOS")) {
                searchTextBox = By.xpath("(//XCUIElementTypeTextField)[1]");
            } else {
                searchTextBox = By.xpath("(//android.widget.ImageView)[1]");
            }
            getDriver().findElement(searchTextBox).click();
            getDriver().findElement(searchTextBox).clear();
            getDriver().getKeyboard().sendKeys(courseName);
            ExtentReport.getTest().log(Status.INFO, "Searched Course: '" + courseName + "'");
            getDriver().hideKeyboard();
            utils.log().info("Closed keyboard!");
            ExtentReport.getTest().log(Status.INFO, "Closed keyboard!");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Searching Course Failed!");
            ExtentReport.getTest().log(Status.INFO, "Error: Searching Course Failed!");
            throw new Exception("Error: Searching Course Failed!");
        }
        return this;
    }

    public LoginPage viewSpecificCourse(String courseName) throws Exception {
        try {
            getDriver().findElementByAccessibilityId(courseName).click();
            utils.log().info("Clicked on '" + courseName + "' Course");
            ExtentReport.getTest().log(Status.INFO, "Clicked on '" + courseName + "' Course");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on '" + courseName + "' Course");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on '" + courseName + "' Course");
            throw new Exception("Error: Unable to Click on '" + courseName + "' Course");
        }
        return this;
    }

    public LoginPage clickEnrollNow() throws Exception {
        try {
            click(enrollNowButton);
            utils.log().info("Clicked on Enroll Now Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Enroll Now Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Enroll Now Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Enroll Now Button");
            throw new Exception("Error: Unable to Click on Enroll Now Button");
        }
        return this;
    }

    public LoginPage clickCompletedButton() throws Exception {
        try {
            click(completedButton);
            utils.log().info("Clicked on Completed Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Completed Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Enroll Now Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Completed Button");
            throw new Exception("Error: Unable to Click on Completed Button");
        }
        return this;
    }

    public LoginPage clickStartCourse() throws Exception {
        try {
            click(startCourseButton);
            utils.log().info("Clicked on Start Course Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Start Course Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Start Course Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Start Course Button");
            throw new Exception("Error: Unable to Click on Start Course Button");
        }
        return this;
    }

    public LoginPage clickResumeButton() throws Exception {
        try {
            click(resumeButton);
            utils.log().info("Clicked on Resume Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Resume Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Resume Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Resume Button");
            throw new Exception("Error: Unable to Click on Resume Button");
        }
        return this;
    }

    public LoginPage clickNextLesson() throws Exception {
        try {
            Thread.sleep(1500);
            click(nextLessonButton);
            utils.log().info("Clicked on Next Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Next Lesson Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Next Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Next Lesson Button");
            throw new Exception("Error: Unable to Click on Next Lesson Button");
        }
        return this;
    }

    public LoginPage clickTakeAssessment() throws Exception {
        try {
            Thread.sleep(1500);
            //click(takeAssessmentButton);
            getDriver().findElementByAccessibilityId("Take Assessment").click();
            utils.log().info("Clicked on Take Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Take Assessment Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Take Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Take Assessment Button");
            throw new Exception("Error: Unable to Click on Take Assessment Button");
        }
        return this;
    }

    public LoginPage clickSkipAssessment() throws Exception {
        try {
            //click(skipAssessmentButton);
            getDriver().findElementByAccessibilityId("Skip Assessment").click();
            utils.log().info("Clicked on Skip Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Skip Assessment Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Skip Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Skip Assessment Button");
            throw new Exception("Error: Unable to Click on Skip Assessment Button");
        }
        return this;
    }

    public LoginPage clickSkipButton() throws Exception {
        try {
            click(skipButton);
            utils.log().info("Clicked on Skip Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Skip Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Skip Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Skip Button");
            throw new Exception("Error: Unable to Click on Skip Button");
        }
        return this;
    }

    public LoginPage clickAttendLater() throws Exception {
        try {
            // click(attendLaterButton);
            getDriver().findElementByAccessibilityId("Attend later").click();
            utils.log().info("Clicked on Attend Later Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Attend Later Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Attend Later Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Attend Later Button");
            throw new Exception("Error: Unable to click Attend Later Button");
        }
        return this;
    }

    public LoginPage clickYesButton() throws Exception {
        try {
            click(yesButton);
            utils.log().info("Clicked on Yes Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Yes Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Yes Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Yes Button");
            throw new Exception("Error: Unable to click Yes Button");
        }
        return this;
    }

    public LoginPage clickNoButton() throws Exception {
        try {
            click(noButton);
            utils.log().info("Clicked on No Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on No Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click No Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click No Button");
            throw new Exception("Error: Unable to click No Button");
        }
        return this;
    }

    public LoginPage clickCompleteAssessment() throws Exception {
        try {
            Thread.sleep(1500);
            // click(completeAssessmentButton);
            getDriver().findElementByAccessibilityId("Complete Assessment").click();
            utils.log().info("Clicked on Complete Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Complete Assessment Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Complete Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Complete Assessment Button");
            throw new Exception("Error: Unable to click Complete Assessment Button");
        }
        return this;
    }

    public LoginPage clickCompleteButton() throws Exception {
        try { /*Need to be removed*/
            click(completeButton);
            getDriver().findElementByAccessibilityId("Complete Lesson").click();
            utils.log().info("Clicked on Complete Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Complete Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Complete Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Complete Button");
            throw new Exception("Error: Unable to click Complete Button");
        }
        return this;
    }

    public LoginPage clickCompleteLessonButton() throws Exception {
        try {
            // click(completeLessonButton);
            getDriver().findElementByAccessibilityId("Complete Lesson").click();
            utils.log().info("Clicked on Complete Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Complete Lesson Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Complete Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Complete Lesson Button");
            throw new Exception("Error: Unable to click Complete Lesson Button");
        }
        return this;
    }

    public LoginPage selectOption(String option) throws Exception {
        try {
            getDriver().findElementByAccessibilityId(option).click();
            utils.log().info("Selected Option '" + option + "'");
            ExtentReport.getTest().log(Status.INFO, "Selected Option '" + option + "'");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click/select Option '" + option + "'");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click/select Option '" + option + "'");
            throw new Exception("Error: Unable to click/select Option '" + option + "'");
        }
        return this;
    }

    public LoginPage clickAttemptAssessmentAgainButton(String attemptNumber) throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Attempt again(" + attemptNumber + ")").click();
            utils.log().info("Attempt again(" + attemptNumber + ") Button");
            ExtentReport.getTest().log(Status.INFO, "Attempt again(" + attemptNumber + ") Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Attempt again(" + attemptNumber + ") Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Attempt again(" + attemptNumber + ") Button");
            throw new Exception("Error: Unable to click Attempt again(" + attemptNumber + ") Button");
        }
        return this;
    }

    public LoginPage clickAssessmentSummary() throws Exception {
        try {
            // click(assessmentSummaryButton);
            getDriver().findElementByAccessibilityId("Assessment summary").click();
            utils.log().info("Clicked on Assessment Summary Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Assessment Summary Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Assessment Summary Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Assessment Summary Button");
            throw new Exception("Error: Unable to click Assessment Summary Button");
        }
        return this;
    }

    public LoginPage clickProceed() throws Exception {
        try {
            // click(proceedButton);
            getDriver().findElementByAccessibilityId("Proceed").click();
            utils.log().info("Clicked on Proceed Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Proceed Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Proceed Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Proceed Button");
            throw new Exception("Error: Unable to click Proceed Button");
        }
        return this;
    }

    public LoginPage clickViewCertificate() throws Exception {
        try {
            // click(viewCertificateButton);
            getDriver().findElementByAccessibilityId("View Certificate").click();
            utils.log().info("Clicked on View Certificate Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on View Certificate Button");
            Thread.sleep(10000);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click View Certificate Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click View Certificate Button");
            throw new Exception("Error: Unable to click View Certificate Button");
        }
        return this;
    }

    public LoginPage clickDownloadButton() throws Exception {
        try {
            click(downloadButton);
            utils.log().info("Clicked on Download Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Download Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Download Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Download Button");
            throw new Exception("Error: Unable to click Download Button");
        }
        return this;
    }

    public LoginPage downloadCertificateButton() throws Exception {
        try {
            click(downloadCertificateButton);
            utils.log().info("Clicked on Download Certificate Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Download Certificate Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Download Certificate Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Download Certificate Button");
            throw new Exception("Error: Unable to click Download Certificate Button");
        }
        return this;
    }

    public LoginPage downloadCertificateImage() throws Exception {
        try {
            downloadCertificateButton();
            // click(certificateExportAsImage);
            getDriver().findElementByAccessibilityId("Export as Image").click();
            utils.log().info("Clicked on Export as Image Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Export as Image Button");
            isFileAlreadyPresent();
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Export as Image Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Export as Image Button");
            throw new Exception("Error: Unable to click Export as Image Button");
        }
        return this;
    }

    public LoginPage downloadCertificatePDF() throws Exception {
        try {
            downloadCertificateButton();
            // click(certificateExportAsPDF);
            getDriver().findElementByAccessibilityId("Export as PDF").click();
            utils.log().info("Clicked on Export as PDF Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Export as PDF Button");
            isFileAlreadyPresent();
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Export as PDF Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Export as PDF Button");
            throw new Exception("Error: Unable to click Export as PDF Button");
        }
        return this;
    }

    public boolean isFileAlreadyPresent() throws Exception {
        try {
            if(getDriver().findElementsById("com.android.chrome:id/button_primary").size() > 0) {
                click(downloadButtonChrome);
                utils.log().info("Clicked on Download Button");
                ExtentReport.getTest().log(Status.INFO, "Clicked on Download Button");
                utils.log().info("This file with same name is already present in downloads, Downloaded Again");
                ExtentReport.getTest().log(Status.INFO, "This file with same name is already present in downloads, Downloaded Again");
                return true;
            } else {
                utils.log().info("File is Downloaded Successfully!");
                ExtentReport.getTest().log(Status.INFO, "File is Downloaded Successfully!");
                return false;
            }
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Download Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Download Button");
            throw new Exception("Error: Unable to click Download Button");
        }
    }

    public LoginPage clickBackToCourseButton() throws Exception {
        try {
            // click(backToCourseButton);
            getDriver().findElementByAccessibilityId("Back to Course").click();
            utils.log().info("Clicked on Back to Course Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Back to Course Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Back to Course Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Back to Course Button");
            throw new Exception("Error: Unable to click Back to Course Button");
        }
        return this;
    }

    public LoginPage clickBackToCoursesButton() throws Exception {
        try {
            click(backToCoursesButton);
            utils.log().info("Clicked on Back to courses Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Back to courses Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Back to courses Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Back to courses Button");
            throw new Exception("Error: Unable to click Back to courses Button");
        }
        return this;
    }

    public LoginPage pressBackButtonFromMobile() throws Exception {
        try {
            getDriver().navigate().back();
            utils.log().info("Clicked Back Button from Mobile");
            ExtentReport.getTest().log(Status.INFO, "Clicked Back Button from Mobile");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click Back Button from Mobile");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click Back Button from Mobile");
            throw new Exception("Error: Unable to Click Back Button from Mobile");
        }
        return this;
    }

    public LoginPage clickGoBackButton() throws Exception {
        try {
            click(goBackButton);
            utils.log().info("Clicked Go Back Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked Go Back Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Go Back Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Go Back Button");
            throw new Exception("Error: Unable to click Go Back Button");
        }
        return this;
    }

    /*****************
     Validations
     *****************/

    public boolean validateNotificationTab() throws Exception {
        utils.log().info("Validating Notifications Tab");
        ExtentReport.getTest().log(Status.INFO, "Validating Notifications Tab");
        if(getDriver().findElementsByAccessibilityId("Notifications").size() > 0) {
            utils.log().info("Validated Notification Tab");
            ExtentReport.getTest().log(Status.INFO, "Validated Notification Tab");
            return true;
        }
        utils.log().info("Error: Unable to Validated Notification Tab, You're not on Notifications Tab");
        ExtentReport.getTest().log(Status.INFO, "Error: Unable to Validated Notification Tab, You're not on Notifications Tab");
        return false;
    }

    public boolean validateAssessmentStatus() throws Exception {
        utils.log().info("Validating Assessment Status");
        ExtentReport.getTest().log(Status.INFO, "Validating Assessment Status");
        if(getDriver().findElementsByAccessibilityId("Awesome!!!!!").size() > 0) {
            // Congratulations!! You have passed the assessment. Your Certificate is awaiting!!!
            utils.log().info("Required Assessment Status(Pass) validated Successfully!");
            ExtentReport.getTest().log(Status.INFO, "Required Assessment Status(Pass) validated Successfully!");
            return true;
        } else if(getDriver().findElementsByAccessibilityId("Uhoh!! You didn't pass").size() > 0) {
            utils.log().info("Required Assessment Status(Fail) validated Successfully!");
            ExtentReport.getTest().log(Status.INFO, "Required Assessment Status(Fail) validated Successfully!");
            return false;
        } else {
            utils.log().info("Error: Something went wrong while validating Assessment Status!");
            ExtentReport.getTest().log(Status.INFO, "Error: Something went wrong while validating Assessment Status!");
            return false;
        }
    }

    public boolean isNoResultFound() throws Exception {
        utils.log().info("Validating Empty State Container");
        ExtentReport.getTest().log(Status.INFO, "Validating Empty State Container");
        if(getDriver().findElementsByAccessibilityId("Uh oh!! We searched the whole space but couldn't find it").size() > 0) {
            utils.log().info("No Result Found");
            ExtentReport.getTest().log(Status.INFO, "No Result Found");
            return true;
        }
        utils.log().info("Result Found");
        ExtentReport.getTest().log(Status.INFO, "Result Found");
        return false;
    }

    public boolean isCompletedButtonPresent() throws Exception {
        utils.log().info("Validating Completed Button");
        ExtentReport.getTest().log(Status.INFO, "Validating Completed Button");
        if(getDriver().findElementsByAccessibilityId("Completed").size() > 0) {
            utils.log().info("Completed Button Present");
            ExtentReport.getTest().log(Status.INFO, "Completed Button Present");
            return true;
        }
        utils.log().info("Completed Button Not Present");
        ExtentReport.getTest().log(Status.INFO, "Completed Button Not Present");
        return false;
    }

    public boolean isCertificateTabPresent() throws Exception {
        utils.log().info("Validating Certificate Tab");
        ExtentReport.getTest().log(Status.INFO, "Validating Certificate Tab");
        // Alternate Approach: '//android.view.View[@content-desc[contains(., 'Certificate')]]")).size() == 2'
        if(getDriver().findElementsByAccessibilityId(("Certificate")).size() > 0) {
            utils.log().info("Certificate Tab Present");
            ExtentReport.getTest().log(Status.INFO, "Certificate Tab Present");
            return true;
        }
        utils.log().info("Certificate Tab Not Present");
        ExtentReport.getTest().log(Status.INFO, "Certificate Tab Not Present");
        return false;
    }

    public boolean isCertificateAvailable(String platformName) throws Exception {
        utils.log().info("Validating Certificate");
        ExtentReport.getTest().log(Status.INFO, "Validating Certificate");
        /****/ // Should optimized
        By cert_issued;
        if(platformName.equals("iOS")) {
            // iOS
            cert_issued = By.xpath("//XCUIElementTypeStaticText[@name[contains(., 'CERTIFICATE OF COMPLETION')]]");
        } else {
            // Android
            cert_issued = By.xpath("//android.view.View[@content-desc[contains(., 'CERTIFICATE OF COMPLETION')]]");
        }
        if(getDriver().findElements(cert_issued).size() > 0) {
            utils.log().info("Certificate is Available");
            ExtentReport.getTest().log(Status.INFO, "Certificate is Available");
            return true;
        }
        utils.log().info("Certificate is Not Available");
        ExtentReport.getTest().log(Status.INFO, "Certificate is Not Available");
        return false;
    }

    public LoginPage terminateApp(String platformName) throws Exception {
        Thread.sleep(2000);
        JSONObject deviceData = JsonParser.getDevicesData(platformName);
        getDriver().terminateApp(deviceData.get("appPackage").toString());
        //closeApp();
        utils.log().info("Terminated the App");
        ExtentReport.getTest().log(Status.INFO, "Terminated the App");
        return this;
    }

    /*****************
     Actions
     *****************/

    public LoginPage tap() throws Exception {
        // Similar to Click
        TouchAction action = new TouchAction(getDriver());
        action.tap(ElementOption.element(getDriver().findElementByAccessibilityId("Enroll now"))).perform();
        utils.log().info("");
        ExtentReport.getTest().log(Status.INFO, "");
        return this;
    }

    public LoginPage press() throws Exception {
        // Similar to Click
        TouchAction action = new TouchAction(getDriver());
        action.press(ElementOption.element(getDriver().findElementByAccessibilityId(""))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();
        utils.log().info("");
        ExtentReport.getTest().log(Status.INFO, "");
        return this;
    }

    public LoginPage longPress() throws Exception {
        TouchAction action = new TouchAction(getDriver());
        action.longPress(ElementOption.element(getDriver().findElementByAccessibilityId(""))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10000))).release().perform();
        utils.log().info("");
        ExtentReport.getTest().log(Status.INFO, "");
        return this;
    }

    public LoginPage tapAtSpecificPosition() {
        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.tap(PointOption.point(0, 800)).perform();
        return this;
    }

    public LoginPage checkMobileNotifications() throws Exception {
        TouchAction action = new TouchAction(getDriver());
        Dimension size = getDriver().manage().window().getSize();
        size.getHeight();
        size.getWidth();
        System.out.println("Height of the screen: " + getDriver().manage().window().getSize().getHeight());
        System.out.println("Width of the screen: " + getDriver().manage().window().getSize().getWidth());
        // Drag from Top-Bottom
        action.press(PointOption.point(10, 10)).waitAction(waitOptions(Duration.ofMillis(1200))).moveTo(PointOption.point(900, 900)).release().perform();
        Thread.sleep(5000);
        // Drag from Bottom-Top
        action.press(PointOption.point(900, 900)).waitAction(waitOptions(Duration.ofMillis(1200))).moveTo(PointOption.point(10, 10)).release().perform();
        return this;
    }

    public LoginPage scrollDown() throws Exception {
        /*
            xOffset = startScrollingFromX
            yOffset = startScrollingFromY

            Same x,y points are required for end_points(on x_y axis plane)
        */
        // Consider Exception: The swipe action is based on device screen ratio/width which is a dependency(differs device-to-device)
        TouchAction action = new TouchAction(getDriver());
        // Swiping Up(through fingers)
        action.press(PointOption.point(0, 400)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, 100)).release().perform();
        action.press(PointOption.point(0, 400)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, 100)).release().perform();
        utils.log().info("Screen Scrolled Down");
        ExtentReport.getTest().log(Status.INFO, "Screen Scrolled Down");
        return this;
    }

    public LoginPage scrollUp() throws Exception {
        // Consider Exception: The swipe action is based on device screen ratio/width which is a dependency(differs device-to-device)
        // Swiping Down(through fingers)
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(0, 200)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, 500)).release().perform();
        action.press(PointOption.point(0, 200)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, 500)).release().perform();
        utils.log().info("Screen Scrolled Up");
        ExtentReport.getTest().log(Status.INFO, "Screen Scrolled Up");
        return this;
    }

    // Toasters
    public LoginPage getToasterMessage() throws Exception {
        String message = "";
        utils.log().info("Toaster Message Captured: " + message);
        ExtentReport.getTest().log(Status.INFO, "Toaster Message Captured: " + message);
        return this;
    }

    public LoginPage clickEditProfile() {
        click(editProfile);
        return this;
    }

    public LoginPage clickLogout() {
        click(logout);
        return this;
    }

    public LoginPage clickSignOutBtn() {
        click(signout);
        return this;
    }

    /********************************************* Debugging Methods ********************************************/

    public LoginPage bedug() throws Exception {
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(0, 800)).waitAction(waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(0, 200)).release().perform();
        Thread.sleep(5000);
        return this;
    }

    public LoginPage touches() {
        TouchAction touchAction = new TouchAction(getDriver());
        //touchAction.longPress();
        //touchAction.moveTo();
        //touchAction.cancel();
        //touchAction.perform().longPress();
        touchAction.tap(PointOption.point(1280, 1013)).perform();
        return this;
    }

    public LoginPage swipe() {
        TouchAction swipe = new TouchAction(getDriver()).press(PointOption.point(972, 500)).waitAction(waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(108, 500)).release().perform();
        return this;
    }

    public LoginPage multiTouches() {
        // Multiple touches at a time
        TouchAction touchActionOne = new TouchAction(getDriver());
        touchActionOne.press(PointOption.point(100, 100));
        touchActionOne.release();
        TouchAction touchActionTwo = new TouchAction(getDriver());
        touchActionTwo.press(PointOption.point(200, 200));
        touchActionTwo.release();
        MultiTouchAction action = new MultiTouchAction(getDriver());
        action.add(touchActionOne);
        action.add(touchActionTwo);
        action.perform();
        // perform multi touch on particular elements
        TouchAction touchAction1 = new TouchAction(getDriver()).tap(ElementOption.element(getDriver().findElementByAccessibilityId("Sign In"))).release();
        TouchAction touchAction2 = new TouchAction(getDriver()).tap(ElementOption.element(getDriver().findElementByAccessibilityId("Sign In"))).release();
        MultiTouchAction action1 = new MultiTouchAction(getDriver());
        action1.add(touchAction1);
        action1.add(touchAction2);
        action1.perform();
        return this;
    }

    public MobileElement scrollToElement(String elementName) {
        return (MobileElement) ((FindsByAndroidUIAutomator) getDriver()).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView(" + "new UiSelector().description(" + elementName + "));");
    }

    public void scrollToElement2(String elementName) {
        RemoteWebElement element = (RemoteWebElement) getDriver().findElement(By.name(elementName));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("direction", "down");
        scrollObject.put("predicateString", "label == 'certificate'");
        scrollObject.put("name", "certificate");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        getDriver().executeScript("mobile:scroll", scrollObject);
    }
}
