package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testChangeColor() {
        // checks all Views
        onView(withId(R.id.textView))
                .check(matches(withText("Hello World!")));
        onView(withId(R.id.btn_color))
                .check(matches(withText("Change text color!")));

        // runs first clicks to turn Hello World to black
        onView(withId(R.id.btn_color)).perform(click());
        onView(withId(R.id.textView))
                .check(matches(hasTextColor(R.color.black)));

        // runs second clicks to turn Hello World to red
        onView(withId(R.id.btn_color)).perform(click());
        onView(withId(R.id.textView))
                .check(matches(hasTextColor(R.color.red)));

        // runs third clicks to turn Hello World back to black
        onView(withId(R.id.btn_color)).perform(click());
        onView(withId(R.id.textView))
                .check(matches(hasTextColor(R.color.black)));

    }
}