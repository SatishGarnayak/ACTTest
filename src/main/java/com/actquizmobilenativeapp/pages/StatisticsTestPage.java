package com.actquizmobilenativeapp.pages;

import org.hamcrest.Matchers;

import com.actquizmobilenativeapp.utils.AppUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class StatisticsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "statistics.lnk.quizsubject")
	private QAFWebElement statisticsLnkQuizsubject;
	@FindBy(locator = "statistics.lbl.points")
	private QAFWebElement statisticsLblPoints;
	@FindBy(locator = "statistics.btn.submit")
	private QAFWebElement statisticsBtnSubmit;
	@FindBy(locator = "statistics.header")
	private HeaderBar statisticsHeader=new HeaderBar();
	
	int points;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getStatisticsLnkQuizsubject(String quizSubject) {
		QAFExtendedWebElement statisticsLnkQuizsubject=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("statistics.lnk.quizsubject"), quizSubject));
		return statisticsLnkQuizsubject;
	}

	public QAFWebElement getStatisticsLblPoints() {
		return statisticsLblPoints;
	}

	public QAFWebElement getStatisticsBtnSubmit() {
		return statisticsBtnSubmit;
	}
	
	public HeaderBar getStatisticsHeader() {
		return statisticsHeader;
	}

	public void verifyStatisticsPage() {
		getStatisticsLblPoints().waitForPresent();
		getStatisticsLblPoints().verifyVisible();
	}
	
	public int getPointsScored(String quizSubject) {
		clickOnQuizSubject(quizSubject);
		String strPoints=getStatisticsLblPoints().getText().split("Your score: ",2)[1].split(" point",2)[0];
		return points=AppUtils.convertToInteger(strPoints);
	}
	
	public void verifyScoredPoints(int pointsScored) {
		Validator.verifyThat("Scores are matching", points, Matchers.equalTo(pointsScored));
	}
	
	public void getBackToMain() {
		getStatisticsHeader().getHeaderBtnBack().click();
	}
	
	public void clickOnQuizSubject(String quizSubject) {
		getStatisticsHeader().getHeaderStatisticsSubjectSpinner().click();
		getStatisticsLnkQuizsubject(quizSubject).click();
	}
}
