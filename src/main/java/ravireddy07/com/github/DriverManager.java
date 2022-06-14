package ravireddy07.com.github;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import ravireddy07.com.github.utils.JsonParser;

import io.appium.java_client.android.AndroidElement;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings({"WeakerAccess", "unused"})
public class DriverManager extends BaseTest {
    public void initializeDriver(String envID, String platformName) throws Exception {
        try {
            AppiumDriver<AndroidElement> driver;
            URL launchURL;
            Properties objProperties = new Properties();

            //  Reading Data
            JSONObject deviceData = JsonParser.getDevicesData(platformName);
            objProperties.load((InputStream) getClass().getClassLoader().getResourceAsStream((String) "config.properties"));
            setProps(objProperties);

            setPlatform(platformName);
            setDeviceName(deviceData.get("deviceName").toString());
            setDateTime(utils.dateTime());

            // App(.apk or .ipa) Location for Local Execution
            String app = (System.getProperty("user.dir") + File.separator + deviceData.get("app").toString()).replace("\\", "/");

            // SauceLabs/BrowserStack Keys
            String userName = objProperties.getProperty("browserStackUserName"); // sauceLabsUserName/browserStackUserName
            String accessKey = objProperties.getProperty("browserStackAccessKey"); // sauceLabsAccessKey/browserStackAccessKey

            // Driver Launch URL
            if(envID.equals("local")) {
                launchURL = new URL(objProperties.getProperty("appiumURL"));
            } else {
                //launchURL = new URL("https://" + userName + ":" + accessKey + (String) objProperties.getProperty("sauceLabsURL"));
                launchURL = new URL("https://" + userName + ":" + accessKey + (String) objProperties.getProperty("browserStackURL"));
            }

            // Capabilities
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            desiredCapabilities.setCapability("build", platformName + " " + deviceData.get("build").toString());
            desiredCapabilities.setCapability("name", "Testing");
            desiredCapabilities.setCapability("appPackage", objProperties.getProperty("appPackage"));
            desiredCapabilities.setCapability("appActivity", objProperties.getProperty("appActivity"));
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("autoAcceptAlerts", true);
            desiredCapabilities.setCapability("waitForIdleTimeout", 0);
            // desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            // desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);
            // desiredCapabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

            if(envID.equals("remote")) {
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceData.get("cloudDeviceName").toString());
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceData.get("cloudOSVersion").toString());
                desiredCapabilities.setCapability(MobileCapabilityType.APP, deviceData.get("browserStackAppID").toString());
            } else {
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceData.get("deviceName").toString());
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceData.get("OSVersion").toString());
                desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            }

            switch(platformName) {
                case "Android":
                    desiredCapabilities.setCapability(MobileCapabilityType.UDID, objProperties.getProperty("androidEmulatorUDID"));
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    driver = new AndroidDriver<>(launchURL, desiredCapabilities);
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    break;
                case "iOS":
                    desiredCapabilities.setCapability(MobileCapabilityType.UDID, objProperties.getProperty("iOSSimulatorUDID"));
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    driver = new IOSDriver<>(launchURL, desiredCapabilities);
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    break;
                default:
                    throw new IllegalStateException("Invalid Platform id" + platformName);
            }
            setDriver(driver);
            getSessionDetails(driver);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
