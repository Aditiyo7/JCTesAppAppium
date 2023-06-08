package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCatatanKeuangan {
    AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "realme 5 Pro");
        dc.setCapability("udid", "f501004b");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("appWaitActivity","com.rookie.catatankeuangan.feature.main.MainActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, dc);
    }

    @Test(priority = 1)
    public void testIncomeTransactions(){
        MobileElement btnFabMenu = driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnFabMenu.click();
        delay(2);
        MobileElement income = driver.findElementById("com.chad.financialrecord:id/btnIncome");
        income.click();
        MobileElement entAmount = driver.findElementById("com.chad.financialrecord:id/etAmount");
        entAmount.sendKeys("1000");
        MobileElement btnSave = driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSave.click();
        delay(2);
        MobileElement incomeResult = driver.findElementById("com.chad.financialrecord:id/tvIncome");
        String actualResult =  incomeResult.getText();
        String expectResult = "1.000";
        Assert.assertEquals(actualResult,expectResult);
    }

    @Test(priority = 2)
    public void expanditureTransactions(){
        MobileElement btnFabMenu = driver.findElementById("com.chad.financialrecord:id/fabMenu");
        btnFabMenu.click();
        delay(2);
        MobileElement entAmount = driver.findElementById("com.chad.financialrecord:id/etAmount");
        entAmount.sendKeys("1000");
        MobileElement btnSave = driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSave.click();
        delay(2);
        MobileElement expendResult = driver.findElementById("com.chad.financialrecord:id/tvExpense");
        String actualResult =  expendResult.getText();
        String expectResult = "1.000";
        Assert.assertEquals(actualResult,expectResult);
    }
    static void delay(long sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



