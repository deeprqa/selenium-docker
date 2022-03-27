package com.parabanks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "username")
    private WebElement txtUserName;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(linkText = "Register")
    private WebElement lnkRegister;

    @FindBy(css = "input[type='submit']")
    private WebElement btnLogIn;

    @FindBy(id = "accountTable")
    private WebElement tblAccountOverView;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void navigateTOParaBank(){
        this.driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    public void enterLoginCredentials(String username, String password){
        this.wait.until(ExpectedConditions.visibilityOf(this.txtUserName));
        this.txtUserName.sendKeys(username);
        this.txtPassword.sendKeys(password);
    }

    public void clickOnLogIn(){
        this.btnLogIn.click();
    }

    public void clickOnRegisterLink(){
        this.lnkRegister.click();
    }

    public void verifyLoginSuccessful(){
        this.wait.until(ExpectedConditions.visibilityOf(this.tblAccountOverView));
        Assert.assertEquals(java.util.Optional.of(this.tblAccountOverView.isDisplayed()), Boolean.TRUE);
    }

}
