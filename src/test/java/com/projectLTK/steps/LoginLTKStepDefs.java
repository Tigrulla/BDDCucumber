package com.projectLTK.steps;

import com.projectLTK.pages.BasePageLTK;
import com.projectLTK.pages.ShopPageLTK;
import com.projectLTK.utilities.BrowserUtils;
import com.projectLTK.utilities.ConfigurationReader;
import com.projectLTK.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginLTKStepDefs {

    BasePageLTK basePageLTK = new BasePageLTK();
    ShopPageLTK shopPageLTK = new ShopPageLTK();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user signed up")
    public void user_signed_up() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ltkUrl"));
        basePageLTK.login(ConfigurationReader.getProperty("ltkUsername"), ConfigurationReader.getProperty("ltkPassword"));

    }

    @When("user selects the {string} navigation menu")
    public void user_selects_the_navigation_menu(String module) {

        shopPageLTK.navigateTo(module);
        wait.until(ExpectedConditions.visibilityOfAllElements(shopPageLTK.ltkCategories));
    }

    @Then("user should see the following categories present")
    public void user_should_see_the_following_categories_present(List<String> expectedCategories) {


        List<WebElement> categoriesElements = shopPageLTK.categories;
        List<String> actualCategoriesList = BrowserUtils.getElementsText(categoriesElements);

        Assert.assertEquals(expectedCategories, actualCategoriesList);

    }

}
