package com.actquizmobilenativeapp.pages;


import com.actquizmobilenativeapp.utils.AppUtils;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class QuizstartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "quizstart.title.page")
	private QAFWebElement quizstartTitlePage;
	@FindBy(locator = "quizstart.btn.start")
	private QAFWebElement quizstartBtnStart;
	@FindBy(locator = "quizstart.no.questions.selected")
	private QAFWebElement quizstartNoQuestionsSelected;
	@FindBy(locator = "quizstart.lbl.score")
	private QAFWebElement quizstartLblScore;
	//@FindBy(locator = "quizstart.header")
	private HeaderBar quizstartHeader=new HeaderBar();
	
	String points,percentage;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getQuizstartTitlePage() {
		return quizstartTitlePage;
	}

	public QAFWebElement getQuizstartBtnStart() {
		return quizstartBtnStart;
	}

	public QAFWebElement getQuizstartNoQuestionsSelected() {
		return quizstartNoQuestionsSelected;
	}
	
	public QAFWebElement getQuizstartLblScore() {
		return quizstartLblScore;
	}
	
	public HeaderBar getQuizstartHeader() {
		return quizstartHeader;
	}
	
	public void verifyStartQuiz() {
		getQuizstartTitlePage().waitForPresent();
		getQuizstartTitlePage().verifyVisible();
	}
	
	public void verifyPageAndStartQuiz() {
		verifyStartQuiz();
		getQuizstartBtnStart().click();
	}
	
	public int getPoints() {
		String strPpoints=getQuizstartLblScore().getText().split("Your score: ",2)[1].split(" point",2)[0];
		return AppUtils.convertToInteger(strPpoints);
	}
	
	public int verifyStartPageAndGetPointsScored() {
		verifyStartQuiz();
		return getPoints();
	}
	
	public void goBackToMain() {
		getQuizstartHeader().getHeaderBtnBack().click();
	}

}
