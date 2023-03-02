package com.VaccineLedger.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
@Test(priority=1)
public void verifyLoginWithValidCredentials()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://test.vaccineledger.com/");
	driver.findElement(By.id("outlined-basic")).sendKeys("dev@statwig.com");
	driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	driver.findElement(By.id("otp0")).sendKeys("1234");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-sm-3 f-700 grey']")).isDisplayed());
	driver.quit();
}
@Test(priority=2)
public void verifyLoginWithInvaildMailId()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://test.vaccineledger.com/");
	driver.findElement(By.id("outlined-basic")).sendKeys("dev@statwigserf.com");
	driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	String actualWarningMessage=driver.findElement(By.xpath("//span[@class='error-msg text-dangerS']")).getText();
    String expectedWarningMessage="Account not found";
    Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message");
	driver.quit();
}
@Test(priority=3)
public void verifyLoginWithInvalidOtp()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://test.vaccineledger.com/");
	driver.findElement(By.id("outlined-basic")).sendKeys("dev@statwig.com");
	driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	driver.findElement(By.id("otp0")).sendKeys("01234");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actualMessage =driver.findElement(By.xpath("//p[@class='vl-body f-400 error-text visible']")).getText();
	String expectedMessage="OTP does not match";
	Assert.assertTrue(actualMessage.contains(expectedMessage), "Expected message is not displayed");
	driver.quit();
}
}
