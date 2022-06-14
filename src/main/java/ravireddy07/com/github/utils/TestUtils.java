package ravireddy07.com.github.utils;

import ravireddy07.com.github.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings({"WeakerAccess", "unused"})
public class TestUtils {

    public String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd-HH-mm-ss
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void log(String txt) {
        BaseTest base = new BaseTest();
        String msg = Thread.currentThread().getId() + ":" + base.getPlatform() + ":" + base.getDeviceName() + ":" + Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;
        String strFile = "logs" + File.separator + base.getPlatform() + "_" + base.getDeviceName() + File.separator + base.getDateTime();

        File logFile = new File(strFile);
        if(!logFile.exists()) {
            logFile.mkdirs();
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(logFile + File.separator + "log.txt", true);
        } catch(IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(msg);
        printWriter.close();
    }

    public static Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }

    public static String sendPostRequest(String requestUrl, String payload) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Authorization", "Basic Z29qdXIucmF2aWthbnRoQGFtZXJpY2FuLXRlY2hub2xvZ3kubmV0OkhhcnJ5JDE0Mw==");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
            writer.write(payload);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            return jsonString.toString();
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void updateTestRailResult(boolean result, String testCaseName, String module) throws Exception {
        String testCaseId = "";
        boolean flag = false;
        String runId = "190";
        try {
            if(flag) {
                JSONObject getUserTCs = JsonParser.GetTestCaseId(module);
                testCaseId = getUserTCs.get(testCaseName).toString();
                String payload = (result) ? ("{\"status_id\":\"1\"}") : ("{\"status_id\":\"5\"}");
                String requestUrl = "https://auzmorhr.testrail.io/index.php?/api/v2/add_result_for_case/" + runId + "/" + testCaseId;
                sendPostRequest(requestUrl, payload);
            }
            if(result)
                System.out.println("TestCase: " + testCaseId + " Passed");
            else
                System.out.println("TestCase: " + testCaseId + " Failed");
            /****/ // Logs Required
        } catch(Exception e) {
            e.printStackTrace();
            throw new Exception("Something Wrong with Testcase name in Json(TestcaseID) file, Check & Try again");
        }
    }
}
