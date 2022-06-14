package ravireddy07.com.github.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;

public class httpHelper {
    static String userName = "oauth-gojur.ravikanth-77299"; // BS: "gowthamrupavatha1"
    static String accessKey = "2f1b6b64-c96a-4242-979b-42c6516c21d8"; // BS: "3UGtjcGp8xF9psSmSfnY"

    // BrowserStack
    public static String uploadAppBS(String filePath) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api-cloud.browserstack.com/app-automate/upload").header("Authorization", "Basic Z293dGhhbXJ1cGF2YXRoYTE6M1VHdGpjR3A4eEY5cHNTbVNmblk=").field("file", new File(filePath)).asString();
        return response.getBody();
    }

    // sauceLabs
    public static String uploadApp(String filePath) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api.eu-central-1.saucelabs.com/v1/storage/upload").basicAuth(userName, accessKey).field("upload", new File(filePath)).asString();
        return response.getBody();
    }
}
