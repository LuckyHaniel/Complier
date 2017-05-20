

package org.thanatos.flowgeek;

import com.robotium.solo.Solo;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.thanatos.flowgeek.ui.activity.LoginActivity;
import org.thanatos.flowgeek.ui.activity.MainActivity;



@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    private static final String username = "ws.luckycoder@gmail.com";
    private static final String passwd = "lucky.1996";
    private Solo solo;


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        //setUp() is run before a test case is started.
        //This is where the solo object is created.
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
                activityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }

    @Test
    public void testLogin() throws Exception {

        solo.unlockScreen();

        solo.clickOnView(solo.getView(R.id.iv_portrait));

        solo.assertCurrentActivity("Now we are in Activity:", LoginActivity.class);

        solo.clickOnView(solo.getView(R.id.et_username));

        solo.enterText(0, username);

        solo.clickOnView(solo.getView(R.id.et_password));

        solo.typeText(0, passwd);

        solo.clickOnView(solo.getView(R.id.btn_submit));

        solo.takeScreenshot();

        boolean notesFound = solo.searchText(username) && solo.searchText(passwd);

        viewNotes();

    }

    @Test
    public void testViewAuto() throws Exception {

        solo.clickOnView(solo.getView(R.id.menu_blog));

        solo.clickOnView(solo.getView(R.id.menu_my_favorite));

        solo.clickOnView(solo.getView(R.id.menu_theme));

        solo.clickOnView(solo.getView(R.id.menu_publish));
    }

    private void viewNotes() {

        solo.clickInList(1);

        solo.clickOnView(solo.getView(R.id.tv_title));

        solo.clickOnText(solo.getString(R.id.toolbar));
    }
}
