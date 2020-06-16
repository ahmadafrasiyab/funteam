package com.example.funteam;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void hasTestOnScreen(){
        onView(withId(R.id.firstName))
                .perform(typeText("text"));
    }

    @Test
    public void hasTextOnScreen2(){
        onView(withId(R.id.lastName))
                .perform(typeText("text"));
    }

    @Test
    public void hasTextOnEmail(){
        onView(withId(R.id.email))
                .perform(typeText("text"));
    }

    @Test
    public void hasTextOnUserName(){
        onView(withId(R.id.tablayout_id))
                .perform(typeText("text"));

        onView(withId(R.id.signUpButton)).perform(click());

    }

    @Test
    public void hasButtonClick(){

        onView(withId(R.id.signUpButton)).perform(click());

    }


    @Test
    public void hasScroll(){

        onView(withId(R.id.signUpButton)).perform(scrollTo(), click());

    }



}