package appium.junit.project.tests;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Test1 extends BaseTest {

	@AndroidFindBy(id = "all_apps_handle")
	private AndroidElement trayArrow;

	@AndroidFindBy(id = "search_box_input")
	private AndroidElement searchBox;

	boolean isSearchBoxVisible = false;

	public Test1() {
		initElements(this);
	}

	@Test
	public void openTray() {

		System.out.println("1) openTray");

		Point p = trayArrow.getCenter();
		int endY = (int) (dimension.height * 0.2);
		touchAction.press(PointOption.point(p.getX(), p.getY()))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(0))).moveTo(PointOption.point(p.getX(), endY))
				.release().perform();

		wait = new WebDriverWait(driver, 3);
		if (wait.until(ExpectedConditions.visibilityOf(searchBox)).isDisplayed()) {
			isSearchBoxVisible = true;
		}

		assertTrue("Failed to display search box!", isSearchBoxVisible);
	}

}
