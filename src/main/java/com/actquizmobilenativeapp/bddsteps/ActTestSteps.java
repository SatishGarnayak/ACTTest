package com.actquizmobilenativeapp.bddsteps;

import com.actquizmobilenativeapp.pages.CollectionsTestPage;
import com.actquizmobilenativeapp.pages.HomeTestPage;
import com.actquizmobilenativeapp.pages.ProfileTestPage;
import com.actquizmobilenativeapp.pages.QuestionsTestPage;
import com.actquizmobilenativeapp.pages.QuizstartTestPage;
import com.actquizmobilenativeapp.pages.StatisticsTestPage;
import com.actquizmobilenativeapp.utils.AppUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class ActTestSteps {

	HomeTestPage homeTestPage = new HomeTestPage();
	ProfileTestPage profileTestPage = new ProfileTestPage();
	QuizstartTestPage quizstartTestPage = new QuizstartTestPage();
	QuestionsTestPage questionsTestPage = new QuestionsTestPage();
	CollectionsTestPage collectionsTestPage = new CollectionsTestPage();
	StatisticsTestPage statisticsTestPage = new StatisticsTestPage();

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user launches the ACT Test application")
	public void OpenACTTestApplication() {

	}

	
	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user verify homepage")
	public void userVerifyHomepage() {
	       System.out.println("  Modified by satish ");
		homeTestPage.verifyHomePage();
	}

	@QAFTestStep(description = "user click on profile icon")
	public void clickOnProfile() {

		homeTestPage.clickOnProfileIcon();

	}

	@QAFTestStep(description = "user verify profilePage")
	public void verifyProfilePage() {

		profileTestPage.verifyProfilePage();

	}

	@QAFTestStep(description = "user update user info and go back")
	public void updateUserInfoAndBack() {
		String[] userinfo = ConfigurationManager.getBundle().getPropertyValue("user.info").split(",");
		profileTestPage.updateUserInfoAndGoBack(userinfo);

	}

	@QAFTestStep(description = "user verify  the updated info")
	public void verifyUpdatedInfo() {
		String[] userinfo = ConfigurationManager.getBundle().getPropertyValue("user.info").split(",");
		homeTestPage.verifyUserInfoUpdated(userinfo);

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select {0} quiz by name")
	public void userSelectQuizByName(String quiz) {
		ConfigurationManager.getBundle().addProperty("quizName", quiz);
		homeTestPage.selectQuizByName(quiz);
		QAFTestBase.pause(3000);

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user verify quiz page and click on start button")
	public void userVerifyPageAndClickOnStartButton() {

		quizstartTestPage.verifyPageAndStartQuiz();
		QAFTestBase.pause(3000);

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user mark the question in questionpage")
	public void userMarkTheQuestionInQuestionpage() {
		String[] marks = ConfigurationManager.getBundle().getPropertyValue("user.input.mark").split(",");
		for (int mark = 0; mark < marks.length; mark++) {

			questionsTestPage.verifyAndGetQuestionAndSetMark(marks[mark]);
			questionsTestPage.getNextQuestion(mark + 1);
		}

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user Navigates to homepage without finishing quiz")
	public void userNavigatesToHomepage() {

		questionsTestPage.navigateBackWithoutFinish();

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user Navigates to collection screen")
	public void userNavigatesToCollectionScreen() {
		homeTestPage.selectCollections();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select previous quiz type and verify the question displayed in list")
	public void userSelectPreviousQuizTypeAndVerifyTheQuestionDisplayedInList() {

		String filterMark = "Mastered";
		collectionsTestPage.filterMarked(ConfigurationManager.getBundle().getPropertyValue("quizName"), filterMark);
		collectionsTestPage.verifyNoOfQuestions(questionsTestPage.count);
		collectionsTestPage.getCollectionsHeader().getHeaderBtnBack().click();
		AppUtils.swipeTo("TopToBottom");
		questionsTestPage.setCountZero();
		QAFTestBase.pause(3000);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user navigates to homescreen")
	public void userNavigatesToHomescreen() {
		quizstartTestPage.goBackToMain();
	}

	/*
	 * @QAFTestStep(description = "user select statistics in homepage") public
	 * void userSelectStatisticsInHomepage() { homeTestPage.selectStatistics();
	 * }
	 */

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user verify quiz start page and get the points earned")
	public int verifyQuizstartPageAndGetPointsEarned() {
		return quizstartTestPage.verifyStartPageAndGetPointsScored();

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user navigates back to home page")
	public void navigateBackToHomePage() {
		quizstartTestPage.goBackToMain();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select statistics screen")
	public void selectStatisticsScreen() {
		homeTestPage.selectStatistics();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user verify statistics page and get the points present in statistics")
	public void verifyStatisticsPageAndGetPointsEarned() {
		statisticsTestPage.verifyStatisticsPage();
		statisticsTestPage.getPointsScored(ConfigurationManager.getBundle().getPropertyValue("quizName"));
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user matches both points earned in quiz {0} and points present in Statistics")
	public void comparePointsEarnedInBothQuizAndStatistics(int startPagePoints) {
		statisticsTestPage.verifyScoredPoints(startPagePoints);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user navigates back and swipes up")
	public void navigateBackAndSwipeUp() {
		statisticsTestPage.getBackToMain();
		AppUtils.swipeTo("TopToBottom");
	}

}
