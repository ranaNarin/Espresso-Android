package com.soft.espresso;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by narinder.rana on 11/30/2017.
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginTest {


    private static final long DEFAULT_TIMEOUT = 300;
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private String mStringToBetyped;
    private UiDevice mDevice;

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
        final Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void mainActivityTest() throws IOException, UiObjectNotFoundException {
        sleep3000();
        onView(withId(R.id.btnLogin)).perform(click());
        sleep3000();
        onView(withId(R.id.edtEmail)).perform(typeText("rana.narin@gmail.com"));
        sleep3000();
        onView(withId(R.id.btnLogin)).perform(click());
        sleep3000();
        onView(withId(R.id.edtPassword)).perform(typeText("password"));
        onView(withId(R.id.edtPassword)).perform(closeSoftKeyboard());
        sleep3000();
        onView(withId(R.id.btnLogin)).perform(click());
        sleep3000();
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        sleep3000();
        onView(withText("About us")).perform(click());
        sleep3000();
        onView(withId(R.id.action_search)).perform(click());
        sleep3000();
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
      //  openDrawer(R.id.drawer_layout);
        sleep3000();
        onView(ViewMatchers.withId(R.id.drawerList)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        sleep3000();
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        sleep3000();
        onView(ViewMatchers.withId(R.id.drawerList)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        sleep3000();
        onView(ViewMatchers.withId(R.id.my_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(5,click()));
        sleep3000();
        onView(withId(R.id.userImage)).perform(click());
        sleep3000();
        onView(withText("Take Photo")).perform(click());
        sleep3000();

        //device.findObject(new UiSelector().resourceId("com.android.camera:id/shutter_button")).click();
        //or
        //device.findObject(new UiSelector().description("Shutter button")).click();
        //or
        mDevice.executeShellCommand("input keyevent 27");
        //or
        //device.click(x,y);
        sleep3000();

        UiObject okButton = mDevice.findObject(new UiSelector()
                .text("OK"));/*
                .className("android.widget.Button"));*/

        okButton.click();


        //Espresso.pressBack();
        sleep3000();
        sleep10000();



    }

    public void sleep3000() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep10000() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
