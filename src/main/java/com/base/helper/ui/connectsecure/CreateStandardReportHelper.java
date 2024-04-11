package com.base.helper.ui.connectsecure;

import com.base.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateStandardReportHelper {


  /**
   * Constructor.
   */
  public CreateStandardReportHelper() {
    PageFactory.initElements(WebDriverFactory.getDriver(), this);
  }

  /**
   * Launch the Web Application and navigate to the Company Label.
   *
   * @author simran.kumari
   */

  @FindBy(xpath = "//mat-select[@id='sSearchCompanyInput']")
  private WebElement txtboxSearchCompanyInput;

  @FindBy(xpath = "//input[@placeholder='Search Company']")
  private WebElement txtboxEnterCompanyName;

  @FindBy(xpath = "//span[contains(text(),'Reports')]")
  private WebElement lblReports;

  @FindBy(xpath = "//span[contains(text(),'Standard Reports')]")
  private WebElement lblStandardReports;

  @FindBy(xpath = "//span[contains(text(),'STANDARD REPORTS')]")
  private WebElement textStandardReports;

  public void enterSearchCompanyInput(String companyName) {
    WebDriverFactory.clickWebElement(txtboxSearchCompanyInput);
    WebDriverFactory.sendKeys(txtboxEnterCompanyName, companyName);
    WebDriverFactory.getDriver()
        .findElement(By.xpath("//span[contains(text(),'" + companyName + "')]")).click();
    WebDriverFactory.waitForPageToLoad(20);
  }

  public void clickOnLabelReports(){
    WebDriverFactory.clickWebElement(lblReports,10);
    WebDriverFactory.clickWebElement(lblStandardReports,10);
  }

  public boolean isTextStandardReportDisplayed(){
    return textStandardReports.isDisplayed();
  }
}
