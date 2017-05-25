package com.actquizmobilenativeapp.pages;

import java.util.List;


import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;


public class QuestionsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "questions.btn.show")
	private QAFWebElement questionsBtnShow;
	@FindBy(locator = "questions.lbl.question")
	private QAFWebElement questionsLblQuestion;
	@FindBy(locator = "questions.lst.options")
	private List<QAFWebElement> questionsLstOptions;
	@FindBy(locator = "questions.lst.no.question")
	private List<QAFWebElement> questionsLstNoQuestion;
	//@FindBy(locator = "questions.header")
	private HeaderBar questionsHeader=new HeaderBar();

	public static int count=0;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getQuestionsBtnShow() {
		return questionsBtnShow;
	}

	public QAFWebElement getQuestionsLblQuestion() {
		return questionsLblQuestion;
	}

	public List<QAFWebElement> getQuestionsLstOptions() {
		return questionsLstOptions;
	}

	public List<QAFWebElement> getQuestionsLstNoQuestion() {
		return questionsLstNoQuestion;
	}
	
	public HeaderBar getQuestionsHeader() {
		return questionsHeader;
	}
	
	public void verifyQuestionsPage() {
		getQuestionsLblQuestion().waitForPresent();
		getQuestionsLblQuestion().verifyPresent();
	}
	
	public void getQuestionsInfo() {
		getQuestionsLblQuestion().getText();
	}

	public void setMark(String markType) {
		getQuestionsHeader().markQuestion(markType);
	}
	
	public void verifyAndGetQuestionAndSetMark(String markType) {
		if(markType.contentEquals("Mastered")) {
			count=count+1;
		}
		//QAFTestBase.pause(5000);
		
		verifyQuestionsPage();
		getQuestionsInfo();
		setMark(markType);
	}
	
	public void getNextQuestion(int index) {
		System.out.println("Total questions present: "+getQuestionsLstNoQuestion().size());
		System.out.println("Question Number: "+getQuestionsLstNoQuestion().get(index).getText());
		getQuestionsLstNoQuestion().get(index).click();
	}
	
	public void navigateBackWithoutFinish() {
		getQuestionsHeader().getHeaderBtnBack().click();
		getQuestionsHeader().getHeaderAlertExitYes().click();
	}
	
	public void setCountZero() {
		count=0;
	}
}
