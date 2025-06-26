package testBase;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;
    
    @AfterSuite
    public void allure() throws IOException {
    	ProcessBuilder builder = new ProcessBuilder("cmd.exe");
		builder.redirectErrorStream(true);
		Process process = builder.start();

		// Send commands to the window
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		writer.write("cd C:\\Users\\Fleeek\\eclipse-workspace\\SeleniumFramework");
		writer.flush();
		writer.close(); // Close the writer to signal the end of input
    }
    
    
    @SuppressWarnings("deprecation")
	@BeforeClass(groups= "Sanity")
    @Parameters({"os","browser"})
    public void setUp(String os,String br) throws IOException {
    	
    	FileReader file=new FileReader("./src/test/resources/config.properties");
    	p=new Properties();
    	p.load(file);
    	
    	logger=LogManager.getLogger(this.getClass());
    	
    	
    	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}
    	
       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(p.getProperty("baseUrl"));
        driver.manage().window().maximize();
        login();
    }
    
	
	  public void login() { 
		  String email = p.getProperty("Email"); 
		  String password= p.getProperty("Password");
	  
	  logger.info("Logging in with user: " + email); 
	  HomePage home = new HomePage(driver); 
	  home.login(email,password); 
	  }
	 
     
    @AfterClass(groups= {"Sanity","Regression","Master"})
    public void tearDown() throws InterruptedException {
    	Thread.sleep(600);
        driver.close();
    }
    @BeforeClass
    public WebDriver getDriver() {
        return driver;
    }
}

