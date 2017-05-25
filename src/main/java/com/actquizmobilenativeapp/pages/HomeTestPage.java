package com.actquizmobilenativeapp.pages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.actquizmobilenativeapp.tests.NewTest;
import com.actquizmobilenativeapp.utils.AppUtils;
import com.actquizmobilenativeapp.utils.DriverUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider.App;
import com.thoughtworks.selenium.webdriven.commands.KeyPressNative;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;

public class HomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	
	
	//
	@FindBy(locator = "header.btn.mark")
	private QAFWebElement headerBtnMark;
	
	//
	
	@FindBy(locator = "home.logo.ACT")
	private QAFWebElement homeLogoACT;
	@FindBy(locator = "home.lbl.home")
	private QAFWebElement homeLblHome;
	@FindBy(locator = "home.btn.profile")
	private QAFWebElement homeBtnProfile;
	@FindBy(locator = "home.btn.learningfeed")
	private QAFWebElement homeBtnLearningfeed;
	@FindBy(locator = "home.lst.cmp.quiz")
	private List<QAFWebElement> homeLstCmpQuiz;
	@FindBy(locator = "home.loader.app")
	private QAFWebElement homeLoaderApp;
	@FindBy(locator = "home.btn.collections")
	private QAFWebElement homeBtnCollections;
	@FindBy(locator = "home.btn.statistics")
	private QAFWebElement homeBtnStatistics;
	
	
	HashMap<String, Integer> homePageItems ;
	String quizName;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
//
	public QAFWebElement getHeaderBtnMark() {
		return headerBtnMark;
	}
	//
	
	
	
	
	public QAFWebElement getHomeLogo() {
		return homeLogoACT;
	}

	public QAFWebElement getHomeLbl() {
		return homeLblHome;
	}

	public QAFWebElement getHomeBtnProfile() {
		return homeBtnProfile;
	}

	public QAFWebElement getHomeBtnLearningfeed() {
		return homeBtnLearningfeed;
	}
	
	public List<QAFWebElement> getHomeLstCmpQuiz() {
		return homeLstCmpQuiz;
	}

	public QAFWebElement getHomeLoaderApp() {
		return homeLoaderApp;
	}

	public QAFWebElement getHomeBtnCollections() {
		return homeBtnCollections;
	}

	public QAFWebElement getHomeBtnStatistics() {
		return homeBtnStatistics;
	}

	public void openApplication() {
		new HomeTestPage();
	}

	public void verifyHomePage() {
		System.out.println("Step started");
		// This step is for loading the application
		homeLoaderApp.waitForNotVisible(150000);
		// This step will wait for PopUp, we included this because of PopUp will not appearing immediately
		//QAFTestBase.pause(5000);
		boolean flag=true; int time=0;
		/*while(flag) {
			System.out.println("loop continued");
			time=time+500;
			if(getHomeLbl().verifyVisible()) {
				getHomeLbl().waitForNotVisible(500);
			}
			if(time<=10000 && !getHomeLbl().verifyVisible()) {
				AppUtils.clickOnBack();	
				flag=false;
			}
			if(time>=10000)
				flag=false;
		}*/
		//AppUtils.clickOnBack();
		getHomeLbl().waitForVisible();
		getHomeLbl().verifyPresent();
		System.out.println("Step success");
	}

	public void clickOnProfileIcon() {
		getHomeBtnProfile().waitForVisible();
		getHomeBtnProfile().click();
	}

	public String getQuizSelected() {
		return quizName;
	}
	
	public void setQuizSelected(String quizName) {
		this.quizName=quizName;
	}
	
	public void selectQuizByName(String quizName) {
		setQuizSelected(quizName);
		loadQuizItems();
		int quizPosition=homePageItems.get(quizName);
		getHomeLstCmpQuiz().get((quizPosition-1)).waitForVisible();
		getHomeLstCmpQuiz().get((quizPosition-1)).click();
		
	}
	
	public void loadQuizItems() {
		homePageItems = new HashMap<String, Integer>();
		String[] items=ConfigurationManager.getBundle().getPropertyValue("homecomps.quiz").split(",");
		for(int i=0;i<items.length;i++) {
			homePageItems.put(items[i], i+1);
		}
	}
	
	public void selectCollections() {
		AppUtils.swipeTo("BottomToTop");
		getHomeBtnCollections().waitForPresent();
		getHomeBtnCollections().click();
	}
	
	public void selectStatistics() {
		AppUtils.swipeTo("BottomToTop");
		getHomeBtnStatistics().waitForPresent();
		getHomeBtnStatistics().click();
	}
	
public void verifyUserInfoUpdated(String[] userinfo){
		
	ProfileTestPage profileTestPage = new ProfileTestPage();
		Validator.verifyThat("update user info", profileTestPage.getUserInfo(), Matchers.equalTo(userinfo));
	}



	
	
	
	/**
	 *  below methods are written for future use
	 */
	/*public void selectPerformanceAndSettingsByName(String itemName) {
		loadPerformanceAndSettings();
		int i=homePageItems.get(itemName);
		getHomeCmpItem().get(i);
	}
	
	public void selectCollectionsByName(String itemName) {
		loadPerformanceAndSettings();
		int i=homePageItems.get(itemName);
		getHomeCmpItem().get(i);
	}
	
	public void loadPerformanceAndSettings() {
		homePageItems = new HashMap<String, Integer>();
		String[] items=ConfigurationManager.getBundle().getPropertyValue("homecomps.performance").split(",");
		for(int i=0;i<items.length;i++) {
			homePageItems.put(items[i], i+1);
		}
	}
	
	public void loadUserCollections() {
		homePageItems = new HashMap<String, Integer>();
		String[] items=ConfigurationManager.getBundle().getPropertyValue("homecomps.usermaterial").split(",");
		for(int i=0;i<items.length;i++) {
			homePageItems.put(items[i], i+1);
		}
	}*/


}
