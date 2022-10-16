package com.projectLTK.pages;

import com.github.javafaker.Faker;
import com.projectLTK.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageLTK {

    public BasePageLTK() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    Faker faker = new Faker();

    @FindBy(xpath = "//*[text()='Sign up']")
    public WebElement signUpBtn;

    @FindBy(xpath = "//span[text()='Log in']")
    public WebElement loginBtn;

    @FindBy(name = "email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//div[@class='v-text-field__slot']")
    public WebElement emailIB;

    @FindBy(xpath = "//span[text()='continue']")
    public WebElement continueBtn;

    @FindBy(name = "password")
    public WebElement passwordIB;

    @FindBy(xpath = "(//span[@class='v-btn__content'])[5]")
    public WebElement loginContinueBtn;

    @FindBy(xpath = "//span[text()='sign up to begin shopping']")
    public WebElement signUpToBeginBtn;

    public void login(String username,String password) {
        wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(emailInputBox)).sendKeys(username);
        continueBtn.click();
        wait.until(ExpectedConditions.visibilityOf(passwordIB)).sendKeys(password);
        loginContinueBtn.click();
    }

    public void signUpWithFaker (){
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(emailInputBox)).sendKeys(faker.internet().emailAddress());
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordIB)).sendKeys(faker.letterify("?????????"));
        signUpToBeginBtn.click();
    }

}
