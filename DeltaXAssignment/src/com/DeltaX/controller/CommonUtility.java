package com.DeltaX.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonUtility {

	public static WebDriver driver;
	public static String driverName;
	public static String screenShotFolderName;
	public static DateFormat sdf;
	 public static String testCaseId;
    public static  Properties driverProperties=new Properties();
    public static  String excelPath=".//TestData//TestData.xlsx";

	public  static void CommonUtility()  {
	    sdf = new SimpleDateFormat("yyyy-MM-dd");
		screenShotFolderName=String.valueOf(sdf.format(new Date()));
		try {
			driverProperties.load(new FileInputStream(new File(".//Properties//Selenium.Properties")));
		
		driverName=driverProperties.getProperty("DriverName");
		
		if (driverName.equals("ChromeDriver")) {
			System.setProperty("webdriver.chrome.driver",".//Driver//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (driverName.equals("FireFoxDriver")) {
			System.setProperty("webdriver.gecko.driver",".//Driver//chromedriver.exe");
			driver = new FirefoxDriver();
		}
	      else if (driverName.equals("IEDriver")) {
		     System.setProperty("webdriver.ie.driver",".//Driver//IEDriverServer.exe");
		     driver = new InternetExplorerDriver();
	    }
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://adjiva.com/qa-test/");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
