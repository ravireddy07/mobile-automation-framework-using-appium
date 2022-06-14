package ravireddy07.com.github.testcases.Notifications;

import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.pages.LoginPage;
import org.testng.annotations.Test;

public class notifications extends BaseTest {

    @Test(enabled = false)
    public void validateNotifications() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("", "auzmor@zetmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("", "Test@123");
        loginPage.clickShowPasswordButton();
        loginPage.clickHidePasswordButton();
        loginPage.clickForgotPassword();
        loginPage.clickContinue();
        Thread.sleep(5000);
        loginPage.clickNotificationTab();
        loginPage.validateNotificationTab();
        loginPage.clickMarkAllReadNotifications();
        // validate toasters
    }
}
