package com.actquizmobilenativeapp.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AppUtils {
	
	public static void clickOnBack() {
		DriverUtils.getAppiumDriver().navigate().back();
	}
	
	// this method is only for update user profile
	public static void clearAndEnterText(QAFWebElement element,String inputText) {
		element.waitForVisible();
		element.clear();
		element.sendKeys(inputText);
	}

	public static void swipeTo(String swipeType) {
		 Dimension size = DriverUtils.getAppiumDriver().manage().window().getSize();
		 
		 switch(swipeType) {
		 case "TopToBottom" :
			 DriverUtils.getAppiumDriver().swipe((size.width / 2), (int) (size.height * 0.20), (size.width / 2), (int) (size.height * 0.80), 2000);
			 break;
			 
		 case "BottomToTop" :
			 DriverUtils.getAppiumDriver().swipe((size.width / 2), (int) (size.height * 0.80), (size.width / 2), (int) (size.height * 0.20), 2000);
			 break;
			 
		 case "LeftToRight" :
			 DriverUtils.getAppiumDriver().swipe((int) (size.width * 0.30), (size.height / 2), (int) (size.width * 0.70), (size.height / 2), 2000);
			 break;
			 
		 case "RightToLeft" :
			 DriverUtils.getAppiumDriver().swipe((int) (size.width * 0.70), (size.height / 2), (int) (size.width * 0.30), (size.height / 2), 2000);
			 break;
		 }
	}
	
	public static void swipeToTillVisible(String swipeType,QAFWebElement element) {
		 Point points = element.getLocation();
		 Dimension size = DriverUtils.getAppiumDriver().manage().window().getSize();
		 switch(swipeType) {
		 case "TopToBottom" :
			 DriverUtils.getAppiumDriver().swipe((size.width / 2), (int) (size.height * 0.20), (size.width / 2), (int) (size.height * 0.80), 2000);
			 break;
			 
		 case "BottomToTop" :
			 DriverUtils.getAppiumDriver().swipe((size.width / 2), (int) (size.height * 0.80), (size.width / 2), (int) (size.height * 0.20), 2000);
			 break;
			 
		 case "LeftToRight" :
			 DriverUtils.getAppiumDriver().swipe(50, points.getY(), 250, points.getY(), 2000);
			 break;
			 
		 case "RightToLeft" :
			 DriverUtils.getAppiumDriver().swipe(250, points.getY(), 50, points.getY(), 2000);
			 break;
		 }
	}
	
	public static int convertToInteger(String num) {
		return Integer.parseInt(num);
	}
	
	
}
