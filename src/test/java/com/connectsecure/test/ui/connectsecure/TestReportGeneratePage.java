package com.connectsecure.test.ui.connectsecure;

import com.base.helper.ui.connectsecure.CreateStandardReportHelper;
import com.base.helper.ui.connectsecure.LoginPageHelper;
import com.base.utils.LogPrinter;
import com.base.utils.Utilities;
import com.base.utils.WebDriverFactory;
import com.base.utils.timeutils.TimeUtil;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestReportGeneratePage {

  LoginPageHelper loginPageHelper;
  CreateStandardReportHelper createStandardReportHelper;


  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.launchBrowser();
    WebDriverFactory.openApplication();
    WebDriverFactory.waitForPageToLoad(30);

    loginPageHelper = new LoginPageHelper();
    createStandardReportHelper = new CreateStandardReportHelper();

    String tenantName = Utilities.getEnvironmentProperties("tenantName");
    String loginName = Utilities.getEnvironmentProperties("loginName");
    String password = Utilities.getEnvironmentProperties("password");
    LoginPageHelper.loginIntoTheApplication(tenantName, loginName, password);
  }

  @AfterMethod
  public void afterMethod() {
    WebDriverFactory.closeWindow();
  }

  @Test(priority = 0, enabled = true)
  public void testReportPageIsWorkingFine() {
    String companyName=Utilities.getEnvironmentProperties("companyName");
    createStandardReportHelper.enterSearchCompanyInput(companyName);
    createStandardReportHelper.clickOnLabelReports();
    Assert.assertTrue(createStandardReportHelper.isTextStandardReportDisplayed());
    LogPrinter.printLog("Standard report generating page displayed.");

  }
}
