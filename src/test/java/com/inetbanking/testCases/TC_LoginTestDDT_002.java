package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTestDDT_002 extends BaseClass{

    @Test(dataProvider = "Login")
    public void loginTest(String uname, String pwd) throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(uname);
        lp.setPassword(pwd);
        lp.clickSubmit();



        if(isAlertPresent()){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("Login Failed");
        }else{
            Assert.assertTrue(true);
            logger.info("Login Passed");
            lp.logOut();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();

        }

    }

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }catch(NoAlertPresentException e){
            return false;
        }
    }

    @DataProvider(name = "Login")
    Object[][] getData() throws IOException {
    String path = System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "Sheet1");
        int colNum = XLUtils.getCellCount(path, "Sheet1", 1);
        String[][] loginData = new String[rowNum][colNum];
        for(int i=1; i<= rowNum; i++){
            for(int j=0; j < colNum; j++){
                loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return loginData;
    }
}
