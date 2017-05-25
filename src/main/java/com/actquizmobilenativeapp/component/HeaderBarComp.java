package com.actquizmobilenativeapp.component;

import java.util.HashMap;
import java.util.List;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HeaderBarComp extends QAFWebComponent {

	public HeaderBarComp(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	public HeaderBarComp() {
		super("collections.header");
		
	}
	
	@FindBy(locator = "header.btn.back")
	private QAFWebElement headerBtnBack;
	@FindBy(locator = "header.btn.comment")
	private QAFWebElement headerBtnComment;
	@FindBy(locator = "header.btn.help")
	private QAFWebElement headerBtnHelp;
	@FindBy(locator = "header.btn.mark")
	private QAFWebElement headerBtnMark;
	@FindBy(locator = "header.lst.radio.mark")
	private List<QAFWebElement> headerLstRadioMark;
	@FindBy(locator = "header.lbl.quizselected")
	private QAFWebElement headerLblQuizselected;
	@FindBy(locator = "header.alert.exit.yes")
	private QAFWebElement headerAlertExitYes;
	@FindBy(locator = "header.alert.exit.cancel")
	private QAFWebElement headerAlertExitCancel;
	@FindBy(locator = "header.btn.view")
	private QAFWebElement headerBtnView;
	@FindBy(locator = "header.statistics.subjectspinner")
	private QAFWebElement headerStatisticsSubjectSpinner;
	
	HashMap<String, Integer> marks;

	public QAFWebElement getHeaderBtnBack() {
		return headerBtnBack;
	}

	public QAFWebElement getHeaderBtnComment() {
		return headerBtnComment;
	}

	public QAFWebElement getHeaderBtnHelp() {
		return headerBtnHelp;
	}

	public QAFWebElement getHeaderBtnMark() {
		return headerBtnMark;
	}

	public List<QAFWebElement> getHeaderLstRadioMark() {
		return headerLstRadioMark;
	}

	public QAFWebElement getHeaderLblQuizselected() {
		return headerLblQuizselected;
	}
	
	public QAFWebElement getHeaderAlertExitYes() {
		return headerAlertExitYes;
	}
	
	public QAFWebElement getHeaderAlertExitCancel() {
		return headerAlertExitCancel;
	}
	
	public QAFWebElement getHeaderBtnView() {
		return headerBtnView;
	}

	public QAFWebElement getHeaderStatisticsSubjectSpinner() {
		return headerStatisticsSubjectSpinner;
	}

	public void markQuestion(String markType) {
		QAFTestBase.pause(5000);
		loadMarkItems();
		int markPosition=marks.get(markType);
		//getHeaderBtnMark().waitForPresent();
		getHeaderBtnMark().verifyPresent();
	    getHeaderBtnMark().click();	
		getHeaderLstRadioMark().get((markPosition-1)).click();
	}
	
	public void loadMarkItems() {
		marks = new HashMap<String, Integer>();
		String[] items=ConfigurationManager.getBundle().getPropertyValue("mark.type").split(",");
		for(int i=0;i<items.length;i++) {
			marks.put(items[i], i+1);
		}
	}
	
	public void filterMark(String markType) {
		getHeaderBtnView().waitForPresent();
		getHeaderBtnView().click();
		//new TouchAction(DriverUtils.getAppiumDriver()).press(getHeaderBtnView());
		loadMarkItems();
		int markPosition=marks.get(markType);
		getHeaderLstRadioMark().get((markPosition-1)).click();
	}

}
