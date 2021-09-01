package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Username entered");

        lp.setPassword(password);
        logger.info("Password entered");

        lp.clickSubmit();

        if(driver.getTitle().equals("GTPL Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else{
            Assert.assertTrue(false);
            captureScreenshot(driver, "Login_Test_001");
            logger.warn("Login test failed!!!");
        }
    }

}
