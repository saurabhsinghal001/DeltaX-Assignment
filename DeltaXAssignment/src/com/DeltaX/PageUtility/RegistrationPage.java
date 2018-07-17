package com.DeltaX.PageUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.DeltaX.controller.CommonUtility;

public class RegistrationPage extends CommonUtility{
	@FindBy(how=How.XPATH,using="//b")
	public WebElement titlePage;
	@FindBy(how=How.NAME,using="first_name")
	public WebElement firstNameFiled;
	@FindBy(how=How.NAME,using="last_name")
	public WebElement lastnameField;
	@FindBy(how=How.NAME,using="department")
	public WebElement department;
	@FindBy(how=How.NAME,using="user_name")
	public WebElement userNameField;
	@FindBy(how=How.NAME,using="user_password")
	public WebElement password;
	@FindBy(how=How.NAME,using="confirm_password")
	public WebElement confirmPassword;
	@FindBy(how=How.NAME,using="email")
	public WebElement emailfiled;
	@FindBy(how=How.NAME,using="contact_no")
	public WebElement mobNofield;
	@FindBy(how=How.XPATH,using="//button")
	public WebElement submit;
	@FindBy(how=How.XPATH,using="//*[@class='help-block' and @style!='display: none;']")
	public static WebElement errorMsg;
	
	public RegistrationPage(){
		PageFactory.initElements(driver,this);
	}
	
	public String signUp(String firstName, String lastName, String dept, String userName, String pwd, String confirmPwd, String email, String mobNo){
		String previousUrl=driver.getCurrentUrl();
		firstNameFiled.sendKeys(firstName);
		lastnameField.sendKeys(lastName);
		if(!dept.equals("")){
	    new Select(department).selectByVisibleText(dept);
	    }
	    userNameField.sendKeys(userName);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		emailfiled.sendKeys(email);
		mobNofield.sendKeys(mobNo);
		if(submit.isEnabled()){
			submit.click();
			if(driver.getCurrentUrl().equalsIgnoreCase(previousUrl)){
			    return errorMsg.getText();
			  }else{
				  return driver.getCurrentUrl();
				  
			   }
		}
		else{
			   return errorMsg.getText();
		}
		
		
	}
	public String verifyTitlePage(){
		return titlePage.getText();
		
	}

}
