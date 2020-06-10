package FactorialCalculator.Calculator.Pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {
	public static ExtentReports report;
	@BeforeSuite
	public static void createReport() {
		ExtentHtmlReporter htmlReport= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\report.html");
		report =new ExtentReports();
		report.attachReporter(htmlReport);
	}
	
	@AfterSuite
	public static void closeReport() {
		if(report!=null) {
			report.flush();
		}
	}
	

}
