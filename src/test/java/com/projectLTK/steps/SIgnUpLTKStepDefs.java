package com.projectLTK.steps;

import com.github.javafaker.Faker;
import com.projectLTK.pages.BasePageLTK;
import com.projectLTK.utilities.ConfigurationReader;
import com.projectLTK.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SIgnUpLTKStepDefs {
    BasePageLTK basePageLTK = new BasePageLTK();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Faker faker = new Faker();

    @Given("user is  on the ltk sign up page")
    public void userIsOnTheLtkSignUpPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ltkUrl"));
        wait.until(ExpectedConditions.elementToBeClickable(basePageLTK.signUpBtn));
        basePageLTK.signUpBtn.click();
    }

    @When("user sign up as a new user with valid email format")
    public void user_sign_up_as_a_new_user_with_valid_email_format() {

        wait.until(ExpectedConditions.visibilityOf(basePageLTK.emailIB)).sendKeys(faker.internet().emailAddress());
        wait.until(ExpectedConditions.elementToBeClickable(basePageLTK.continueBtn)).click();

    }

    @When("user should be able to continue creating a new valid password")
    public void user_should_be_able_to_continue_creating_a_new_valid_password() {
        wait.until(ExpectedConditions.visibilityOf(basePageLTK.passwordIB)).sendKeys(faker.letterify("?????????"));
        wait.until(ExpectedConditions.elementToBeClickable(basePageLTK.signUpToBeginBtn)).click();
    }

    @Then("user should be redirected to discover home page")
    public void user_should_be_redirected_to_discover_home_page() {
        wait.until(ExpectedConditions.urlContains("home"));
        String pageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(pageTitle.contains("Discover"));
    }


    @When("User enters invalid email format")
    public void userEntersInvalidEmailFormat() {
        wait.until(ExpectedConditions.visibilityOf(basePageLTK.emailIB));
        basePageLTK.emailInputBox.sendKeys(faker.name().firstName());
        wait.until(ExpectedConditions.visibilityOf(basePageLTK.continueBtn)).click();
    }

    @Then("User should be able to see {string} message")
    public void userShouldBeAbleToSeeMessage(String errMessage) {
        Assert.assertTrue(basePageLTK.emailIB.getText().contains(errMessage));

    }

    @When("User enters empty email format")
    public void userEntersEmptyEmailFormat() {
        wait.until(ExpectedConditions.visibilityOf(basePageLTK.emailIB));

    }

    @Then("User should not not be able to click continue")
    public void userShouldNotNotBeAbleToClickContinue() {

       Assert.assertFalse(basePageLTK.continueBtn.isEnabled());
    }

}
