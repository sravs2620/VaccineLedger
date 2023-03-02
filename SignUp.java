package com.VaccineLedger.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SignUp {
	@Test
public void verifySignup() throws AWTException
{
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://test.vaccineledger.com/");
driver.findElement(By.xpath("//a[@class='vl-blue vl-link']")).click();
driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("karri");
driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("sravani");
driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ksravani1008@gmail.com");
driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9848247977");
driver.findElement(By.xpath("//button[@type='submit']")).click();
WebElement ele=driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-1uvydh2']"));

}
}
