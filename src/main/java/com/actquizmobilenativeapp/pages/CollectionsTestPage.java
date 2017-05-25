package com.actquizmobilenativeapp.pages;

import java.util.List;

import org.hamcrest.Matchers;

//import com.actquizmobilenativeapp.component.HeaderBarComp;
import com.actquizmobilenativeapp.utils.AppUtils;
import com.actquizmobilenativeapp.utils.DriverUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class CollectionsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "collections.lnk.quizsubject")
	private QAFWebElement collectionsLnkQuizsubject;
	//@FindBy(locator = "collections.header")
	private HeaderBar collectionsHeader=new HeaderBar();
	@FindBy(locator = "collections.lst.questions")
	private List<QAFWebElement> collectionsLstQuestions;
	@FindBy(locator = "collections.lst.quizes")
	private List<QAFWebElement> collectionsLstQuizes;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getCollectionsLnkQuizsubject(String quizSubject) {
		QAFExtendedWebElement collectionsLnkQuizsubject=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("collections.lnk.quizsubject"), quizSubject));
		return collectionsLnkQuizsubject;
	}

	public HeaderBar getCollectionsHeader() {
		return collectionsHeader;
	}
	
	public List<QAFWebElement> getCollectionsLstQuizes() {
		return collectionsLstQuizes;
	}
	
	
	public List<QAFWebElement> getCollectionsLstQuestions() {
		return collectionsLstQuestions;
	}
	
	public void verifyCollectionsPage(String quizSubject) {
		getCollectionsLnkQuizsubject(quizSubject).waitForVisible();
		getCollectionsLnkQuizsubject(quizSubject).verifyPresent();
	}
	
	public void selectQuizSubject(String quizSubject) {
		int  time=0;
		while(!isVisible(getCollectionsLnkQuizsubject(quizSubject))) {
			time=time+500;
			AppUtils.swipeToTillVisible("RightToLeft",getCollectionsLstQuizes().get(1));
			if(time>=10000)
				break;
		}
		getCollectionsLnkQuizsubject(quizSubject).click();
	}
	
	//This method is to avoid TC fail due to element not visible
	public boolean isVisible(QAFWebElement element) {
		try
		{
			element.isDisplayed();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void selectMark(String markType) {
		getCollectionsHeader().filterMark(markType);
		QAFTestBase.pause(2000);
	}
	
	public void filterMarked(String quizSubject,String markType) {
		selectQuizSubject(quizSubject);
		selectMark(markType);
	}
	
	public void verifyNoOfQuestions(int questionsNum) {
		Validator.verifyThat("No of questions are matched", getCollectionsLstQuestions().size(), Matchers.equalTo(questionsNum));	
	}
	


}
