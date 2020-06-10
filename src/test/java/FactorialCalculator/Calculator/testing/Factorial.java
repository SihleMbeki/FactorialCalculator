package FactorialCalculator.Calculator.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FactorialCalculator.Calculator.Pages.Base;
import FactorialCalculator.Calculator.Pages.Calculator;
import FactorialCalculator.Calculator.Pages.VerifyError;

public class Factorial extends Base{

	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		driver= new ChromeDriver();
	}

	@Test
	public void VerifyFactorial() {
		driver.get("http://qainterview.pythonanywhere.com/factorial");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Calculator factorial=new Calculator(driver);
		factorial.executeTest("7","5040");	
	}
	@Test
	public void VerifyFactorialError() {
		driver.get("http://qainterview.pythonanywhere.com/factorial");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		VerifyError factorialError=new VerifyError(driver);
		factorialError.executeTest("@");	
	}
	
	@AfterMethod
	public void cleanup() {
		if(driver !=null) {
			driver.close();
		}
	}
	
}
