

package com.apporio.ubereats.mvp.ui.activity.login;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.apporio.ubereats.mvp.TestComponentRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by amitshekhar on 03/02/17.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final IntentsTestRule<LoginActivity> main =
            new IntentsTestRule<>(LoginActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setup() {

    }

    @Test
    public void checkViewsDisplay() {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));

        onView(ViewMatchers.withId(com.apporio.ubereats.mvp.R.id.et_email))
                .check(matches(isDisplayed()));

        onView(ViewMatchers.withId(com.apporio.ubereats.mvp.R.id.et_password))
                .check(matches(isDisplayed()));

        onView(ViewMatchers.withId(com.apporio.ubereats.mvp.R.id.btn_server_login))
                .check(matches(isDisplayed()));

        onView(ViewMatchers.withText(com.apporio.ubereats.mvp.R.string.login))
                .check(matches(isDisplayed()));

        onView(ViewMatchers.withId(com.apporio.ubereats.mvp.R.id.ib_google_login))
                .check(matches(isDisplayed()));

        onView(ViewMatchers.withId(com.apporio.ubereats.mvp.R.id.ib_fb_login))
                .check(matches(isDisplayed()));
    }
}