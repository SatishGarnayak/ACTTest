package com.actquizmobilenativeapp.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.util.Reporter;

import io.appium.java_client.AppiumDriver;

public class PerfectoUtilities {

	static int timeout = 30;

	public static void openApplication(String paramString) {
		String command = "mobile:application:open";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", paramString);
		params.put("timeout", 60);
		getDriver().executeScript(command, params);
	}

	public static void openAppiumApplication(String appPackage,String appActivity)
	{
		DriverUtils.getAndroidDriver().startActivity(appPackage, appActivity,null,null);
	}
	public static void closeApplication(String paramString) {
		try {
			String command = "mobile:application:close";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", paramString);
			getDriver().executeScript(command, params);
		} catch (WebDriverException e) {
			Reporter.log(paramString + " application did not close/already closed", MessageTypes.Info);
		}
	}

	public static void recoverDevice() {
		String command = "mobile:device:recover";
		Map<String, Object> params = new HashMap<String, Object>();
		getDriver().executeScript(command, params);
	}

	public static void rebootDevice() {
		String command = "mobile:device:reboot";
		Map<String, Object> params = new HashMap<String, Object>();
		getDriver().executeScript(command, params);
	}

	public static boolean findText(String needle) {
		boolean isFound = findText(needle, timeout);
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean findText(String needle, int timeout) {
		boolean isFound = findText(needle, timeout, 100);
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean findText(String needle, int timeout, int threshold) {
		String command = "mobile:text:find";
		Map<String, Object> params = new HashMap<>();
		params.put("content", needle);
		params.put("timeout", timeout);
		params.put("threshold", threshold);
		boolean isFound = Boolean.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean findImage(String needle) {
		boolean isFound = findImage(needle, timeout);
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean findImage(String needle, int timeout) {
		boolean isFound = findImage(needle, timeout, 100);
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean findImage(String needle, int timeout, int threshold) {
		String command = "mobile:image:find";
		Map<String, Object> params = new HashMap<>();
		params.put("content", needle);
		params.put("timeout", timeout);
		params.put("threshold", threshold);
		boolean isFound = Boolean.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean textButtonClick(String needle) {
		boolean isFound = textButtonClick(needle, timeout);
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean textButtonClick(String needle, int timeout) {
		boolean isFound = textButtonClick(needle, timeout, 100);
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean textButtonClick(String needle, int timeout, int threshold) {
		String command = "mobile:button-text:click";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("label", needle);
		params.put("threshold", 82);
		params.put("timeout", 20);
		params.put("label.direction", "none");
		boolean isFound = Boolean.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static void imageButtonClick(String needle) {
		imageButtonClick(needle, timeout);
	}

	public static void imageButtonClick(String needle, int timeout) {
		imageButtonClick(needle, timeout, 100);
	}

	public static void imageButtonClick(String needle, int timeout, int threshold) {
		String command = "mobile:button-image:click";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("label", needle);
		params.put("threshold", threshold);
		params.put("timeout", timeout);
		getDriver().executeScript(command, params);
	}

	public static void setDeviceLocationByAddress(String address) {
		String command = "mobile:location:set";
		Map<String, Object> params = new HashMap<>();
		params.put("address", address);
		getDriver().executeScript(command, params);
		Reporter.log("Location set to : " + address, MessageTypes.Info);
	}

	public static void setDeviceLocationByLatLon(String lat, String lon) {
		Location loc = new Location(Double.valueOf(lat), Double.valueOf(lon), 0.0);
		getDriver().setLocation(loc);
		Reporter.log("Location set to : " + lat + " , " + loc, MessageTypes.Info);
	}

	public static String screenText() {
		String command = "mobile:screen:text";
		Map<String, Object> params = new HashMap<>();
		String txt = (String) getDriver().executeScript(command, params);
		Reporter.log("Screen text : " + txt, MessageTypes.Info);
		return txt;
	}

	public static boolean selectText(String needle, int timeout, int threshold) {
		String command = "mobile:text:select";
		Map<String, Object> params = new HashMap<>();
		params.put("content", needle);
		params.put("timeout", timeout);
		params.put("threshold", threshold);
		boolean isFound = Boolean.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static boolean selectText(String needle, int timeout, int threshold, int index) {
		String command = "mobile:text:select";
		Map<String, Object> params = new HashMap<>();
		params.put("content", needle);
		params.put("timeout", timeout);
		params.put("threshold", threshold);
		params.put("index", index);

		boolean isFound = Boolean.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static void enterTextbyLabel(String needle, String label) {
		String command = "mobile:edit-text:set";
		Map<String, Object> params = new HashMap<>();
		params.put("text", needle);
		params.put("label", label);
		params.put("threshold", 80);
		params.put("timeout", 60);
		getDriver().executeScript(command, params);
	}

	// Gets the user experience (UX) timer
	public static long timerGet(RemoteWebDriver driver, String timerType) {
		String command = "mobile:timer:info";
		Map<String, String> params = new HashMap<String, String>();
		params.put("type", timerType);
		long result = (long) getDriver().executeScript(command, params);
		return result;
	}

	// Adds a timer report to the Wind Tunnel report
	public static void timerReport(long timerResult, int threashold, String description, String name) {
		String command = "mobile:status:timer";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("result", timerResult);
		params.put("threshold", threashold);
		params.put("description", description);
		params.put("name", name);
		getDriver().executeScript(command, params);
	}

	// Adds a point of interest to the Wind Tunnel report
	public static void pointOfInterest(String poiName, String poiStatus) {
		String command = "mobile:status:event";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("description", poiName);
		params.put("status", poiStatus);
		getDriver().executeScript(command, params);
	}

	public static String getDeviceResolution() {
		String command = "mobile:handset:info";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("property", "resolution");
		String returnText = (String) getDriver().executeScript(command, params);
		Reporter.log("returned Resolution: " + returnText, MessageTypes.Info);
		return returnText;

	}

	public static boolean stringCheckpoint(String needle, int timeout) {
		String command = "mobile:checkpoint:text";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", needle);
		params.put("timeout", timeout);
		boolean isFound = Boolean.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log(needle + " is Found: " + isFound, MessageTypes.Info);
		return isFound;
	}

	public static String getTextText(String label, String labelDirection, String labelInline, String ocr,
			String report) {
		String command = "mobile:edit-text:get";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("label", label);
		params.put("label.direction", labelDirection);
		params.put("label.inline", labelInline);
		params.put("timeout", 60);
		params.put("ocr", ocr);
		params.put("report", report);
		String returnText = (String) getDriver().executeScript(command, params);
		Reporter.log("returned Text: " + returnText, MessageTypes.Info);
		return returnText;
	}

	public static void swipe(String start, String end, int duration) {
		String command = "mobile:touch:swipe";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("end", end);
		params.put("duration", duration);
		getDriver().executeScript(command, params);
	}

	public static void zoomIn(String start, String end) {
		Map<String, Object> params = new HashMap<>();
		params.put("operation", "Zoom");
		params.put("start", start);
		params.put("end", end);
		getDriver().executeScript("mobile:touch:gesture", params);
	}

	public static void pinch(String start, String end) {
		Map<String, Object> params = new HashMap<>();
		params.put("operation", "Pinch");
		params.put("start", start);
		params.put("end", end);
		params.put("duration", 3);
		getDriver().executeScript("mobile:touch:gesture", params);
	}

	private static AppiumDriver getDriver() {
		return DriverUtils.getAppiumDriver();
	}

	public static String getDeviceInfo(DEVICEINFO deviceInfo) {
		String command = "mobile:device:info";
		Map<String, Object> params = new HashMap<>();
		params.put("property", deviceInfo.toString());
		String response = String.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log("Device '" + deviceInfo.toString() + "' info :" + response, MessageTypes.Info);
		return response;
	}

	public static void setupDevice(String personaRepositoryFile) {
		String command = "mobile:device:setup";
		Map<String, Object> params = new HashMap<>();
		params.put("repositoryFile", personaRepositoryFile);
		getDriver().executeScript(command, params);
	}

	public static void toggleNetworkSettings(String network, String onOff) {
		String command = "mobile:network.settings:set";
		Map<String, Object> params = new HashMap<>();
		params.put(network.toLowerCase(), onOff);
		Reporter.log("Set network settings '" + network.toString() + "' to " + onOff, MessageTypes.Info);
		getDriver().executeScript(command, params);
		// wait for device to change network settings
	}

	public static String getNetworkSettings() {
		String command = "mobile:network.settings:get";
		Map<String, Object> params = new HashMap<>();
		String responce = String.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log("Network setting :" + responce, MessageTypes.Info);
		return responce;
	}

	public static void setNetworkSpeedTo(String networkProfile) {
		String command = "mobile:vnetwork:start";
		Map<String, Object> params = new HashMap<>();
		params.put("profile", networkProfile);
		getDriver().executeScript(command, params);
	}

	public static void resetNetworkSpeed() {
		String command = "mobile:vnetwork:stop";
		Map<String, Object> params = new HashMap<>();
		getDriver().executeScript(command, params);
	}

	public static enum DEVICEINFO {
		location, network, model, deviceId, os;
	}

	public static String getDeviceTimeZone() {
		String command = "mobile:timezone:get";
		Map<String, Object> params = new HashMap<>();
		String response = String.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log("Device timezone info :" + response, MessageTypes.Info);
		System.out.println("Device timezone info :" + response);
		return response;
	}

	public static String getDeviceWiFiIP() {
		String command = "mobile:ipAddress:get";
		Map<String, Object> params = new HashMap<String, Object>();
		String response = String.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log("Device IP address is :" + response, MessageTypes.Info);
		return response;
	}

	public static Boolean setDeviceTimeZone(String timezone) {
		String command = "mobile:timezone:set";
		Map<String, Object> params = new HashMap<>();
		params.put("timezone", timezone);
		boolean response = Boolean.valueOf((String) getDriver().executeScript(command, params));
		Reporter.log("Device timezone info :" + response, MessageTypes.Info);
		System.out.println("Device timezone info :" + response);
		return response;
	}

	public static void callDevice() {
		String deviceID = getDeviceInfo(DEVICEINFO.deviceId);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("to.handset", deviceID);
		String.valueOf((String) getDriver().executeScript("mobile:gateway:call", params));
	}

}
