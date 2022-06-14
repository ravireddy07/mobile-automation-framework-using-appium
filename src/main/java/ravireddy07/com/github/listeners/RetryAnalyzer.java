package ravireddy07.com.github.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int currentCount = 0;
    int maxRetryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        while(currentCount < maxRetryCount) {
            ++currentCount;
            return true;
        }
        return false;
    }
}
