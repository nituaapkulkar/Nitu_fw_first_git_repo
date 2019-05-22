package com.zerobank.po;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;


	import com.zerobank.Utils;

	public class Po_LoginPage {
		WebDriver driver;
		
		public Po_LoginPage(WebDriver driver) {
			this.driver = driver;
		}
		
			//Elements or Locators
				@FindBy(how = How.NAME,using="user_login")
				WebElement txtbx_username;

				@FindBy(how = How.NAME,using="user_password")
				WebElement txtbx_password;

				@FindBy(how = How.XPATH,using="//input[@value = 'Sign in']")
				WebElement btn_submit;

				

				//Methods
				public void SetUserName(String u) {
					try {
						txtbx_username.sendKeys(u);
						Utils.WriteLogs("info","Username set with value as : " + u + " Invoke from method:"
								+ Thread.currentThread().getStackTrace()[1].getMethodName());
					}catch(Exception e) {
						e.printStackTrace();
						Utils.WriteLogs("fail","Unable to set user name with value as : u. "
								+ "Run time exception thrown. Exception: " + e.toString());	
					}
				}

				public void SetPassword(String u) {
					try {
						txtbx_password.sendKeys(u);
						Utils.WriteLogs("pass","Password set with value as : " + u);
					}catch(Exception e) {
						e.printStackTrace();
						Utils.WriteLogs("fail","Unable to set Password with value as : u. "
								+ "Run time exception thrown. Exception: " + e.toString());	
					}
				}

				public void ClickSubmitButton() {
					try {
						btn_submit.click();
						Utils.WriteLogs("info","Clicked on Submit Button");
					}catch(Exception e) {
						e.printStackTrace();
						Utils.WriteLogs("fail","Unable to Click on Submit Button. "
								+ "Run time exception thrown. Exception: " + e.toString());	
					}
				}

				public void KW_LoginInToApplication(String u,String p) {
					try {
						SetUserName(u);
						SetPassword(p);
						ClickSubmitButton();
						Utils.WriteLogs("fail","User name and password Set and Submit Button Clicked.");

						//CheckPoint
						String expected = "Zero - Account Summary";
						String actual = driver.getTitle();
						Assert.assertEquals(expected, actual);
						Utils.WriteLogs("pass","Login Successfull");
					}catch(Exception e) {
						e.printStackTrace();
						Utils.WriteLogs("fail","Unable to Login in to the Application "
								+ "Run time exception thrown. Exception: " + e.toString());	
					}

				}



			
		}

	


