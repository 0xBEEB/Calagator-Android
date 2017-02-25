package com.github.ubiquill.calagator;

import com.github.ubiquill.calagator.activities.EventDetailsActivity;
import com.github.ubiquill.calagator.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by polymerwitch on 6/22/16.
 */
@RunWith(CalagatorTestRunner.class)
@Config(constants = BuildConfig.class, packageName = "com.github.ubiquill.calagator", sdk = 21)
public class MainActivityTest {

    @Test
    public void openMainActivityTest() {
        EventDetailsActivity activity = Robolectric.setupActivity(EventDetailsActivity.class);
        assertThat(activity).isNotNull();
    }
}
