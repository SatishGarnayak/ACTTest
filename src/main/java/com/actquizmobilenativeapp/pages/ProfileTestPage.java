package com.actquizmobilenativeapp.pages;

import com.actquizmobilenativeapp.utils.AppUtils;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProfileTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "profile.lbl.username")
	private QAFWebElement profileLblUsername;
	@FindBy(locator = "profile.lbl.livingin")
	private QAFWebElement profileLblLivingin;
	@FindBy(locator = "profile.lbl.aboutyou")
	private QAFWebElement profileLblAboutyou;
	@FindBy(locator = "profile.lbl.totalscore")
	private QAFWebElement profileLblTotalscore;
	@FindBy(locator = "profile.edit.updateinfo")
	private QAFWebElement profileEditUpdateinfo;
	@FindBy(locator = "profile.btn.ok")
	private QAFWebElement profileBtnOk;
	@FindBy(locator = "profile.btn.cancel")
	private QAFWebElement profileBtnCancel;
	@FindBy(locator = "profile.txt.username")
	private QAFWebElement profileTxtUsername;
	@FindBy(locator = "profile.btn.home")
	private QAFWebElement profileBtnHome;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProfileLblUsername() {
		return profileLblUsername;
	}

	public QAFWebElement getProfileLblLivingin() {
		return profileLblLivingin;
	}

	public QAFWebElement getProfileLblAboutyou() {
		return profileLblAboutyou;
	}

	public QAFWebElement getProfileLblTotalscore() {
		return profileLblTotalscore;
	}

	public QAFWebElement getProfileEditUpdateinfo() {
		return profileEditUpdateinfo;
	}

	public QAFWebElement getProfileBtnOk() {
		return profileBtnOk;
	}

	public QAFWebElement getProfileBtnCancel() {
		return profileBtnCancel;
	}

	public QAFWebElement getProfileTxtUsername() {
		return profileTxtUsername;
	}

	public QAFWebElement getProfileBtnHome() {
		return profileBtnHome;
	}
	
	public void verifyProfilePage() {
		getProfileTxtUsername().waitForPresent();
		getProfileTxtUsername().verifyPresent();
		getProfileBtnHome().verifyPresent();
	}
	
	public void updateUserInfo(String[] userinfo) {
		// update username
		getProfileLblUsername().click();
		AppUtils.clearAndEnterText(getProfileEditUpdateinfo(), userinfo[0]);
		getProfileBtnOk().click();
		
		// update living in
		getProfileLblLivingin().click();
		AppUtils.clearAndEnterText(getProfileEditUpdateinfo(), userinfo[1]);
		getProfileBtnOk().click();
		
		// update about you
		getProfileLblAboutyou().click();
		AppUtils.clearAndEnterText(getProfileEditUpdateinfo(), userinfo[2]);
		getProfileBtnOk().click();
	}
	
	public void clickOnHome() {
		getProfileBtnHome().click();
	}
	
	public void updateUserInfoAndGoBack(String[] userinfo) {
		updateUserInfo(userinfo);
		clickOnHome();
	}
	
	public String[] getUserInfo() {
		String[] userinfo=new String[3];
		userinfo[0]=getProfileLblUsername().getText().trim().replace(" edit", "");
		userinfo[1]=getProfileLblLivingin().getText().trim().replace(" edit", "");
		userinfo[2]=getProfileLblAboutyou().getText().trim().replace(" edit", "");
		return userinfo;
	}
	
	
}
