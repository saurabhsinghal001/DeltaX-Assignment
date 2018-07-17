package com.DeltaX.Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.DeltaX.controller.CommonUtility;

public class TestListeners extends CommonUtility implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Successful");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed");
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(srcfile, new File(".//ScreenShots//"+screenShotFolderName+"//"+testCaseId+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
