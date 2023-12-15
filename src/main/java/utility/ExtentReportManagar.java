package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReportManagar extends TestBase
{
	static ExtentReports reports;
	public static ExtentReports getReportInstance()
	{
		if(reports==null)
		{
			String reportName=new SimpleDateFormat("dd-MM-YY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("E:\\Software Testing\\Jarfile\\Eclipse Program\\Selenium_Framework\\ExtendReport\\report.html");
			reports=new ExtentReports();
			reports.attachReporter(htmlReporter);
			reports.setSystemInfo("OS","Windows");
			reports.setSystemInfo("Environment","SIT");
			reports.setSystemInfo("Build Number","102.02.02.126");
			reports.setSystemInfo("Browser","Chrome");
			htmlReporter.config().setDocumentTitle("UI Testing Document");
			htmlReporter.config().setReportName("UI Test Report");
			
			
		}
		return reports;
		
	}

}
