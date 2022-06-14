package ravireddy07.com.github;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.aventstack.extentreports.Status;
import ravireddy07.com.github.reports.ExtentReport;
import ravireddy07.com.github.utils.JsonParser;
import ravireddy07.com.github.utils.StringParser;
import ravireddy07.com.github.utils.TestUtils;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@SuppressWarnings({"WeakerAccess", "unused"})
public class BaseTest {
    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    protected static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
    protected static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    protected static ThreadLocal<String> platform = new ThreadLocal<String>();
    protected static ThreadLocal<String> dateTime = new ThreadLocal<String>();
    protected static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static AppiumDriverLocalService server;
    TestUtils utils = new TestUtils();

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public Properties getProps() {
        return props.get();
    }

    public void setProps(Properties props2) {
        props.set(props2);
    }

    public HashMap<String, String> getString() {
        return strings.get();
    }

    public void setStrings(HashMap<String, String> strings2) {
        strings.set(strings2);
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public void setDateTime(String dateTime2) {
        dateTime.set(dateTime2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    @Parameters({"envID"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String envID) throws Exception {
        if(envID.equals("local")) {
            ThreadContext.put("ROUTINGKEY", "ServerLogs"); // Appium Server Logs
            server = getAppiumService("Mac OS X"); // Need to provide the OS. Windows or Mac
            if(!checkIfAppiumServerIsRunnning(4723)) {
                server.start();
                server.clearOutPutStreams();
                utils.log().info("Appium server started");
            }
            utils.log().info("'beforeSuite' Executed for Local");
        } else {
            utils.log().info("'beforeSuite' Executed for Remote");
        }
    }

    @Parameters({"envID"})
    @AfterSuite(alwaysRun = true)
    public void afterSuite(@Optional String envID) {
        if(envID.equals("local")) {
            server.stop();
            utils.log().info("'afterSuite' Executed for Local");
        } else {
            utils.log().info("'afterSuite' Executed for Remote");
        }
    }

    public AppiumDriverLocalService getAppiumService(String platform) throws Exception {
        /****/ //requirement here..?
        HashMap<String, String> environment = new HashMap<String, String>();
        switch(platform) {
            case "Windows": {
                environment.put("PATH", "C:\\Users\\New User\\AppData\\Local\\Android\\Sdk:-:-" + System.getenv("PATH"));
                environment.put("ANDROID_HOME", "C:\\Users\\New User\\AppData\\Local\\Android\\Sdk");
                return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).withAppiumJS(new File("C:\\Users\\New User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).usingPort(4723).withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment).withLogFile(new File("ServerLogs/server.log")));
            }
            case "Mac OS X": {
                environment.put("PATH", "/Library/Java/JavaVirtualMachines/jdk1.8.0_321.jdk/Contents/Home/bin:/Users/harry/Library/Android/sdk/tools:/Users/harry/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/munki:/Library/Apple/usr/bin" + System.getenv("PATH"));
                environment.put("ANDROID_HOME", "/Users/harry/Library/Android/sdk");
                environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk1.8.0_321.jdk/Contents/Home");
                return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node")).withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).usingPort(4723).withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment).withLogFile(new File("ServerLogs/server.log")));
            }
            default: {
                utils.log().info("Something wrong with 'getAppiumService()'");
                throw new Exception("Something wrong with 'getAppiumService()'");
            }
        }
    }

    public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
        boolean isAppiumServerRunning = false;
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            socket.close();
        } catch(IOException e) {
            utils.log().info("Appium Server is Running!");
            isAppiumServerRunning = true;
        } finally {
            socket = null;
        }
        return isAppiumServerRunning;
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    @Parameters({"platformName"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional String platformName) throws Exception {
        try {
            JSONObject deviceData = JsonParser.getDevicesData(platformName);
            // Logs Initialization
            setupCustomLogs(platformName, deviceData.get("deviceName").toString());
            utils.log().info("'beforeTest' Executed for Local");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Parameters({"envID"})
    @AfterTest(alwaysRun = true)
    public void quit(@Optional String envID) {
        if(envID.equals("local")) {
            utils.log().info("'afterTest' Executed for Local");
        } else {
            utils.log().info("'afterTest' Executed for Remote");
        }
    }

    @Parameters({"envID"})
    @BeforeClass
    public void beforeClass(String envID) throws Exception {
        InputStream datais = null;
        try {
            /****/ // Action required(Optimize)
            String dataFileName = "data/loginData.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener token = new JSONTokener(datais);
            JSONObject loginUsers = new JSONObject(token);
            HashMap<String, String> testData = StringParser.parseStringXML("strings/TestDataValidation.xml");
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(datais != null) {
                datais.close();
            }
        }
        if(envID.equals("local")) {
            utils.log().info("'beforeClass' Executed for Local");
        } else {
            utils.log().info("'beforeClass' Executed for Remote");
        }
    }

    @Parameters({"envID"})
    @AfterClass
    public void afterClass(String envID) {
        if(envID.equals("local")) {
            utils.log().info("'afterClass' Executed for Local");
        } else {
            utils.log().info("'afterClass' Executed for Remote");
        }
    }

    @Parameters({"envID", "platformName"})
    @BeforeMethod
    public void beforeMethod(String envID, String platformName) throws Exception {
        // Driver Initialization
        DriverManager objDriver = new DriverManager();
        objDriver.initializeDriver(envID, platformName);
        launchApp();
        if(envID.equals("local")) {
            ((CanRecordScreen) getDriver()).startRecordingScreen();
            utils.log().info("Recording has been Started for this Test-Case:");
            utils.log().info("'beforeMethod' Executed for Local");
        } else {
            utils.log().info("'beforeMethod' Executed for Remote");
        }
    }

    @Parameters({"envID", "platformName"})
    @AfterMethod
    public synchronized void afterMethod(ITestResult result, String envID, String platformName) throws Exception {
        if(envID.equals("local")) {
            FileOutputStream testcaseVideOutputStream;
            JSONObject deviceData = JsonParser.getDevicesData(platformName);
            String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
            String dir = "videos" + File.separator + platformName + "_" + deviceData.get("OSVersion").toString() + "_" + deviceData.get("deviceName").toString() + File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
            File videoDir = new File(dir);
            synchronized(videoDir) {
                if(!videoDir.exists()) {
                    videoDir.mkdirs();
                }
            }
            testcaseVideOutputStream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
            testcaseVideOutputStream.write(Base64.decodeBase64(media));
            testcaseVideOutputStream.close();
            utils.log().info("Saved the Testcase Recording at '" + videoDir + File.separator + result.getName() + ".mp4'");
            // Closing App Session
            closeApp();
            if(getDriver() != null) {
                getDriver().quit();
            }
            utils.log().info("'afterMethod' Executed for Local");
        } else {
            utils.log().info("'afterMethod' Executed for Remote");
        }
    }

    public void getSessionDetails(AppiumDriver driver) {
        Map<String, Object> sessionDetails = driver.getSessionDetails();
        utils.log().info("----------------------- Getting Session Logs -----------------------");
        sessionDetails.forEach((key, value) -> utils.log().info(key + ": '" + value + "'"));
        utils.log().info("------------------------------- Logs -------------------------------");
    }

    public void launchApp() {
        utils.log().info("Launching Application...");
        getDriver().launchApp();
    }

    public void closeApp() {
        utils.log().info("Application Closed!");
        getDriver().closeApp();
    }

    public void updateTestcaseStatus(boolean status) {
        JavascriptExecutor object = (JavascriptExecutor) getDriver();
        object.executeScript("browserstack_executor: {'action': 'setSessionStatus', 'arguments': {'status': " + ((status) ? "passed" : "failed") + ", 'reason': 'Title matched!'}}");
        utils.log().info("Testcase Status marked as '" + status + "'");
    }

    public void setupCustomLogs(String platformName, String deviceName) {
        // Setting Custom logs
        String logFilePath = "logs" + File.separator + platformName + "_" + deviceName;
        File logFile = new File(logFilePath);
        if(!logFile.exists()) {
            logFile.mkdirs();
        }
        ThreadContext.put("ROUTINGKEY", logFilePath);
        utils.log().info("Log(s) for this Run is initiated at: " + logFilePath);
    }

    public void iOSPermissions() throws Exception {
        try {
            /****/ // Update
            waitForVisibility((MobileElement) getDriver().findElement(By.name("Allow Access to All Photos")));
            getDriver().findElement(By.name("Allow Access to All Photos")).click();
            utils.log().info("'Allow Access to All Photos' Permission allowed Successfully");
            ExtentReport.getTest().log(Status.INFO, "'Allow Access to All Photos' Permission allowed Successfully");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to 'Allow Access to All Photos' Permission");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to 'Allow Access to All Photos' Permission");
            throw new Exception("Error: Unable to 'Allow Access to All Photos' Permission!");
        }
    }

    // Debug Methods

    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.clear();
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt = null;
        System.out.println("Platform Name: " + getPlatform());
        switch(getPlatform()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
        }
        utils.log().info(msg + txt);
        ExtentReport.getTest().log(Status.INFO, msg + txt);
        return txt;
    }

    public void OpenAppWithDeepLinks(String url) {
        switch(Objects.requireNonNull(getDriver().getPlatformName())) {
            case "Android":
                HashMap<String, String> deepUrl = new HashMap<>();
                deepUrl.put("url", url);
                deepUrl.put("package", "com.swaglabsmobileapp");
                getDriver().executeScript("mobile: deepLink", deepUrl);
                break;
            case "iOS":
                By urlBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'URL'");
                By urlFld = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' && name CONTAINS 'URL'");
                By openBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'Open'");
                getDriver().activateApp("com.apple.mobilesafari");
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                wait.until(visibilityOfElementLocated(urlBtn)).click();
                wait.until(visibilityOfElementLocated(urlFld)).sendKeys("" + url + "\uE007");
                wait.until(visibilityOfElementLocated(openBtn)).click();
                break;
        }
    }
}
