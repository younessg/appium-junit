package appium.junit.project.core;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class DriversFactory {

	private static String currentDriverType;
	private static AndroidDriver<AndroidElement> androidDriver = null;
	private static IOSDriver<IOSElement> iOSDriver = null;

	public static void createDriver(String platform, Server server, DesiredCapabilities caps) {
		if (platform.equals(Platforms.ANDROID)) {
			System.out.println("Creating android driver...");
			try {
				androidDriver = new AndroidDriver<AndroidElement>(server.getUrl(), caps);
				currentDriverType = Platforms.ANDROID;
			} catch (Exception e) {
				System.out.println("Failed to create driver ");
				e.printStackTrace();
			}
		} else if (platform.equals(Platforms.IOS)) {
			System.out.println("Creating iOS driver...");
			iOSDriver = new IOSDriver<IOSElement>(server.getUrl(), caps);
			currentDriverType = Platforms.IOS;
		} else if (platform.equals(Platforms.WINDOWS)) {
			// handle driver creation for Windows
			// currentDriverType = Platforms.WINDOWS;
		}
	}

	public static String getCurrentDriverType() {
		return currentDriverType;
	}

	public static AndroidDriver<AndroidElement> getAndroidDriver() {
		return androidDriver;
	}

	public static IOSDriver<IOSElement> getiOSDriver() {
		return iOSDriver;
	}
	
}
