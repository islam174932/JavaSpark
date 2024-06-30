package runner;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;


@CucumberOptions(

		features = {"Featurefiles/datadriven.feature","Featurefiles/Login.feature", "Featurefiles/homePage.feature","Featurefiles/product.feature"},
		glue = {"pages"},
		plugin = {
				"pretty",
				"html:target/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber.json",
				"rerun:target/failed_senarios.txt"
		},
		monochrome = true



)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}


	}



