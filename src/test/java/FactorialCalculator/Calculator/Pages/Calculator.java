package FactorialCalculator.Calculator.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class Calculator {
	String header = "//h1[text()='The greatest factorial calculator!']";
	String numberInput = "#number";
	String calculateButton = "#getFactorial";
	String url = "http://qainterview.pythonanywhere.com/factorial";

	ExtentTest test;
	private WebDriver driver;

	public By factorialResult(String number, String result) {
		return By.xpath("//p[text()='The factorial of " + number + " is: " + result + "']");
	}

	public Calculator(WebDriver driver) {
		this.driver = driver;
		test = Base.report.createTest("Calculate Factorial");
	}

	public void executeTest(String number, String expected) {
		Assert.assertEquals(driver.getCurrentUrl(), url, "URL");
		test.pass("Navigated to factorial page");
		Assert.assertTrue(driver.findElement(By.xpath(header)).isDisplayed(), "Page Header");
		test.pass("Validated header title");
		driver.findElement(By.cssSelector(numberInput)).sendKeys(number);
		test.pass("Entered:" + number);
		driver.findElement(By.cssSelector(calculateButton)).click();
		Assert.assertTrue(waitForElement(factorialResult(number, expected)), "Factorial");
		test.pass("Validated:" + driver.findElement(factorialResult(number, expected)).getText());
		test.pass("Test Complete");
	}

	public boolean waitForElement(By xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
