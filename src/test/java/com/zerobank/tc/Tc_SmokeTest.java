package com.zerobank.tc;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Assert;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.zerobank.Utils;
import com.zerobank.po.*;
	
	
	public class Tc_SmokeTest {
		
		@Parameters({"url","browser"})
		@Test(priority=1)
		public void t_01_check_login(String url,String browser) {
			try {
				//String url = "http://zero.webappsecurity.com/login.html";
				WebDriver driver = Utils.InvokeBrowser(browser, url);

				//Init Page Object
				Po_LoginPage PO_Login = PageFactory.initElements(driver, Po_LoginPage.class);
				PO_Login.KW_LoginInToApplication("username", "password");
				
				Utils.WriteLogs("pass","Test Case completed");
			}catch(Exception e) {
				Utils.WriteLogs("fail","Test failed");
				Assert.assertFalse(false);
			}

		}
		
		@Parameters({"url","browser"})
		@Test(priority=2)
		public void t_02_check_transfer_funds(String url,String browserType)  {
			WebDriver driver = Utils.InvokeBrowser(browserType, url);
			//Init Page Object
			Po_LoginPage PO_Login = PageFactory.initElements(driver, Po_LoginPage.class);
			PO_Login.KW_LoginInToApplication("username", "password");
			
			//Click on Transfer Funds
			Po_BaseClass PO_Common = PageFactory.initElements(driver, Po_BaseClass.class);
			PO_Common.ClickOnTransferFunds();
			
			//Transfer Funds
			Po_TransferFunds PO_TransferFunds = PageFactory.initElements(driver, Po_TransferFunds.class);
			String from = "1";
			String to = "2";
			String ammount = "10";
			String descp = "test";
			
			PO_TransferFunds.KW_FillTransferFundsPageAndSubmit(from, to, ammount, descp);
			Utils.WriteLogs("pass","Test Case completed");
			
		}
		
		//<parameter name="url_parabank" value="http://parabank.parasoft.com/parabank/index.htm" />/
		//@Parameters({"url_icici"})
		//@Test(groups="smoke",description="Smoke Test For Search funtionality",enabled=true)
	}

