package com.projectLTK.pages;

import com.projectLTK.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShopPageLTK {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public ShopPageLTK() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h2[text()='LTK Categories']")
    public WebElement ltkCategories;

    @FindBy(xpath = "//a[@class='d-inline-flex align-center category-item flex-row']")
    public List<WebElement> categories;

    @FindBy(xpath = "//a[@class='v-card v-card--flat v-card--link v-sheet theme--light']")
    public List<WebElement> discoveryPagePosts;

    public void navigateTo(String navigationMenuName) {
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//a[.='" + navigationMenuName + "']"))));
        wait.until(ExpectedConditions.visibilityOfAllElements(discoveryPagePosts));
        Driver.getDriver().findElement(By.xpath("//a[.='" + navigationMenuName + "']")).click();

    }

}
