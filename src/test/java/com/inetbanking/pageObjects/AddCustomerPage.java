package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement lnkAddCustomer;

    @FindBy(how = How.NAME, using="name")
    @CacheLookup
    WebElement cName;

    @FindBy(how = How.NAME, using="rad1")
    @CacheLookup
    WebElement cGender;

    @FindBy(how = How.NAME, using="dob")
    @CacheLookup
    WebElement cBirthDate;

    @FindBy(how = How.NAME, using="addr")
    @CacheLookup
    WebElement cAddress;

    @FindBy(how = How.NAME, using="city")
    @CacheLookup
    WebElement cCity;

    @FindBy(how = How.NAME, using="state")
    @CacheLookup
    WebElement cState;

    @FindBy(how = How.NAME, using="pinno")
    @CacheLookup
    WebElement cPin;

    @FindBy(how = How.NAME, using="telephoneno")
    @CacheLookup
    WebElement cTelNo;

    @FindBy(how = How.NAME, using="emailid")
    @CacheLookup
    WebElement cEmail;

    @FindBy(how = How.NAME, using="sub")
    @CacheLookup
    WebElement btnSubmit;

    @FindBy(how = How.NAME, using="password")
    @CacheLookup
    WebElement cPassword;


    public void clickAddCustomer(){
        lnkAddCustomer.click();
    }

    public boolean isBtnPresent(){
        return lnkAddCustomer.isDisplayed();
    }

    public void setcName(String str){
        cName.sendKeys(str);
    }

    public void setcGender(String str){
        cGender.click();
    }

    public void setcBirthDate(String month, String day, String year){
        cBirthDate.sendKeys(month);
        cBirthDate.sendKeys(day);
        cBirthDate.sendKeys(year);
    }

    public void setcAddress(String str){
        cAddress.sendKeys(str);
    }

    public void setcCity(String str){
        cCity.sendKeys(str);
    }

    public void setcState(String str){
        cState.sendKeys(str);
    }

    public void setcPin(String str){
        cPin.sendKeys(str);
    }

    public void setcTelNo(String str){
        cTelNo.sendKeys(str);
    }

    public void setcEmail(String str){
        cEmail.sendKeys(str);
    }

    public void setcPassword(String str){
        cPassword.sendKeys(str);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }


}
