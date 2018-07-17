package com.DeltaX.TestUtility;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DeltaX.ExcelUtility.ReadExcel;
import com.DeltaX.PageUtility.RegistrationPage;
import com.DeltaX.controller.CommonUtility;

public class RegistrationTest extends CommonUtility{
	RegistrationPage rPage;
	
  
	@BeforeMethod
	public void beforTest() throws FileNotFoundException, IOException{
		CommonUtility();
		rPage=new RegistrationPage();
	}
	@Test
		public void verifyTitlePage(){
		assertEquals("Registration Form",rPage.verifyTitlePage());
	}
	
   @Test(dataProvider="TestData")
   	public void verifyRegistrationPageForManadatoryField (String testCaseNo,String firstName, String lastName, String dept, String userName, String pwd, String confirmPwd, String email, String mobNo,String expectedMessage) throws Exception{
    testCaseId=testCaseNo;
  
	String status=rPage.signUp(firstName, lastName, dept, userName, pwd, confirmPwd, email, mobNo);
     assertEquals(expectedMessage.trim(), status);
    }
  
    @AfterMethod
   	public void afterTest(){
    	driver.close();
    	driver.quit();
    }

    @DataProvider
   	public Object[][] TestData() throws Exception{
    	System.out.println("hi");
    	return ReadExcel.readExcel(excelPath);
    

    			
    	
    }
}