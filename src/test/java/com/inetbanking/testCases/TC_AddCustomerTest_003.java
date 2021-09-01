package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass{

    @Test
    public void addCustomerTest() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();

        AddCustomerPage addCust = new AddCustomerPage(driver);

        addCust.clickAddCustomer();
        addCust.setcName(randomStr(3,10));
        addCust.setcGender("female");
        addCust.setcBirthDate("11", "11", "1111");
        Thread.sleep(3000);
        addCust.setcAddress(randomStr(15,40));
        addCust.setcCity(randomStr(4,10));
        addCust.setcState(randomStr(5,9));
        addCust.setcPin(randomNum(6,7));
        addCust.setcTelNo(randomNum(7,12));
        addCust.setcEmail(randomStr(5,9) + "@gmail.com");
        addCust.setcPassword(randomStr(4,8));
        addCust.clickSubmit();
        if(driver.getPageSource().contains("Customer Registered Successfully")){
            Assert.assertTrue(true);
            logger.info("AddCustomerTest Passed");
        }else{
            Assert.assertTrue(false);
            logger.warn("AddCustomerTest Failed");
            captureScreenshot(driver, "AddCustomerTest");
        }

    }


    public String randomStr(int min, int max){
      return RandomStringUtils.randomAlphabetic(min, max);
    }

    public String randomNum(int min, int max){
        return RandomStringUtils.randomNumeric(min, max);
    }
}
