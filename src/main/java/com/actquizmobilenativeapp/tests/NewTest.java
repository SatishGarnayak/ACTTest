package com.actquizmobilenativeapp.tests;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.actquizmobilenativeapp.pages.CollectionsTestPage;
import com.actquizmobilenativeapp.pages.HomeTestPage;
import com.actquizmobilenativeapp.pages.ProfileTestPage;
//import com.actquizmobilenativeapp.pages.QuestionsTestPage;
import com.actquizmobilenativeapp.pages.QuestionsTestPage;
import com.actquizmobilenativeapp.pages.QuizstartTestPage;
import com.actquizmobilenativeapp.pages.StatisticsTestPage;
import com.actquizmobilenativeapp.utils.AppUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Validator;

public class NewTest extends WebDriverTestCase {
	

	HomeTestPage homeTestPage = new HomeTestPage();
	ProfileTestPage profileTestPage = new ProfileTestPage();
	QuizstartTestPage quizstartTestPage = new QuizstartTestPage();
	QuestionsTestPage questionsTestPage = new QuestionsTestPage();
	CollectionsTestPage collectionsTestPage = new CollectionsTestPage();
	StatisticsTestPage statisticsTestPage = new StatisticsTestPage();
	
	// public static String[] userinfo = { "A team", "Pune", "This is Scenario 1" };
	@Test(description = "Scenario 1: Update User Profile", priority = 1)
	public void testCase1() {
		// input data must have only three String values
		String[] userinfo = ConfigurationManager.getBundle().getPropertyValue("user.info").split(",");

		homeTestPage.verifyHomePage();
		homeTestPage.clickOnProfileIcon();
		profileTestPage.verifyProfilePage();
		profileTestPage.updateUserInfoAndGoBack(userinfo);
		homeTestPage.clickOnProfileIcon();
		//Validator.verifyThat("update user info", profileTestPage.getUserInfo(), Matchers.equalTo(userinfo));
        homeTestPage.verifyUserInfoUpdated(userinfo);
		// This will verify user info
		getDriver();
	}

	@QAFDataProvider(dataFile = "resources/data/userdata.csv")
	@Test(description = "Scenario 2: Master a Question", priority = 2)
	public void testCase2(Map<String, String> map) {

		String quizes = map.get("quiz");

		String[] marks = ConfigurationManager.getBundle().getPropertyValue("user.input.mark").split(",");
		String filterMark = "Mastered";

		homeTestPage.verifyHomePage();

		homeTestPage.selectQuizByName(quizes);
		QAFTestBase.pause(3000);

		quizstartTestPage.verifyPageAndStartQuiz();
		QAFTestBase.pause(3000);

		// This loop will set mark for different questions
		// Marks will be placed as we mentioned above
		for (int mark = 0; mark < marks.length; mark++) {

			questionsTestPage.verifyAndGetQuestionAndSetMark(marks[mark]);
			questionsTestPage.getNextQuestion(mark + 1);
		}
		questionsTestPage.navigateBackWithoutFinish();
		homeTestPage.selectCollections();
		collectionsTestPage.filterMarked(quizes, filterMark);
		collectionsTestPage.verifyNoOfQuestions(questionsTestPage.count);
		collectionsTestPage.getCollectionsHeader().getHeaderBtnBack().click();
		AppUtils.swipeTo("TopToBottom");
		questionsTestPage.setCountZero();
		QAFTestBase.pause(3000);

	}

	@QAFDataProvider(dataFile = "resources/android/userdata.csv")
	@Test(description = "Scenario 3: Verify Stats", priority = 3)
	public void testCase3(Map<String, String> map) {

		String quizes = map.get("quiz");
		int startPagePoints = 0;
		//ConfigurationManager.getBundle().setProperty("quizName", map.get("quiz"));
		homeTestPage.verifyHomePage();

		// This loop will iterate for all quiz subjects
		// Quizes will be placed as we mentioned above
		homeTestPage.selectQuizByName(quizes);
		QAFTestBase.pause(3000);
		startPagePoints = quizstartTestPage.verifyStartPageAndGetPointsScored();
		quizstartTestPage.goBackToMain();
		homeTestPage.selectStatistics();
		statisticsTestPage.verifyStatisticsPage();
		statisticsTestPage.getPointsScored(quizes);
		statisticsTestPage.verifyScoredPoints(startPagePoints);
		statisticsTestPage.getBackToMain();
		AppUtils.swipeTo("TopToBottom");
	}
}