package com.parabanks.tests;

import com.BaseTest;
import com.parabanks.pages.LoginPage;
import com.parabanks.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class RegistrationTest extends BaseTest {


    private String username;
    private String password;

    @BeforeTest
    @Parameters({"username", "password"})
    public void setupParameters(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Test
    public void registrationTest(){
        LoginPage login = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        login.navigateTOParaBank();
        login.clickOnRegisterLink();
        registrationPage.enterUserDetails("fTest", "lTest", "test", "test", "test", "1234", "1234","123");
        registrationPage.enterUserCredentials(username, password);
        registrationPage.clickOnRegister();
        registrationPage.verifyRegistrationSuccessful();
        registrationPage.clickOnLogOut();
    }
    @Test(dependsOnMethods = "registrationTest")
    public void loginTest(){
        LoginPage login = new LoginPage(driver);
        login.navigateTOParaBank();
        login.enterLoginCredentials(username, password);
        login.clickOnLogIn();
        login.verifyLoginSuccessful();
    }
}
