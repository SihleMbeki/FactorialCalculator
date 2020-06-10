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

public class VerifyError {
	String header = "//h1[text()='The greatest factorial calculator!']";
	String numberInput = "#number";
	String calculateButton = "#getFactorial";
	String url = "http://qainterview.pythonanywhere.com/factorial";

	ExtentTest test;
	private WebDriver driver;

	public By factorialResult() {
		return By.cssSelector("#resultDiv[style='color: rgb(255, 0, 0);']");
	}

	public VerifyError(WebDriver driver) {
		this.driver = driver;
		test = Base.report.createTest("Calculate Factorial Error");
	}

	public void executeTest(String text) {
		Assert.assertEquals(driver.getCurrentUrl(), url, "URL");
		test.pass("Navigated to factorial page");
		Assert.assertTrue(driver.findElement(By.xpath(header)).isDisplayed(), "Page Header");
		test.pass("Validated header title");
		driver.findElement(By.cssSelector(numberInput)).sendKeys(text);
		test.pass("Entered:" + text);
		driver.findElement(By.cssSelector(calculateButton)).click();
		Assert.assertTrue(waitForElement(factorialResult()), "Factorial");
		test.pass("Validated:" + driver.findElement(factorialResult()).getText());
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
