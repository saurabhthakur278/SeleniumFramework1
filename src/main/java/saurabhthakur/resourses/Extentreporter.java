package saurabhthakur.resourses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreporter {
	static ExtentReports extent;
	
	public static ExtentReports getreportobject() {

		String path=System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter report =new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation report");
		
		report.config().setDocumentTitle("report extent");
		
		 extent = new ExtentReports();
		
		extent.attachReporter(report);
		extent.setSystemInfo("tester", "Saurabh thakur");
return extent;
	}

}
