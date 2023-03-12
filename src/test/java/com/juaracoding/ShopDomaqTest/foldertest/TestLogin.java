package com.juaracoding.cucumber.foldertest;

import com.juaracoding.cucumber.lib.LibraryTest;
import com.juaracoding.cucumber.pages.LoginDemoqaPage;
import com.juaracoding.cucumber.utils.Regular;
import com.juaracoding.cucumber.utils.RegularPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {

    public static WebDriver driver;
    public static LoginDemoqaPage logDemoq;

    public TestLogin() {
        driver = LibraryTest.driver;
        logDemoq = new LoginDemoqaPage();
    }

    @Given("User open browser and url")
    public void user_open_browser_and_url() {
        System.out.println("User open browser and url");
        driver.get(Regular.URL);
        Assert.assertTrue(logDemoq.getTitleBar().contains("ToolsQA"));
        RegularPage.delayDuration(1);
    }

    @Given("User logout web demoqa shop")
    public void User_logout_web_demoqa_shop(){
        System.out.println("User logout web demoqa shop");
        RegularPage.delayDuration(1);
        logDemoq.linktxLogout();
    }

    @When("User click popup dismiss")
    public void user_click_popup_dismiss() {
        System.out.println("User click popup dismiss");
        logDemoq.clickPopUp();
        RegularPage.delayDuration(1);
    }

    @When("User scroll and enter invalid username")
    public void user_scroll_and_enter_invalid_username(){
        System.out.println("User scroll and enter invalid username");
        RegularPage.scrollPage("0","500");
        RegularPage.delayDuration(1);
        logDemoq.enterUsernama("HadiJuaraCoding");
    }

    @And("User click link my account and scroll")
    public void user_click_link_my_account_and_scroll() {
        System.out.println("User click link my account and scroll");
        logDemoq.activityLogin();
        RegularPage.scrollPage("0", "500");
    }

    @And("User enter valid username")
    public void user_enter_valid_username() {
        System.out.println("User enter valid username");
        logDemoq.enterUsernama("HadiJuaraCoding");
    }

    @And("User enter valid password")
    public void user_enter_valid_password() {
        System.out.println("User enter valid password");
        logDemoq.enterPassword("JuaraCoding@2023','//");
    }

    @And("User click checkbox remember me")
    public void user_click_checkbox_remember_me() {
        System.out.println("User click checkbox remember me");
        logDemoq.clickRememberme();
    }

    @And("User click button login")
    public void user_click_button_login() {
        System.out.println("User click button login");
        logDemoq.clickBtnLogin();
    }

    @And("User go to page my account and scroll")
    public void user_go_to_page_my_account_and_scroll() {
        System.out.println("User go to page my account");
        logDemoq.getTextMyacc();
        RegularPage.scrollPage("0", "400");
    }

    @And("User enter invalid password")
    public void user_enter_invalid_password(){
        System.out.println("User enter invalid password");
        logDemoq.enterPassword("juaracoding@2023");
    }

    @Then("User get account name")
    public void user_get_account_name() {
        System.out.println("User get account name");
        Assert.assertEquals(logDemoq.getAccountName(), "HadiJuaraCoding");
    }

    @Then("User get message error message")
    public void user_get_message_error_message(){
        System.out.println("User get message error message");
        RegularPage.scrollPage("0","400");
        RegularPage.delayDuration(1);
        Assert.assertTrue(logDemoq.messageError().contains("ERROR:"));
    }
}
