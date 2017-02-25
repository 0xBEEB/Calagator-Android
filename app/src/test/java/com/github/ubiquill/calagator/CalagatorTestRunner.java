package com.github.ubiquill.calagator;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by polymerwitch on 6/22/16.
 */
public class CalagatorTestRunner extends RobolectricTestRunner {

    public CalagatorTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
        String buildVariant = BuildConfig.BUILD_TYPE + (BuildConfig.FLAVOR.isEmpty()? "" : "/" + BuildConfig.FLAVOR);
        System.setProperty("android.package", BuildConfig.APPLICATION_ID);
        System.setProperty("android.manifest", "build/intermediates/manifests/full/" + buildVariant + "/AndroidManifest.xml");
        System.setProperty("android.resources", "build/intermediates/res/merged/" + buildVariant);
        System.setProperty("android.assets", "build/intermediates/assets/" + buildVariant);
    }
}
