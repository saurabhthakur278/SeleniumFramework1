package saurabhthakur.testcomponent;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import saurabhthakur.resourses.Extentreporter;

public class Listener extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent=Extentreporter.getreportobject();
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
	 test=extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

   test.log(Status.PASS, "test is passedd");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
//screenshot
	
		 test.fail(result.getThrowable());
		 
		 
		 
		try {
			String filepath = ScreenshotDemo(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filepath = null;
		 
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {


		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


		
	}

	@Override
	public void onStart(ITestContext context) {


		
	}

	@Override
	public void onFinish(ITestContext context) {

extent.flush();
		
	}

}
