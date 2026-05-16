package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Verify user log into the application")
	public void setUp(){
		myAccountPage = homePage.goToLoginPage().doLoginWith("niyaz.hashmi@rediffmail.com","P@ssw0rd");
		address = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewFirstAddress(){
		String actualText = myAccountPage.goToAddressPage().saveAddress(address);
		Assert.assertEquals(actualText,address.getAddressTitle().toUpperCase());
	}

}
