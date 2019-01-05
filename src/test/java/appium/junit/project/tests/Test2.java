package appium.junit.project.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Test2 extends BaseTest {

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1' and @text='YouTube']")
	AndroidElement youTubeIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='0' and @text='YouTube']")
	AndroidElement youTubeTitle;

	boolean isYouTubeLaunched = false;

	public Test2() {
		initElements(this);
	}

	@Test
	public void launchYouTube() {

		System.out.println("2) launchYouTube");
		
		wait = new WebDriverWait(driver, 3);
		if (wait.until(ExpectedConditions.visibilityOf(youTubeIcon)).isDisplayed()) {
			youTubeIcon.click();
		}

		if (wait.until(ExpectedConditions.visibilityOf(youTubeTitle)).isDisplayed()) {
			isYouTubeLaunched = true;
		}

		assertTrue("YouTube failed to launch!", isYouTubeLaunched);
	}

}
