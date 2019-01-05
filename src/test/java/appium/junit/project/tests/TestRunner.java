package appium.junit.project.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.remote.DesiredCapabilities;

import appium.junit.project.core.DriversFactory;
import appium.junit.project.core.Platforms;
import appium.junit.project.core.Server;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

// @RunWith(Suite.class)
// @Suite.SuiteClasses({ Test1.class, Test2.class, Test3.class})
public class TestRunner {

	// Set capabilities
	private static DesiredCapabilities capabilities;
	private static Server server;

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(Test1.class, Test2.class, Test3.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());

	}

	@BeforeClass
	public static void setup() {
		System.out.println("@BeforeClass");
		// Set desired capabilities
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.nexuslauncher");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.google.android.apps.nexuslauncher.NexusLauncherActivity");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		// Create driver
		DriversFactory.createDriver(Platforms.ANDROID, server, capabilities);
	}

	// Run tests

	@AfterClass
	public static void tearDown() {
		System.out.println("@AfterClass");
		// Clean up
	}

}
