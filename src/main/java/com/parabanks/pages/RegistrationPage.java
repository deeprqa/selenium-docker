package com.parabanks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "customer.firstName")
    private WebElement txtFirstName;

    @FindBy(id = "customer.lastName")
    private WebElement txtLastName;

    @FindBy(id = "customer.address.street")
    private WebElement txtAddress;

    @FindBy(id = "customer.address.city")
    private WebElement txtCity;

    @FindBy(id = "customer.address.state")
    private WebElement txtState;

    @FindBy(id = "customer.address.zipCode")
    private WebElement txtZipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement txtPhoneNo;

    @FindBy(id = "customer.ssn")
    private WebElement txtSSN;

    @FindBy(id = "customer.username")
    private WebElement txtUserName;

    @FindBy(id = "customer.password")
    private WebElement txtPassword;

    @FindBy(id = "repeatedPassword")
    private WebElement txtConfirmPassword;

    @FindBy(css = "input[value='Register']")
    private WebElement btnRegister;

    @FindBy(xpath = "//div[@id='rightPanel']/p")
    private WebElement lblLoginConfirmation;

    @FindBy(linkText = "Log Out")
    private WebElement lnkLogOut;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void enterUserDetails(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNo, String ssn){
        this.wait.until(ExpectedConditions.visibilityOf(this.txtFirstName));
        this.txtFirstName.sendKeys(firstName);
        this.txtLastName.sendKeys(lastName);
        this.txtAddress.sendKeys(address);
        this.txtCity.sendKeys(city);
        this.txtState.sendKeys(state);
        this.txtZipCode.sendKeys(zipCode);
        this.txtPhoneNo.sendKeys(phoneNo);
        this.txtSSN.sendKeys(ssn);
    }

    public void enterUserCredentials(String userName, String password){
        this.txtUserName.sendKeys(userName);
        this.txtPassword.sendKeys(password);
        this.txtConfirmPassword.sendKeys(password);
    }

    public void clickOnRegister(){
        this.btnRegister.click();
    }

    public void verifyRegistrationSuccessful(){
        this.wait.until(ExpectedConditions.visibilityOf(this.lblLoginConfirmation));
        Assert.assertEquals(this.lblLoginConfirmation.getText(), "Your account was created successfully. You are now logged in.");
    }

    public void clickOnLogOut(){
        this.lnkLogOut.click();
    }



}
