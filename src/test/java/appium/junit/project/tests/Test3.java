package appium.junit.project.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Test3 extends BaseTest {

	@AndroidFindBy(xpath = "//android.widget.ImageView[@index='0' and @content-desc='Search']")
	private AndroidElement searchIcon;

	@AndroidFindBy(id = "com.google.android.youtube:id/search_edit_text")
	private AndroidElement searchTextInput;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0' and @content-desc='Navigate up']")
	private AndroidElement arrow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@index='0' and @text='Eminem - Venom']")
	private AndroidElement resultVideoTitle;

	private String keyWord = "Venom";

	private boolean isResultFound = false;

	public Test3() {
		initElements(this);
	}

	@Test
	public void searchUsingKeyWord() {
		System.out.println("3) searchUsingKeyWord");
		// Click magnifier
		wait = new WebDriverWait(driver, 3);
		if (wait.until(ExpectedConditions.visibilityOf(searchIcon)).isDisplayed()) {
			searchIcon.click();
		}
		// Insert text
		wait = new WebDriverWait(driver, 3);
		if (wait.until(ExpectedConditions.visibilityOf(searchTextInput)).isDisplayed()) {
			searchTextInput.click();
			searchTextInput.sendKeys(keyWord);
		}
		// Submit keyword
		wait = new WebDriverWait(driver, 3);
		if (wait.until(ExpectedConditions.textToBePresentInElement(searchTextInput, keyWord))) {
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		}
		// Check result title
		wait = new WebDriverWait(driver, 3);
		if (wait.until(ExpectedConditions.visibilityOf(resultVideoTitle)).isDisplayed()) {
			isResultFound = true;
		}

		assertTrue("Failed to find video!", isResultFound);
	}

}
