package appium.junit.project.tests;

import org.junit.Rule;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appium.junit.project.core.DriversFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseTest {
	
	@Rule
	public Retry retry = new Retry(3);

	protected AndroidDriver<AndroidElement> driver;
	@SuppressWarnings("rawtypes")
	protected TouchAction touchAction;
	protected Dimension dimension;
	protected WebDriverWait wait;
	
	@SuppressWarnings("rawtypes")
	public BaseTest() {
		driver = DriversFactory.getAndroidDriver();
		touchAction = new TouchAction(driver);
		dimension = driver.manage().window().getSize();
	}

	protected void initElements(Object page) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), page);		
	}
}
