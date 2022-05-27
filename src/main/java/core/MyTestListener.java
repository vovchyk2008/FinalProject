package core;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class MyTestListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult test){
    log.info("Test {} starting...", test.getName());
  }

  @Override
  public void onTestFailure(ITestResult test){
    ScreenShotter.takeScreenShot(test.getName());
  }
}