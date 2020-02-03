package org.d3ifcool.cloure;

import android.os.SystemClock;
import android.util.Log;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.d3ifcool.cloure.R;

import org.junit.Rule;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class DataDrivenTest {@Rule
public ActivityTestRule<DishesEditorActivity> mainActivityActivityTestRule
        = new ActivityTestRule<>(DishesEditorActivity.class);

    @Test
    public void reasCsvFile() {
        InputStream inputStream = mainActivityActivityTestRule.getActivity()
                .getResources()
                .openRawResource(R.raw.data);
        String[] ids;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                ids = csvLine.split(";");
                try {
                    Espresso.onView(withId(R.drawable.ic_people_black_24dp)).perform(click());
                } catch (Exception e) {
                    Log.e("Unknown fuck", e.toString());
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        }
    }
}