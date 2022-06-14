package ravireddy07.com.github.utils;

import org.json.simple.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

public class JsonParser {
    public static JSONObject parse(String file) {
        InputStream is = JsonParser.class.getClassLoader().getResourceAsStream(file);
        assert is != null;
        return new JSONObject(new JSONTokener(is));
    }

    // Reading Test Case ID's(testCaseID.json)
    public static JSONObject GetTestCaseId(String module) {
        try {
            String jsonFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "data" + File.separator + "testCaseID.json";
            org.json.simple.JSONObject jsonData = (org.json.simple.JSONObject) new JSONParser().parse(new FileReader(jsonFile));
            org.json.simple.JSONObject moduleData = (org.json.simple.JSONObject) jsonData.get(module.toString());
            // Selecting Users
            JSONObject userTC = (JSONObject) moduleData.get("Learner");
            return userTC; // returns json_array of that specified user
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getTestData() {
        return (JSONObject) JsonParser.parse("data/testData.json");
    }

    public static JSONObject getLoginData() {
        return (JSONObject) JsonParser.parse("data/loginData.json");
    }

    public static JSONObject getDevicesData(String platformName) {
        return new JSONObject(JsonParser.parse("data/devicesData.json").getJSONObject(platformName).toString());
    }
}
